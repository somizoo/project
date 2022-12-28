package guestroomimg;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestRoomImgDAO {
	private SqlSession sqlSessoin;
	
	public GuestRoomImgDAO(SqlSession sqlSessoin) {
		this.sqlSessoin = sqlSessoin;
	}

	public List<GuestRoomImgVO> grImgs(int no) {
		return sqlSessoin.selectList("guestRoomImg.grImgs", no);
	}

	// 객실 사진 전체 지우기
	public int grImgDelete(int no) {
		return sqlSessoin.delete("guestRoomImg.grImgDelete",no);
		
	}

	// 객실 사진 하나만 지우기
	public int imgDelete(String imgname) {
		return sqlSessoin.delete("guestRoomImg.imgDelete", imgname);
	}

}
