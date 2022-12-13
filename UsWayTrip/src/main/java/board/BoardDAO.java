package board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import boarddata.BoardDataVO;

public class BoardDAO {
	private SqlSession sqlSession;
	
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BoardDataVO> selectList() {
		return sqlSession.selectList("board.selectList");
	}
	
	public List<BoardDataVO> selectList2(Map<String, Object> map) {
		return sqlSession.selectList("board.selectList2", map);
	}
	
	public BoardVO selectOne(int board_no) {
		return sqlSession.selectOne("board.selectOne", board_no);
	}
	
	public int count(int board_no) {
		return sqlSession.selectOne("board.count", board_no);
	}
	
}
