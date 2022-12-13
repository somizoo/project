package ticketevent;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ticket.TicketVO;

public class TicketEventDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<TicketEventVO> allList(){
		return sqlSession.selectList("ticketevent.selectList");
	}
	
	public int write(TicketEventVO vo) {
		return sqlSession.insert("ticketevent.insert", vo);
	}
	
	public TicketEventVO list(int seq) {
		return sqlSession.selectOne("ticketevent.selectOne", seq);
	}

	public int deleteImg(int seq) {
		return sqlSession.update("ticketevent.deletImg", seq);
	}
	
	public int update(TicketEventVO vo) {
		return sqlSession.update("ticketevent.update", vo);
	}

	public int delete(int seq) {
		return sqlSession.delete("ticketevent.delete", seq);
	}

	public int teDelete(TicketVO vo) {
		return sqlSession.delete("ticketevent.teDelete", vo);
	}
}
