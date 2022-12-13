package ticketsmallcategory;

public class TicketSmallCategoryVO {
	
	private int tsc_no; // 카테고리 번호seq
	private String tsc_name; // 카테고리 이름
	private int tbc_no; // 카테고리 번호
	
	public TicketSmallCategoryVO() {
		
	}
	
	public TicketSmallCategoryVO(int tsc_no, String tsc_name, int tbc_no) {
		super();
		this.tsc_no = tsc_no;
		this.tsc_name = tsc_name;
		this.tbc_no = tbc_no;
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

	public int getTbc_no() {
		return tbc_no;
	}

	public void setTbc_no(int tbc_no) {
		this.tbc_no = tbc_no;
	}
	
}
