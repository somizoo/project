package review;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import img.ImgVO;

public class ReviewVO {
	private int review_no;	//후기번호 seq
	private int product_no;	//상품번호 seq
	private int review_star; // 별점
	private String review_uname; //작성자명
	private String review_content; //내용
	private Date review_regdate; //등록일
	private int agency_no;		//여행사번호seq
	private int member_no;		//회원번호seq
	
	private List<MultipartFile> imgs;	//다중 파일첨부
	private int cnt; //후기 총 개수 
	
	// 12.04 추가 
	private double star; // 평점
	private int count; // 후기 갯수
	


	public ReviewVO() {}
	
	public ReviewVO(int review_no, int product_no, int review_star, String review_uname, String review_content,
			Date review_regdate, int agency_no, int member_no, List<MultipartFile> imgs, int cnt) {
		this.review_no = review_no;
		this.product_no = product_no;
		this.review_star = review_star;
		this.review_uname = review_uname;
		this.review_content = review_content;
		this.review_regdate = review_regdate;
		this.agency_no = agency_no;
		this.member_no = member_no;
		this.imgs = imgs;
		this.cnt = cnt;
	}


	public int getCnt() {
		return cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getReview_star() {
		return review_star;
	}
	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}
	public String getReview_uname() {
		return review_uname;
	}
	public void setReview_uname(String review_uname) {
		this.review_uname = review_uname;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Date getReview_regdate() {
		return review_regdate;
	}
	public void setReview_regdate(Date review_regdate) {
		this.review_regdate = review_regdate;
	}
	public int getAgency_no() {
		return agency_no;
	}
	public void setAgency_no(int agency_no) {
		this.agency_no = agency_no;
	}

	public List<MultipartFile> getImgs() {
		return imgs;
	}

	public void setImgs(List<MultipartFile> imgs) {
		this.imgs = imgs;
	}
	
	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public void disp() {
		System.out.println("review_no : " + review_no);
		System.out.println("product_no : " + product_no);
		System.out.println("review_star : " + review_star);
		System.out.println("review_uname : " + review_uname);
		System.out.println("review_content : " + review_content);
		System.out.println("agency_no : " + agency_no);
		System.out.println("member_no : " + member_no);
	}
}
