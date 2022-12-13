package guestroomoption;

import java.util.List;

import guestroom.GuestRoomDAO;
import guestroom.GuestRoomVO;
import lodging.LodgingDAO;

public class GuestRoomOptionService {
	private GuestRoomOptionDAO groDao;
	private GuestRoomDAO grDao;
	private LodgingDAO lodDao;
	
	public GuestRoomOptionService(GuestRoomOptionDAO groDao,GuestRoomDAO grDao,LodgingDAO lodDao) {
		this.groDao = groDao;
		this.grDao = grDao;
		this.lodDao= lodDao;
	}

	public int groInsert(GuestRoomOptionVO vo) {
		return groDao.groInsert(vo);
	}

	public GuestRoomOptionVO groOne(int no) {
		return groDao.groOne(no);
	}

	public int groDelete(int no) {
		return groDao.groDelete(no);
	}

	public List<GuestRoomOptionVO> groAllList() {
		return groDao.groAllList();
	}

	public int groUpdate(GuestRoomOptionVO vo) {
		return groDao.groUpdate(vo);
	}

	public GuestRoomVO grOne(int no) {
		return grDao.guestOne(no);
	}

	public int getlodbf(int no) {
		return lodDao.getlodbf(no);
	}
}
