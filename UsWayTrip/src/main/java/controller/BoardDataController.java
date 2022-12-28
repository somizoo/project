package controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import board.BoardVO;
import boarddata.BoardDataService;
import boarddata.BoardDataVO;
import boarddatafile.BoardDataFileVO;
import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;

// 22.12.01 추가
@Configuration
@PropertySource("classpath:config/globals.properties")

//11.25 BoardController -> BoardDataController 변경
@Controller
public class BoardDataController {
	
	// 11.24 BoardService -> BoardDataService 변경
	private BoardDataService boardDataService;
	
	@Value("${globals.dir}")
	private String FILEPATH;
	
	// 22.12.01 추가
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigPlaceon() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public BoardDataController(BoardDataService boardDataService) {
		this.boardDataService = boardDataService;
	}
	
	// 11.24 내용 변경 mainListForm-> detailNoticeListForm
	// mainListForm -> noticeListForm 에서 (문서 n개 보기) 선택하면 나오는 화면
	@RequestMapping("/admin/boardData/detailNoticeListForm/{board_no}")
	public String list(Model model, @PathVariable("board_no") int board_no) {
		
		List<BoardDataVO> list = boardDataService.bnSelectList(board_no);
		
		BoardVO vo = boardDataService.selectOne(board_no);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("list", list);
		model.addAttribute("boardpath", RedirectPath.A_BOARD);
		model.addAttribute("bdpath", RedirectPath.A_BD);
		model.addAttribute("b_no",board_no);
		
		return ViewPath.A_BOARDDATA + "detailNoticeListForm.jsp";
	}
	
	// 공지사항작성을 눌렀을 경우 글쓰기 뷰로 이동(11.24 추가)
	@RequestMapping("/admin/boardData/detailWriteForm/{board_no}")
	public String detailWriteForm(Model model, @PathVariable("board_no") int board_no) {
		model.addAttribute("boardpath", RedirectPath.A_BOARD);
		model.addAttribute("bdpath", RedirectPath.A_BD);
		return ViewPath.A_BOARDDATA + "detailWriteForm.jsp";
	}
	
