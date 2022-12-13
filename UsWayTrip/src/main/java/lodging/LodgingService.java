package lodging;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import amenities.AmenitiesDAO;
import amenities.AmenitiesVO;
import facilities.FacilitiesVO;
import guestroom.GuestRoomDAO;
import guestroom.GuestRoomVO;
import guestroomamenities.GuestRoomAmenitiesDAO;
import guestroombed.GuestRoomBedDAO;
import guestroombed.GuestRoomBedVO;
import guestroomimg.GuestRoomImgDAO;
import guestroomimg.GuestRoomImgVO;
import guestroomoption.GuestRoomOptionDAO;
import guestroomoption.GuestRoomOptionVO;
import img.ImgDAO;
import img.ImgVO;
import lodgingfacilities.LodgingFacilitiesVO;
import lodgingservice.LodgingServiceVO;
import lodgingtype.LodgingTypeVO;
import managercoupon.ManagerCouponDAO;
import managercoupon.ManagerCouponVO;
import member.MemberDAO;
import place.PlaceVO;
import price.priceVO;
import review.ReviewDAO;
import review.ReviewVO;
import service.ServiceVO;



public class LodgingService {
	private LodgingDAO lodgingDao;
	private ImgDAO imgDao;
	private GuestRoomDAO grDao;
	private GuestRoomOptionDAO groDao;
	private GuestRoomBedDAO grbDao;
	private AmenitiesDAO amDao;
	private GuestRoomImgDAO griDao;
	private GuestRoomAmenitiesDAO graDao;
	private ReviewDAO reviewDao;
	private ManagerCouponDAO mcDao;

	
	public LodgingService(LodgingDAO lodgingDao,ImgDAO imgDao,GuestRoomDAO grDao,GuestRoomOptionDAO groDao,GuestRoomBedDAO grbDao,AmenitiesDAO amDao,GuestRoomImgDAO griDao, GuestRoomAmenitiesDAO graDao,ReviewDAO reviewDao,ManagerCouponDAO mcDao) {
		this.lodgingDao = lodgingDao;
		this.imgDao = imgDao;
		this.grDao = grDao;
		this.groDao = groDao;
		this.grbDao = grbDao;
		this.griDao = griDao;
		this.amDao = amDao;
		this.graDao = graDao;
		this.reviewDao = reviewDao;
		this.mcDao = mcDao;
	}



	public List<LodgingVO> lodgingList(Map<String, Object> map) {
		return lodgingDao.lodgingList(map);
	}
	
//	public List<LodgingVO> lodgingList() {
//		return lodgingDao.lodgingList();
//	}
	
	public List<ServiceVO> serviceList(){
		return lodgingDao.serviceList();
	}



	public List<FacilitiesVO> FacilitieList() {
		return lodgingDao.FacilitieList();
	}



	public List<PlaceVO> placeList() {
		return lodgingDao.placeList();
	}

	public List<LodgingTypeVO> lodTypeList() {
		return lodgingDao.lodTypeList();
	}

	public int lodgingInsert(LodgingVO vo) {
		return lodgingDao.lodgingInsert(vo);
	}



	public int getProductSeq() {
		return lodgingDao.getProductSeq();
	}



	public int imgInsert(ImgVO img) {
		return lodgingDao.imgInsert(img);
	}
	
	public LodgingVO lodgingOne(int no) {
		return lodgingDao.lodgingOne(no);
	}



	public int lodgingDelete(int no) {
		return lodgingDao.lodgingDelete(no);
		
	}



	public int LodgingFacilitiesInsert(LodgingFacilitiesVO lodfacvo) {
		return lodgingDao.LodgingFacilitiesInsert(lodfacvo);
	}


	// 추가 11.15
	public int LodgingServiceInsert(LodgingServiceVO loserviceVo) {
		return lodgingDao.LodgingServiceInsert(loserviceVo);
	}



	public int lodfacDelete(int no) {
		return lodgingDao.lodfacDelete(no);
		
	}

	public int lodserDelete(int no) {
		return lodgingDao.lodserDelete(no);
		
	}



	public LodgingVO lodPlaceOne(int no) {
		return lodgingDao.lodPlaceOne(no);
	}



	public List<ServiceVO> lodServices(int no) {
		return lodgingDao.lodServices(no);
	}



	public List<FacilitiesVO> lodFacs(int no) {
		return lodgingDao.lodFacs(no);
	}



	public List<ImgVO> logImgs(int no) {
		return lodgingDao.logImgs(no);
	}



	public int lodgingUpdate(LodgingVO vo) {
		return lodgingDao.lodgingUpdate(vo);
	}

	public GuestRoomOptionVO groOne(int gr_no) {
		return lodgingDao.groOne(gr_no);
	}



	public void lodimgDelete(int no) {
		imgDao.lodImgDel(no);
	}


	public List<GuestRoomVO> lodgrList(int no) {
		return grDao.lodgrList(no);
	}



	public List<GuestRoomOptionVO> groList(int no) {
		return groDao.groList(no);
	}



	public List<GuestRoomBedVO> grbedList(int no) {
		return grbDao.grbedList(no);
	}

	public List<AmenitiesVO> gramList(int no) {
		return amDao.gramList(no);
	}



	public List<GuestRoomImgVO> grimgList(int no) {
		return griDao.grImgs(no);
	}



	public int mainImgUpdate(LodgingVO vo) {
		return lodgingDao.mainImgUpdate(vo);
	}



	public int imgDelete(String imgname) {
		return imgDao.imgDelete(imgname);
		
	}



	public List<Integer> grnoList(int no) {
		return grDao.grnoList(no);
	}



	public void grImgDelete(Integer no) {
		griDao.grImgDelete(no);
		
	}



	public void grAmDelete(Integer no) {
		graDao.gramDelete(no);
		
	}



	public void grBedDelete(Integer no) {
		grbDao.grbedDelete(no);
		
	}



	public void groDelete(Integer no) {
		groDao.groDelete(no);
		
	}

	public void grAllDelete(int no) {
		grDao.grAllDelete(no);
		
	}



	public ReviewVO lodgingReview(int no) {
		return reviewDao.lodgingReview(no);
	}

	public ManagerCouponVO getlodcupon(int no) {
		return mcDao.getlodcupon(no);
	}



	public List<priceVO> lodpriceList() {
		return groDao.lodpriceList();
	}



	public List<ReviewVO> reviewList(int no) {
		return reviewDao.reviewList(no);
	}



	public int getTotal(Map<String, Object> map) {
		return lodgingDao.getTotal(map);
	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
