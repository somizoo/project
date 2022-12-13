package ticketcalendarandoption;

import java.sql.Date;

public class TicketCalendarAndOptionVO {
	
	private int to_no; // 옵션번호seq
	private String tcao_name; // 옵션명
	private int tcao_price; // 가격
	private int tcao_su; // 수량
	private Date tcao_start; // 시작일
	private Date tcao_end; // 시작일
	
	public TicketCalendarAndOptionVO() {
		
	}

	public int getTo_no() {
		return to_no;
	}

	public void setTo_no(int to_no) {
		this.to_no = to_no;
	}

	public String getTcao_name() {
		return tcao_name;
	}

	public void setTcao_name(String tcao_name) {
		this.tcao_name = tcao_name;
	}

	public int getTcao_price() {
		return tcao_price;
	}

	public void setTcao_price(int tcao_price) {
		this.tcao_price = tcao_price;
	}

	public int getTcao_su() {
		return tcao_su;
	}

	public void setTcao_su(int tcao_su) {
		this.tcao_su = tcao_su;
	}

	public Date getTcao_start() {
		return tcao_start;
	}

	public void setTcao_start(Date tcao_start) {
		this.tcao_start = tcao_start;
	}

	public Date getTcao_end() {
		return tcao_end;
	}

	public void setTcao_end(Date tcao_end) {
		this.tcao_end = tcao_end;
	}
	

}
