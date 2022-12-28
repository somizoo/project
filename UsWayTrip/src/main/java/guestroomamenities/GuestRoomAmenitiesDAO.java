package guestroomamenities;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import amenities.AmenitiesVO;

public class GuestRoomAmenitiesDAO {
	private SqlSession sqlSession;
	
	public GuestRoomAmenitiesDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int graInsert(GuestRoomAmenitiesVO vo) {
		return sqlSession.insert("guestRoomAmenities.graInsert",vo);
	}

	public int gramDelete(int no) {
		return sqlSession.delete("guestRoomAmenities.gramDelete",no);
		
	}

	public List<AmenitiesVO> guestAm(int no) {
		return sqlSession.selectList("guestRoomAmenities.guestAms",no);
	}
}
