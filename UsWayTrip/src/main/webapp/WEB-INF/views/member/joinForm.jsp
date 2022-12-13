<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script>
/* 22.11.23 인진 회원가입 폼 작성 */
  	
	function check() {
		
// 		이름 유효성 검사
		if(document.input.member_name.value == ""){
			alert("이름을 입력해 주세요");
			document.input.member_name.focus();
			return;
		}
		
// 		생년월일 유효성 검사
		if(document.input.member_birthday.value == ""){
			alert("생년월일을 선택해주세요");
			return;
		}
		
// 		이메일 유효성 검사
		if(document.input.member_email.value == ""){
			alert("이메일을 입력해주세요");
			return;
		}
		
// 		이메일 유효성 검사 체크
		var regemail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

		if(!regemail.test(document.input.member_email.value)){
			alert("이메일을 확인해주시기 바랍니다");
			form.document.input.member_email.focus();
			return;
		}

// 		비밀번호 유효성 검사
		if(document.input.member_pw.value == ""){
			alert("비밀번호를 입력해 주세요")
			document.input.member_pw.focus();
			return;
		}
		
// 		비밀번호 자리수 유효성 검사
		if(document.input.member_pw.value.length < 8 || document.input.member_pw.value.length > 15){
			alert("비밀번호는 8 ~ 15자 사이로 작성하여야 합니다");
			form.document.input.member_pw.focus();
			return;
		}
		
// 		비밀번호 포함 유효성 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])/;
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!reg.test(document.input.member_pw.value)){
			alert("비밀번호는 대문자, 소문자, 숫자, 특수문자를 모두 포함하여야 합니다");
			form.document.input.member_pw.focus();
			return;
		}
		if(hangleCheck.test(document.input.member_pw.value)){
			alert("비밀번호는 한글을 사용할 수 없습니다.");
			form.document.input.member_pw.focus();
			return;
		}
		
// 		비밀번호 동일 문자 반복 유효성 검사
		if(/(\w)\1\1/.test(document.input.member_pw.value)){
			alert("비밀번호는 같은 문자를 3번 이상 사용하실 수 없습니다");
			form.document.input.member_pw.focus();
			return;
		}
		
// 		비밀번호 공백 포함 유효성 검사
		if(document.input.member_pw.value.search(/\s/) != -1){
			alert("비밀번호는 공백을 포함할 수 없습니다");
			form.document.input.member_pw.focus();
			return;
		}
		
// 		비밀번호 유효성 재검사
		if(document.input.member_repw.value == ""){
			alert("비밀번호를 다시 입력해주세요");
			document.input.member_repw.focus();
			return;
		}
		
// 		비밀번호와 비밀번호 재입력 유효성 검사
		if(document.input.member_pw.value != document.input.member_repw.value){
			alert("비밀번호가 다릅니다");
			document.input.member_repw.focus();
			return;
		}
		
// 		연락처 유효성 검사
		if(document.input.member_ph.value == ""){
			alert("연락처를 입력해주세요");
			document.input.member_ph.focus();
			return;
		}

// 		연락처 유효성 검사 체크
		var regph = /^\d{3}-\d{3,4}-\d{4}$/;

		if(!regph.test(document.input.member_ph.value)){
			alert("연락처를 확인해주시기 바랍니다");
			form.document.input.member_ph.focus();
			return;
		}
		
// 		필수 약관 1번 유효성 검사
		if(!document.input.agree1.checked){
			alert("필수 약관에 동의해주시기 바랍니다");
			return;
		}
		
// 		필수 약관 2번 유효성 검사
		if(!document.input.agree2.checked){
			alert("필수 약관에 동의해주시기 바랍니다");
			return;
		}
		
// 		필수 약관 3번 유효성 검사
		if(!document.input.agree3.checked){
			alert("필수 약관에 동의해주시기 바랍니다");
			return;
		}
		
// 		필수 약관 4번 유효성 검사
		if(!document.input.agree4.checked){
			alert("필수 약관에 동의해주시기 바랍니다");
			return;
		}
		
		document.input.member_pw.value = btoa(document.input.member_pw.value);
		
		document.input.submit();
	}

