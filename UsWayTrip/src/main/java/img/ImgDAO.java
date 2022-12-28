package img;

import org.apache.ibatis.session.SqlSession;

import lodging.LodgingVO;

public class ImgDAO {
	private SqlSession sqlSession;
	
	public ImgDAO(SqlSession sqlSession) {
	this.sqlSession = sqlSession;
	}

	public void lodImgDel(int no) {
		sqlSession.delete("img.lodimgDel",no);
		
	}

	public int imgDelete(String imgname) {
		return sqlSession.delete("img.imgDelete",imgname);
		
	}



}
