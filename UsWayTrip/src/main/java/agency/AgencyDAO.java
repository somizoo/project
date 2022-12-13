package agency;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boarddata.BoardDataVO;

public class AgencyDAO {
	
	private SqlSession sqlSession;
	
	public AgencyDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<AgencyVO> selectList() {
		return sqlSession.selectList("agency.selectList");
	}
	
	public int insert(AgencyVO vo) {
		return sqlSession.insert("agency.insert", vo);
	}
	
	public AgencyVO selectOne(int agency_no) {
		return sqlSession.selectOne("agency.selectOne", agency_no);
	}
	
	public int update(AgencyVO vo) {
		return sqlSession.update("agency.update", vo);
	}
	
	public int delete(int agency_no) {
		return sqlSession.delete("agency.delete", agency_no);
	}
}
