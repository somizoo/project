<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center">
	<table  class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>이벤트명</th>
				<th>활성여부</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach var="data" items="${list}">
			<tr>
				<th>${data.te_no}</th>
				<td><a href="${path}updateForm/${data.te_no }">${data.te_name}</a></td>
				<td>
					${active[data.te_active]}
				</td>
				<td>
					<input type="button" value="수정" onClick="location.href='${path}updateForm/${data.te_no }'"/>
					<a href='${path}delete/${data.te_no }' onclick="return confirm('삭제 하시겠습니까??');">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="등록" onClick="location.href='${path}writeForm'"/>
</div>

<!-- 	경계선 -->
	<div style="height:100px"></div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>