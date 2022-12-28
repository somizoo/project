<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div style="margin-top:20px;">
	<c:choose>
		<c:when test="${!check}">
			<h3>이메일 혹은 비밀번호를 찾지 못하였습니다.</h3>
			<a href="/usWayTrip/admin/member/findForm?mode=email">이메일찾기</a> | 
			<a href="/usWayTrip/admin/member/findForm?mode=pw">비밀번호찾기</a> |
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${param.mode=='email'}">
						<h3>Email : ${member_email}</h3> 	
						<a href="/usWayTrip/admin/member/findForm?mode=pw">비밀번호찾기</a> | 
				</c:when>
				<c:otherwise>
						<h3>비밀번호 : ${member_pw}</h3>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</div>
<div>
	<a href="${pageContext.request.contextPath}/admin/member/loginform">로그인</a>
</div>
