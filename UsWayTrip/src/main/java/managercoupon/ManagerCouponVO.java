package managercoupon;

import java.sql.Date;

public class ManagerCouponVO {
	private int mc_no;	//쿠폰 생성번호seq
	private String mc_name;	//쿠폰이름
	private Date mc_start;	//쿠폰 유효기간 시작일
	private Date mc_end;	//쿠폰 유효기간 종료일
	private int mc_figure; 	//쿠폰 수치 
	private int mc_sort;	//퍼센트 / 가격 구분자
	private String mc_code; //쿠폰코드
	private int mc_active; // 쿠폰활성여부
	
	public ManagerCouponVO() {
			
	}


	public ManagerCouponVO(int mc_no, String mc_name, Date mc_start, Date mc_end, int mc_figure, int mc_sort,
			String mc_code, int mc_active) {
		this.mc_no = mc_no;
		this.mc_name = mc_name;
		this.mc_start = mc_start;
		this.mc_end = mc_end;
		this.mc_figure = mc_figure;
		this.mc_sort = mc_sort;
		this.mc_code = mc_code;
		this.mc_active = mc_active;
	}


	public int getMc_figure() {
		return mc_figure;
	}


	public void setMc_figure(int mc_figure) {
		this.mc_figure = mc_figure;
	}


	public Date getMc_start() {
		return mc_start;
	}

	public void setMc_start(Date mc_start) {
		this.mc_start = mc_start;
	}

	public Date getMc_end() {
		return mc_end;
	}

	public void setMc_end(Date mc_end) {
		this.mc_end = mc_end;
	}

	public String getMc_code() {
		return mc_code;
	}

	public void setMc_code(String mc_code) {
		this.mc_code = mc_code;
	}

	public int getMc_active() {
		return mc_active;
	}

	public void setMc_active(int mc_active) {
		this.mc_active = mc_active;
	}

	public int getMc_no() {
		return mc_no;
	}
	public void setMc_no(int mc_no) {
		this.mc_no = mc_no;
	}
	public String getMc_name() {
		return mc_name;
	}
	public void setMc_name(String mc_name) {
		this.mc_name = mc_name;
	}
	
	public int getMc_sort() {
		return mc_sort;
	}
	public void setMc_sort(int mc_sort) {
		this.mc_sort = mc_sort;
	}
}
