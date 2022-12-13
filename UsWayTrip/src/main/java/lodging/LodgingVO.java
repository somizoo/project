package lodging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class LodgingVO {
	private int lodging_no;
	private int place_no;
	private int lt_no;
	private String lodging_name;
	private String lodging_address;
	private double lodging_long;
	private double lodging_lat;
	
	private String lodging_grade;
	private String lodging_checkin;
	private String lodging_checkout;
	private String lodging_info;
	private String lodging_refund;
	private String lodging_content;
	private String lodging_minp;
	private String lodging_mainimg;
	private int member_no;
	private int lodging_bprice;
	private String lodging_active; // 숙소 활성 여부	
	
	
	private String member_name;
	private String place_name;
	
	private int[] service_no;
	private int[] facilities_no;
	

	//파일을 받기위한 클래스
	private MultipartFile mainImg;
	private List<MultipartFile> imgs;

	public LodgingVO() {
		
	}
//	public LodgingVO(int lodging_no, int place_no, int lt_no, String lodging_name, String lodging_address,
//			double lodging_long, double lodging_lat, String lodging_grade, String lodging_checkin,
//			String lodging_checkout, String lodging_info, String lodging_refund, String lodging_content,
//			String lodging_minp, String lodging_mainimg, int member_no, int lodging_bprice
//			) {
//		super();
//		this.lodging_no = lodging_no;
//		this.place_no = place_no;
//		this.lt_no = lt_no;
//		this.lodging_name = lodging_name;
//		this.lodging_address = lodging_address;
//		this.lodging_long = lodging_long;
//		this.lodging_lat = lodging_lat;
//		this.lodging_grade = lodging_grade;
//		this.lodging_checkin = lodging_checkin;
//		this.lodging_checkout = lodging_checkout;
//		this.lodging_info = lodging_info;
//		this.lodging_refund = lodging_refund;
//		this.lodging_content = lodging_content;
//		this.lodging_minp = lodging_minp;
//		this.lodging_mainimg = lodging_mainimg;
//		this.member_no = member_no;
//		this.lodging_bprice = lodging_bprice;
//	
//	}

	
	public LodgingVO(int lodging_no, int place_no, int lt_no, String lodging_name, String lodging_address,
			double lodging_long, double lodging_lat, int[] service_no, String lodging_grade, String lodging_checkin,
			String lodging_checkout, String lodging_info, String lodging_refund, String lodging_content,
			String lodging_minp, String lodging_mainimg, int member_no, int lodging_bprice, String member_name,
			String place_name, MultipartFile mainImg, List<MultipartFile> imgs ,String lodging_active) {
		super();
		this.lodging_no = lodging_no;
		this.place_no = place_no;
		this.lt_no = lt_no;
		this.lodging_name = lodging_name;
		this.lodging_address = lodging_address;
		this.lodging_long = lodging_long;
		this.lodging_lat = lodging_lat;
		this.service_no = service_no;
		this.lodging_grade = lodging_grade;
		this.lodging_checkin = lodging_checkin;
		this.lodging_checkout = lodging_checkout;
		this.lodging_info = lodging_info;
		this.lodging_refund = lodging_refund;
		this.lodging_content = lodging_content;
		this.lodging_minp = lodging_minp;
		this.lodging_mainimg = lodging_mainimg;
		this.member_no = member_no;
		this.lodging_bprice = lodging_bprice;
		this.member_name = member_name;
		this.place_name = place_name;
		this.mainImg = mainImg;
		this.imgs = imgs;
		this.lodging_active = lodging_active;
	}
	public MultipartFile getMainImg() {
		return mainImg;
	}

	public void setMainImg(MultipartFile mainImg) {
		this.mainImg = mainImg;
	}

	public List<MultipartFile> getImgs() {
		return imgs;
	}

	public void setImgs(List<MultipartFile> imgs) {
		this.imgs = imgs;
	}
	
	
	
	public int getMember_no() {
		return member_no;
	}
	
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getLodging_no() {
		return lodging_no;
	}
	public void setLodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}
	public int getPlace_no() {
		return place_no;
	}
	public void setPlace_no(int place_no) {
		this.place_no = place_no;
	}
	public int getLt_no() {
		return lt_no;
	}
	public void setLt_no(int lt_no) {
		this.lt_no = lt_no;
	}
	public String getLodging_name() {
		return lodging_name;
	}
	public void setLodging_name(String lodging_name) {
		this.lodging_name = lodging_name;
	}
	public String getLodging_address() {
		return lodging_address;
	}
	public void setLodging_address(String lodging_address) {
		this.lodging_address = lodging_address;
	}
	
	
	public double getLodging_long() {
		return lodging_long;
	}
	public void setLodging_long(double lodging_long) {
		this.lodging_long = lodging_long;
	}
	public double getLodging_lat() {
		return lodging_lat;
	}
	public void setLodging_lat(double lodging_lat) {
		this.lodging_lat = lodging_lat;
	}
	
	
	public String getLodging_grade() {
		return lodging_grade;
	}
	public void setLodging_grade(String lodging_grade) {
		this.lodging_grade = lodging_grade;
	}
	
	
	public String getLodging_checkin() {
		return lodging_checkin;
	}
	public void setLodging_checkin(String lodging_checkin) {
		this.lodging_checkin = lodging_checkin;
	}
	public String getLodging_checkout() {
		return lodging_checkout;
	}
	public void setLodging_checkout(String lodging_checkout) {
		this.lodging_checkout = lodging_checkout;
	}
	
	
	public String getLodging_info() {
		return lodging_info;
	}
	public void setLodging_info(String lodging_info) {
		this.lodging_info = lodging_info;
	}
	public String getLodging_refund() {
		return lodging_refund;
	}
	public void setLodging_refund(String lodging_refund) {
		this.lodging_refund = lodging_refund;
	}
	public String getLodging_content() {
		return lodging_content;
	}
	public void setLodging_content(String lodging_content) {
		this.lodging_content = lodging_content;
	}
	

	public String getLodging_minp() {
		return lodging_minp;
	}
	public void setLodging_minp(String lodging_minp) {
		this.lodging_minp = lodging_minp;
	}
	public String getLodging_mainimg() {
		return lodging_mainimg;
	}
	public void setLodging_mainimg(String lodging_mainimg) {
		this.lodging_mainimg = lodging_mainimg;
	}
	
	public int getLodging_bprice() {
		return lodging_bprice;
	}

	public void setLodging_bprice(int lodging_bprice) {
		this.lodging_bprice = lodging_bprice;
	}
	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	
	public int[] getService_no() {
		return service_no;
	}
	public void setService_no(int[] service_no) {
		this.service_no = service_no;
	}
	
	public int[] getFacilities_no() {
		return facilities_no;
	}
	public void setFacilities_no(int[] facilities_no) {
		this.facilities_no = facilities_no;
	}
	
	public String getLodging_active() {
		return lodging_active;
	}
	public void setLodging_active(String lodging_active) {
		this.lodging_active = lodging_active;
	}
	public void disp() {
		System.out.println("lodging_address " + lodging_address);
		System.out.println("lodging_bprice " +lodging_bprice);
		System.out.println("lodging_checkin "+lodging_checkin);
		System.out.println("lodging_checkout "+lodging_checkout);
		System.out.println("lodging_content "+lodging_content);
		System.out.println("lodging_grade "+lodging_grade);
		System.out.println("lodging_info "+lodging_info);
		System.out.println("lodging_lat "+lodging_lat);
		System.out.println("lodging_long "+lodging_long);
		System.out.println("lodging_mainimg "+lodging_mainimg);
		System.out.println("lodging_minp "+lodging_minp);
		System.out.println("lodging_name "+lodging_name);
		System.out.println("lodging_no "+lodging_no);
		System.out.println("lodging_refund "+lodging_refund);
		System.out.println("member_no "+member_no);
		System.out.println("lt_no "+lt_no);
		System.out.println("place_no "+place_no);
	}
	
	
	
	
}
