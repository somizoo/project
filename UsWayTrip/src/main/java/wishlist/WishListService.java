package wishlist;

import java.util.List;

public class WishListService {
	
	private WishListDAO wlDao;
	
	public WishListService(WishListDAO wlDao) {
		this.wlDao = wlDao;
	}

	public List<WishListVO> allList(int no) {
		return wlDao.allList(no);
	}

	public int insert(WishListVO vo) {
		return wlDao.insert(vo);
	}

	public int delete(WishListVO vo) {
		return wlDao.delete(vo);
	}
}
