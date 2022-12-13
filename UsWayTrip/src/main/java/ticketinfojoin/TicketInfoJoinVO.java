package ticketinfojoin;

public class TicketInfoJoinVO {
	private int ticket_no;
	private int tid_no;
	
	public TicketInfoJoinVO(int ticket_no, int tid_no) {
		super();
		this.ticket_no = ticket_no;
		this.tid_no = tid_no;
	}
	public int getTicket_no() {
		return ticket_no;
	}
	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}
	public int getTid_no() {
		return tid_no;
	}
	public void setTid_no(int tid_no) {
		this.tid_no = tid_no;
	}

}
