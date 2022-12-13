package boarddata;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// 11.24 board_sort -> board_no 수정
// getter, setter 수정
public class BoardDataVO {
	private int bd_no;	//게시글번호seq
	private int board_no;	//게시판구분seq
	private String bd_title;	//제목
	private Date bd_upload;	//작성일
	private String bd_content;	//내용
	private int member_no;	//회원번호seq
	
	private MultipartFile photo;
	private String filename;
	
	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	// summernote를 통하여 업로드된 파일명들
	private List<String> fileList;
	
	public List<String> getFileList() {
		return fileList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}

	public BoardDataVO(int bd_no, String bd_title, String bd_content) {
		this.bd_no = bd_no;
		this.bd_title = bd_title;
		this.bd_content = bd_content;
	}
	
	public BoardDataVO(int bd_no, String bd_title, Date bd_upload, String bd_content) {
		this.bd_no = bd_no;
		this.bd_title = bd_title;
		this.bd_upload = bd_upload;
		this.bd_content = bd_content;
	}
	
	public BoardDataVO(String bd_title, String bd_content) {
		this.bd_title = bd_title;
		this.bd_content = bd_content;
	}
	
	public BoardDataVO(int bd_no, int board_no, String bd_title, Date bd_upload, String bd_content, int member_no) {
		this.bd_no = bd_no;
		this.board_no = board_no;
		this.bd_title = bd_title;
		this.bd_upload = bd_upload;
		this.bd_content = bd_content;
		this.member_no = member_no;
	}
	
	public BoardDataVO(int bd_no, String bd_title, String bd_content, String filename) {
		this.bd_no = bd_no;
		this.bd_title = bd_title;
		this.bd_content = bd_content;
		this.filename = filename;
	}

	public BoardDataVO() {
		
	}

	public int getBd_no() {
		return bd_no;
	}

	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBd_title() {
		return bd_title;
	}

	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}

	public Date getBd_upload() {
		return bd_upload;
	}

	public void setBd_upload(Date bd_upload) {
		this.bd_upload = bd_upload;
	}

	public String getBd_content() {
		return bd_content;
	}

	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	
}
