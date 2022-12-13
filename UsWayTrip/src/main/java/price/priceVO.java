package price;

public class priceVO {
	
	private int product_no; // 상품 번호
	private String coupon_figure; //할인율(10% , 2000원)
	private int cost; // 원가
	private int sale; // 할인가
	
	public priceVO() {
		
	}

	public priceVO(int product_no, String coupon_figure, int cost, int sale) {
		super();
		this.product_no = product_no;
		this.coupon_figure = coupon_figure;
		this.cost = cost;
		this.sale = sale;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}


	public String getCoupon_figure() {
		return coupon_figure;
	}

	public void setCoupon_figure(String coupon_figure) {
		this.coupon_figure = coupon_figure;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	
	
	
	

}
