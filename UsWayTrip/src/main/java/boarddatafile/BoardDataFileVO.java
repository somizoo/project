package boarddatafile;

public class BoardDataFileVO {
	private int bdf_no;
	private String bdf_name;
	private int bd_no;
	
	public BoardDataFileVO() {
		
	}
	
	public BoardDataFileVO(String bdf_name, int bd_no) {
		this.bdf_name = bdf_name;
		this.bd_no = bd_no;
	}
	
	public BoardDataFileVO(int bd_no) {
		this.bd_no = bd_no;
	} 
	
	public int getBdf_no() {
		return bdf_no;
	}
	public void setBdf_no(int bdf_no) {
		this.bdf_no = bdf_no;
	}
	public String getBdf_name() {
		return bdf_name;
	}
	public void setBdf_name(String bdf_name) {
		this.bdf_name = bdf_name;
	}
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	
	
}
