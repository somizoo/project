<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>


<div align = "center" style="padding-top: 150px">
	<div  align = "center" style ="border:1px solid black; height:auto; width:440px">
		<input type="hidden" name = "member_no" value="${vo.member_no}">
			<h2>마이페이지</h2>
			
			<!-- updateForm으로 이동 -->
			<div align = "right" style="margin-right: 30px; margin-top:20px;">
				<button class="btn btn-dark" onclick="document.location.href='${path }updateForm'">편집</button>
			</div>
			
			<!-- 이름 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label for="member_name" class="modal-title text-uppercase font-weight-bold">이름</label>
			<div >${vo.member_name}</div>
			</div>
		
			<!-- 이메일 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label class="modal-title text-uppercase font-weight-bold" for="member_email">이메일</label>
			<br>
				<div>${vo.member_email}</div>
			</div>
		
			<!-- 연락처 -->
			<div align = "left" style="margin-left: 30px; margin-top:20px;">
				<label class="modal-title text-uppercase font-weight-bold" for="member_ph">연락처</label>
			<br>
				<div>${vo.member_ph}</div>
			</div>
			
			<!-- 비밀번호 입력 -->
<!-- 			<div align = "left" style="margin-left: 30px; margin-top:20px;"> -->
<!-- 				<label class="modal-title text-uppercase font-weight-bold" for="member_pw">비밀번호</label> -->
<!-- 			<br> -->
<%-- 				<c:forEach begin="0" end="${countpw }"> --%>
<!-- 					<span>*</span> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
		
			<!-- 수신 동의 -->

			<div align = "left" style="margin-left: 30px; magin-botoom: 30px">
				<label for="member_clause" style="margin-top:20px" class="modal-title text-uppercase font-weight-bold" > 마케팅 수신동의</label>
			<div align = "left">
				<div>이메일: 
					<c:choose>
						<c:when test="${vo.member_clause eq 0}">수신거부</c:when>
						<c:otherwise>수신동의</c:otherwise>
					</c:choose>
				</div>
				</div>
		  		</div>
			</div>
</div>
<div style="height: 150px"></div>	
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>	