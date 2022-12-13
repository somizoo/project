package guestroomoption;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import price.priceVO;

public class GuestRoomOptionDAO {
	private SqlSession sqlSession;
	
	public GuestRoomOptionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int groInsert(GuestRoomOptionVO vo) {
		sqlSession.insert("guestRoomOption.groInert", vo);
		return vo.getGro_no();
	}

	public GuestRoomOptionVO groOne(int no) {
		return sqlSession.selectOne("guestRoomOption.groOne", no);
	}

	public int groDelete(int no) {
		return sqlSession.delete("guestRoomOption.groDelete", no);
	}

	public List<GuestRoomOptionVO> groAllList() {
		return sqlSession.selectList("guestRoomOption.groAllList");
	}

	public int groUpdate(GuestRoomOptionVO vo) {
		return sqlSession.update("guestRoomOption.groUpdate",vo);
	}

	public int guestRoomDelete(int grno) {
		return sqlSession.delete("guestRoom.grDelete",grno);
		
	}

	public List<GuestRoomOptionVO> groList(int no) {
		return sqlSession.selectList("guestRoomOption.groList",no);
	}

	public Integer getlodMinPrice(int no) {
		return sqlSession.selectOne("guestRoomOption.getlodMinPrice",no);
	}

	public List<priceVO> lodpriceList() {
		return sqlSession.selectList("guestRoomOption.lodpriceList");
	}
	
	public int getPrice(int grono) {
		return sqlSession.selectOne("guestRoomOption.getPrice", grono);
	}
}
