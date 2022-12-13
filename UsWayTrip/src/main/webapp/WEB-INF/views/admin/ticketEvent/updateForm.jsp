<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<script type="text/javascript">

	function checkUpdate() {
		
		if(document.update.te_name.value == ""){
			alert("이벤트명을 입력하십시오!");
			document.update.te_name.focus();
			return false;
		}
		
		document.update.submit();
		
	}
	
	function checkDelete(){
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		location.href='${path}delete/${vo.te_no }';
	}
	
</script>

<div align="center">
	<form name="update" action="${ path }update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="te_no" value="${vo.te_no }" />
		<table  class="table caption-top">
			<caption>티켓 이벤트 수정</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>이벤트명</th>
					<td><input type="text" value="${vo.te_name }" name="te_name"/></td>
				</tr>
				<tr>
					<th>이벤트이미지</th>
					<td>
				 	 <c:choose>
						<c:when test="${not empty vo.te_img }">
							<img src="${imgPath}${vo.te_img}" />
							<br>
							 <a href="${imgPath }${vo.te_img}" download>${vo.te_img }</a>
							 <a href="${path }deleteImg?filename=${vo.te_img}&seq=${vo.te_no}" onclick='return confirm("사진을 삭제하시겠습니까?")'><img src="">X</a>
							
						</c:when>
						<c:otherwise>
							<input type="file" name="photo"/>
						</c:otherwise>
				 	 
				 	 </c:choose>
					</td>
				</tr>
				<tr>
					<th>활성여부</th>
					<td>
						<input type="radio" name="te_active" value="0" ${vo.te_active eq 0 ? "checked" : ""}/>활성
						<input type="radio" name="te_active" value="1" ${vo.te_active eq 1 ? "checked" : ""}/>비활성
					</td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="수정" onclick="checkUpdate()">  
						<input type="button" value="삭제" onClick="checkDelete()">
						<input type="button" value="목록" onClick="location.href='${path}listForm'">  
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>