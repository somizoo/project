package member;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
   
   private SqlSession sqlSession;
   
   public void setSqlSession(SqlSession sqlSession) {
      this.sqlSession = sqlSession;
   }
   
   public int insert(MemberVO vo) {
      return sqlSession.insert("member.insert", vo);
   }
   
   public int checkLogin(MemberVO vo) {
      int no = 0;
      try {
         no = sqlSession.selectOne("member.checkLogin", vo);
      } catch (NullPointerException e) {
         e.printStackTrace();
      }
      return no;
   }
//   12.1.(목) 세션에 권한 담기 추가
   public int checkRole(MemberVO vo) {
	   int no1 = 0;
	   try {
		   no1 = sqlSession.selectOne("member.checkRole", vo);
	   } catch (NullPointerException e) {
		   e.printStackTrace();
	   }
	   return no1;
   }
   
   
   public String checkEmail(String member_email) {
      return sqlSession.selectOne("member.checkEmail", member_email);
   }
   
   public MemberVO selectOne(int member_no) {
      return sqlSession.selectOne("member.selectOne",member_no);
   }
   
   public String findEmail(MemberVO vo) {
      return sqlSession.selectOne("member.findEmail",vo);
   }
   
   public String findPw(MemberVO vo) {
      return sqlSession.selectOne("member.findPw",vo);
   }
   
   public String getEmail(int member_no) {
      return sqlSession.selectOne("member.getEmail",member_no);
   }
   public String getName(int member_no) {
      return sqlSession.selectOne("member.getName",member_no);
   }
//   12.1. update DAO 추가
   public int update(MemberVO vo) {
	  return sqlSession.update("member.update", vo);
   }
   
   // 22.12.03 내용 추가
   public int countpw(int member_no) {
	   return sqlSession.selectOne("countpw", member_no);
   }
   
   // 22.12.03 내용 추가
   public String getId(int no) {
		return sqlSession.selectOne("member.getId",no);
	}
   
	// 22.12.03 내용 추가
	public int delete(int no) {
	   return sqlSession.delete("member.delete", no);
	}
}
   














