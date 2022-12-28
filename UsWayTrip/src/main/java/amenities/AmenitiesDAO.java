package amenities;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class AmenitiesDAO {
	private SqlSession sqlSessoin;
	
	public AmenitiesDAO(SqlSession sqlSessoin) {
		this.sqlSessoin = sqlSessoin;
	}

	public List<AmenitiesVO> grAmAllList() {
		return sqlSessoin.selectList("amenities.grAmAllList");
	}

	public List<AmenitiesVO> gramList(int no) {
		return sqlSessoin.selectList("amenities.gramList",no);
	}
}
