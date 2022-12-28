<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div class="divTable minimalistBlack">
	<div class="divTableBody">
			<c:forEach var="al" items="${al }">
			<div class="divTableRow">
				<div class="divTableCell">${al.agency_mainimg }</div>
				<div class="divTableCell">${al.agency_name }</div>
				<div class="divTableCell">${al.agency_proimg }</div>
			</div>	
			<div class="divTableRow">
				<div class="divTableCell">${al.agency_content }</div>
			</div>
			</c:forEach>
			<c:forEach var="al2" items="${al }">
				<tr>
					<td>
						<div>
							<button onclick="document.location.href='${path }writeForm'">내용입력</button>
							<c:forEach var="al2" items="${al }">
							<button onclick="document.location.href='${path }updateForm/${al2.agency_no }'">수정</button>
							<button onclick="document.location.href='${path }delete/${al2.agency_no }'">삭제</button>
							</c:forEach>
						</div>
					</td>
				</tr>
			</c:forEach>
	</div>
</div>