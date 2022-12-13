package ticketoption;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class TicketOptionDAO {
private SqlSession sqlSession;
	
	public TicketOptionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<TicketOptionVO> selectList() {
		return sqlSession.selectList("ticketoption.selectList");
	}

	public int insert(TicketOptionVO vo) {
		return sqlSession.insert("ticketoption.insert", vo);
	}

	public int delete(int no) {
		return sqlSession.delete("ticketoption.delete", no);
	}

	public TicketOptionVO selectOne(int no) {
		return sqlSession.selectOne("ticketoption.selectOne", no);
	}

	public int update(TicketOptionVO vo) {
		return sqlSession.update("ticketoption.update", vo);
	}

	public int toMinSelect(int no) {
		return sqlSession.selectOne("ticketoption.toMinSelect", no);
	}


	public TicketOptionVO selectTicketOption(int val) {
		return sqlSession.selectOne("ticketoption.selectOne", val);
	}


	
}
