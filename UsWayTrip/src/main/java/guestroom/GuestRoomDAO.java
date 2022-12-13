package guestroom;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import amenities.AmenitiesVO;
import bed.BedVO;
import guestroombed.GuestRoomBedVO;
import guestroomimg.GuestRoomImgVO;
import outlook.OutLookVO;

public class GuestRoomDAO {
	private SqlSession sqlSessoin;
	
	public GuestRoomDAO(SqlSession sqlSessoin) {
		this.sqlSessoin = sqlSessoin;
	}

	public List<GuestRoomVO> grList(int no) {
		return sqlSessoin.selectList("guestRoom.grList",no);
	}

	public List<AmenitiesVO> amList() {
		return sqlSessoin.selectList("guestRoom.amList");
	}

	public List<BedVO> bedList() {
		return sqlSessoin.selectList("guestRoom.bedList");
	}

	public List<OutLookVO> otList() {
		return sqlSessoin.selectList("guestRoom.otList");
	}

	public int guestRoomInsert(GuestRoomVO vo) {
		sqlSessoin.insert("guestRoom.grInsert",vo);
		return vo.getGr_no(); 
	}

	public int grbInsert(GuestRoomBedVO vo) {
		return sqlSessoin.insert("guestRoom.grbInsert",vo);
		
	}

	public int grimgInsert(GuestRoomImgVO vo) {
		return sqlSessoin.insert("guestRoom.grimgInsert",vo);
		
	}

	public GuestRoomVO guestOne(int no) {
		return sqlSessoin.selectOne("guestRoom.guestOne",no);
	}

	public List<GuestRoomBedVO> guestBed(int no) {
		return sqlSessoin.selectList("guestRoom.guestBeds",no);
	}


	public void grDelete(int no) {
		sqlSessoin.delete("guestRoom.grDelete",no);
	}


	

	public int grUpdate(GuestRoomVO vo) {
		return sqlSessoin.update("guestRoom.grUpdate",vo);
	}

	public List<GuestRoomVO> lodgrList(int no) {
		return sqlSessoin.selectList("guestRoom.lodgrList",no);
	}

	public List<Integer> grnoList(int no) {
		return sqlSessoin.selectList("guestRoom.grnoList",no);
	}

	public void grAllDelete(int no) {
		sqlSessoin.delete("guestRoom.grAllDelete",no);
		
	}

	public int mainImgUpdate(GuestRoomVO vo) {
		return sqlSessoin.update("guestRoom.mainImgUpdate",vo);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
