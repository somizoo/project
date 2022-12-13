<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<div align="center">
	<table  class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>별점</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4" align="center"><span style="font-weight: bold;">등록된 후기가 없습니다.</span></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="data" items="${list}">
						<tr>
							<th>${data.review_no}</th>
							<td><a href="${path}updateForm/${data.review_no }">${data.review_content}</a></td>
							<td>${data.review_uname }</td>
							<td>
								<input type="button" value="수정" onClick="location.href='${path}updateForm/${data.review_no }'"/>
								<input type="button" value="삭제" onClick="location.href='${path}delete/${data.review_no }'" />
							</td>
						</tr>
				
					</c:forEach>
				</c:otherwise>
			</c:choose>
		
		</tbody>
	</table>
	<input type="button" value="등록" onClick="location.href='${path}writeForm'"/>