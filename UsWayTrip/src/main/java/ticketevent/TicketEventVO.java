package ticketevent;

import org.springframework.web.multipart.MultipartFile;

public class TicketEventVO {

	private int te_no;	//이벤트번호 seq
	private String te_name; // 이벤트명
	private String te_img; // 이벤트 이미지명
	private String te_active; //이벤트 활성, 비활성
	
	private MultipartFile photo;	//첨부파일
	
	public TicketEventVO() {}
	
	public TicketEventVO(int te_no, String te_name, String te_img, String te_active) {
		this.te_no = te_no;
		this.te_name = te_name;
		this.te_img = te_img;
		this.te_active = te_active;
	}
	
	public TicketEventVO(int te_no, String te_name, String te_img, String te_active, MultipartFile photo) {
		this.te_no = te_no;
		this.te_name = te_name;
		this.te_img = te_img;
		this.te_active = te_active;
		this.photo = photo;
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
	public String getTe_img() {
		return te_img;
	}
	public void setTe_img(String te_img) {
		this.te_img = te_img;
	}
	public String getTe_active() {
		return te_active;
	}
	public void setTe_active(String te_active) {
		this.te_active = te_active;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	public void disp() {
		System.out.println("te_no" + te_no);
		System.out.println("te_name" + te_name);
		System.out.println("te_img" + te_img);
		System.out.println("te_active" + te_active);
	}
	
}
