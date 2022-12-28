package boarddatafile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDataFileDAO {
	private SqlSession sqlSession;

	public BoardDataFileDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(BoardDataFileVO vo) {
		return sqlSession.insert("bdf.insert",vo);
	}
	
	public List<BoardDataFileVO> selectList(int bd_no){
		return sqlSession.selectList("bdf.selectList",bd_no);
	}
}
