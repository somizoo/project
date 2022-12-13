<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<script>

	function check(f){
		if(f.member_email.value == ""){
			alert("ID를 입력하십시오!");
			f.member_email.focus();
			return false;
		} else if(f.member_pw.value == ""){
			alert("PW를 입력하십시오!");
			f.member_pw.focus();
			return false;
		}
		f.member_pw.value = btoa(f.member_pw.value);
		
// 		document.input.member_pw.value = btoa(document.input.member_pw.value);
		return true;
	}
	
</script>
<!-- 로그인 폼 -->

<div align = "center">
	<div  align = "center" style ="border:1px solid black; height:auto; width:400px">
		<form action ="${path}loginCheck" method = "post" name = "input" onsubmit = "return check(this)">
			<h2>로그인</h2>
			
			<!-- 이메일 입력 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_email">이메일</label>
			<br>
				<!-- 여기 기억하기 기능 구현하기 위해서 ${member_email} 추가 기능 구현 -->
				<input type = "text" name = "member_email" placeholder="ID@example.com" size=40 value = "${member_email}">
			</div>
			
			<!-- 비밀번호 입력 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_pw">비밀번호</label>
			<br>
				<input type = "password" name = "member_pw" placeholder="비밀번호를 입력해주세요" size=40>
			</div>
			
			<!-- 아이디 기억하기, 비밀번호 찾기 flex -->			
			<div style = "display:flex; justify-content: space-around">
				<div style = "display:flex; justify-content: flex-start">
			<!-- 아이디 기억하기 -->
				<c:choose>
					<c:when test="${check == true}">
							<input type="checkbox" name = "ckemail" value= "true" checked = "checked">
						</c:when>
						<c:when test="${check == false}">
							<input type="checkbox" name = "ckemail" value = "true">
						</c:when>
					</c:choose>
						<div class= "id-search">
						<font class="ckemail_text">아이디 기억하기</font>
						</div>
				</div>
				
			<!-- 이메일, 비밀번호 찾기 -->	
				<div style=" display:flex; justify-content: space-around; margin-right:20px">
					<div>
						<a href = "${path }findForm?mode=email" style="font-size: 5px; margin-right:15px" >이메일 찾기</a>
					</div>
					<div>
						<a href = "${path }findForm?mode=pw"  style="font-size: 5px">비밀번호 찾기</a>
					</div>
				</div>
			</div>
				<br>
				<div align = "left" style = "margin-left:30px; margin-top:20px;">
					<button type ="submit" style = "width:320px; height:30px">로그인</button>
				</div>
				<!-- 아직 회원이 아니신가요?, 회원가입 flex  -->
				<div class= "id-search" style="margin-right:20px; display:flex; justify-content: space-around">
			
				<!-- 단순 안내문 -->	
				<div>
					<p> 아직 회원이 아니신가요?</p>
				</div>
				
				<!-- 클릭했을 때 회원가입으로 이어지게 설계 -->
				<div style= "margin-top: 5px; font-size: 5px">
					<a href="${pageContext.request.contextPath}/admin/member/joinForm">회원가입</a>
				</div>
			</div>
		</form>
	</div>
</div>
  
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
