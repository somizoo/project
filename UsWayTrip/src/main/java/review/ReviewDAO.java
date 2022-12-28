package review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ReviewDAO {
   private SqlSession sqlSession;

   public ReviewDAO(SqlSession sqlSession) {
      this.sqlSession = sqlSession;
   }
   
   public List<ReviewVO> allList(){
      return sqlSession.selectList("review.selectList");
   }

   public int insert(ReviewVO vo) {
      sqlSession.insert("review.insert", vo);
      return vo.getReview_no();
   }

   public ReviewVO selectOne(int reviewSeq) {
      return sqlSession.selectOne("review.selectOne", reviewSeq);
   }

   public int update(ReviewVO vo) {
      return sqlSession.update("review.update", vo);
   }

   public int delete(int seq) {
      return sqlSession.delete("review.delete", seq);
   }

   // 12.04 추가
   public ReviewVO lodgingReview(int no) {
      return sqlSession.selectOne("review.lodgingReview",no);
   }

   public List<ReviewVO> reviewList(int no) {
      return sqlSession.selectList("review.reviewList",no);
   }

   public ReviewVO reviewStarSelect(int no) {
      return sqlSession.selectOne("review.reviewStarSelect",no);
   }

public List<ReviewVO> allUList(int member_no) {
	return sqlSession.selectList("review.List", member_no);
}

   
}