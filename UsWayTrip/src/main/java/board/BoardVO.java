package board;

public class BoardVO {
	private int board_no;	//게시판구분seq
	private String board_name;	//게시판명
	
	public BoardVO() {
		
	}
	
	public BoardVO(int board_no, String board_name) {
		this.board_no = board_no;
		this.board_name = board_name;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
}
