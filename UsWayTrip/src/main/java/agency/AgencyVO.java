package agency;

public class AgencyVO {
	private int agency_no;			//여행사번호seq
	private String agency_name;		//여행사 명
	private String agency_content;	//여행사 간략소개
	private String agency_proimg;	//여행사 프로필사진
	private String agency_mainimg;	//여행사 대표사진
	
	public AgencyVO() {
		
	}
	
	public AgencyVO(int agency_no, String agency_name, String agency_content, String agency_proimg, String agency_mainimg) {
		this.agency_no = agency_no;
		this.agency_name = agency_name;
		this.agency_content = agency_content;
		this.agency_proimg = agency_proimg;
		this.agency_mainimg = agency_mainimg;
	}
	
	public AgencyVO(String agency_name, String agency_content, String agency_proimg, String agency_mainimg) {
		this.agency_name = agency_name;
		this.agency_content = agency_content;
		this.agency_proimg = agency_proimg;
		this.agency_mainimg = agency_mainimg;
	}
	
	public int getAgency_no() {
		return agency_no;
	}
	public void setAgency_no(int agency_no) {
		this.agency_no = agency_no;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public String getAgency_content() {
		return agency_content;
	}
	public void setAgency_content(String agency_content) {
		this.agency_content = agency_content;
	}
	public String getAgency_proimg() {
		return agency_proimg;
	}
	public void setAgency_proimg(String agency_proimg) {
		this.agency_proimg = agency_proimg;
	}
	public String getAgency_mainimg() {
		return agency_mainimg;
	}
	public void setAgency_mainimg(String agency_mainimg) {
		this.agency_mainimg = agency_mainimg;
	}
	
	
	
}
