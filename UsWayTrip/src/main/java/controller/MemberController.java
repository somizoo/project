package controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.RedirectPath;
import common.ScriptUtil;
import common.ViewPath;
import member.MemberService;
import member.MemberVO;

// 22.11.24. 인진 컨트롤러 내용 수정
@Controller
public class MemberController {
   
   @Autowired
   private MemberService memberService;
   
      public MemberController(MemberService memberService) {
         this.memberService = memberService;
      }
//      회원가입 폼 연결
      @RequestMapping("/member/joinForm")
      public String joinForm(Model model) {
         
         model.addAttribute("path", RedirectPath.U_MEMBER);
         
         return ViewPath.U_MEMBER + "joinForm.jsp";
      }
      
//      이메일 중복 검사
      // 뒤에 produces는 servlet-context에서 설정해준거 있어서 앞으로는 안적어도 괜찮은거야
      @RequestMapping(value = "/member/checkEmail"/* , produces = "application/text;charset=utf-8" */)
      // 데이터 자체를 클라이언트에게 전달하겠다는 의미 ResponseBody
      @ResponseBody
      public String checkEmail(String member_email) {
         
         
         if(memberService.checkEmail(member_email) != null) {
            
            return "이미 사용중인 이메일 입니다";
         } else{
            return "사용 가능한 이메일 입니다";
            
         }
         
         
      }
      
//      회원가입 DB 저장
      @RequestMapping("/member/insert")
      public void join(MemberVO vo, Model model, HttpServletResponse response) {
         
         String msg = null;
         String url = null;
         
         int su = memberService.insert(vo);
         
         if(su != 0) {
            msg = vo.getMember_name() + "님의 회원가입이 완료되었습니다.";
            url =  RedirectPath.U_MEMBER + "loginForm?id=" + vo.getMember_email();
            
         } else {
            msg = vo.getMember_name() + "님의 회원가입이 실패됐습니다.";
            url = RedirectPath.U_MEMBER + "joinForm";
         }
         
         try {
            ScriptUtil.alertAndMovePage(response, msg, url);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      
//      로그인
      @RequestMapping("/member/loginForm")
      public String loginForm (HttpServletRequest request, Model model) {
         
         String email = request.getParameter("member_email");
         
   //      여기서는 cookie 생성을 할 필요가 없어. 로그인을 눌렀을 때, 기존 쿠키가 있다면 그 값을 가져오기 위함이야
   //      그래서 쿠키 생성 관련은 없고, 쿠키가 있는지만 찾아주고, 없으면 그냥 넘어가겠다고 설계가 되어있어
         
   //      쿠키 유무 확인
         boolean check = false;
   //      만약에 이메일 값이 없으면(로그인 창에 처음 들어왔을 때)
         if(email == null) {
   //         기존에 쿠키 값이 있었는지 찾기
            Cookie[] cks = request.getCookies();
   //         기존에 쿠키 값이 있었으면 그 값으로 쿠키 값을 변경해주기
            if(cks != null) {
               for(Cookie ck : cks) {
                  if(ck.getName().equals("ckemail")) {
                     email = ck.getValue();
                     check = true;
                     break;
                  }
               }
            }
   //         기존에 쿠키 값이 없으면 null 값으로 냅두기
            if(email == null) {
               email = "";
            }
         }
         
         model.addAttribute("path", RedirectPath.U_MEMBER);
         
   //      쿠키 값 체크 관련하여 쓴 check 값 넣어주기
         model.addAttribute("check", check);
   //      로그인 관련해서 기존에 있는 쿠키값 비교 후 있으면 그걸 넣었고, 없으면 null 값 넣은 것을 담아주기
         model.addAttribute("member_email", email);
         return ViewPath.U_MEMBER + "loginForm.jsp";
      }
      
   //   아이디 기억하기를 위하여 사용
      @RequestMapping("/member/loginCheck")
      public void loginCheck(MemberVO vo, HttpServletRequest request, HttpServletResponse response, Model model) {
         
   //      checkLogin에 담긴 값 사용하기 위하여 변수 생성
         int no = 0;
         int role = 0;
         
   //      checkLogin에 담긴 값 가져오기
         no = memberService.checkLogin(vo);
//         세션에 권한 담기 추가
         role = memberService.checkRole(vo);
         
   //      msg, url, cks, sck 찾기 위하여 변수 생성
         String msg = null;
         String url = null;
         Cookie[] cks = null;
         Cookie sck = null;
   
   //      쿠키 값이 있는지 없는지 체크하기 위하여 check를 일단 false로 놓기
         boolean check = false;
         
   //      no가 0이 아니라는 것은 담긴 값이 있다는 것이고 로그인이 되었다는 것
         if(no != 0) {
            
   //         로그인이 되었다면 그 값을 session에 담기 위한 것(중요)
            request.getSession().setAttribute("login", no);
            request.getSession().setAttribute("role", role);
            
   //         아이디 기억하기 체크를 판단하기 위하여 chemail 값을 받아 오기 위한 변수 설정
            String ckemail = request.getParameter("ckemail");
   //         초기 check를 false로 해놓았기 때문에 여기서 true로 변경
            check = true;
   //         로그인에 성공하면 아래와 같은 msg를 띄우기
            msg = vo.getMember_email() + "님의 로그인이 되셨습니다";
   //         로그인 이후에 이동되는 url로 index.jsp가 완성 되면 거기로 가기(수정 요망)
            url = "/uswaytrip/";
            
   //         기존에 쿠키 값이 있었는지 확인하기 위함
            cks = request.getCookies();
   //         for문 if문 돌려서 ckemail 값이 있는지 확인하여서 쿠키를 찾기 위하여 만든 sck 값에 찾은 ck 값 넣는다는 의미
            for(Cookie ck : cks) {
               if(ck.getName().equals("ckemail")) {
                  sck = ck;
                  break;
               }
            }
            
   //         여기는 ckemail 그니까 ckemail 기억하기가 체크가 되어있다면을 의미
            if(ckemail != null) {
   //            기억하기를 체크 하였으니 기존에 쿠키 값이 있는지 찾아보기
   //            sck == null 이라는 것은 쿠키가 없다는 의미
               if(sck == null) {
   //               쿠키가 없으니 새롭게 만들어주기
                  sck = new Cookie("ckemail", vo.getMember_email());
   //               root로 경로 설정해서 프로젝트 전체에서 접근 가능하도록 설정하기
                  sck.setPath("/");
   //               쿠키 만료 기간을 1일로 설정하기
                  sck.setMaxAge(60*60*24);
   //               이 모든 값을 addCookie(sck)에 담아주기
                  response.addCookie(sck);
               }
   //            기억하기를 체크 하였고(ckemail != null), 쿠키가 있으면을 의미
               else {
   //               그러면 내가 입력한 쿠키가 아니니까 내가 입력한 쿠키로 기존의 쿠키 값을 변경해주기
                  if(!sck.getValue().equals(vo.getMember_email())) {
                     sck.setValue(vo.getMember_email());
   //                  설정한 값을 다시 addCookie(sck)에 담아주기
                     response.addCookie(sck);
                  }
               }
   //         여기는 ckemail 그니까 ckemail 기억하기가 체크가 안되어있다면을 의미   
            }else {
   //            sck != null 이라는 것은 쿠키가 있다는 의미
               if(sck != null) {
   //               기억하기를 원하지 않다는 것이고,
   //               기존에 쿠키가 내가 넣었던 email 관련한 쿠키와 같다면
   //               쿠키 유효기간을 0으로 설정하겠다는 의미
                   if(sck.getValue().equals(vo.getMember_email())) {
                     sck.setMaxAge(0);
                     sck.setPath("/");
   //                  역시 바뀌게 된 값을 다시 addCookie(sck)에 담아주겠다는 의미
                     response.addCookie(sck);
                  }
               }
            }
   //      no가 0이라는 의미이며, 로그인에 실패했다는 의미
         }else {
            msg = "아이디나 비밀번호를 확인해주세요";
   //         그리고 기존 loginForm으로 이동해주는 다는 의미
            url = RedirectPath.U_MEMBER + "loginForm";
         }
         
   //      msg, check, ulr을 다시 model에 담아주라는 의미
         model.addAttribute("msg", msg);
         model.addAttribute("check", check);
         model.addAttribute("url", url);
         
   //      인호가 만든 ScriptUtil 사용해서 return 값을 3개 중 1개로 처리해주기
         try {
            ScriptUtil.alertAndMovePage(response, msg, url);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      
//      로그아웃
      @RequestMapping("/member/logout")
      public void logout(Model model, HttpSession session, HttpServletResponse response) {
         
//         세션을 비운다는 의미
         session.invalidate();
         
         String msg = null;
         String url = null;
         
         msg = "로그아웃되었습니다";
         url = RedirectPath.USER;
               
         try {
            ScriptUtil.alertAndMovePage(response, msg, url);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      
//      email, pw 찾기
      
      @RequestMapping("/member/findForm")
      public String findForm() {
         return ViewPath.U_MEMBER + "findForm.jsp";
      }
      
      @RequestMapping("/member/find")
      public String find(Model model, MemberVO vo, String mode) {
         
         String find = null;
         if(vo.getMember_email() == null){
            find = memberService.findEmail(vo);
         }else{
            find = memberService.findPw(vo);   
         }
         
         boolean check = false;
         if(find != null){
        	 if(vo.getMember_email() != null){ 
        		 Decoder decoder = Base64.getDecoder();
        		 find = new String(decoder.decode(find));
        	 }
            check = true;
            String re = "";
            for(int i = 0; i < find.length(); i++){
               if(i % 2 == 0){
                  re += find.charAt(i);
               }else{
                  re += "*";
               }
            }
            
            if(mode.equals("member_email")){
               model.addAttribute("member_email", re);
            }else{
               model.addAttribute("member_pw", re);   
            }
         }
         
         model.addAttribute("check", check);
         
         return ViewPath.U_MEMBER + "findResult.jsp";
      }
      
//    마이페이지 연결
      @RequestMapping("/member/myPageForm")
      public String myPageForm(HttpServletRequest request) {
    	Integer no = (Integer)request.getSession().getAttribute("login");
		
    	if(no == null) {
			return RedirectPath.U_MEMBER + "loginForm";
		}
		
		MemberVO vo = memberService.selectOne(no);
		
		// 22.12.03 비밀번호 (*) 표시
		int countpw = memberService.countpw(no) - 8;
		
		request.setAttribute("countpw", countpw);
		request.setAttribute("vo", vo);
		request.setAttribute("path", RedirectPath.U_MEMBER);
		
		return ViewPath.U_MEMBER + "myPageForm.jsp";    
      }
      
      @RequestMapping("/member/updateForm")
      public String updateForm(HttpServletRequest request, MemberVO vo) {
    	Integer no = (Integer)request.getSession().getAttribute("login");
  		
      	if(no == null) {
  			return RedirectPath.U_MEMBER + "loginForm";
  		}
      	
      	vo = memberService.selectOne(no);
      	
      	request.setAttribute("vo", vo);
      	request.setAttribute("path", RedirectPath.U_MEMBER);
      	
      	return ViewPath.U_MEMBER + "updateForm.jsp";
      }
      
//    회원가입 DB 수정
    @RequestMapping("/member/update")
    
    public void update(MemberVO vo, Model model, HttpServletResponse response) {
       
       String msg = null;
       String url = null;
       
       int ud = memberService.update(vo);
       if(ud != 0) {
          msg = vo.getMember_name() + "님의 회원정보가 수정되었습니다.";
          url =  RedirectPath.U_MEMBER + "myPageForm";
          
       } else {
          msg = vo.getMember_name() + "님의 회원정보 수정에 실패하였습니다.";
          url = RedirectPath.U_MEMBER + "myPageForm";
       }
       
       try {
          ScriptUtil.alertAndMovePage(response, msg, url);
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    
    @RequestMapping("/member/deleteForm")
	public String deleteForm(HttpServletRequest request) {
		
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return RedirectPath.U_MEMBER + "loginForm";
		}
		
		String id = memberService.getId(no);
		
		request.setAttribute("id", id);
      	request.setAttribute("path", RedirectPath.U_MEMBER);

		return ViewPath.U_MEMBER + "deleteForm.jsp";
	}
    
    //회원탈퇴
    @RequestMapping("/member/delete")
    
    public void delete(MemberVO vo, String member_pw, HttpServletRequest request, HttpServletResponse response) {
    	
    	Integer no = (Integer)request.getSession().getAttribute("login");
    	
    	vo = memberService.selectOne(no);
    	
    	String msg = "";
		String url = "";
		
				
		if(!vo.getMember_pw().equals(member_pw)){
			msg = "비밀번호가 틀렸습니다.!!이전페이지로....";
			url = RedirectPath.U_MEMBER + "deleteform";
		} else {
			int check = memberService.delete(no);
			System.out.println(check);
			if(check != 0){
	    		
	    		Cookie[] cks = request.getCookies();
	    		if(cks != null) {
	    			for(Cookie ck : cks) {
	    				if(ck.getValue().equals(vo.getMember_email())) {
	    					ck.setMaxAge(0);
	    					ck.setPath("/");
	    					response.addCookie(ck);
	    					break;
	    				}
	    			}
	    		}
	    		request.getSession().invalidate();
	    		msg = vo.getMember_email() + "님의 정보가 삭제되었습니다";
	    		url = RedirectPath.U_MEMBER + "loginForm";
	    	} else {
	    		 msg = vo.getMember_name() + "님의 회원탈퇴에 실패하였습니다.";
	             url = RedirectPath.U_MEMBER + "deleteForm";
	    	}
	        try {
	            ScriptUtil.alertAndMovePage(response, msg, url);
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	    }
    }
}
