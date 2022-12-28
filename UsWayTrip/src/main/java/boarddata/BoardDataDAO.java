package boarddata;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.BoardVO;

public class BoardDataDAO {
	
	private SqlSession sqlSession;
	
	public BoardDataDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BoardDataVO> selectList() {
		return sqlSession.selectList("boardData.selectList");
	}
	
	public List<BoardDataVO> bnSelectList(int board_no) {
		return sqlSession.selectList("boardData.bnSelectList", board_no);
	}
	
	public int insert(BoardDataVO vo) {
		return sqlSession.insert("boardData.insert", vo);
	}
	
	public BoardDataVO selectOne(BoardDataVO vo) {
		return sqlSession.selectOne("boardData.selectOne", vo);
	}
	
	// 22.12.01 추가 -> board.xml 참조하도록 할 것임
	public BoardVO selectOne(int board_no) {
		return sqlSession.selectOne("board.selectOne", board_no);
	}
	
	public int delete(int bd_no) {
		return sqlSession.delete("boardData.delete", bd_no);
	}
	
	// 11.26 추가
	public int update(BoardDataVO vo) {
		return sqlSession.update("boardData.update", vo);
	}
	
	// 22.12.02 추가
	public int getBd_no() {
		return sqlSession.selectOne("boardData.getBd_no");
	}
}