// 		이메일 중복 검사
		function checkEmail(){
			const member_email = document.getElementById("member_email");
			
			if(member_email.value == ""){
				alert("이메일을 입력하세요");
			return;
			}
			
			httpRequest = new XMLHttpRequest();
			
			if(!httpRequest){
				alert("인스턴스 생성 불가!");
				return;
			}
		
			var httpMethod = "GET";
			var httpParam = "member_email=" + encodeURIComponent(member_email.value);
			var httpURL = "${pageContext.request.contextPath}/member/checkEmail?"+httpParam;
			
			httpRequest.open(httpMethod, httpURL, true);
			
			// 콜백메소드 지정
			httpRequest.onreadystatechange = resultCheckEmail;
			httpRequest.send();
		}
		
		// 4. status : response 상태값을 의미하며, 여기서 200은 ok를 의미
		function resultCheckEmail(){
			if(httpRequest.readyState == 4 && httpRequest.status == 200){
				
				var data = httpRequest.responseText;
				const check = document.getElementById("check");
				
				check.innerText = "";
				
				if(data == "사용 가능한 이메일 입니다"){
					check.style.cssText = "color: blue; font-size: 10px;";
					document.getElementById("join").disabled = false;
				}else{
					check.style.cssText = "color: red; font-size: 10px;";
					document.getElementById("join").disabled = true;
				}
				
				check.innerText = data;
			}
		}
		
// 		전체 약관 동의 토글
		$(document).ready(function(){
			 
			$("#allCheck").click(function(){
				if($("#allCheck").prop("checked")){
				    $("#allCheck").prop("checked",true);
				    $("#agree1").prop("checked",true);
				    $("#agree2").prop("checked",true);
				    $("#agree3").prop("checked",true);
				    $("#agree4").prop("checked",true);
				    $("#member_clause").prop("checked",true);
				}else{
				    $("#allCheck").prop("checked",false);
				    $("#agree1").prop("checked",false);
				    $("#agree2").prop("checked",false);
				    $("#agree3").prop("checked",false);
			   		$("#agree4").prop("checked",false);
			   		$("#member_clause").prop("checked",false);
				}
			});
		});

			
</script>
<div align = "center" style="padding-top: 150px">
	<div  align = "center" style ="border:1px solid black; height:1300px; width:400px">
		<form action="${ pageContext.request.contextPath }/member/insert" method="post" name = "input">
		<h2>회원가입</h2>
		<div align = "left" style="margin-left:20px; margin-right:20px; margin-top:20px;">
			<label for="exampleFormControlInput1" class="form-label">이름</label>
		<br>
			<input type = "text" name = "member_name" class="form-control" id="exampleFormControlInput1" placeholder="이름을 입력해주세요">
		</div>
		<div align = "left" style="margin-left: 20px; margin-top:20px">
	  		<input type="radio" name="member_gender" id="male" value="0" checked>
	  		<label for="male">남자</label>
	  		<input type="radio" name="member_gender" id="female" value="1">
	  		<label for="female">여자</label>
		</div>
		<div align = "left" style="margin-left:20px; margin-right:20px; margin-top:20px;">
			<label for="exampleFormControlInput2" class="form-label">생년월일</label>
		<br>
			<input type = "date" name = "member_birthday" class="form-control" id="exampleFormControlInput2">
		</div>
		<div align = "left" style="margin-left:20px; margin-right:20px; margin-top:20px;">
			<label for="member_email" class="form-label">이메일</label>
		<br>
			<div style="margin-right:20px; display:flex; justify-content: space-around">
				<input type = "text" name = "member_email" id="member_email" class="form-control" placeholder="ID@example.com">
				<button type = "button" name = "member_emailB" id="member_emailB" style = "width:40%; margin-left:30px; font-size: 8px;" class="btn btn-success" onclick="checkEmail()">중복확인</button>
			</div>
		</div>
			<div align = "left" style="margin-left:20px;">
			<span id="check"></span>
			</div>
