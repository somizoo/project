package payment;

import org.apache.ibatis.session.SqlSession;

public class PaymentDAO {
	private SqlSession sqlSession;
	
	public PaymentDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(PaymentVO vo) {
		return sqlSession.insert("payment.insert", vo);
	}

	public PaymentVO selectOne(Integer member_no) {
		return sqlSession.selectOne("payment.selectOne", member_no);
	}
	

}
