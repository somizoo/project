<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center">
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>정보 이름</th>
				<th>값</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:if test= "${empty ti_list}">
				<tr>
					<th align="center" colspan="3">상품이 없습니다</th>
				</tr>
			</c:if>

			<c:forEach var="ti" items="${ti_list}">
			<tr>
				<th>${ti.ti_no}</th>
				<td><a href="${path}updateForm/${ti.ti_no}">${ti.ti_name}</a></td>
				<td>
				<c:forEach var="tid" items="${tid_list}">
				
					<c:if test="${ti.ti_no eq tid.ti_no }">
						${tid.tid_value}
					</c:if>
				
				</c:forEach>
				</td>
				<td>
					<input type="button" value="수정" onClick="location.href='${path}updateForm/${ti.ti_no }'"/>
					<a href='${path}deleteForm/${ti.ti_no}' onclick="return confirm('삭제 하시겠습니까??');">삭제</a>
				</td>
			</tr>
			</c:forEach>
	
		</tbody>
	</table>
	<input type="button" value="추가" onClick="location.href='${path}writeForm'"/>
</div>

<!-- 	경계선 -->
<div style="height:100px"></div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>