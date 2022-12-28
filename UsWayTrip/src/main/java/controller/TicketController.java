package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.ImgPath;
import common.RedirectPath;
import common.ScriptUtil;
import common.Util;
import common.ViewPath;
import img.ImgVO;
import place.PlaceVO;
import review.ReviewVO;
import ticket.TicketService;
import ticket.TicketVO;
import ticketevent.TicketEventVO;
import ticketeventdata.TicketEventDataVO;
import ticketinfo.TicketInfoVO;
import ticketinfodata.TicketInfoDataVO;
import ticketinfojoin.TicketInfoJoinVO;
import ticketoption.TicketOptionVO;
import ticketsubcategory.TicketSubCategoryService;
import ticketsubcategory.TicketSubCategoryVO;


@Controller
public class TicketController {
   
   private TicketService ticketService;
   private TicketSubCategoryService tscService;
   
   @Autowired // 자동 주입
   private ServletContext application;

   public TicketController(TicketService ticketService, TicketSubCategoryService tscService) {
      this.ticketService = ticketService;
      this.tscService = tscService;
   }
   
   /*
    * 게시글 리스트 형식으로 출력
    * 22.11.23
    * 22.12.08 추가
    * 22.12.08 wishlist 수정
    * */
   @RequestMapping(value = {"/admin/ticket/listForm", "/ticket/listForm"})
   public String listForm(TicketVO vo, HttpServletRequest request) {
      Integer member_no = (Integer)request.getSession().getAttribute("login");
      List<TicketVO> list = ticketService.selectList(); 
      // 최저가, 별점 평균
      for(TicketVO one : list) {
          Integer to_price = ticketService.toMinSelect(one.getTicket_no()); 
          ReviewVO rvo = ticketService.reviewStarSelect(one.getTicket_no()); 
            
            one.setTo_price(to_price);
            one.setReview_star(rvo.getReview_star());
            one.setCnt(rvo.getCnt());
      }

      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      Map<String, Integer> tmp = new HashMap<String, Integer>();
      
      
      if(member_no != null) {
         for(TicketVO tvo : list) {
         // 위시리스트
            tmp.put("ticket_no", tvo.getTicket_no());
            tmp.put("member_no", member_no);
            int cnt = ticketService.wishChoice(tmp);
                        
            boolean check = false;
            
            if(cnt > 0) check = true;
            map.put(tvo.getTicket_no(), check);
         
         
         }
      }

      
      request.setAttribute("imgPath", ImgPath.TICKET);

      request.setAttribute("list", list);
      request.setAttribute("map", map);
      
      
      String url = "";
      
      /* 22.12.07 추가*/
      if(request.getServletPath().equals("/admin/ticket/listForm")) {
         url= ViewPath.A_TICKET +"listForm.jsp";
      }else {
         url = ViewPath.U_TICKET +"listForm.jsp";
      }
      return url;
   }
   
   /*
    * ticket 상품 추가 폼
    * 22.11.23
    * */
   @RequestMapping("/admin/ticket/writeForm")
   public String writeForm(Model model) {
      
//      int no = ticketService.noSelect();
      
      List<TicketSubCategoryVO> tsc_list = ticketService.tscSelectList();
      
      List<TicketEventVO> teList = ticketService.teSelectList();

      List<TicketInfoVO> ti_list = ticketService.tiSelectList();
      
      List<PlaceVO> place_list = ticketService.placeSelectList();
      
      Map<Integer, List<TicketInfoDataVO>> map = new HashMap<Integer, List<TicketInfoDataVO>>();
      
      for(TicketInfoVO ti : ti_list) {
         List<TicketInfoDataVO> tid_list = ticketService.tidSelectValList(ti.getTi_no());
         map.put(ti.getTi_no(), tid_list);
      }
      
      
      
      
      model.addAttribute("tsc_list", tsc_list);
      model.addAttribute("teList", teList);
      model.addAttribute("ti_list", ti_list);
      model.addAttribute("place_list", place_list);
      model.addAttribute("map", map);
      
      
      return ViewPath.A_TICKET + "writeForm.jsp"; 
   }
   
