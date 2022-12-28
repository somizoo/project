package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;

import ticketsubcategory.TicketSubCategoryService;
import ticketsubcategory.TicketSubCategoryVO;

@Controller
public class TicketSubCategoryController {
	private TicketSubCategoryService tscService;
	
	public TicketSubCategoryController(TicketSubCategoryService tscService) {
		this.tscService = tscService;
	}
	
	@RequestMapping("/admin/ticketSubCategory/listForm")
	public String list(Model model) {
		List<TicketSubCategoryVO> list = tscService.list();
		
		model.addAttribute("list", list);
		model.addAttribute("path", RedirectPath.A_TSC);
		
		return ViewPath.A_TSC + "listForm.jsp";
	}
	
	
	@RequestMapping("/admin/ticketSubCategory/writeForm")
	public String writeForm(Model model) {
		model.addAttribute("path", RedirectPath.A_TSC);
		return ViewPath.A_TSC + "writeForm.jsp";
	}
	
	@RequestMapping("/admin/ticketSubCategory/write")
	public void write(TicketSubCategoryVO vo, HttpServletResponse response) {
		int check = tscService.write(vo);
		
		String msg = "", url = "";
		if(check != 0) {
			msg = "등록 성공";
			url = RedirectPath.A_TSC +"listForm";
		}else {
			msg = "등록 실패";
			url = "history.go(-1)";
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * seq 매칭하여 updateForm으로 이동시키는 메소드
	 * 22.11.23
	 * */
	@RequestMapping("/admin/ticketSubCategory/updateForm/{seq}")
	public String updateForm(Model model, HttpServletResponse response, HttpServletRequest request, @PathVariable(value = "seq") int seq) {
		
		TicketSubCategoryVO vo = tscService.selectOne(seq);
		model.addAttribute("vo", vo);
		model.addAttribute("path", RedirectPath.A_TSC);
		
		return ViewPath.A_TSC + "updateForm.jsp";
	}
	
	
	/*
	 * 티켓 소분류 데이터 삭제 메소드
	 * 22.11.23
	 * */
	@RequestMapping("/admin/ticketSubCategory/delete/{seq}")
	public void delete(HttpServletResponse response, HttpServletRequest request, @PathVariable(value = "seq") int seq) {
		
		int check = tscService.delete(seq);
		
		String msg = "", url = "";
		if(check != 0) {
			msg = "삭제 성공";
			url = RedirectPath.A_TSC +"listForm";
		}else {
			msg = "삭제 실패";
			url = RedirectPath.A_TSC +"listForm";
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 22.11.29 티켓 소분류 데이터 수정
	 * */
	@RequestMapping("/admin/ticketSubCategory/update")
	public void update(HttpServletResponse response, HttpServletRequest request, TicketSubCategoryVO vo) {
		System.out.println(vo.getTsc_no() + vo.getTsc_name());
		int check = tscService.update(vo);
		
		String msg = "", url = "";
		if(check != 0) {
			msg = "수정 성공";
			url = RedirectPath.A_TSC +"updateForm/"+vo.getTsc_no();
		}else {
			msg = "수정 실패";
			url = RedirectPath.A_TSC +"updateForm/"+vo.getTsc_no();
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
