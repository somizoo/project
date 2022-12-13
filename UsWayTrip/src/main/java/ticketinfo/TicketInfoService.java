package ticketinfo;

import java.util.List;

import ticketinfodata.TicketInfoDataVO;

public class TicketInfoService {

	private TicketInfoDAO tiDao;
	
	public TicketInfoService(TicketInfoDAO tiDao) {
		this.tiDao = tiDao;
	}
	
	public int tiInsert(TicketInfoVO ti_vo) {
		return tiDao.tiInsert(ti_vo);
	}

	public void tidInsert(TicketInfoDataVO tid_vo) {
		tiDao.tidInsert(tid_vo);
	}
	
	public TicketInfoVO tiSelect() {
		return tiDao.tiSelect();
	}

	public List<TicketInfoVO> tiSelectList() {
		return tiDao.tiSelectList();
	}
	
	public List<TicketInfoDataVO> tidSelectList() {
		return tiDao.tidSelectList();
	}

	public TicketInfoVO tiSelectOne(int ti_no) {
		return tiDao.tiSelectOne(ti_no);
	}

	public TicketInfoDataVO tidSelectOne(int ti_no) {
		return tiDao.tidSelectOne(ti_no);
	}
	
	public List<TicketInfoDataVO> tidValSelect(int ti_no) {
		return tiDao.tidValSelect(ti_no);
	}

	public int tiUpdate(TicketInfoVO ti_vo) {
		return tiDao.tiUpdate(ti_vo);
	}

	public void tidUpdate(TicketInfoDataVO tid_vo) {
		tiDao.tiUpdate(tid_vo);
	}

	public int delete(int ti_no) {
		return tiDao.delete(ti_no);
	}

	public void tidDelete(int tid_no) {
		tiDao.tidDelete(tid_no);
	}



}
