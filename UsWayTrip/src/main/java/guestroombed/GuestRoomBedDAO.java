package guestroombed;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestRoomBedDAO {
	private SqlSession sqlSessoin;
	public GuestRoomBedDAO(SqlSession sqlSessoin) {
		this.sqlSessoin = sqlSessoin;
	}
	
	public int grbedDelete(int no) {
		return sqlSessoin.delete("guestRoomBed.grbedDelete",no);
		
	}

	//객실 전체 침대 리스트
	public List<GuestRoomBedVO> grbedAllList() {
		return sqlSessoin.selectList("guestRoomBed.grbedAllList");
	}
	// 해당 객실 침대 리스트
	public List<GuestRoomBedVO> grbedList(int no) {
		return sqlSessoin.selectList("guestRoomBed.grbedList", no);
	}
}
