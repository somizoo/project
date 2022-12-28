<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center">
	<h3>티켓 정보</h3>
	<table  class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>가격</th>
				<th>수량</th>
				<th>설명</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<th align="center" colspan="6">상품이 없습니다</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${list}">
					<tr>
						<th>${vo.to_no}</th>
						<td><a href="${cpath}/admin/ticketOption/updateForm/${vo.to_no }">${vo.to_title}</a></td>
						<td>${vo.to_price }</td>
						<td>${vo.to_su }</td>
						<td>${vo.to_content }</td>
						<td>
							<input type="button" value="수정" onClick="location.href='${cpath}/admin/ticketOption/updateForm/${vo.to_no }'"/>
							<a href='${cpath}/admin/ticketOption/delete/${vo.to_no }' onclick="return confirm('삭제 하시겠습니까??');">삭제</a>
						</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
<%-- 	<input type="button" value="추가" onclick="document.location.href='${cpath}/admin/ticketOption/writeForm/'"> --%>
</div>

<!-- 	경계선 -->
<div style="height:100px"></div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>