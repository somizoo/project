package ticketsubcategory;

public class TicketSubCategoryVO {
	
	private int tsc_no; // 소분류 번호seq
	private String tsc_name; // 소분류 이름
	
	public TicketSubCategoryVO() {
		
	}
	
	public TicketSubCategoryVO(int tsc_no, String tsc_name) {
		super();
		this.tsc_no = tsc_no;
		this.tsc_name = tsc_name;
	}

	public int getTsc_no() {
		return tsc_no;
	}

	public void setTsc_no(int tsc_no) {
		this.tsc_no = tsc_no;
	}

	public String getTsc_name() {
		return tsc_name;
	}

	public void setTsc_name(String tsc_name) {
		this.tsc_name = tsc_name;
	}
}
