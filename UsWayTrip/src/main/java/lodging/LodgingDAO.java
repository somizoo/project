package lodging;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartFile;

import facilities.FacilitiesVO;
import guestroom.GuestRoomVO;
import guestroomoption.GuestRoomOptionVO;
import img.ImgVO;
import lodgingfacilities.LodgingFacilitiesVO;
import lodgingservice.LodgingServiceVO;
import lodgingtype.LodgingTypeVO;
import place.PlaceVO;
import service.ServiceVO;

public class LodgingDAO {
	private SqlSession sqlSession;
	
	public LodgingDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	public List<LodgingVO> lodgingList() {
		return sqlSession.selectList("lodging.lodgingList");
	}
//	public List<LodgingVO> lodgingList(Map<String, Object> map) {
//		return sqlSession.selectList("lodging.lodgingList",map);
//	}

	public List<ServiceVO> serviceList() {
		return sqlSession.selectList("lodging.serviceList");
	}


	public List<FacilitiesVO> FacilitieList() {
		return sqlSession.selectList("lodging.facilitieList");
	}


	public List<PlaceVO> placeList() {
		return sqlSession.selectList("lodging.placeList");
	}


	public int lodgingInsert(LodgingVO vo) {
		sqlSession.insert("lodging.lodgingInsert", vo);
		return vo.getLodging_no();
	}


	public int getProductSeq() {
		return sqlSession.selectOne("lodging.getProductSeq");
	}


	public int imgInsert(ImgVO img) {
		return sqlSession.insert("lodging.imgInsert", img);
	}
	
	public LodgingVO lodgingOne(int seq) {
		return sqlSession.selectOne("lodging.selectOne", seq);
	}


	public int lodgingDelete(int seq) {
		return sqlSession.delete("lodging.lodgingDelete",seq);
	}


	public int LodgingFacilitiesInsert(LodgingFacilitiesVO lodfacvo) {
		return sqlSession.insert("lodging.lfInsert",lodfacvo);
	}


	public int LodgingServiceInsert(LodgingServiceVO loserviceVo) {
		return sqlSession.insert("lodging.lsInsert",loserviceVo);
	}


	public int lodfacDelete(int no) {
		return sqlSession.delete("lodging.lfDelete", no);
	}


	public int lodserDelete(int no) {
		return sqlSession.delete("lodging.lsDelete",no);
	}


	public LodgingVO lodPlaceOne(int no) {
		return sqlSession.selectOne("lodging.lodPlaceOne",no);
	}


	public List<ServiceVO> lodServices(int no) {
		return sqlSession.selectList("lodging.lodServices", no);
	}


	public List<FacilitiesVO> lodFacs(int no) {
		return sqlSession.selectList("lodging.lodFacs", no);
	}


	public List<ImgVO> logImgs(int no) {
		return sqlSession.selectList("lodging.logImgs",no);
	}


	public List<LodgingTypeVO> lodTypeList() {
		return sqlSession.selectList("lodging.ltList");
	}


	public int lodgingUpdate(LodgingVO vo) {
		return sqlSession.update("lodging.lodgingUpdate",vo);
	}

	public GuestRoomOptionVO groOne(int gr_no) {
		return sqlSession.selectOne("guestRoomOption.groOne", gr_no);
	}


	public int mainImgUpdate(LodgingVO vo) {
		return sqlSession.update("lodging.mainImgUpdate",vo);
	}


	public int getlodbf(int no) {
		return sqlSession.selectOne("lodging.getlodbf",no);
	}


	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("lodging.getTotal", map);
	}


	public List<LodgingVO> lodgingList(Map<String, Object> map) {
		return sqlSession.selectList("lodging.lodgingList", map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
