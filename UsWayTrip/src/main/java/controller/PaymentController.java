package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ImgPath;
import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;
import guestroom.GuestRoomVO;
import guestroombed.GuestRoomBedVO;
import lodging.LodgingVO;
import managercoupon.ManagerCouponVO;
import payment.PaymentService;
import payment.PaymentVO;
import ticket.TicketVO;
import ticketoption.TicketOptionVO;

@Controller
public class PaymentController {
	private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@RequestMapping("/paymentForm")
	public String paymentForm(Model model, HttpServletRequest request, HttpServletResponse response) {
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		Integer member_no = (Integer)request.getSession().getAttribute("login");
		
		if(member_no == null) {
			try {
				ScriptUtil.alertAndMovePage(response, "로그인 후 이용가능합니다.", RedirectPath.U_MEMBER + "loginForm");
			} catch (IOException e) {
				e.printStackTrace();
			}
	      
		}
		
		String product_sort = request.getParameter("product_sort");
		String returnUrl = "";
		String uname = paymentService.getName(member_no);
		
		if(product_sort.equals("l")) {//숙소 정보
			//product_no로 숙소정보 가져오기
			// + 객실 + 객실 옵션 정보 (파라미터로 처리) + 가격, 쿠폰여부
			
			//객실 seq
			int gr_no = Integer.parseInt(request.getParameter("gr_no"));
			
			//객실 옵션 seq
			int gro_no = Integer.parseInt(request.getParameter("gro_no"));
			//체크인
			Date checkIn = Date.valueOf(request.getParameter("checkIn"));
			//체크아웃
			Date checkOut = Date.valueOf(request.getParameter("checkOut"));
			
			//인원
			int person = request.getParameter("payment_people") == null ? 0 : Integer.parseInt(request.getParameter("payment_people"));
			
			
			//숙소정보 가져오기
			LodgingVO lodgingvo = paymentService.lodgingSelectOne(product_no);
			
			//객실정보 가져오기
			GuestRoomVO grvo = paymentService.guestSelectOne(gr_no);
			
			//객실옵션 가져오기
			List<GuestRoomBedVO> grbList = paymentService.guestBeds(gr_no);
			
			//숙소 쿠폰정보 가져오기
			ManagerCouponVO mcvo = paymentService.getlodcupon(product_no);
			
			//객실 원가 가져오기
			int price = paymentService.lodgingGetPrice(gro_no);
			price = price * person;
			
			model.addAttribute("product_no", product_no);
			model.addAttribute("gr_no", gr_no);
			model.addAttribute("gro_no", gro_no);
			
			model.addAttribute("lodgingvo", lodgingvo);
			model.addAttribute("grvo", grvo);
			model.addAttribute("grbList", grbList);
			model.addAttribute("mcvo", mcvo);
			model.addAttribute("imgPath", ImgPath.LODGING);
			model.addAttribute("imgGrPath",ImgPath.GUEST);
			model.addAttribute("checkIn", checkIn);
			model.addAttribute("checkOut", checkOut);
			model.addAttribute("person", person);
			model.addAttribute("price", price);
			model.addAttribute("grbList", grbList);
			model.addAttribute("path", RedirectPath.U_PAYMENT);
			returnUrl = ViewPath.U_PAYMENT + "lodgingPayForm.jsp";
		
		}else if(product_sort.contentEquals("t")) {//티켓정보 
			
			 String[] to_nums= request.getParameterValues("to_nums");
		     String[] cnts = request.getParameterValues("cnts");
		     
		     int tmp = 0;
		     
		     for(int i=0; i < cnts.length; i++) {
		    	 tmp += Integer.parseInt(cnts[i]);
		     }
		     if(tmp == 0) {
		    	 try {
					ScriptUtil.alertAndBackPage(response, "티켓 옵션을 선택하셔야 합니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
		     }

		     if(to_nums.length == 0) {
		    	 try {
					ScriptUtil.alertAndBackPage(response, "티켓 수량을 선택해야 합니다");
				} catch (IOException e) {
					e.printStackTrace();
				}
		     }
		   
		    
		      //Map<String, String> map = new HashMap<String, String>();
		     List<String> to_num = new ArrayList<String>();
		     List<String> cnt = new ArrayList<String>();
		      for(int i = 0; i < to_nums.length; i++) {
		         if(!cnts[i].equals("0")) {
		        	to_num.add(to_nums[i]);
		        	cnt.add(cnts[i]);
		         }
		      }
			
			List<TicketOptionVO> toList = new ArrayList<TicketOptionVO>();
			int totalPrice = 0;
			int z = 0;
			for(String key : to_num) {
				int val = Integer.parseInt(key);
				TicketOptionVO tovo = paymentService.selectOne(val);
				totalPrice += (tovo.getTo_price() * Integer.parseInt(cnt.get(z)));
				
				toList.add(tovo);
				z++;
			}
			
			// 티켓 정보 가져오기
			TicketVO ticketVO = paymentService.ticketSelectOne(product_no);
			
			model.addAttribute("imgTicket", ImgPath.TICKET);
			model.addAttribute("to_num", to_num);
			model.addAttribute("cnts", cnt);
			model.addAttribute("ticketVO", ticketVO);
			model.addAttribute("toList", toList);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("path", RedirectPath.U_TICKET);
			
			returnUrl = ViewPath.U_PAYMENT + "ticketPayForm.jsp";
		}
		
		model.addAttribute("member_no", member_no);
		model.addAttribute("uname", uname);
		model.addAttribute("product_sort", product_sort);
		
		
		return returnUrl;
	}
	
	
	@RequestMapping("/payment/payment")
	public void payment(HttpServletRequest request, HttpServletResponse response, PaymentVO vo) {
		
		LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 포맷 적용
        String formatedNow = now.format(formatter);
 
		//결제아이디 세팅
		String payment_id = formatedNow+vo.getProduct_sort()+(int)((Math.random() * 9999) + 1);
		String msg ="", url ="";
		
		
		vo.setPayment_id(payment_id);
		System.out.println(vo.toString());
		
		int insert = paymentService.insert(vo);
		
		if(insert != 0) {
			msg = "결제 완료";
			url = RedirectPath.U_PAYMENT + "reservation";
		}else {
			msg = "결제 실패";
			url = (String)request.getHeader("REFERER");
		}
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/payment/reservation")
	public String reservation(Model model, HttpServletRequest request) {
		
		String product_sort = request.getParameter("product_sort");
		
		Integer member_no = (Integer)request.getSession().getAttribute("login");
		String uname = paymentService.getName(member_no);
		PaymentVO vo = paymentService.SelectOne(member_no);
		
		String 	returnUrl = "";
		
		if(vo.getProduct_sort().equals("l")) {
		
			//숙소정보 가져오기
			LodgingVO lodgingvo = paymentService.lodgingSelectOne(vo.getProduct_no());
			
			//객실정보 가져오기
			GuestRoomVO grvo = paymentService.guestSelectOne(vo.getGr_no());
		
			//객실옵션 가져오기
			List<GuestRoomBedVO> grbList = paymentService.guestBeds(vo.getGr_no());
			
			model.addAttribute("lodgingvo", lodgingvo);
			model.addAttribute("grvo", grvo);
			model.addAttribute("grbList", grbList);
			model.addAttribute("imgPath", ImgPath.LODGING);
			model.addAttribute("imgGrPath",ImgPath.GUEST);
			model.addAttribute("grbList", grbList);
			model.addAttribute("uname", uname);
			
			returnUrl = ViewPath.U_PAYMENT + "reservationLodging.jsp";
		
		}else if(vo.getProduct_sort().equals("t")) {
			
			int product_no = Integer.parseInt(request.getParameter("product_no"));
			 String[] to_title= request.getParameterValues("to_title");
		     String[] to_price = request.getParameterValues("to_price");
		     String[] cnt = request.getParameterValues("cnt");
		     int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		     
			
			// 티켓 정보 가져오기
			TicketVO ticketVO = paymentService.ticketSelectOne(product_no);
			
			model.addAttribute("imgTicket", ImgPath.TICKET);
			model.addAttribute("to_title", to_title);
			model.addAttribute("to_price", to_price);
			model.addAttribute("ticketVO", ticketVO);
			model.addAttribute("cnt", cnt);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("path", RedirectPath.U_TICKET);
			
			returnUrl = ViewPath.U_PAYMENT + "reservationTicket.jsp";
		}

		model.addAttribute("member_no", member_no);
		model.addAttribute("uname", uname);
		model.addAttribute("product_sort", product_sort);
		
	//	model.addAttribute("vo", vo);
		// 12.08 추가
		model.addAttribute("reviewPath", RedirectPath.U_REVIEW);
		
		return returnUrl;
	}
}
