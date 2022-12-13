package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import comingsoon.ComingSoonService;
import common.ViewPath;
import member.MemberService;

// 22.11.24. 인진 컨트롤러 내용 수정
@Controller
public class ComingSoonController {
   
   @Autowired
   private ComingSoonService comingSoonService;
   
      public ComingSoonController(ComingSoonService comingSoonService) {
         this.comingSoonService = comingSoonService;
      }
//      커밍 순 폼 연결
      @RequestMapping("/comingSoon/comingSoonForm")
      public String joinForm() {
         
         return ViewPath.U_I + "comingSoonForm.jsp";
      }
      
}
