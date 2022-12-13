package ticket;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class TicketVO {

   private int ticket_no; // 투어티켓 상품번호seq
   private int place_no; // 지역번호seq
   private int tsc_no; // 카테고리번호seq
   private int member_no; // 회원번호seq
   private String ticket_priceSticker; // 가격 스티커
   private String ticket_title; // 제목
   private String ticket_confirmation; // 즉시확정
   private String ticket_precautions; // 유의사항
   private String ticket_info; // 상품정보 
   private String ticket_route; // 코스 소개
   private String ticket_user; // 이용 안내
   private String ticket_refund; // 취소 및 환불 규정내용
   private int ticket_sold_cnt; // 구매 횟수
   private int mc_no; // 사용쿠폰 번호seq
   private String ticket_img; // 대표이미지
   private int to_type; // 티켓 옵션 타입seq
   private int agency_no; // 여행사번호seq

   private String ticket_valid; // 유효기간
   private int ticket_active; // 티켓 활성/비활성seq
   
   private MultipartFile photo;  // 대표이미지 파일 받을 이미지
   private List<MultipartFile> listPhoto;    // list에 넣으면 다중 파일

   
   // 추가
   private int to_price;
   private double review_star;
   private String tsc_name;
   private String place_name;
   private int te_no;
   private String te_name;
   
   /* 22.12.06 추가*/
   private int cnt; //후기 총 개수 

   
   
   



public TicketVO() {
      
   }


   public TicketVO(int ticket_no, int place_no, int tsc_no, int member_no, String ticket_priceSticker,
         String ticket_title, String ticket_confirmation, String ticket_precautions, String ticket_info,
         String ticket_route, String ticket_user, String ticket_refund, int ticket_sold_cnt, int mc_no,
         String ticket_img, int to_type, int agency_no, String ticket_valid, int ticket_active, MultipartFile photo,
         List<MultipartFile> listPhoto) {
      super();
      this.ticket_no = ticket_no;
      this.place_no = place_no;
      this.tsc_no = tsc_no;
      this.member_no = member_no;
      this.ticket_priceSticker = ticket_priceSticker;
      this.ticket_title = ticket_title;
      this.ticket_confirmation = ticket_confirmation;
      this.ticket_precautions = ticket_precautions;
      this.ticket_info = ticket_info;
      this.ticket_route = ticket_route;
      this.ticket_user = ticket_user;
      this.ticket_refund = ticket_refund;
      this.ticket_sold_cnt = ticket_sold_cnt;
      this.mc_no = mc_no;
      this.ticket_img = ticket_img;
      this.to_type = to_type;
      this.agency_no = agency_no;
      this.ticket_valid = ticket_valid;
      this.ticket_active = ticket_active;
      this.photo = photo;
      this.listPhoto = listPhoto;
   }
   

	public TicketVO(int ticket_no, int place_no, int tsc_no, int member_no, String ticket_priceSticker, String ticket_title,
		String ticket_confirmation, String ticket_precautions, String ticket_info, String ticket_route,
		String ticket_user, String ticket_refund, int ticket_sold_cnt, int mc_no, String ticket_img, int to_type,
		int agency_no, String ticket_valid, int ticket_active, MultipartFile photo, List<MultipartFile> listPhoto,
		int to_price, double review_star, String tsc_name, String place_name, int te_no, String te_name, int cnt) {
		super();
		this.ticket_no = ticket_no;
		this.place_no = place_no;
		this.tsc_no = tsc_no;
		this.member_no = member_no;
		this.ticket_priceSticker = ticket_priceSticker;
		this.ticket_title = ticket_title;
		this.ticket_confirmation = ticket_confirmation;
		this.ticket_precautions = ticket_precautions;
		this.ticket_info = ticket_info;
		this.ticket_route = ticket_route;
		this.ticket_user = ticket_user;
		this.ticket_refund = ticket_refund;
		this.ticket_sold_cnt = ticket_sold_cnt;
		this.mc_no = mc_no;
		this.ticket_img = ticket_img;
		this.to_type = to_type;
		this.agency_no = agency_no;
		this.ticket_valid = ticket_valid;
		this.ticket_active = ticket_active;
		this.photo = photo;
		this.listPhoto = listPhoto;
		this.to_price = to_price;
		this.review_star = review_star;
		this.tsc_name = tsc_name;
		this.place_name = place_name;
		this.te_no = te_no;
		this.te_name = te_name;
		this.cnt = cnt;
	}


	public int getTicket_no() {
		return ticket_no;
	}
	
	
	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}
	
	
	public int getPlace_no() {
		return place_no;
	}
	
	
	public void setPlace_no(int place_no) {
		this.place_no = place_no;
	}
	
	
	public int getTsc_no() {
		return tsc_no;
	}
	
	
	public void setTsc_no(int tsc_no) {
		this.tsc_no = tsc_no;
	}
	
	
	public int getMember_no() {
		return member_no;
	}
	
	
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	
	public String getTicket_priceSticker() {
		return ticket_priceSticker;
	}
	
	
	public void setTicket_priceSticker(String ticket_priceSticker) {
		this.ticket_priceSticker = ticket_priceSticker;
	}
	
	
	public String getTicket_title() {
		return ticket_title;
	}
	
	
	public void setTicket_title(String ticket_title) {
		this.ticket_title = ticket_title;
	}
	
	
	public String getTicket_confirmation() {
		return ticket_confirmation;
	}
	
	
	public void setTicket_confirmation(String ticket_confirmation) {
		this.ticket_confirmation = ticket_confirmation;
	}
	
	
	public String getTicket_precautions() {
		return ticket_precautions;
	}
	
	
	public void setTicket_precautions(String ticket_precautions) {
		this.ticket_precautions = ticket_precautions;
	}
	
	
	public String getTicket_info() {
		return ticket_info;
	}
	
	
	public void setTicket_info(String ticket_info) {
		this.ticket_info = ticket_info;
	}
	
	
	public String getTicket_route() {
		return ticket_route;
	}
	
	
	public void setTicket_route(String ticket_route) {
		this.ticket_route = ticket_route;
	}
	
	
	public String getTicket_user() {
		return ticket_user;
	}
	
	
	public void setTicket_user(String ticket_user) {
		this.ticket_user = ticket_user;
	}
	
	
	public String getTicket_refund() {
		return ticket_refund;
	}
	
	
	public void setTicket_refund(String ticket_refund) {
		this.ticket_refund = ticket_refund;
	}
	
	
	public int getTicket_sold_cnt() {
		return ticket_sold_cnt;
	}
	
	
	public void setTicket_sold_cnt(int ticket_sold_cnt) {
		this.ticket_sold_cnt = ticket_sold_cnt;
	}
	
	
	public int getMc_no() {
		return mc_no;
	}
	
	
	public void setMc_no(int mc_no) {
		this.mc_no = mc_no;
	}
	
	
	public String getTicket_img() {
		return ticket_img;
	}
	
	
	public void setTicket_img(String ticket_img) {
		this.ticket_img = ticket_img;
	}
	
	
	public int getTo_type() {
		return to_type;
	}
	
	
	public void setTo_type(int to_type) {
		this.to_type = to_type;
	}
	
	
	public int getAgency_no() {
		return agency_no;
	}
	
	
	public void setAgency_no(int agency_no) {
		this.agency_no = agency_no;
	}
	
	
	public String getTicket_valid() {
		return ticket_valid;
	}
	
	
	public void setTicket_valid(String ticket_valid) {
		this.ticket_valid = ticket_valid;
	}
	
	
	public int getTicket_active() {
		return ticket_active;
	}
	
	
	public void setTicket_active(int ticket_active) {
		this.ticket_active = ticket_active;
	}
	
	
	public MultipartFile getPhoto() {
		return photo;
	}
	
	
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	public List<MultipartFile> getListPhoto() {
		return listPhoto;
	}
	
	
	public void setListPhoto(List<MultipartFile> listPhoto) {
		this.listPhoto = listPhoto;
	}
	
	
	public int getTo_price() {
		return to_price;
	}
	
	
	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}
	
	
	public double getReview_star() {
		return review_star;
	}
	
	
	public void setReview_star(double review_star) {
		this.review_star = review_star;
	}
	
	
	public String getTsc_name() {
		return tsc_name;
	}
	
	
	public void setTsc_name(String tsc_name) {
		this.tsc_name = tsc_name;
	}
	
	
	public String getPlace_name() {
		return place_name;
	}
	
	
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	
	
	public int getTe_no() {
		return te_no;
	}
	
	
	public void setTe_no(int te_no) {
		this.te_no = te_no;
	}
	
	
	public String getTe_name() {
		return te_name;
	}
	
	
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	
	
	public int getCnt() {
		return cnt;
	}
	
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}



   
   
   
   
   

//   public void disp() {
//      System.out.println("ticket_no : " + ticket_no);
//      System.out.println("tsc_no : " + tsc_no);
//      System.out.println("member_no : " + member_no);
//      System.out.println("ticket_priceSticker" + ticket_priceSticker);
//      System.out.println("ticket_title : " + ticket_title);
//      System.out.println("ticket_confirmation : " + ticket_confirmation);
//      System.out.println("ticket_precautions : " + ticket_precautions);
//      System.out.println("ticket_info : " + ticket_info);
//      System.out.println("ticket_route " + ticket_route );
//      System.out.println("ticket_user : " + ticket_user);
//      System.out.println("ticket_refund : " + ticket_refund);
//      System.out.println("ticket_sold_cnt : " + ticket_sold_cnt);
//      System.out.println("ticket_img : " + ticket_img);
//      System.out.println("to_type : " + to_type);
//   }

   
   
}