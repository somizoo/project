<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<script type="text/javascript">

function checkWrite() {
	
	
	formData = new FormData();

	if(document.write.tsc_name.value == ""){
		alert("카테고리명을 입력하십시오!");
		return;
	}
	
	document.write.submit();
	
}
</script>

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<div align="center" style="padding-top: 20%">
	<form name="write" action="${ path }write" method="post">
		<table  class="table caption-top">
			<caption>티켓 소분류 등록</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>카테고리명</th>
					<td><input type="text" value="" name="tsc_name"/></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="등록" onclick="javascript:checkWrite();">
						<input type="reset" value="리셋">  
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>



<%@ include file="/WEB-INF/views/layout/footer.jsp" %>