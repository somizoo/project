package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;
import ticketoption.TicketOptionService;
import ticketoption.TicketOptionVO;
import ticketsubcategory.TicketSubCategoryService;
import ticketsubcategory.TicketSubCategoryVO;

@Controller
public class TicketOptionController {

	private TicketOptionService toService;
	
	public TicketOptionController(TicketOptionService toService) {
		this.toService = toService;
	}
	
	// 221126 ticketoption list 추가
	@RequestMapping("/admin/ticketOption/listForm")
	public String list(Model model, TicketOptionVO vo) {
		
		List<TicketOptionVO> list = toService.selectList();
		
		model.addAttribute("list", list);
		return ViewPath.A_TO+ "listForm.jsp";
	}
	
	// 221126 ticketoption 추가
	@RequestMapping("/admin/ticketOption/writeForm/{vo.ticket_no}/{to_type}")
	public String writeForm(Model model, TicketOptionVO vo, @PathVariable("vo.ticket_no") int ticket_no, @PathVariable("to_type") int to_type, HttpServletRequest request, HttpServletResponse response) {
		
		model.addAttribute("ticket_no", ticket_no);
		return ViewPath.A_TO+ "writeForm.jsp";
	}
	
	
	@RequestMapping("/admin/ticketOption/write/{ticket_no}")
	public String write(Model model, TicketOptionVO vo, @PathVariable("ticket_no") int no, HttpServletRequest request, HttpServletResponse response) {

		int check = toService.insert(vo);
		
		
		String msg = "", url = "";
		if(check != 0) {
			
			msg = "추가 성공";
			url = RedirectPath.A_TICKET +"content/"+no;


		}else {
			msg = "추가 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ViewPath.A_TICKET+ "content.jsp";
	}
	
	
	// 221126 ticketoption 수정
	@RequestMapping("/admin/ticketOption/updateForm/{to_no}")
	public String updateForm(Model model, TicketOptionVO vo, @PathVariable("to_no") int no) {

		vo = toService.selectOne(no);

		model.addAttribute("vo", vo);
		
		return ViewPath.A_TO+ "updateForm.jsp";
	}
	
	@RequestMapping("/admin/ticketOption/update/{to_no}")
	public String update(Model model, TicketOptionVO vo, @PathVariable("to_no") int no, HttpServletRequest request, HttpServletResponse response) {

		int check = toService.update(vo);
		
		String msg = "", url = "";
		if(check != 0) {
			
			msg = "수정 성공";
			url = RedirectPath.A_TO + "listForm";


		}else {
			msg = "수정 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ViewPath.A_TO+ "listForm.jsp";
	}
	
	
	// 221126 ticketoption 삭제
	@RequestMapping("/admin/ticketOption/delete/{to_no}")
	public String delete(Model model, TicketOptionVO vo,  @PathVariable("to_no") int to_no, HttpServletRequest request, HttpServletResponse response) {
		
		int check = toService.delete(to_no);
		
		String msg = "", url = "";
		if(check != 0) {
			
			msg = "삭제 성공";
			url = RedirectPath.A_TO +"listForm";


		}else {
			msg = "삭제 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ViewPath.A_TO+ "listForm.jsp";
	}
	
	@RequestMapping("/admin/ticketOption/deleteContent/{vo.ticket_no}/{to.to_no}")
	public void delete(Model model, TicketOptionVO vo, @PathVariable("vo.ticket_no") int ticket_no, @PathVariable("to.to_no") int to_no, HttpServletRequest request, HttpServletResponse response) {
		
		int check = toService.delete(to_no);
		
		String msg = "", url = "";
		if(check != 0) {
			
			msg = "삭제 성공";
			url = RedirectPath.A_TICKET +"content/"+ticket_no;
			
			
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