   /*
    * ticket 상품 추가
    * 22.11.23
    * */
   @RequestMapping("/admin/ticket/write")
   public void write(Model model, TicketVO vo, TicketEventVO te_vo, ImgVO imgvo, HttpServletRequest request, HttpServletResponse response) {
      
      
      //단일 업로드 - 메인
      String savePathMain = application.getRealPath("/resources/upload/product/ticket/mainimg");
      ImgVO imgVo = Util.fileUpload(vo.getPhoto(), savePathMain);
      vo.setTicket_img(imgVo.getImg_name()); 
      
      // 다중 업로드
      String savePath = application.getRealPath("/resources/upload/product/ticket");
      List<ImgVO> Imglist = Util.fileListUpload(vo.getListPhoto(), savePath);


      // write 줄 enter
      String pre = vo.getTicket_precautions();
      String route = vo.getTicket_route ();
      String user = vo.getTicket_user();
      String refund = vo.getTicket_refund();
      vo.setTicket_precautions(pre.replaceAll("\r\n", "<br>"));
      vo.setTicket_route(route.replaceAll("\r\n", "<br>"));
      vo.setTicket_user(user.replaceAll("\r\n", "<br>"));
      vo.setTicket_refund(refund.replaceAll("\r\n", "<br>"));
   
      // tsc
      int tsc_no = Integer.parseInt(request.getParameter("tsc_no"));
      vo.setTsc_no(tsc_no);      
      
      // valid 
      String date = request.getParameter("date");
      vo.setTicket_valid(date);

      // ticketoption select
      int to_type = Integer.parseInt(request.getParameter("to_type"));   
      vo.setTo_type(to_type);
      
      // ticket 테이블 데이터 삽입. no는 상품 번호
      int no = ticketService.ticketInsert(vo);
      
      for(ImgVO img : Imglist) {
         imgvo = new ImgVO(no, img.getImg_name(), img.getImg_extension());
         
         //img 테이블 insert
         ticketService.imgInsert(imgvo);
      }
      

      // ticketevent 체크박스 값 가져오기
      String[] arr = request.getParameterValues("te_event");
      
      // ticketeventdata 데이터 삽입
      for(String te_no : arr) {
         TicketEventDataVO ted_vo = new TicketEventDataVO(Integer.parseInt(te_no), no);
         ticketService.teInsert(ted_vo);
      }
      
   
      // 221202 select 값 가져오고 tij 삽입
      int i = 0;
      List<TicketInfoVO> ti_list = ticketService.tiSelectList();

      for(TicketInfoVO ti : ti_list) {
         if(ti.getTi_name() != null) {
            if(request.getParameter(""+i) != null) {
               int tid_no = Integer.parseInt(request.getParameter(""+i));
               TicketInfoJoinVO tij = new TicketInfoJoinVO(no, tid_no);
               ticketService.tijInsert(tij);
               i++;
               
            }else {
               i++;
            }
         }else {
            break;
         }
      }
      
      model.addAttribute("path", RedirectPath.A_TICKET);

      model.addAttribute("no", no);
      model.addAttribute("arr", arr);
      model.addAttribute("date", date);
      
      String msg = "", url = "";
      if(no != 0) {
         
         msg = "등록 성공";
         url = RedirectPath.A_TICKET +"content/" + no;
         
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
   
   /*
    * ticket 상품 내용
    * 22.11.23
    * 22.12.07 수정
    * 22.12.08 wishlist 수정
    * */
   @RequestMapping(value = {"/admin/ticket/content/{vo.ticket_no}", "/ticket/content/{vo.ticket_no}"})
   public String contentForm(Model model, @PathVariable("vo.ticket_no") int no, TicketVO vo, ImgVO imgvo, TicketOptionVO to_vo, HttpServletRequest request) {
 
      vo = ticketService.selectOne(no);
      
      List<TicketVO> list = ticketService.selectList(); 


      Integer member_no = (Integer)request.getSession().getAttribute("login");

//      Integer to_price = ticketService.toMinSelect(vo.getTicket_no()); 
         ReviewVO rvo = ticketService.reviewStarSelect(vo.getTicket_no()); 
        
       vo.setReview_star(rvo.getReview_star()); 
        vo.setCnt(rvo.getCnt());
  
      
      // 카테고리 이름
      String tsc_name = ticketService.tscSelectOne(vo.getTsc_no());
      
      // place
      String place_name = ticketService.placeSelectOne(vo.getPlace_no());
      
      // ticketOption
      to_vo = ticketService.toSelectOne(no);
      List<TicketOptionVO> toList = ticketService.toSelectList(no);
      
      int to_price = ticketService.toMinSelect(no);
      
      // 다중 img select
      List<ImgVO> multiImg = ticketService.multiImgSelect(no);

      // ticketeventdata 이름 뽑기
      List<String> te_name_list = ticketService.teNameSelectList(no);
      
      // ticketinfojoin 데이터 뽑기      
      List<TicketInfoDataVO> tij_list = ticketService.tijSelect(no);
      
      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      Map<String, Integer> tmp = new HashMap<String, Integer>();
      
      if(member_no != null) {
         for(TicketVO tvo : list) {
         // 위시리스트
            tmp.put("ticket_no", tvo.getTicket_no());
            tmp.put("member_no", member_no);
            int cnt = ticketService.wishChoice(tmp);
            
            boolean check = false;
            
            if(cnt > 0) check = true;
            map.put(tvo.getTicket_no(), check);
         }
      }
   // 12.09 추가 
      List<ReviewVO> ticketRivew = ticketService.reviewList(no);
      
      model.addAttribute("path", ImgPath.TICKETINFO);
      model.addAttribute("reviewList",ticketRivew);
      model.addAttribute("vo", vo);
      model.addAttribute("list", list);
      model.addAttribute("tsc_name", tsc_name);
      model.addAttribute("place_name", place_name);
      model.addAttribute("to_vo", to_vo);
      model.addAttribute("to_price", to_price);
      model.addAttribute("toList", toList);
      model.addAttribute("multiImg", multiImg);
      model.addAttribute("te_name_list", te_name_list);
      model.addAttribute("tij_list", tij_list);
      
      model.addAttribute("map", map);
      

      String url = "";
      
      /* 22.12.07 추가*/
      if(request.getServletPath().equals("/admin/ticket/content/"+no)) {
         url= ViewPath.A_TICKET +"contentForm.jsp";
      }else {
         url = ViewPath.U_TICKET +"contentForm.jsp";
      }
      return url;

   }
   
   // 22.12.07 수정
   @RequestMapping("/admin/ticket/updateForm/{vo.ticket_no}")
   public String updateForm(Model model, @PathVariable("vo.ticket_no") int no, TicketVO vo, ImgVO imgvo, HttpServletRequest request) {
      
      vo = ticketService.joinSelectOne(no);
      
      List<PlaceVO> place_list = ticketService.placeSelectList();
      
      List<TicketSubCategoryVO> tsc_list = ticketService.tscSelectList();
      
      // te 이름, 값
      List<TicketEventVO> te_list = ticketService.teSelectList();
      List<Integer> te_no = ticketService.joinTeSelectList(no);
      
      
      List<TicketInfoVO> ti_list = ticketService.tiSelectList();

      List<TicketInfoDataVO> tij_list = ticketService.tijSelect(no);

      Map<Integer, List<TicketInfoDataVO>> map = new HashMap<Integer, List<TicketInfoDataVO>>();
      
      for(TicketInfoVO ti : ti_list) {
         List<TicketInfoDataVO> tid_list = ticketService.tidSelectValList(ti.getTi_no());
         map.put(ti.getTi_no(), tid_list);
      }

      List<ImgVO> multiImg = ticketService.multiImgSelect(no);
//      
//      // write 줄 enter
      String pre = vo.getTicket_precautions();
      String route = vo.getTicket_route();
      String user = vo.getTicket_user();
      String refund = vo.getTicket_refund();
      
      if(pre != null) {
         vo.setTicket_precautions(pre.replaceAll("<br>", "\r\n"));
      }
      

      vo.setTicket_route(route.replaceAll("<br>", "\r\n"));
      vo.setTicket_user(user.replaceAll("<br>", "\r\n"));
      vo.setTicket_refund(refund.replaceAll("<br>", "\r\n"));

      model.addAttribute("vo", vo);
      model.addAttribute("place_list", place_list);
      model.addAttribute("te_list", te_list);
      model.addAttribute("te_no", te_no);
      model.addAttribute("tsc_list", tsc_list);
//      model.addAttribute("ti_list", ti_list);
//      model.addAttribute("tij_list", tij_list);
//      model.addAttribute("map", map);
      model.addAttribute("multiImg", multiImg);
      
      return ViewPath.A_TICKET + "updateForm.jsp";
 
   }
   
   // 22.12.07 수정
   @RequestMapping("/admin/ticket/update/{ticket_no}")
   public void update(@PathVariable("ticket_no") int no, TicketVO vo, HttpServletRequest request, HttpServletResponse response) {

      vo.setTicket_no(no);
      
      // 날짜
      String date = request.getParameter("date");
      vo.setTicket_valid(date);
      
      // 스티커
      String ticket_priceSticker = request.getParameter("ticket_priceSticker");   
      vo.setTicket_priceSticker(ticket_priceSticker);
      
      // to_type
      int to_type = Integer.parseInt(request.getParameter("to_type"));   
      vo.setTo_type(to_type);
      
      // te
      String[] arr = request.getParameterValues("te_event");
      
      // te 삭제
      
      // ticketeventdata 데이터 삽입
      for(String te_no : arr) {
         ticketService.teDelete(vo);
         TicketEventDataVO ted_vo = new TicketEventDataVO(Integer.parseInt(te_no), no);
         ticketService.teInsert(ted_vo);
      }
      
      
      
      String pre = vo.getTicket_precautions();
      String route = vo.getTicket_route ();
      String user = vo.getTicket_user();
      String refund = vo.getTicket_refund();
      vo.setTicket_precautions(pre.replaceAll("\r\n", "<br>"));
      vo.setTicket_route(route.replaceAll("\r\n", "<br>"));
      vo.setTicket_user(user.replaceAll("\r\n", "<br>"));
      vo.setTicket_refund(refund.replaceAll("\r\n", "<br>"));
//      
      int check = ticketService.update(vo);
      
      String msg = "", url = "";
      if(check != 0) {
         
         msg = "수정 성공";
         url = RedirectPath.A_TICKET +"content/" + no;
         
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
   
   /*
    * ticket 상품 삭제
    * 22.11.25
    * */
   @RequestMapping("/admin/ticket/deleteForm/{vo.ticket_no}")
   public String deleteForm(Model model, @PathVariable("vo.ticket_no") int no, TicketVO vo, HttpServletRequest request, HttpServletResponse response) {

      int check = ticketService.delete(no);
      
      String msg = "", url = "";
      if(check != 0) {
         
         msg = "삭제 성공";
         url = RedirectPath.A_TICKET +"listForm";
         
      }else {
         msg = "삭제 실패";
         url = (String)request.getHeader("REFERER");
      }
      
      try {
         ScriptUtil.alertAndMovePage(response, msg, url);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return ViewPath.A_TICKET + "deleteForm.jsp"; 
   }
}