<!-- 				<input type= "button" style = "width:40%; margin-left:30px; font-size: 8px;" id="checkEmail" class="btn btn-success" value="중복 확인"> -->
<!-- 			<!-- id ajax 중복체크 -->
<!-- 				<span class="member_email_ok">사용 가능한 이메일입니다</span> -->
<!-- 				<span class="member_email_already">이미 사용중인 이메일 입니다</span> -->
		<br>
		<div align = "left" style="margin-left:20px; margin-right:20px; margin-top:20px;">
			<label for="exampleFormControlInput4" class="form-label">비밀번호</label>
		<br>
			<input type = "password" name = "member_pw" class="form-control" id="exampleFormControlInput4" placeholder="대문자, 소문자, 숫자, 특수문자를 포함하여  8 ~ 15자">
		</div>
		<br>
		<div align = "left" style="margin-left:20px; margin-right:20px; margin-top:20px;">
			<label for="exampleFormControlInput5" class="form-label">비밀번호확인</label>
		<br>
			<input type = "password" name = "member_repw" class="form-control" id="exampleFormControlInput5" placeholder="비밀번호를 한번 더 입력해주세요.">
		</div>
		<br>
		<div align = "left" style="margin-left:20px; margin-right:20px; margin-top:20px;">
			<label for="exampleFormControlInput6" class="form-label">연락처</label>	
		<br>
			<input type = "text" name = "member_ph" class="form-control" id="exampleFormControlInput6" placeholder="연락처를 입력해주세요.">
			<div align = "left" style="margin-top:20px;">
			<p style="font-size: 5px">연락처는 '-' 를 포함하여 입력해주시기 바랍니다 ex)010-1111-2222</p>
			</div>
		</div>
		<br>
		<div align = "left" style="margin-left: 20px; margin-top:20px">
		  <input type="radio" name="member_role" id="inlineRadio1" value="0">
		  <label for="inlineRadio1">개발자</label>&nbsp;
		  <input type="radio" name="member_role" id="inlineRadio2" value="1">
		  <label for="inlineRadio2">관리자</label>&nbsp;
		  <input type="radio" name="member_role" id="inlineRadio3" value="2">
		  <label for="inlineRadio3">업체</label>&nbsp;
		  <input type="radio" name="member_role" id="inlineRadio4" value="3" checked>
		  <label for="inlineRadio4">사용자</label>
		</div>
	<div>
			<div align = "left" style="margin-left: 20px; margin-top:20px;">
				<input type='checkbox' id="allCheck" name="allCheck" class="checks"> 
				<label for="allCheck">전체 약관 동의</label>
			</div>
			<div align = "left" style="margin-left: 20px; margin-top:20px;">
				<input type = "checkbox" class="checks" id= "agree1" name = "agree1" >
				<label for="agree">만 14세 이상입니다.(필수)</label>
			</div>
			<div align = "left" style="margin-left: 20px; margin-top:20px;">
				<input type = "checkbox" class="checks" id= "agree2" name = "agree2">
				<label for="agree">회원 가입 및 운영약관 동의(필수)</label>
			</div>
			<div align = "left" style="margin-left: 20px; margin-top:20px;">
				<input type = "checkbox" class="checks" id= "agree3" name = "agree3">
				<label for="agree">개인정보 수집 및 이용(필수)</label>
			</div>
			<div align = "left" style="margin-left: 20px; margin-top:20px;">
				<input type = "checkbox" class="checks" id= "agree4" name = "agree4">
				<label for="agree">위치정보 이용약관(필수)</label>
			</div>
			<div align = "left" style="margin-left: 20px; margin-top:20px;">
				<input type = "checkbox" class="checks" id="member_clause" name = "member_clause" value = "1">
				<label for="member_clause">특가 항공권 및 할인 혜택 안내 동의(선택)</label>
			</div>
		</div>
		<div align = "left" style="margin-left: 20px; margin-top:20px;">
		<p style="font-size: 5px">선택 항목을 동의 하지 않아도 서비스를 이용하실 수 있습니다.</p>
		</div>
		<br>				
		<div align = "center">
		
			<button style = "width: 100%" id="join" type = "button" class="btn btn-dark" disabled = "disabled" onclick = "check()">회원가입</button>
		</div>
		</form>
	</div>
</div>
<div style="height: 150px"></div>	
<%@ include file = "/WEB-INF/views/layout/footer.jsp"%>