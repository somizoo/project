package wishlist;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class WishListDAO {
	private SqlSession sqlSession;
	
	public WishListDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<WishListVO> allList(int no) {
		return sqlSession.selectList("wishList.allList", no);
	}

	public int insert(WishListVO vo) {
		return sqlSession.insert("wishList.insert", vo);
	}

	public int delete(WishListVO vo) {
		return sqlSession.delete("wishList.delete", vo);
	}
}
