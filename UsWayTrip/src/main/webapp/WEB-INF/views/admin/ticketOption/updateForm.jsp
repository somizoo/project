<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function checkWrite() {
		var ck = /^[0-9]+$/;
		
		if(document.input.to_title.value == ""){
			alert("제목을 입력하십시오!");
			document.input.to_title.focus();
		}else if(document.input.to_price.value == ""){
			alert("가격을 입력하십시오!");
			document.input.to_price.focus();
		}else if(!ck.test(document.input.to_price.value)){
			alert("숫자만 입력 가능합니다.");
			document.input.to_price.focus();
		}else if(document.input.to_su.value == ""){
			alert("수량을 입력하십시오!");
			document.input.to_su.focus();
		}else if(!ck.test(document.input.to_su.value)){
			alert("숫자만 입력 가능합니다.");
			document.input.to_su.focus();
		}else if(document.input.to_content.value == ""){
			alert("설명을 입력하십시오!")
			document.input.to_content.focus();
		}else{
			document.input.submit();
		}
	}
</script>

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<div align="center">
	<form action="${ cpath }/admin/ticketOption/update/${vo.to_no}" method="post" name = "input"> 
	
	<h4>티켓 수정</h4>
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="to_title" size="70" value="${vo.to_title }"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="NUMBER" name="to_price" size="30" value="${vo.to_price }"></td>
		</tr>
		<tr>
			<th>수량</th>
			<td><input type="NUMBER" name="to_su" size="10" value="${vo.to_su }"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><input type="text" name="to_content" size="70" value="${vo.to_content }"></td>
		</tr>
		
		</table>
		<input type="button" value="수정" onclick="checkWrite()">
	</form>
</div>

<!-- 	경계선 -->
	<div style="height:100px"></div>	
 <%@ include file="/WEB-INF/views/layout/footer.jsp" %>