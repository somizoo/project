<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">



	function check(){
		
		if(document.find.member_name.value == ""){
			alert("이름을 입력하십시오!");
			return false;
		}
		if(document.find.member_ph == ""){
			alert("연락처를 입력하십시오!");
			return false;
		}
		if(document.find.member_email == ""){
			alert("이메일을 입력하십시오!");
			return false;
		}
		
		return true;
	}
	
</script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center">
	<div  align = "center" style ="border:1px solid black; height:auto; width:400px">
	<form action="${ pageContext.request.contextPath }/admin/member/find" onsubmit="return check();" method="post" name="find">
			<c:choose>
				<c:when test="${param.mode == 'email'}">
					<input type="hidden" name="mode" value="member_email">
					<h3>이메일찾기</h3>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="mode" value="member_pw">					
					<h3>패스워드찾기</h3>
				</c:otherwise>
			</c:choose>
			<table>
				<c:if test="${param.mode == 'pw'}">
					<tr>
						<th>email</th>
						<td><input type="text" name="member_email"></td>
					</tr>
				</c:if>
				<tr>
					<th>이름</th>
					<td><input type="text" name="member_name"></td>
				</tr>
				<tr>
					<th>TEL</th>
				<td><input type="text" name="member_ph"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="find">
						<input type="button" value="Reset" onclick="document.find.reset()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>