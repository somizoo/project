package boarddatahelp;

public class BoardDataHelpVO {
	private int bd_no;	//게시글번호seq
	private int member_no;	//회원번호seq
	private int bdh_yn;	//도움여부
	
	public BoardDataHelpVO() {
		
	}
	
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getBdh_yn() {
		return bdh_yn;
	}
	public void setBdh_yn(int bdh_yn) {
		this.bdh_yn = bdh_yn;
	}
}
