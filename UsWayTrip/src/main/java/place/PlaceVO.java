package place;

public class PlaceVO {
	private int place_no;
	private String place_name;
	
	public PlaceVO() {
		
	}

	//setter
	public void setPlace_no(int place_no) {
		this.place_no = place_no;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	
	//getter
	
	public String getPlace_name() {
		return place_name;
	}
	public int getPlace_no() {
		return place_no;
	}
}
