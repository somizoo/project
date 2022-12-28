package reviewimg;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ReviewImgDAO{
	private SqlSession sqlSession;
	
	public ReviewImgDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(ReviewImgVO vo) {		
		return sqlSession.insert("ri.insert", vo);
	}

	public List<String> getImage(int seq) {
		return sqlSession.selectList("ri.getImage", seq);
	}
	public int deleteImg(int seq) {
		return sqlSession.delete("ri.delete", seq);
	}
	
}