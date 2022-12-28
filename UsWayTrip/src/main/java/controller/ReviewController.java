package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import member.MemberService;
import review.ReviewService;
import review.ReviewVO;
import reviewimg.ReviewImgVO;

@Controller
public class ReviewController {
	private ReviewService reviewService;
	
	@Autowired
	private ServletContext application;
	private String msg = "";
	private String url = "";
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	
	@RequestMapping(value= {"/admin/review/listForm", "/review/listForm"})
	public String allList(Model model, HttpServletRequest request){
		 List<ReviewVO> list = reviewService.allList();
		 int member_no = (int)request.getSession().getAttribute("login");
		 if(request.getServletPath().equals("/review/listForm")) {
			 list = reviewService.allUList(member_no);
		 }
		
		 model.addAttribute("list", list);
		 model.addAttribute("path", RedirectPath.A_REVIEW);
		 
		 return ViewPath.A_REVIEW + "listForm.jsp";
	}
	
	@RequestMapping("/review/writeForm")
	public String writeForm(Model model, HttpServletRequest request) {
		Integer member_no = (Integer)request.getSession().getAttribute("login");
		Integer product_no = Integer.parseInt(request.getParameter("product_no"));
		//Integer agency_no = Integer.parseInt(request.getParameter("agency_no"));
		Integer agency_no =1;
		
		//사용자명
		String uname = reviewService.getName(member_no);	
		
		model.addAttribute("path", RedirectPath.U_REVIEW);
		model.addAttribute("uname", uname);
		model.addAttribute("product_no", product_no);
		model.addAttribute("member_no", member_no);
		model.addAttribute("agency_no", agency_no);
		
		return ViewPath.U_REVIEW + "writeForm.jsp";
	}
	
	@RequestMapping("/review/write")
	public void write(HttpServletRequest request, HttpServletResponse response, ReviewVO vo) {
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		int agency_no = Integer.parseInt(request.getParameter("agency_no"));

		String review_content = vo.getReview_content().replaceAll("\r\n", "<br>");
		vo.setReview_content(review_content);
		String savePath = application.getRealPath("/resources/upload/review");
		
	
		int reviewSeq = reviewService.insert(vo);
		ReviewVO check = reviewService.selectOne(reviewSeq);
		
		
		if(check != null) {
			
			if(!vo.getImgs().get(0).getOriginalFilename().equals("")) {
				List<MultipartFile> files = vo.getImgs();
				
				List<ImgVO> list = Util.fileListUpload(files, savePath);
			
				for(ImgVO img : list) {
					ReviewImgVO riVO = new ReviewImgVO(reviewSeq, img.getImg_name());
					int imgCheck = reviewService.insertImg(riVO);
				}
			}
			msg = "후기 등록 성공";
			url = RedirectPath.U_REVIEW + "listForm";
		}else {
			msg = "후기 등록 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/review/updateForm/{seq}")
	public String updateForm(Model model, @PathVariable(value= "seq") int seq, HttpServletResponse response, HttpServletRequest request) {
		Integer member_no = (Integer)request.getSession().getAttribute("login");
		Integer member_role = (Integer)request.getSession().getAttribute("role");
		
		ReviewVO vo = reviewService.selectOne(seq);
		
		//리뷰 작성자와 로그인한 사용자가 다를 때 
		if(member_no != vo.getMember_no() && member_role > 2) {
			try {
				ScriptUtil.alertAndBackPage(response, "잘못된 접근입니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<String> riList = reviewService.getImage(seq);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("path", RedirectPath.U_REVIEW);
		model.addAttribute("riList", riList);
		model.addAttribute("imgPath", ImgPath.REVIEW);
		
		return ViewPath.A_REVIEW + "updateForm.jsp";
	}
	
	@RequestMapping("/admin/review/update")
	public void update(ReviewVO vo, HttpServletRequest request, HttpServletResponse response) {
		int update = reviewService.update(vo);
		int seq = vo.getReview_no();
		
		if(!vo.getImgs().isEmpty()) {
			List<MultipartFile> files = vo.getImgs();
			String savePath = application.getRealPath("/resources/upload/review");
			List<ImgVO> list = Util.fileListUpload(files, savePath);
			
			for(ImgVO img : list) {
				ReviewImgVO riVO = new ReviewImgVO(seq, img.getImg_name());
				int imgCheck = reviewService.insertImg(riVO);
			}
		}
		
		if(update != 0) {
			msg = "수정 성공";
			url = RedirectPath.A_REVIEW + "updateForm/"+seq;
		}else {
			msg = "수정 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/admin/review/delete/{seq}")
	public void delete(@PathVariable(value= "seq") int seq, HttpServletRequest request, HttpServletResponse response) {
		int delete = reviewService.delete(seq);
		
		if(delete != 0) {
			int img = reviewService.deleteImg(seq);
			msg = "삭제 성공";
			url = RedirectPath.A_REVIEW + "listForm";
		}else {
			msg = "삭제 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
