<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align = "center" style="margin-top:20px; padding-top: 150px">
	<c:choose>
		<c:when test="${!check}">
			<h3>이메일 혹은 비밀번호를 찾지 못하였습니다.</h3>
			| <a href="${cpath }/comingSoon/comingSoonForm">이메일 찾기</a> | 
			<a href="${cpath }/comingSoon/comingSoonForm">비밀번호 찾기</a> |
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${param.mode=='email'}">
						<h3>Email : ${member_email}</h3> 	
						<a href="${cpath }/comingSoon/comingSoonForm">비밀번호 찾기</a> | 
				</c:when>
				<c:otherwise>
						<h3>비밀번호 : ${member_pw}</h3>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</div>	
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
