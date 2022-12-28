package ticketoption;

import java.util.AbstractSequentialList;
import java.util.List;

public class TicketOptionService {
	private TicketOptionDAO toDao;
	
	public TicketOptionService(TicketOptionDAO toDao) {
		this.toDao = toDao;
	}

	public List<TicketOptionVO> selectList() {
		return toDao.selectList();
	}

	public int insert(TicketOptionVO vo) {
		return toDao.insert(vo);
		
	}

	public int delete(int no) {
		return toDao.delete(no);
	}

	public TicketOptionVO selectOne(int no) {
		return toDao.selectOne(no);
	}

	public int update(TicketOptionVO vo) {
		return toDao.update(vo);
	}


	
	
	
}
