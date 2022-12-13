package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.ImgPath;
import common.RedirectPath;
import common.ScriptUtil;
import common.Util;
import common.ViewPath;
import img.ImgVO;
import ticketinfo.TicketInfoService;
import ticketinfo.TicketInfoVO;
import ticketinfodata.TicketInfoDataVO;

@Controller
public class TicketInfoController {
	
	private TicketInfoService tiService;
	
	@Autowired // 자동 주입
	private ServletContext application;

	public TicketInfoController(TicketInfoService tiService) {
		this.tiService = tiService;
	}
	
	@RequestMapping("/admin/ticketInfo/listForm")
	public String listForm(Model model, TicketInfoVO ti_vo, TicketInfoDataVO tid_vo) {
		
		List<TicketInfoVO> ti_list = tiService.tiSelectList();

		List<TicketInfoDataVO> tid_list = tiService.tidSelectList();

		for(TicketInfoDataVO list : tid_list) {
			System.out.println(list.getTid_value());
		}
		
		model.addAttribute("ti_list", ti_list);
		model.addAttribute("tid_list", tid_list);
		
		model.addAttribute("path", RedirectPath.A_TI);
		
		return ViewPath.A_TI + "listForm.jsp";
	}
	
	@RequestMapping("/admin/ticketInfo/writeForm")
	public String writeForm(Model model) {
		
		model.addAttribute("path", RedirectPath.A_TI);
		
		return ViewPath.A_TI + "writeForm.jsp";
	}
	
	@RequestMapping("/admin/ticketInfo/write")
	public String write(Model model, TicketInfoVO ti_vo, TicketInfoDataVO tid_vo, HttpServletRequest request, HttpServletResponse response) {
		
		// ti 파일 업로드
		String savePath = application.getRealPath("/resources/upload/product/ticketInfo/mainimg");
		ImgVO imgVo = Util.fileUpload(ti_vo.getPhoto(), savePath);
		System.out.println(imgVo.getImg_name());
		ti_vo.setTi_img(imgVo.getImg_name());
		
		// ti 데이터 삽입
		int no = tiService.tiInsert(ti_vo);
		tid_vo.setTi_no(no);
		String[] arr = request.getParameterValues("tid_value");
		
		if(arr == null) {
			
		}else {
			for(String val : arr) {
				tid_vo = new TicketInfoDataVO(no, val);
				tiService.tidInsert(tid_vo);
			}
		}
		
		
		String msg = "", url = "";
		if(no != 0) {
			
			msg = "등록 성공";
			url = RedirectPath.A_TI +"listForm";
			
		}else {
			msg = "등록 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ViewPath.A_TI + "writeForm.jsp";
	}
	
	@RequestMapping("/admin/ticketInfo/updateForm/{ti_no}") 
	public String updateForm(Model model, @PathVariable("ti_no") int ti_no, TicketInfoDataVO tid_vo) {
		
		// 221201 ti 데이터 출력
		TicketInfoVO ti_vo = tiService.tiSelectOne(ti_no);
		List<TicketInfoDataVO> tid_list = tiService.tidValSelect(ti_no);
		
		model.addAttribute("imgPath", ImgPath.TICKETINFO);
		model.addAttribute("path", RedirectPath.A_TI);

		model.addAttribute("ti_vo", ti_vo);
		model.addAttribute("tid_list", tid_list);

		return ViewPath.A_TI + "updateForm.jsp";
	}
	
//	@RequestMapping(value="/admin/ticketInfo/update", method = {RequestMethod.POST}) 
	@RequestMapping("/admin/ticketInfo/update/{ti_no}") 
	public String update(Model model, TicketInfoVO ti_vo, TicketInfoDataVO tid_vo, @PathVariable("ti_no") int ti_no, HttpServletRequest request, HttpServletResponse response) {
		
		// ti 파일 업로드
		String savePath = application.getRealPath("/resources/upload/product/ticketInfo/mainimg");
		System.out.println(tid_vo.getTid_value());
		// 수정하지 않을 시엔 null이니까 기존의 파일명 넣기
		if(!ti_vo.getPhoto().isEmpty()) {
			ImgVO imgVo = Util.fileUpload(ti_vo.getPhoto(), savePath);
			ti_vo.setTi_img(imgVo.getImg_name());
		}
		
		
		System.out.println(ti_no);
		
		List<TicketInfoDataVO> tid_list = tiService.tidValSelect(ti_no);
		
		// 수정 : 삭제 후 삽입

		
		for(TicketInfoDataVO tid:tid_list) {
			tiService.tidDelete(tid.getTid_no());
		}
		
		String[] arr = request.getParameterValues("tid_value");
		
		for(String val : arr) {
			tid_vo = new TicketInfoDataVO(ti_no, val);
			tiService.tidInsert(tid_vo);
			}
	
		
		
		int check = tiService.tiUpdate(ti_vo);
//
//		tiService.tidUpdate(tid_vo);
		
		
		
		
		String msg = "", url = "";
		if(check != 0) {
			
			msg = "수정 성공";
			url = RedirectPath.A_TI +"listForm";
			
		}else {
			msg = "수정 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ViewPath.A_TI + "listForm.jsp";
	}
	
	
	@RequestMapping("/admin/ticketInfo/deleteForm/{ti_no}")
	public void listForm(HttpServletRequest request, HttpServletResponse response, @PathVariable("ti_no") int ti_no) {
		
		System.out.println(ti_no);
		int check = tiService.delete(ti_no);
		
		String msg = "", url = "";
		if(check != 0) {
			
			msg = "삭제 성공";
			url = RedirectPath.A_TI +"listForm";
			
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
