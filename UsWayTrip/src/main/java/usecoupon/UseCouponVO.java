package usecoupon;

public class UseCouponVO {
	private int uc_no;	//쿠폰 사용여부 구분seq
	private int mc_no;	//쿠폰 생성번호seq
	private int product_no;	//상품번호seq
	private int uc_use;	//쿠폰사용여부
	private String uc_sort;	//상품 구분자
	
	public UseCouponVO() {
		
	}
	
	public int getUc_no() {
		return uc_no;
	}
	public void setUc_no(int uc_no) {
		this.uc_no = uc_no;
	}
	public int getMc_no() {
		return mc_no;
	}
	public void setMc_no(int mc_no) {
		this.mc_no = mc_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getUc_use() {
		return uc_use;
	}
	public void setUc_use(int uc_use) {
		this.uc_use = uc_use;
	}
	public String getUc_sort() {
		return uc_sort;
	}
	public void setUc_sort(String uc_sort) {
		this.uc_sort = uc_sort;
	}
}
