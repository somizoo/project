package ticketpayoption;

public class TicketPayOptionVO {

	private int payment_no;
	private int to_no;
	private int ticket_cnt;
	
	
	public TicketPayOptionVO(int payment_no, int to_no, int ticket_cnt) {
		this.payment_no = payment_no;
		this.to_no = to_no;
		this.ticket_cnt = ticket_cnt;
	}
	
	
	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public int getTo_no() {
		return to_no;
	}
	public void setTo_no(int to_no) {
		this.to_no = to_no;
	}
	public int getTicket_cnt() {
		return ticket_cnt;
	}
	public void setTicket_cnt(int ticket_cnt) {
		this.ticket_cnt = ticket_cnt;
	}
	
	
	
}
