<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
	<c:choose >
			<c:when test="${empty groList }">
				
				<span style="font-weight: bold;">등록된 객실옵션이 없습니다.</span>
				
			</c:when>
			<c:otherwise>
				<c:forEach var="gro" items="${groList}">
					<div>
						객실번호 : ${gro.gro_no}
						객실 옵션명 : <a href="${path}contentForm/${gro.gro_no }">${ gro.gro_name}</a>
						${gro. gro_bf == 'y'? "조식포함": ""}
						객실 가격 : ${gro. gro_price} 
						<button type="button" onclick="location.href='${path}contentForm/${gro.gro_no }'" >수정</button>
						<button type="button" onclick="location.href='${path}delete/${gro.gro_no }'">삭제</button>
					</div>
					<hr>
				</c:forEach>
			</c:otherwise>
	</c:choose>
	<button type="button" onclick="location.href='${path}writeForm'">객실 옵션 등록하기</button>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	