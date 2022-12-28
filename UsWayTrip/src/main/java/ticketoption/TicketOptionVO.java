package ticketoption;

public class TicketOptionVO {
	
	private int to_no; // 옵션번호seq
	private String to_title; // 티켓 제목
	private int to_price; // 가격
	private int to_su; // 수량
	private int to_type; // 타입
	private String to_content; // 설명
	private int ticket_no; // 티켓번호seq
	
	public TicketOptionVO() {
		
	}
	
	public TicketOptionVO(int to_no, String to_title, int to_price, int to_su, int to_type, String to_content, int ticket_no) {
		super();
		this.to_no = to_no;
		this.to_title = to_title;
		this.to_price = to_price;
		this.to_su = to_su;
		this.to_type = to_type;
		this.to_content = to_content;
		this.ticket_no = ticket_no;
	}
	
	
	
	public int getTicket_no() {
		return ticket_no;
	}

	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}

	public int getTo_no() {
		return to_no;
	}
	public void setTo_no(int to_no) {
		this.to_no = to_no;
	}
	public String getTo_title() {
		return to_title;
	}
	public void setTo_title(String to_title) {
		this.to_title = to_title;
	}
	public int getTo_price() {
		return to_price;
	}
	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}
	public int getTo_su() {
		return to_su;
	}
	public void setTo_su(int to_su) {
		this.to_su = to_su;
	}
	public int getTo_type() {
		return to_type;
	}
	public void setTo_type(int to_type) {
		this.to_type = to_type;
	}
	public String getTo_content() {
		return to_content;
	}
	public void setTo_content(String to_content) {
		this.to_content = to_content;
	}
}
