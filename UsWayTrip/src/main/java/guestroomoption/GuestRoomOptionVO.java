package guestroomoption;

public class GuestRoomOptionVO {

	private int gro_no; // 객실 옵션 번호
	private int gr_no; //객실 번호
	private String gro_name;
	private String gro_bf;
	private int gro_price;
	
	private String coupon_figure; //할인율(10% , 2000원)
	private int sale; // 할인가
	
	public GuestRoomOptionVO() {
		
	}

	public int getGro_no() {
		return gro_no;
	}

	public void setGro_no(int gro_no) {
		this.gro_no = gro_no;
	}

	public int getGr_no() {
		return gr_no;
	}

	public void setGr_no(int gr_no) {
		this.gr_no = gr_no;
	}

	public String getGro_name() {
		return gro_name;
	}

	public void setGro_name(String gro_name) {
		this.gro_name = gro_name;
	}

	public String getGro_bf() {
		return gro_bf;
	}

	public void setGro_bf(String gro_bf) {
		this.gro_bf = gro_bf;
	}

	public int getGro_price() {
		return gro_price;
	}

	public void setGro_price(int gro_price) {
		this.gro_price = gro_price;
	}
	
	public String getCoupon_figure() {
		return coupon_figure;
	}

	public void setCoupon_figure(String coupon_figure) {
		this.coupon_figure = coupon_figure;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public void disp() {
		System.out.println(gro_no);
		System.out.println(gr_no);
		System.out.println(gro_name);
		System.out.println(gro_bf);
		System.out.println(gro_price);
	}
	
	
}
