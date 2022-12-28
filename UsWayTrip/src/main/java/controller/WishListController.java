package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ImgPath;
import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;
import review.ReviewVO;
import ticket.TicketService;
import ticket.TicketVO;
import wishlist.WishListService;
import wishlist.WishListVO;

@Controller
public class WishListController {
	
	private WishListService wlService;
	private TicketService ticketService;
	private String msg = "";
	private String url = "";
	
	public WishListController(WishListService wlService, TicketService ticketService) {
		this.wlService = wlService;
		this.ticketService = ticketService;
	}
	
	@RequestMapping("/wishList/listForm")
	public String listForm(Model model, HttpServletRequest request) {
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return ViewPath.U_wishList + "listForm.jsp";
		}
		
		List<WishListVO> list = wlService.allList(no);
		List<TicketVO> Tlist = new ArrayList<TicketVO>();
		for(WishListVO vo : list) {
			 TicketVO tvo = ticketService.wishList(vo.getProduct_no()); 
			 
		      // to no list 별점
	         int to_price = ticketService.toMinSelect(tvo.getTicket_no()); 
	         ReviewVO rvo = ticketService.reviewStarSelect(tvo.getTicket_no()); 
	         
	         tvo.setTo_price(to_price);
	         tvo.setReview_star(rvo.getReview_star());
	         tvo.setCnt(rvo.getCnt());
		     Tlist.add(tvo);
		}
		
		model.addAttribute("imgPath", ImgPath.TICKET);
		model.addAttribute("list", list);
		model.addAttribute("Tlist", Tlist);
		
		return ViewPath.U_wishList + "listForm.jsp";
	}
	
	@RequestMapping("/wishList/write")
	@ResponseBody
	public int write(HttpServletResponse response, HttpServletRequest request) {
		Integer no = (Integer)request.getSession().getAttribute("login");
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		String product_sort = request.getParameter("product_sort");
		
		int check = 0;
		
		if(no == null) {
			check = 1;
		}else {
			WishListVO vo = new WishListVO();
			vo.setMember_no(no);
			vo.setProduct_no(product_no);
			vo.setProduct_sort(product_sort);
			int insert = wlService.insert(vo);
			if(insert != 0) {
				check = 2;
			}else {
				check = 3;
			}
		}
		
		return check;
	}
	
	@RequestMapping("/wishList/delete")
	@ResponseBody
	public int delete(HttpServletResponse response, HttpServletRequest request) {
		Integer no = (Integer)request.getSession().getAttribute("login");
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		String product_sort = request.getParameter("product_sort");
		
		int check = 0;
		WishListVO vo = new WishListVO();
		vo.setMember_no(no);
		vo.setProduct_no(product_no);
		vo.setProduct_sort(product_sort);
		int delete = wlService.delete(vo);
		
		if(delete != 0) {
			check = 2;
		}else {
			check = 3;
		}
		
		return check;
		
	}
}
