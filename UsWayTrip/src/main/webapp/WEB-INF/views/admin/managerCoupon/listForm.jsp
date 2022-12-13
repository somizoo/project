<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<div align="center" style="padding-top: 20%">
	<table  class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>쿠폰명</th>
				<th>쿠폰코드</th>
				<th>유효기간</th>
				<th>활성여부</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="6" align="center"><span style="font-weight: bold;">등록된  쿠폰이 없습니다.</span></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="data" items="${list}">
						<tr>
							<th>${data.mc_no}</th>
							<td><a href="${path}updateForm/${data.mc_no }">${data.mc_name}</a></td>
							<td>${data.mc_code }</td>
							<td>${data.mc_start } ~ ${data.mc_end }</td>
							<td>${active[data.mc_active] }</td>
							<td>
								<input type="button" value="수정" onClick="location.href='${path}updateForm/${data.mc_no }'"/>
								<input type="button" value="삭제" onClick="location.href='${path}delete/${data.mc_no }'" />
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		
		</tbody>
	</table>
	<input type="button" value="등록" onClick="location.href='${path}writeForm'"/>
</div>