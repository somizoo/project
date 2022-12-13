package reviewimg;

public class ReviewImgVO {
	private int review_no;		//후기번호seq
	private String ri_name;		//후기 이미지 명
	
	public ReviewImgVO() {
		
	}
	
	public ReviewImgVO(int review_no, String ri_name) {
		this.review_no = review_no;
		this.ri_name = ri_name;
	}
	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getRi_name() {
		return ri_name;
	}
	public void setRi_name(String ri_name) {
		this.ri_name = ri_name;
	}
	
}
