<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<script type="text/javascript">
	function checkWrite(){
		
		var imgFile = $('#photo').val();
		var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|svg)$/;
		
		if(document.write.te_name.value == ""){
			alert("이벤트명을 입력하십시오!")
			document.write.te_name.focus();
			return false;
		}else if($('#photo').val() == "") {
			alert("이벤트이미지를 넣어주세요!");
		    $("#photo").focus();
		    return false;
		}else if(imgFile != "" && imgFile != null) {
		    if(!imgFile.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능!");
		        return false;
		    }
		}
		if($("input[name=te_active]:radio:checked").length < 1){
			alert("활성여부를 선택해 주세요!")
			$("input[name=te_active]:radio:eq(0)").focus();
			return false;
		}
		
		document.write.submit();
	}
</script>

<div align="center" style="padding-top:180px;">
	<form name="write" action="${ path }write" method="post" enctype="multipart/form-data">
		<table  class="table caption-top">
			<caption>티켓 이벤트 등록</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>이벤트명</th>
					<td><input type="text" value="" name="te_name"/></td>
				</tr>
				<tr>
					<th>이벤트이미지</th>
					<td><input type="file" name="photo" id="photo"/></td>
				</tr>
				<tr>
					<th>활성여부</th>
					<td>
						<input type="radio" name="te_active" value="0" />활성
						<input type="radio" name="te_active" value="1" />비활성
					</td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="등록" onclick="checkWrite()">
						<input type="reset" value="리셋">  
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<!-- 	경계선 -->
	<div style="height:100px"></div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>