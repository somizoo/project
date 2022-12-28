package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;
import managercoupon.ManagerCouponService;
import managercoupon.ManagerCouponVO;

@Controller
public class ManagerCouponController {
	private ManagerCouponService mcService;
	private String msg = "";
	private String url = "";
	
	public ManagerCouponController(ManagerCouponService mcService) {
		this.mcService = mcService;
	}
	
	@RequestMapping("/admin/managerCoupon/listForm")
	public String listForm(Model model) {
		
		List<ManagerCouponVO> list = mcService.allList(); 
		String[] active = new String[] {"<span style='color:blue'>활성</span>", "<span style='color:red'>비활성</span>"};
		
		model.addAttribute("list", list);
		model.addAttribute("path", RedirectPath.A_MC);
		model.addAttribute("active", active);
		
		return ViewPath.A_MC + "listForm.jsp";
	}
	
	@RequestMapping("/admin/managerCoupon/writeForm")
	public String writeForm(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		model.addAttribute("path", RedirectPath.A_MC);
		
		return ViewPath.A_MC + "writeForm.jsp";
		
	}
	
	@RequestMapping("/admin/managerCoupon/createCoupon")
	@ResponseBody
	public String createCoupon() {
		String coupon = "";
		int couponSize = 12;
		final char[] possibleCharacters =
		    {
		    '1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F',
		     'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
		     'W','X','Y','Z'
		    };
		  
		for(int i = couponSize; i > 0; i--) {
			coupon += possibleCharacters[(int) (Math.random() * possibleCharacters.length)];
			if(i == 9 || i == 5) coupon += "-";
		}
		
		return coupon;
	}
	
	@RequestMapping("/admin/managerCoupon/write")
	public void write(Model model, ManagerCouponVO vo, HttpServletRequest request, HttpServletResponse response) {
		int insert = mcService.insert(vo);
		
		
		if(insert != 0) {
			msg = "등록 성공";
			url = RedirectPath.A_MC + "listForm";
		}else {
			msg = "등록 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/admin/managerCoupon/updateForm/{seq}")
	public String updateForm(Model model, @PathVariable(value = "seq") int seq) {
		ManagerCouponVO vo = mcService.selectOne(seq);
		
		model.addAttribute("vo", vo);
		model.addAttribute("path", RedirectPath.A_MC);
		
		return ViewPath.A_MC + "updateForm.jsp";
	}
	
	@RequestMapping("/admin/managerCoupon/update")
	public void update(Model model, ManagerCouponVO vo, HttpServletRequest request, HttpServletResponse response) {
		int update = mcService.update(vo);
		
		if(update != 0) {
			msg = "수정 성공";
			url = RedirectPath.A_MC + "listForm";
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
	
	@RequestMapping("/admin/managerCoupon/delete/{seq}")
	public void delete(Model model, @PathVariable(value = "seq") int seq, ManagerCouponVO vo, HttpServletRequest request, HttpServletResponse response) {
		int delete = mcService.delete(seq);
		
		if(delete != 0) {
			msg = "삭제 성공";
			url = RedirectPath.A_MC + "listForm";
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
