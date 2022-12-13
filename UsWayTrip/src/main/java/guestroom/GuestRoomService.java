package guestroom;

import java.util.List;

import amenities.AmenitiesDAO;
import amenities.AmenitiesVO;
import bed.BedVO;
import guestroomamenities.GuestRoomAmenitiesDAO;
import guestroomamenities.GuestRoomAmenitiesVO;
import guestroombed.GuestRoomBedDAO;
import guestroombed.GuestRoomBedVO;
import guestroomimg.GuestRoomImgDAO;
import guestroomimg.GuestRoomImgVO;
import guestroomoption.GuestRoomOptionDAO;
import guestroomoption.GuestRoomOptionVO;
import img.ImgVO;
import lodging.LodgingDAO;
import lodging.LodgingVO;
import managercoupon.ManagerCouponDAO;
import managercoupon.ManagerCouponVO;
import outlook.OutLookVO;

public class GuestRoomService {
	
	private GuestRoomDAO grDao;
	private GuestRoomImgDAO griDao;
	private GuestRoomAmenitiesDAO graDao;
	private GuestRoomBedDAO grbDao;
	private GuestRoomOptionDAO groDao;
	private AmenitiesDAO amDao;
	private LodgingDAO lodDao;
	private ManagerCouponDAO mcDao;
	
	public GuestRoomService(GuestRoomDAO grDao,GuestRoomImgDAO griDao ,GuestRoomAmenitiesDAO graDao,GuestRoomBedDAO grbDao,GuestRoomOptionDAO groDao,AmenitiesDAO amDao, LodgingDAO lodDao, ManagerCouponDAO mcDao) {
		this.grDao = grDao;
		this.griDao = griDao;
		this.graDao = graDao;
		this.grbDao = grbDao;
		this.groDao = groDao;
		this.amDao = amDao;
		this.lodDao = lodDao;
		this.mcDao = mcDao;
	}

	public List<GuestRoomVO> grList(int no) {
		return grDao.grList(no);
	}

	public List<AmenitiesVO> amList() {
		return grDao.amList();
	}

	public List<BedVO> bedList() {
		return grDao.bedList();
	}

	public List<OutLookVO> otList() {
		return grDao.otList();
	}

	public int guestRoomInsert(GuestRoomVO vo) {
		return grDao.guestRoomInsert(vo);
	}

	public int graInsert(GuestRoomAmenitiesVO vo) {
		return graDao.graInsert(vo);
		
	}

	public int grbInsert(GuestRoomBedVO vo) {
		return grDao.grbInsert(vo);
		
	}


	public int grimgInsert(GuestRoomImgVO vo) {
		return grDao.grimgInsert(vo);
	}

	public GuestRoomVO guestOne(int no) {
		return grDao.guestOne(no);
	}

	public List<GuestRoomBedVO> guestBed(int no) {
		return grDao.guestBed(no);
	}

	public List<AmenitiesVO> guestAm(int no) {
		return graDao.guestAm(no);
	}

	public List<GuestRoomImgVO> grImgs(int no) {
		return griDao.grImgs(no);
	}

	public void grDelete(int no) {
		grDao.grDelete(no);
		
	}

	public int gramDelete(int no) {
		return graDao.gramDelete(no);
		
	}

	public int grbedDelete(int no) {
		return grbDao.grbedDelete(no);
		
	}

	public int grImgDelete(int no) {
		return griDao.grImgDelete(no);
		
	}

	public int grUpdate(GuestRoomVO vo) {
		return grDao.grUpdate(vo);
	}

	public int guestRoomDelete(int grno) {
		return groDao.guestRoomDelete(grno);
		
	}

	public List<GuestRoomBedVO> grbedAllList() {
		return grbDao.grbedAllList();
	}

	public List<AmenitiesVO> grAmAllList() {
		return amDao.grAmAllList();
	}

	public List<GuestRoomOptionVO> groList(int no) {
		return groDao.groList(no);
	}

	public LodgingVO lodgingOne(int no) {
		return lodDao.lodgingOne(no);
	}

	public int mainImgUpdate(GuestRoomVO vo) {
		return grDao.mainImgUpdate(vo);
	}

	public int groDelete(int no) {
		return groDao.groDelete(no);
		
	}

	public int imgDelete(String imgname) {
		return griDao.imgDelete(imgname);
	}

	public ManagerCouponVO getlodcupon(int no) {
		return mcDao.getlodcupon(no);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}