package ticketinfo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class TicketInfoVO {
	
	private int ti_no;
	private String ti_name;
	private String ti_img;

	
	private MultipartFile photo;
	
	
	public TicketInfoVO() {
		
	}
	
	public TicketInfoVO(int ti_no, String ti_name, String ti_img) {
		this.ti_no = ti_no;
		this.ti_name = ti_name;
		this.ti_img = ti_img;
	}

	public TicketInfoVO(int ti_no, String ti_name, String ti_img,  MultipartFile photo) {
		super();
		this.ti_no = ti_no;
		this.ti_name = ti_name;
		this.ti_img = ti_img;
		this.photo = photo;
	}


	public int getTi_no() {
		return ti_no;
	}

	public void setTi_no(int ti_no) {
		this.ti_no = ti_no;
	}

	public String getTi_name() {
		return ti_name;
	}

	public void setTi_name(String ti_name) {
		this.ti_name = ti_name;
	}

	public String getTi_img() {
		return ti_img;
	}

	public void setTi_img(String ti_img) {
		this.ti_img = ti_img;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}


	

	

}
