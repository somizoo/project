package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import agency.AgencyService;
import agency.AgencyVO;
import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;

@Controller
public class AgencyController {
	
	private AgencyService agencyService;
	
	public AgencyController(AgencyService agencyService) {
		this.agencyService = agencyService;
	}
	
	// 여행사로 이동 버튼 눌렀을 경우 실행
	// list를 뿌려주는 역할
	@RequestMapping("/admin/agency/listForm")
	public String listForm(Model model) {
		
		List<AgencyVO> agencyList = agencyService.selectList();
		
		model.addAttribute("al", agencyList);
		model.addAttribute("path", RedirectPath.A_AGENCY);
		
		return ViewPath.A_AGENCY + "listForm.jsp";
	}
	
	// 내용입력 버튼
	@RequestMapping("/admin/agency/writeForm")
	public String writeForm(Model model) {
		
		model.addAttribute("path", RedirectPath.A_AGENCY);
		
		return ViewPath.A_AGENCY + "writeForm.jsp";
	}
	
	@RequestMapping("/admin/agency/write")
	public void write(AgencyVO vo, HttpServletResponse response) {
		
		String agency_content = vo.getAgency_content();
		
		vo.setAgency_content(agency_content.replaceAll("\r\n", "<br>"));
		
		int check = agencyService.insert(vo);
		
		String msg = null;
		String url = null;
		if(check != 0) {
			msg = "글쓰기 성공";
			url = RedirectPath.A_AGENCY + "listForm";
		} else {
			msg = "글쓰기 실패";
			url = RedirectPath.A_AGENCY + "writeForm";
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/admin/agency/updateForm/{agency_no}")
	public String updateForm(Model model, AgencyVO vo, @PathVariable("agency_no") int agency_no) {
		
		vo = agencyService.selectOne(agency_no);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("path", RedirectPath.A_AGENCY);
		
		return ViewPath.A_AGENCY + "updateForm.jsp";
	}
	
	@RequestMapping("admin/agency/update/{agency_no}")
	public void update(HttpServletResponse response, AgencyVO vo, @PathVariable("agency_no") int agency_no) {
						
		int check = agencyService.update(vo);
		String msg = null;
		String url = null;
		
		if(check != 0) {
			msg = "수정완료! 목록으로";
			url = RedirectPath.A_AGENCY + "listForm";
		} else {
			msg = "수정실패! 다시 시도해주세요";
			url = RedirectPath.A_AGENCY + "listForm";
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("admin/agency/delete/{agency_no}")
	public void delete(HttpServletResponse response, @PathVariable("agency_no") int agency_no) {
		
		int check = agencyService.delete(agency_no);
		String msg = null;
		String url = null;
		
		if(check != 0) {
			msg = "삭제완료! 목록으로";
			url = RedirectPath.A_AGENCY + "listForm";
		} else {
			msg = "삭제실패! 다시 시도해주세요";
			url = RedirectPath.A_AGENCY + "listForm";
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
}





















