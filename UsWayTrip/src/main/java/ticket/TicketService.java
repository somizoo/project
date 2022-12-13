package ticket;

import java.util.List;
import java.util.Map;

import img.ImgVO;
import place.PlaceDAO;
import place.PlaceVO;
import review.ReviewDAO;
import review.ReviewVO;
import ticketevent.TicketEventDAO;
import ticketevent.TicketEventVO;
import ticketeventdata.TicketEventDataVO;
import ticketinfo.TicketInfoDAO;
import ticketinfo.TicketInfoVO;
import ticketinfodata.TicketInfoDataVO;
import ticketinfojoin.TicketInfoJoinVO;
import ticketoption.TicketOptionDAO;
import ticketoption.TicketOptionVO;
import ticketsubcategory.TicketSubCategoryDAO;
import ticketsubcategory.TicketSubCategoryVO;

public class TicketService {
	
	private TicketDAO ticketDao;
	private TicketInfoDAO tiDao;
	private TicketSubCategoryDAO tscDao;
	private TicketOptionDAO toDao;
	private ReviewDAO reviewDao;
	private PlaceDAO placeDao;
	private TicketEventDAO teDao;
	
	public TicketService(TicketDAO ticketDao, TicketInfoDAO tiDao, TicketSubCategoryDAO tscDao, TicketOptionDAO toDao, ReviewDAO reviewDao, PlaceDAO placeDao, TicketEventDAO teDao) {
		this.ticketDao = ticketDao;
		this.tiDao = tiDao;
		this.tscDao = tscDao;
		this.toDao = toDao;
		this.reviewDao = reviewDao;
		this.placeDao = placeDao;
		this.teDao = teDao;
	}
	
	public List<TicketVO> selectList() {
		System.out.println("5");
		return ticketDao.selectList();
	}
	
	public int ticketInsert(TicketVO vo) {
		return ticketDao.ticketInsert(vo);
	}

	public TicketVO selectOne(int no) {
		return ticketDao.selectOne(no);
	}
	
	public String tscSelectOne(int no) {
		return ticketDao.tscSelectOne(no);
	}
	
	public String placeSelectOne(int no) {
		return ticketDao.placeSelectOne(no);
	}
	
	public int delete(int no) {
		return ticketDao.delete(no);
	}

	public TicketOptionVO toSelectOne(int no) {
		return ticketDao.toSelectOne(no);
	}

	public List<TicketOptionVO> toSelectList(int no) {
		return ticketDao.toSelectList(no);
	}

	public List<TicketEventVO> teSelectList() {
		return ticketDao.teSelectList();
	}


	public void imgInsert(ImgVO imgvo) {
		ticketDao.imgInsert(imgvo);
	}
	
	public void teInsert(TicketEventDataVO ted_vo) {
		ticketDao.teInsert(ted_vo);
	}

	public List<String> teNameSelectList(int no) {
		return ticketDao.teNameSelectList(no);
	}


	public List<ImgVO> multiImgSelect(int product_no) {
		return ticketDao.multiImgSelect(product_no);
	}

	// ticket content에 ti name 출력
	public List<TicketInfoVO> tiSelectList() {
		return tiDao.tiSelectList();
	}

	public List<TicketInfoDataVO> tidSelectList() {
		return tiDao.tidSelectList();
	}
	
	public List<TicketInfoDataVO> tidSelectValList(int ti_no) {
		return tiDao.tidSelectValList(ti_no);
	}

	public void tijInsert(TicketInfoJoinVO tij) {
		tiDao.tijInsert(tij);
	}

	public List<TicketInfoDataVO> tijSelect(int no) {
		return tiDao.tijSelect(no);
	}

	public TicketInfoVO tiSelectOne(int ti_no) {
		return tiDao.tiSelectOne(ti_no);
	}

	public List<TicketSubCategoryVO> tscSelectList() {
		return tscDao.tscSelectList();

	}

	public TicketVO joinSelectOne(int no) {
		return ticketDao.joinSelectOne(no);
	}

	public TicketVO joinTeSelectOne(int no) {
		return ticketDao.joinTeSelectOne(no);
	}

	public int toMinSelect(int no) {
		return toDao.toMinSelect(no);
	}


	public ReviewVO reviewStarSelect(int no) {
	      return reviewDao.reviewStarSelect(no);
	}

	public int update(TicketVO vo) {
		return ticketDao.update(vo);
	}

	public List<PlaceVO> placeSelectList() {
		return placeDao.placeSelectList();
	}
	
	public TicketVO wishList(int no) {
		return ticketDao.wishList(no);
	}

	/* 22.12.06 추가 */
	public List<Integer> joinTeSelectList(int no) {
		return ticketDao.joinTeSelectList(no);
	}

	public void teDelete(TicketVO vo) {
		teDao.teDelete(vo);
	}
	
	/* 22.12.08 추가 */
   public int wishChoice(Map<String, Integer> map) {
	      return ticketDao.wishChoice(map);
	   }

public List<ReviewVO> reviewList(int no) {
	return reviewDao.reviewList(no);
}

}
