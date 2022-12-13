package payment;

import java.util.List;

import amenities.AmenitiesDAO;
import guestroom.GuestRoomDAO;
import guestroom.GuestRoomVO;
import guestroombed.GuestRoomBedDAO;
import guestroombed.GuestRoomBedVO;
import guestroomoption.GuestRoomOptionDAO;
import guestroomoption.GuestRoomOptionVO;
import lodging.LodgingDAO;
import lodging.LodgingVO;
import managercoupon.ManagerCouponDAO;
import managercoupon.ManagerCouponVO;
import member.MemberDAO;
import ticket.TicketDAO;
import ticket.TicketVO;
import ticketoption.TicketOptionDAO;
import ticketoption.TicketOptionVO;

public class PaymentService {
	private PaymentDAO paymentDao;
	private LodgingDAO lodgingDao;
	private GuestRoomDAO grDao;
	private GuestRoomOptionDAO groDao;
	private ManagerCouponDAO mcDao;
	private AmenitiesDAO amDao;
	private MemberDAO memberDao;
	private TicketDAO ticketDao;
	private TicketOptionDAO toDao;
	
	public PaymentService(PaymentDAO paymentDao, LodgingDAO lodgingDao, GuestRoomDAO grDao, GuestRoomOptionDAO groDao,
			ManagerCouponDAO mcDao, AmenitiesDAO amDao, MemberDAO memberDao, TicketDAO ticketDao, TicketOptionDAO toDao) {
		this.paymentDao = paymentDao;
		this.lodgingDao = lodgingDao;
		this.grDao = grDao;
		this.groDao = groDao;
		this.mcDao = mcDao;
		this.amDao = amDao;
		this.memberDao = memberDao;
		this.ticketDao = ticketDao;
		this.toDao = toDao;
	}
	
	/*
	 * 22.12.06
	 * 숙소 쿠폰 가져오기
	 * */
	
	public ManagerCouponVO getlodcupon(int product_no) {
		return mcDao.getlodcupon(product_no);
	}
	
	/*
	 * 22.12.06
	 * 숙소 정보 가져오기
	 * **/
	public LodgingVO lodgingSelectOne(int product_no) {
		return lodgingDao.lodgingOne(product_no);
	}
	
	/*
	 * 22.12.06
	 * 객실 정보 가져오기 
	 * */
	public GuestRoomVO guestSelectOne(int grno) {
		return grDao.guestOne(grno);
	}
	
	/*
	 *  22.12.06
	 *  객실 침대 정보 가져오기
	 * */
	public List<GuestRoomBedVO> guestBeds(int grno) {
		return grDao.guestBed(grno);
	}
	
	/*
	 * 22.12.06
	 * 객실 옵션 정보 가져오기 
	 * */
	public GuestRoomOptionVO groOne(int grono) {
		return groDao.groOne(grono);
	}
	
	/*
	 * 22.12.07
	 * 객실 가격 가져오기
	 * */
	public int lodgingGetPrice(int grono) {
		return groDao.getPrice(grono);
	}
	
	/*
	 * 22.12.07
	 * 이름 가져오기
	 * */
	
	public String getName(int no) {
		return memberDao.getName(no);
	}

	
	/*
	 * 22.12.07
	 * 결제
	 * */
	public int insert(PaymentVO vo) {
		return paymentDao.insert(vo);
	}

	/*
	 * 22.12.08
	 * 결제정보 가져오기
	 * */
	public PaymentVO SelectOne(Integer member_no) {
		return paymentDao.selectOne(member_no);
	}

	/*
	 * 22.12.08
	 * 티켓 정보 가져오기
	 * */
	public TicketVO ticketSelectOne(int product_no) {
		return ticketDao.ticketSelectOne(product_no);
	}

	/*
	 * 22.12.08
	 * 티켓 옵션 정보 가져오기
	 * */
	public List<TicketVO> toPaySelectList(int product_no) {
		return ticketDao.toPaySelectList(product_no);
	}



	public TicketOptionVO selectOne(int val) {
		return toDao.selectOne(val);
	}
	
	

	
}
