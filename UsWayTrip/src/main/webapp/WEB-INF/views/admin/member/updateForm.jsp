<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	function check(){
		
// 		이름 유효성 검사
		if(document.update.member_name.value == ""){
			alert("이름을 입력해 주세요");
			document.update.member_name.focus();
			return;
		}
		
// 		연락처 수정
		if(document.update.member_ph.value == ""){
			alert("연락처를 입력해 주세요");
			document.update.member_ph.focus();
			return;
		}
		
// 		연락처 유효성 검사 체크
		var regphs = /^\d{3}-\d{3,4}-\d{4}$/;

		if(!regphs.test(document.update.member_ph.value)){
			alert("연락처를 확인해주시기 바랍니다");
			document.update.member_ph.focus();
			return;
		}
		
// 		비밀번호 유효성 검사
		if(document.update.member_pw.value == ""){
			alert("비밀번호를 확인해 주세요");
			document.update.member_ph.focus();
			return;
		}
		
// 		비밀번호 자리수 유효성 검사
		if(document.update.member_pw.value.length < 8 || document.update.member_pw.value.length > 15){
			alert("비밀번호는 8 ~ 15자 사이로 작성하여야 합니다");
			document.update.member_pw.focus();
			return;
		}
		
// 		비밀번호 포함 유효성 검사
		var regs = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])/;
		var hangleChecks = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!regs.test(document.update.member_pw.value)){
			alert("비밀번호는 대문자, 소문자, 숫자, 특수문자를 모두 포함하여야 합니다");
			document.update.member_pw.focus();
			return;
		}
		if(hangleChecks.test(document.update.member_pw.value)){
			alert("비밀번호는 한글을 사용할 수 없습니다.");
			document.update.member_pw.focus();
			return;
		}
		
// 		비밀번호 동일 문자 반복 유효성 검사
		if(/(\w)\1\1/.test(document.update.member_pw.value)){
			alert("비밀번호는 같은 문자를 3번 이상 사용하실 수 없습니다");
			document.update.member_pw.focus();
			return;
		}
		
// 		비밀번호 공백 포함 유효성 검사
		if(document.update.member_pw.value.search(/\s/) != -1){
			alert("비밀번호는 공백을 포함할 수 없습니다");
			document.update.member_pw.focus();
			return;
		}
				
		document.update.member_pw.value = btoa(document.update.member_pw.value);
		
		document.update.submit();
	}
	
	function deleteAction() {
		var check = confirm("탈퇴 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${path }deleteForm';
	}
	
</script>

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>


<div align = "center">
	<div  align = "center" style ="border:1px solid black; height:auto; width:440px">
		<form action ="${path }update" method = "post" name = "update">
		<input type="hidden" name = "member_no" value="${vo.member_no}">
			<h2>마이페이지</h2>
			
			<!-- 프로필 사진 -->
<!-- 			<div align = "left" style="margin-left: 30px; margin-top:20px; height: 200px"> -->
<!-- 				<label for="pi_name">프로필 이미지명</label> -->
<!-- 			<br> -->
<!-- 				<input type = "image" name = "pi_name" placeholder="ID@example.com" size=40> -->
<!-- 			</div> -->
			
			
			
			<!-- 이름 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_name">이름</label>
			<input type="text" name = "member_name" value="${vo.member_name}" size=40>
			</div>
		
			<!-- 이메일 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_email">이메일</label>
			<br>
				<div>${vo.member_email}</div>
			</div>
		
			<!-- 연락처 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_ph">연락처</label>
			<br>
			<input type="text" name = "member_ph" value="${vo.member_ph}" size=40>
			</div>
			
			<!-- 비밀번호 입력 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_pw">비밀번호</label>
			<br>
				<input type="text" name ="member_pw" placeholder="바꿀 비밀번호를 입력 해 주세요" size=40>
			</div>
		
			<!-- 수신 동의 -->

			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_clause">마케팅 수신동의</label>
			<br>
			<div align = "left" style="margin-left: 20px; margin-top:20px">
				
				
		  		<input type="radio" name="member_clause" id="inlineRadio1" value= "0" <c:if test="${vo.member_clause eq 0}"> checked </c:if>>
		  		<label for="inlineRadio1">수신거부</label>&nbsp;
		  		<input type="radio" name="member_clause" id="inlineRadio2" value= "1" <c:if test="${vo.member_clause eq 1}"> checked </c:if>>
		  		<label for="inlineRadio2">수신</label>&nbsp;
		  		</div>
			</div>
			<br>
			
			<div style = "display:flex; justify-content: center">
				<div align = "right" style = "width:40%; padding-right: 60px; margin-top:20px;">
					<button type ="reset" class="btn btn-success">취소하기</button>
				</div>
				<div align = "left" style = "width:40%; padding-left: 20px; margin-top:20px;">
					<button type ="button" class="btn btn-success" onclick= "check()">저장하기</button>
				</div>
				
				<div align = "left" style = "width:40%; padding-left: 20px; margin-top:20px;">
					<button type ="button" class="btn btn-success" onclick= "deleteAction()">탈퇴하기</button>
				</div>
			</div>
			<br>
		</form>
	</div>
</div>	
