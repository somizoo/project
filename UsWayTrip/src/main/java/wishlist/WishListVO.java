package wishlist;

public class WishListVO {
	
	private int wl_no;		//위시리스트seq
	private int product_no; //상품번호seq
	private String product_sort; // 상품 구분자 (l: 숙박업체, t: 투어티켓, p: 패키자구분자)
	private int member_no;	//회원번호seq
	
	
	public WishListVO() {
		
	}
	
	public WishListVO(int wl_no, int product_no, String product_sort, int member_no) {
		super();
		this.wl_no = wl_no;
		this.product_no = product_no;
		this.product_sort = product_sort;
		this.member_no = member_no;
	}
	
	public String getProduct_sort() {
		return product_sort;
	}
	public void setProduct_sort(String product_sort) {
		this.product_sort = product_sort;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getWl_no() {
		return wl_no;
	}
	public void setWl_no(int wl_no) {
		this.wl_no = wl_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	
	
	
}
