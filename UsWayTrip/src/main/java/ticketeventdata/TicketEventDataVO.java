package ticketeventdata;

public class TicketEventDataVO {
	
	private int te_no;
	private int ticket_no;
	
	public TicketEventDataVO() {
	
	}
	
	public TicketEventDataVO(int te_no, int ticket_no) {
		super();
		this.te_no = te_no;
		this.ticket_no = ticket_no;
	}

	public int getTe_no() {
		return te_no;
	}
	public void setTe_no(int te_no) {
		this.te_no = te_no;
	}
	public int getTicket_no() {
		return ticket_no;
	}
	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}
	
	
	

}
