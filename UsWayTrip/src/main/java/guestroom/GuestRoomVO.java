package guestroom;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GuestRoomVO {
	
	private int gr_no;
	private int lodging_no;
	private String gr_name;
	private String gr_freecancel;
	private String gr_content;
	private String gr_ot;
	private double gr_size;
	private String gr_mainimg;
	private int gr_ap; // 기준 인원
	private int gr_mp; // 최대 인원
	private int gr_count; // 객실 총 갯수
	
	//파일 업로드를 위한 객체
	private MultipartFile mainImg;
	private List<MultipartFile> imgs;
	
	private int[] amenitie;
	private int[] bed_no;
	private int[] bed;
	
	private String lodging_name;
	private String ot_type;
	private int ot_no;
	
	
	public GuestRoomVO() {
		
	}

	
	public int getGr_no() {
		return gr_no;
	}

	public void setGr_no(int gr_no) {
		this.gr_no = gr_no;
	}


	public int getLodging_no() {
		return lodging_no;
	}

	public void setLodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}

	public String getGr_name() {
		return gr_name;
	}

	public void setGr_name(String gr_name) {
		this.gr_name = gr_name;
	}

	public String getGr_freecancel() {
		return gr_freecancel;
	}

	public void setGr_freecancel(String gr_freecancel) {
		this.gr_freecancel = gr_freecancel;
	}

	public String getGr_content() {
		return gr_content;
	}

	public void setGr_content(String gr_content) {
		this.gr_content = gr_content;
	}



	public double getGr_size() {
		return gr_size;
	}

	public void setGr_size(double gr_size) {
		this.gr_size = gr_size;
	}

	public String getGr_mainimg() {
		return gr_mainimg;
	}

	public void setGr_mainimg(String gr_mainimg) {
		this.gr_mainimg = gr_mainimg;
	}


	public int getGr_ap() {
		return gr_ap;
	}


	public void setGr_ap(int gr_ap) {
		this.gr_ap = gr_ap;
	}


	public int getGr_mp() {
		return gr_mp;
	}


	public void setGr_mp(int gr_mp) {
		this.gr_mp = gr_mp;
	}


	public int getGr_count() {
		return gr_count;
	}


	public void setGr_count(int gr_count) {
		this.gr_count = gr_count;
	}


	public String getLodging_name() {
		return lodging_name;
	}


	public void setLodging_name(String lodging_name) {
		this.lodging_name = lodging_name;
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


	public String getGr_ot() {
		return gr_ot;
	}


	public void setGr_ot(String gr_ot) {
		this.gr_ot = gr_ot;
	}
	
	
	public int[] getAmenitie() {
		return amenitie;
	}


	public void setAmenitie(int[] amenitie) {
		this.amenitie = amenitie;
	}
	
	


	public int[] getBed_no() {
		return bed_no;
	}


	public void setBed_no(int[] bed_no) {
		this.bed_no = bed_no;
	}


	public int[] getBed() {
		return bed;
	}


	public void setBed(int[] bed) {
		this.bed = bed;
	}
	
	public String getOt_type() {
		return ot_type;
	}


	public void setOt_type(String ot_type) {
		this.ot_type = ot_type;
	}
	


	public int getOt_no() {
		return ot_no;
	}


	public void setOt_no(int ot_no) {
		this.ot_no = ot_no;
	}


	public void disp() {
		System.out.println("gr_no=="+gr_no );
		System.out.println("lodging_no=="+lodging_no);
		System.out.println("gr_name=="+gr_name);
		System.out.println("gr_freecancel=="+gr_freecancel);
		System.out.println("gr_content=="+gr_content);
		System.out.println("gr_ot=="+gr_ot);
		System.out.println("gr_size=="+gr_size);
		System.out.println("gr_mainimg=="+gr_mainimg);
		System.out.println("gr_ap=="+gr_ap);
		System.out.println("gr_mp=="+gr_mp);
		System.out.println("gr_count=="+gr_count);
		System.out.println("lodging_name=="+lodging_name);
		System.out.println("ot_type=="+ ot_type);
		
	}
	
	
	
	
}
