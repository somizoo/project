<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<script type="text/javascript">

function checkWrite() {
	
	
	formData = new FormData();

	if(document.update.tsc_name.value == ""){
		alert("카테고리명을 입력하십시오!");
		return;
	}
	
	document.update.submit();
	
}
</script>

<div align="center">
	<form name="update" action="${ path }update" method="post">
		<input type="hidden" name="tsc_no" value= "${vo.tsc_no }"/>		
		<table  class="table caption-top">
			<caption>티켓 소분류 수정</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>카테고리명</th>
					<td><input type="text" value="${vo.tsc_name }" name="tsc_name"/></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="수정" onclick="javascript:checkWrite();">
						<input type="button" value="목록" onClick="location.href='${path}listForm'">
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<!-- 	경계선 -->
	<div style="height:100px"></div>
	
 <%@ include file="/WEB-INF/views/layout/footer.jsp" %>