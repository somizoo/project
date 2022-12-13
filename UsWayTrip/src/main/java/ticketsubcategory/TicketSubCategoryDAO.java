package ticketsubcategory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ticketevent.TicketEventVO;

public class TicketSubCategoryDAO{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<TicketSubCategoryVO> selectList(){
		return sqlSession.selectList("ticketsubcategory.selectList");
	}
	
	public int insert(TicketSubCategoryVO vo) {
		return sqlSession.insert("ticketsubcategory.insert", vo);
	}
	
	public TicketSubCategoryVO selectOne(int seq) {
		return sqlSession.selectOne("ticketsubcategory.selectOne", seq);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("ticketsubcategory.delete", seq);
	}
	
	public int update(TicketSubCategoryVO vo) {
		return sqlSession.update("ticketsubcategory.update", vo);
	}

	public List<TicketSubCategoryVO> tscSelectList() {
		return sqlSession.selectList("ticketsubcategory.tscSelectList");
	}

	public String selectNameOne(int ticket_no) {
		return sqlSession.selectOne("ticketsubcategory.selectNameOne", ticket_no);
	}


}