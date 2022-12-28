package managercoupon;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ManagerCouponDAO {
	private SqlSession sqlSession;
	
	public ManagerCouponDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<ManagerCouponVO> allList() {
		return sqlSession.selectList("mc.selectList");
	}

	public int insert(ManagerCouponVO vo) {
		return sqlSession.insert("mc.insert", vo);
	}

	public ManagerCouponVO selectOne(int seq) {
		return sqlSession.selectOne("mc.selectOne", seq);
	}

	public int update(ManagerCouponVO vo) {
		return sqlSession.update("mc.update", vo);
	}

	public int delete(int seq) {
		return sqlSession.update("mc.delete", seq);
	}

	public ManagerCouponVO getlodcupon(int no) {
		return sqlSession.selectOne("mc.getlodcupon", no);
	}
	
	
}
