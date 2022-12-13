package inquiry;

import java.sql.Date;

public class InquiryVO {
	private int inquiry_no;	//식별자번호seq
	private String inquiry_title;	//제목
	private int inquiry_phone;	//전화번호
	private String inquiry_content;	//내용
	private Date inquiry_date;	//작성일
	private String inquiry_answer;	//답변 내용
	private String inquiry_yn;	//답변여부
	
	public InquiryVO() {
		
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public String getInquiry_title() {
		return inquiry_title;
	}

	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	public int getInquiry_phone() {
		return inquiry_phone;
	}

	public void setInquiry_phone(int inquiry_phone) {
		this.inquiry_phone = inquiry_phone;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public Date getInquiry_date() {
		return inquiry_date;
	}

	public void setInquiry_date(Date inquiry_date) {
		this.inquiry_date = inquiry_date;
	}

	public String getInquiry_answer() {
		return inquiry_answer;
	}

	public void setInquiry_answer(String inquiry_answer) {
		this.inquiry_answer = inquiry_answer;
	}

	public String getInquiry_yn() {
		return inquiry_yn;
	}

	public void setInquiry_yn(String inquiry_yn) {
		this.inquiry_yn = inquiry_yn;
	}
	
	
}
