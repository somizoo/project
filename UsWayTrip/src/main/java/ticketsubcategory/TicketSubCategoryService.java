package ticketsubcategory;

import java.util.List;

public class TicketSubCategoryService {
	
	private TicketSubCategoryDAO tscDao;
	
	public TicketSubCategoryService(TicketSubCategoryDAO tscDao) {
		this.tscDao = tscDao;
	}
	
	public List<TicketSubCategoryVO> list(){
		List<TicketSubCategoryVO> list = tscDao.selectList();
		
		return list;
	}
	
	public int write(TicketSubCategoryVO vo) {
		int check = tscDao.insert(vo);
		return check;
	}
	
	public TicketSubCategoryVO selectOne(int seq){
		TicketSubCategoryVO vo = tscDao.selectOne(seq);
		return vo;
	}
	
	public int delete(int seq) {
		int check = tscDao.delete(seq);
		return check;
	}
	
	public int update(TicketSubCategoryVO vo) {
		return tscDao.update(vo);
	}

	public String selectNameOne(int ticket_no) {
		return tscDao.selectNameOne(ticket_no);
	}

}
