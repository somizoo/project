package ticketpayoption;

import org.apache.ibatis.session.SqlSession;

public class TicketPayOptionDAO {
	private SqlSession sqlSession;

	public TicketPayOptionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
}
