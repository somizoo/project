package managercoupon;

import java.util.List;

public class ManagerCouponService {
	private ManagerCouponDAO mcDao;
	
	public ManagerCouponService(ManagerCouponDAO mcDao) {
		this.mcDao = mcDao;
	}

	public List<ManagerCouponVO> allList() {
		return mcDao.allList();
	}

	public int insert(ManagerCouponVO vo) {
		return mcDao.insert(vo);
	}

	public ManagerCouponVO selectOne(int seq) {
		return mcDao.selectOne(seq);
	}

	public int update(ManagerCouponVO vo) {
		return mcDao.update(vo);
	}

	public int delete(int seq) {
		return mcDao.delete(seq);
	}
	
	
	
}
