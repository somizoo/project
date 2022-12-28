package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.MemberVO;


@Service
public class MemberService {
   
   private MemberDAO memberDao;
   
   @Autowired
   public MemberService(MemberDAO memberDao) {
      this.memberDao = memberDao;
   }
   public int insert(MemberVO vo) {
      return memberDao.insert(vo);
   }
   public int checkLogin(MemberVO vo) {
      return memberDao.checkLogin(vo);
   }
//   12.1.(목) 세션에 권한 담기 추가
   public int checkRole(MemberVO vo) {
	   return memberDao.checkRole(vo);
   }
   public String checkEmail(String member_email) {
      return memberDao.checkEmail(member_email);
   }
   
   public MemberVO selectOne(int member_no) {
      return memberDao.selectOne(member_no);
   }
   
   public String findEmail(MemberVO vo) {
      return memberDao.findEmail(vo);
   }
   
   public String findPw(MemberVO vo) {
      return memberDao.findPw(vo);
   }
   
   public String getEmail(int member_no) {
      return memberDao.getEmail(member_no);
   }
   
   public String getName(int member_no) {
      return memberDao.getName(member_no);
   }
//    12.1. update Service 추가
	public int update(MemberVO vo) {
		return memberDao.update(vo);
	}
	
	
	// 22.12.03 내용추가
	public int countpw(int member_no) {
		return memberDao.countpw(member_no);
	}
	
	// 22.12.03 내용추가
	public String getId(int no) {
		return memberDao.getId(no);
	}
	
	// 22.12.03 내용추가
	public int delete(int no) {
		return memberDao.delete(no);
	}
}




















