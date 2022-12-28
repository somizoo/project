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
import guestroom.GuestRoomVO;
import guestroomoption.GuestRoomOptionService;
import guestroomoption.GuestRoomOptionVO;

@Controller
public class GuestRoomOptionController {
	private GuestRoomOptionService groService;
	
	public GuestRoomOptionController(GuestRoomOptionService groService) {
		this.groService = groService;
	}
	
	// 객실 옵션 write폼으로 이동
	@RequestMapping("/admin/guestRoomOption/writeForm/{gr_no}/{lodging_no}")
	public String groWriteForm(Model model, @PathVariable("gr_no")int grno,@PathVariable("lodging_no")int lodno) {
		GuestRoomVO vo = groService.grOne(grno);
		System.out.println(lodno);
		model.addAttribute("groPath",RedirectPath.A_GRO);
		model.addAttribute("grPath",RedirectPath.A_GR);
		model.addAttribute("gr_no",grno);
		model.addAttribute("gr",vo);
		model.addAttribute("lod_no",lodno);
		return ViewPath.A_GRO +"writeForm.jsp";
	}
	
	// 객실 등록하는 메소드
	@RequestMapping("/admin/guestRoomOption/write")
	public void groInsert(GuestRoomOptionVO vo,HttpServletRequest request,HttpServletResponse response,Model model) {
		String msg ="";
		String url ="";
		vo.disp();
		if(vo.getGro_bf().equals("y")) {
			int lodno = Integer.parseInt(request.getParameter("lodging_no"));
			int bfprice = groService.getlodbf(lodno);
			vo.setGro_price(vo.getGro_price() + bfprice);
			
		}
		int no = groService.groInsert(vo);
		GuestRoomOptionVO gro = groService.groOne(no);
		
		if(gro != null) {
			msg="객실 옵션이 등록되었습니다.";
			url = RedirectPath.A_GRO +"contentForm/"+ no ;
		}else {
			msg="객실 옵션 등록이 실패하였습니다.";
			url = (String)request.getHeader("REFERER");
		}
		
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 객실 content 폼으로 이동하는 메소드
	@RequestMapping("/admin/guestRoomOption/contentForm/{no}")
	public String guestRoomOptionContent(@PathVariable("no")int no, Model model) {
		GuestRoomOptionVO vo = groService.groOne(no);
		
		model.addAttribute("vo",vo);
		model.addAttribute("groPath",RedirectPath.A_GRO);
		model.addAttribute("grPath",RedirectPath.A_GR);
		return ViewPath.A_GRO +"contentForm.jsp";
	}
	
	// 객실 옵션 삭제 메소드
	@RequestMapping("/admin/guestRoomOption/delete/{grono}/{grno}")
	public void groDelte(@PathVariable("grono")int grono,@PathVariable("grno")int grno,HttpServletRequest request,HttpServletResponse response,Model model) {
		String msg="";
		String url="";
		
		int check = groService.groDelete(grono);
		if(check !=0) {
			msg="객실 옵션이 삭제되었습니다";
			url= RedirectPath.A_GR + "content/" + grno;
		}else {
			msg="객실 옵션 삭제 실패";
			url = (String)request.getHeader("REFERER");
		}
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 객실 리스트 폼으로 이동하는 메소드
	@RequestMapping("/admin/guestRoomOption/listFrom")
	public String groList(Model model) {
		List<GuestRoomOptionVO> groList = groService.groAllList();
		String path = RedirectPath.A_GRO;
		
		model.addAttribute("groList",groList);
		model.addAttribute("path",path);
		return ViewPath.A_GRO +"listForm.jsp";
	}
	
	// 객실 옵션 업데이트 하는 메소드
	@RequestMapping("/admin/guestRoomOption/update")
	public void groUpdate(GuestRoomOptionVO vo,HttpServletRequest request,HttpServletResponse response, Model model) {
		String url ="";
		String msg ="";
		int check = groService.groUpdate(vo);
		if(check != 0) {
			msg = "수정이 완료되었습니다.";
			url = RedirectPath.A_GRO +"contentForm/"+vo.getGro_no() ;
		}else {
			msg ="수정이 실패되었습니다.";
			url= (String)request.getHeader("REFERER");
		}
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}	
	