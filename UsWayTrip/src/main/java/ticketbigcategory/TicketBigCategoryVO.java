package ticketbigcategory;

public class TicketBigCategoryVO {
	
	private int tbc_no; // 카테고리 번호seq
	private String tbc_name; // 카테고리 이름
	
	public TicketBigCategoryVO() {
		
	}
	
	public TicketBigCategoryVO(int tbc_no, String tbc_name) {
		super();
		this.tbc_no = tbc_no;
		this.tbc_name = tbc_name;
	}

	public int getTbc_no() {
		return tbc_no;
	}

	public void setTbc_no(int tbc_no) {
		this.tbc_no = tbc_no;
	}

	public String getTbc_name() {
		return tbc_name;
	}

	public void setTbc_name(String tbc_name) {
		this.tbc_name = tbc_name;
	}

}
