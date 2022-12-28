package cancelreason;

public class CancelReasonVO {
	
	private int cr_no;
	private String cr_reason;
	
	public CancelReasonVO() {
		
	}
	
	public CancelReasonVO(int cr_no, String cr_reason) {
		super();
		this.cr_no = cr_no;
		this.cr_reason = cr_reason;
	}

	public int getCr_no() {
		return cr_no;
	}

	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}

	public String getCr_reason() {
		return cr_reason;
	}

	public void setCr_reason(String cr_reason) {
		this.cr_reason = cr_reason;
	}
}
