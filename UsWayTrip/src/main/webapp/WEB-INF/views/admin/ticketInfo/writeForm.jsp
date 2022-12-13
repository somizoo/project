<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
    
<script type="text/javascript">
	function checkWrite() {
		
		var imgFile = $('#photo').val();
		var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|svg)$/;
		
		if(document.input.ti_name.value == ""){
			alert("제목을 입력하십시오!");
			document.input.it_name.focus();
		}
		
		if($('#photo').val() == "") {
			alert("이미지를 넣어주십시오!");
		    $("#photo").focus();
		}else if(imgFile != "" && imgFile != null) {
		    if(!imgFile.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능!");
		    }
		}
		
		if(document.input.tid_value.value == ""){
			alert("값을 입력해 주십시오!");
			document.input.tid_value.focus();
			return false;
		}
		
		document.input.submit();
	}
	
	$(function(){
			
		$(".add").hide();
		$(".delete").hide();
		$("#select").on("click", function(){
			$(".add").show();
			$(".delete").show();
		})
		
		$("#add").on("click", function(){
			if($("#list").children().last().val() == "" ) {
				$("#list").append("<br>");
			} 
			$("#list").append("<input type='text' class='val' name='tid_value' size='10' value=''>");
		})
		$("#delete").on("click", function(){
			$("#list").children().last().remove();
		})
			
		
	});

</script>


<div align="center"  style="padding-top:180px;">
	<form action="${path}write" method="post" name="input" enctype="multipart/form-data"> 
	
	<h4>정보 추가</h4>
		<table class="table">
			<thead class="table-group-divider">
 		<tr>
			<th>이름</th>
			<td><input type="text" name="ti_name" size="30"></td>
		</tr>
		<tr> 
			<th>이미지</th>
			<td><input type="file" name="photo" id="photo" multiple="multiple"></td>
 		</tr>
		<tr>
			<th>값</th>
			<td><input type="button" value="추가" id="add">
			<input type="button" value="삭제" id="delete"></td>
		</tr>
		<tr>
		<td>
			<c:forEach var="tid" items="${tid_list}">
				<input type="text" class="val" name="tid_value" size="10" value="${tid.tid_value }">
			</c:forEach>
		</td>
		</tr>
		<tr id="list">
			<td></td>
		</tr>	 
		</thead>
		</table>
		<input type="button" value="입력" onclick="checkWrite()">
	
	</form>
</div>

<div style="height:100px"></div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>