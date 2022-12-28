package ticketevent;

import java.util.List;

public class TicketEventService {
	private TicketEventDAO teDao;
	
	
	public TicketEventService(TicketEventDAO teDao) {
		this.teDao = teDao;
	}
	
	public TicketEventVO list(int seq) {
		TicketEventVO vo = teDao.list(seq);
		return vo;
	}
	public List<TicketEventVO> allList() {
		List<TicketEventVO> list = teDao.allList();
		return list;
	}
	
	public int write(TicketEventVO vo) {
		return teDao.write(vo);
	}

	public int deleteImg(int seq) {
		return teDao.deleteImg(seq);
	}
	
	public int update(TicketEventVO vo) {
		return teDao.update(vo);
	}

	public int delete(int seq) {
		return teDao.delete(seq);
	}

}
