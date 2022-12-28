package place;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PlaceDAO {

   private SqlSession sqlSession;
   
   public PlaceDAO(SqlSession sqlSession) {
      this.sqlSession = sqlSession;
   }

   public List<PlaceVO> placeSelectList() {
      return sqlSession.selectList("place.placeSelectList");
   }
   
   


}