	// 11.24 추가 쓰기 버튼을 눌렀을 경우 실행
	@RequestMapping("/admin/boardData/detailWrite/{board_no}")
	public void detailWrite(BoardDataVO vo, HttpServletRequest request, HttpServletResponse response, @PathVariable("board_no") int board_no) {
		
//		String bd_content = vo.getBd_content();
		
//		vo.setBd_content(bd_content.replaceAll("\r\n", "<br>"));
		
		// 파일을 저장할 경로
		String savePath = FILEPATH + "upload\\board\\";
		
		int bd_no = boardDataService.getBd_no();
		
		vo.setBd_no(bd_no);
		
		String bd_content = vo.getBd_content();
		System.out.println(bd_content);
		bd_content = bd_content.replaceAll("getImg", "getImgLoad/" + bd_no);
		vo.setBd_content(bd_content);
		
		if(vo.getFileList() != null) {
			try {
				summerCopy(vo.getFileList(), bd_no);	// 파일 위치 변경
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int check = boardDataService.insert(vo);
		
		if(vo.getFileList() != null) {
			boardDataService.fileInsert(bd_no, vo.getFileList());
		}
		
		String msg = null;
		String url = null;
		if(check != 0) {
			msg = "글쓰기 성공";
			url = RedirectPath.A_BD + "detailNoticeListForm/" + board_no;
		} else {
			msg = "글쓰기 실패";
			url = RedirectPath.A_BD + "detailWriteForm/"+ board_no;
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 11.27 수정
	@RequestMapping("/admin/boardData/contentForm/{board_no}/{bd_no}")
	public String contentForm(@PathVariable("board_no") int board_no, @PathVariable("bd_no") int bd_no,  Model model, BoardDataVO vo) {
		
		BoardDataVO bdvo = boardDataService.selectOne(vo);
		List<BoardDataFileVO> list = boardDataService.fileSelectList(bd_no);
		
		model.addAttribute("list", list);
		model.addAttribute("bdvo", bdvo);
		model.addAttribute("bdpath", RedirectPath.A_BD);
		
		return ViewPath.A_BOARDDATA + "contentForm.jsp";
	}
	
	@RequestMapping("/admin/boardData/deleteForm/{board_no}/{bd_no}")
	public String deleteForm(@PathVariable("board_no") int board_no, @PathVariable("bd_no") int bd_no, Model model) {
		boardDataService.delete(bd_no);
		
		List<BoardDataVO> list = boardDataService.selectList();
		
		model.addAttribute("list", list);
		/*
		 * 22.11.26
			리다이렉트로 변경
		*/ 
		
		// 22.11.27 리다이렉트 변경 완료
		return "redirect:/admin/boardData/detailNoticeListForm/{board_no}";
	}
	
	
	  // 11.26 수정 버튼 눌렀을 경우 updateForm.jsp 파일로 이동
	  @RequestMapping("/admin/boardData/updateForm/{board_no}/{bd_no}")
	  public String updateForm(@PathVariable("bd_no") int bd_no, @PathVariable("board_no") int board_no, Model model, BoardDataVO vo) {
		  
		  vo = boardDataService.selectOne(vo);
		  
		  model.addAttribute("vo", vo);
		  model.addAttribute("bdpath", RedirectPath.A_BD);
		  
		  return ViewPath.A_BOARDDATA + "updateForm.jsp";
	  }
	 
	
	// 11.26 수정 버튼을 눌렀을 경우 update 기능 실행
	@RequestMapping("/admin/boardData/detailUpdate/{board_no}/{bd_no}")
	public void detailUpdate(HttpServletRequest request,HttpServletResponse response, BoardDataVO vo, @PathVariable("bd_no") int bd_no, @PathVariable("board_no") int board_no) {
		
		
		int check = boardDataService.update(vo);
		String msg = null;
		String url = null;
		
		if(check != 0) {
			msg = "수정완료! 목록으로";
			url = "/uswaytrip/admin/boardData/detailNoticeListForm/" + board_no;
		} else {
			msg = "수정실패! 다시 시도해주세요";
			url = "/uswaytrip/admin/boardData/detailNoticeListForm/" + board_no;
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일 다운로드
	@RequestMapping("/boarddata/download/{bd_no}")
	public void download(@PathVariable("bd_no")int bd_no, String fn,HttpServletResponse response) throws IOException{
        File f = new File(FILEPATH + "/upload/"+ "board/" + bd_no + "/", fn);
        // file 다운로드 설정
        response.setContentType("application/download");
        response.setContentLength((int)f.length());
        response.setHeader("Content-disposition", "attachment;filename=\"" + fn + "\"");
        // response 객체를 통해서 서버로부터 파일 다운로드
        OutputStream os = response.getOutputStream();
        // 파일 입력 객체 생성
        FileInputStream fis = new FileInputStream(f);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();

	}
	
	@RequestMapping("/summer_image")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request ) throws IOException {
	    JsonObject json = new JsonObject();

	    String fileRoot = FILEPATH + "/upload/board/";
	    String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
	    String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); //파일 확장자

	    String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
	    File targetFile = new File(fileRoot + savedFileName);	
	    System.out.println(targetFile);
	    try {
	        // 파일 저장
	        InputStream fileStream = multipartFile.getInputStream();
	        FileUtils.copyInputStreamToFile(fileStream, targetFile);	
	        
	        // 파일을 열기위하여 common/getImg 호출 / 파라미터로 savedFileName 보냄.
	        json.addProperty("url", "/uswaytrip/boarddata/common/getImg?savedFileName="+savedFileName);  
	        json.addProperty("responseCode", "success");
	   
	    } catch (IOException e) {
	        FileUtils.deleteQuietly(targetFile);	
	        json.addProperty("responseCode", "error");
	        e.printStackTrace();
	    }
	    String jsonvalue = json.toString();

	    return jsonvalue;
	}
	
	@RequestMapping(value="/boarddata/common/getImg" , method=RequestMethod.GET)
	public void getImg(@RequestParam(value="savedFileName") String savedFileName, HttpServletResponse response) throws Exception{
	  String filePath;
	  String DIR = FILEPATH + "/upload/board/";
	  filePath = DIR +savedFileName; 
	  getImage(filePath, response);
	}
	
	@RequestMapping(value="/boarddata/common/getImgLoad/{bd_no}" , method=RequestMethod.GET)
	public void getImgCopy(@RequestParam(value="savedFileName") String savedFileName,@PathVariable("bd_no") int bd_no, HttpServletResponse response) throws Exception{
	  String filePath;
	  String DIR = FILEPATH + "/upload/board/" + bd_no + "/";
	  filePath = DIR +savedFileName; 
	  getImage(filePath, response);
	}
	
	private void getImage(String filePath, HttpServletResponse response) throws IOException {
		File file = new File(filePath);
		if(!file.isFile()){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('조회된 정보가 없습니다.'); self.close();</script>");
			out.flush();
			return;
		}
	
		
		FileInputStream fis = null;
		
		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		try {
			fis = new FileInputStream(file);
			in = new BufferedInputStream(fis);
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}

			String type = "";
			String ext = FilenameUtils.getExtension(file.getName());
			System.out.println(ext);
			if (ext != null && !"".equals(ext)) {
				if ("jpg".equals(ext.toLowerCase())) {
					type = "image/jpeg";
				} else {
					type = "image/" + ext.toLowerCase();
				}

			} else {
				System.err.println("Image fileType is null.");
			}

			response.setHeader("Content-Type", type);
			response.setContentLength(bStream.size());

			bStream.writeTo(response.getOutputStream());

			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bStream != null) {
				try {
					bStream.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception ei) {
					ei.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception efis) {
					efis.printStackTrace();
				}
			}
		}
	}
	
	public Map<String, Object> summerCopy(List<String> fileList ,int bd_no) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		//원본 파일경로
		for(int i=0;i<fileList.size();i++){
		    String oriFilePath = FILEPATH + "upload\\board\\" + fileList.get(i);

		    //복사될 파일경로
		    String copyFilePath = FILEPATH + "upload\\board\\" + bd_no + "\\"+fileList.get(i);
		    File copy = new File( FILEPATH + "upload\\board\\" + bd_no + "\\");
		    System.out.println(oriFilePath);
		    System.out.println(copyFilePath);
		    
		    if(!copy.exists()) { //경로에 파일이 없으면
		    	copy.mkdirs();
		    }
		    
		    try {
		        FileInputStream fis = new FileInputStream(oriFilePath); //읽을파일
		        FileOutputStream fos = new FileOutputStream(copyFilePath); //복사할파일
		        int data = 0;
		        while((data=fis.read())!=-1) {
		         fos.write(data);
		        }
		        fis.close();
		        fos.close();
		       } catch (IOException e) {
		        e.printStackTrace();
		       }
		    
		    	File del = new File(oriFilePath);
		    	del.delete();
			}
		
			
	    result.put("SUCCESS", true);
	    return result;
	}
	
	// 22.12.07 사용자용 공지사항 상세
		@RequestMapping("/boarddata/detailNoticeListForm/{board_no}")
		public String Ulist(Model model, @PathVariable("board_no") int board_no) {
			
			List<BoardDataVO> list = boardDataService.bnSelectList(board_no);
			
			BoardVO vo = boardDataService.selectOne(board_no);
			
			model.addAttribute("vo", vo);
			
			model.addAttribute("list", list);
			model.addAttribute("boardpath", RedirectPath.U_BOARD);
			model.addAttribute("bdpath", RedirectPath.U_BD);
			model.addAttribute("b_no",board_no);
			
			return ViewPath.U_BD + "detailNoticeListForm.jsp";
		}
		
		// 22.12.07 사용자용 컨텐트폼
		@RequestMapping("/boarddata/contentForm/{board_no}/{bd_no}")
		public String UcontentForm(@PathVariable("board_no") int board_no, @PathVariable("bd_no") int bd_no,  Model model, BoardDataVO vo) {
			
			BoardDataVO bdvo = boardDataService.selectOne(vo);
			List<BoardDataFileVO> list = boardDataService.fileSelectList(bd_no);
			
			model.addAttribute("list", list);
			model.addAttribute("bdvo", bdvo);
			model.addAttribute("bdpath", RedirectPath.U_BD);
			
			return ViewPath.U_BD + "contentForm.jsp";
		}
		
}




























