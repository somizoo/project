package ticketinfodata;

public class TicketInfoDataVO {

	private int ti_no;
	private String tid_value; 
	private int tid_no;
	
	private String ti_img;
	private String ti_name;
	
	public TicketInfoDataVO() {
		
	}
	
	public TicketInfoDataVO(int ti_no, String tid_value) {
		super();
		this.ti_no = ti_no;
		this.tid_value = tid_value;
	}

	public int getTi_no() {
		return ti_no;
	}

	public void setTi_no(int ti_no) {
		this.ti_no = ti_no;
	}

	public String getTid_value() {
		return tid_value;
	}

	public void setTid_value(String tid_value) {
		this.tid_value = tid_value;
	}

	public int getTid_no() {
		return tid_no;
	}

	public void setTid_no(int tid_no) {
		this.tid_no = tid_no;
	}

	public String getTi_img() {
		return ti_img;
	}

	public void setTi_img(String ti_img) {
		this.ti_img = ti_img;
	}

	public String getTi_name() {
		return ti_name;
	}

	public void setTi_name(String ti_name) {
		this.ti_name = ti_name;
	}
	
	

}
