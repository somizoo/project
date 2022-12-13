package inquiryfile;

public class InquiryFileVO {
	private int inquiry_no;	//식별자번호seq
	private String if_name;	//문의 등록 이미지명
	
	public InquiryFileVO() {
		
	}
	
	public int getInquiry_no() {
		return inquiry_no;
	}
	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}
	public String getIf_name() {
		return if_name;
	}
	public void setIf_name(String if_name) {
		this.if_name = if_name;
	}
}
