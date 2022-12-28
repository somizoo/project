package img;

public class ImgVO {
	private int product_no;		//상품 번호seq
	private String img_name; 	//이미지 명
	private String img_extension; //확장자 구분
	
	public ImgVO() {
		
	}
	public ImgVO(int product_no, String img_name, String img_extension) {
		this.product_no = product_no;
		this.img_name = img_name;
		this.img_extension = img_extension;
	}
	
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getImg_extension() {
		return img_extension;
	}
	public void setImg_extension(String img_extension) {
		this.img_extension = img_extension;
	}
	
	
}
