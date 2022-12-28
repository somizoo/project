package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.ImgPath;
import common.RedirectPath;
import common.ScriptUtil;
import common.Util;
import common.ViewPath;
import img.ImgVO;
import ticketevent.TicketEventService;
import ticketevent.TicketEventVO;

@Controller
public class TicketEventController {
	private TicketEventService teService;
	
	@Autowired
	private ServletContext application;
	
	public TicketEventController(TicketEventService teService) {
		this.teService = teService;
	}
	
	@RequestMapping("/admin/ticketEvent/listForm")
	public String listForm(Model model) {
		List<TicketEventVO> list = teService.allList();
		String[] active = new String[] {"<span style='color:blue'>활성</span>", "<span style='color:red'>비활성</span>"};
		
		model.addAttribute("list", list);
		model.addAttribute("active", active);
		model.addAttribute("path", RedirectPath.A_TE);
		
		return ViewPath.A_TE + "listForm.jsp";
	}
	
	@RequestMapping("/admin/ticketEvent/writeForm")
	public String writeForm(Model model) {
		model.addAttribute("path", RedirectPath.A_TE);
		return ViewPath.A_TE + "writeForm.jsp";
	}
	
	/*
	 * 22.11.25
	 * 티켓 이벤트 등록
	 * */
	@RequestMapping("/admin/ticketEvent/write")
	public void write(TicketEventVO vo, HttpServletResponse response, HttpServletRequest request) {
		String msg = "", url ="";
		String referer = (String)request.getHeader("REFERER");
		ImgVO img = null; 
		if(vo != null) {
			MultipartFile file = vo.getPhoto();
			String savePath = application.getRealPath("/resources/upload/product/ticket/ticketEvent");
			
			img = Util.fileUpload(file, savePath);
			vo.setTe_img(img.getImg_name());
			int check = teService.write(vo);
			
			
			
			
			if(check != 0) {
				 msg = "등록 성공";
				 url = RedirectPath.A_TE + "listForm";
			}else {
				//insert 실패 시 업로드 했던 파일 삭제 
				Util.fileDelete(img.getImg_name(), savePath);
				msg = "등록 실패";
				url = referer;
			}
		}
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 22.11.25 티켓 이벤트 수정페이지
	 */
	@RequestMapping("/admin/ticketEvent/updateForm/{seq}")
	public String updateForm(Model model, @PathVariable(value = "seq") int seq) {
		TicketEventVO vo = teService.list(seq);
		
		if(vo == null) {
			return ViewPath.A_TE + "listForm.jsp";
		}
		model.addAttribute("vo", vo);
		model.addAttribute("path", RedirectPath.A_TE);
		model.addAttribute("imgPath", ImgPath.TICKETEVENT);
		model.addAttribute("imgdeletePath", RedirectPath.A_TE + "deleteImg");
		return ViewPath.A_TE + "updateForm.jsp";
	}
	
	/*
	 * 22.11.25 ~ 22.11.26 티켓 이벤트 이미지 삭제 메소드
	 * 
	 * */
	
	@RequestMapping("/admin/ticketEvent/deleteImg")
	public void deleteImg(HttpServletRequest request, HttpServletResponse response)  {
		boolean check = false;
		String filename = request.getParameter("filename");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int deleteimg = teService.deleteImg(seq);
		
		String msg = "", url ="";
		String referer = (String)request.getHeader("REFERER");
		if(deleteimg != 0) {
			String path = request.getSession().getServletContext().getRealPath("/") + "resources\\upload\\product\\ticket\\ticketEvent";
			check = Util.fileDelete(filename, path);
			
			if(check) {
				msg = "이미지 삭제 성공";
				url = RedirectPath.A_TE + "updateForm/"+seq;
			}else {
				msg = "이미지 삭제 실패";
				url = referer;
			}
		}else {
			msg = "이미지 삭제 실패";
			url = referer;
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 22.11.26 티켓 이벤트 데이터 수정  
	 * */
	@RequestMapping("/admin/ticketEvent/update")
	public void update(HttpServletRequest request, HttpServletResponse response, TicketEventVO vo) {
		String msg = "";
		String url = "";
		ImgVO img = null;
		String referer = (String)request.getHeader("REFERER");
		
	
		//정보 업데이트
		
		//파일 첨부
		MultipartFile photo = vo.getPhoto();
	
		if(photo != null) {
			
			String savePath = application.getRealPath("/resources/upload/product/ticket/ticketEvent");
			img = Util.fileUpload(photo, savePath);
			
			if(img == null ) {
				msg = "이미지 업로드 실패";
				url = referer;
			}else {
				vo.setTe_img(img.getImg_name());
			}
			
		}
				
		int check = teService.update(vo);
		if(check != 0) {
			msg = "수정 성공";
			url = RedirectPath.A_TE + "updateForm/"+vo.getTe_no();
		}else {
			msg = "수정 실패";
			url = referer;
		}
			
	
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 *  22.11.27 티켓 옵션 데이터 삭제 
	 * */
	
	@RequestMapping("/admin/ticketEvent/delete/{seq}")
	public void delete(HttpServletResponse response, HttpServletRequest request, @PathVariable(value = "seq") int seq) {
		String msg = "";
		String url = "";
		String referer = (String)request.getHeader("REFERER");
		//정보조회
		TicketEventVO vo = teService.list(seq);
		String filename = vo.getTe_img();
		
		//정보삭제
		int delete = teService.delete(seq);
		//파일삭제
		if(delete != 0) {
			String savePath = application.getRealPath("/resources/upload/product/ticket/ticketEvent");
			msg = "데이터 삭제 성공";
			url = RedirectPath.A_TE + "listForm";
			if(filename != null) {
				boolean check = Util.fileDelete(filename, savePath);
				//정보삭제 롤백
				if(!check) {
					msg = "데이터 삭제 실패";
					url = referer;
				}else {
					msg = "데이터 삭제 성공";
					url = RedirectPath.A_TE + "listForm";
				}
			}
		}else {
			msg = "데이터 삭제 실패";
			url = referer;
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
