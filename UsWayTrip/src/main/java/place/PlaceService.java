package place;

import java.util.List;

public class PlaceService {

	private PlaceDAO placeDao;
	
	public PlaceService(PlaceDAO placeDao) {
		this.placeDao = placeDao;
	}
	
	public List<PlaceVO> placeSelectList() {
		return placeDao.placeSelectList();
	}
	
	
	
}
