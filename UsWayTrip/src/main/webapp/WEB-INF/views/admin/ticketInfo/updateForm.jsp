<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
    
<script type="text/javascript">
	
	function checkWrite() {
		let check = true;
		if(document.input.ti_name.value == ""){
			alert("제목을 입력하십시오!");
			return false;
		}else if($("input[name='tid_value']").length > 0){
			$("input[name='tid_value']").each(function(){
				if($(this).val() == ""){
					alert("값을 입력하세요");
					check = false;
					return false;
				}
			})
			return check;
		}
	}
	
	$(function(){
		$("#add").on("click", function(){
			/* if($("#list").children().last().val() == "" ) {
				$("#list").append("<br>");
			} */
			$("#list").append("<input type='text' class='val' name='tid_value' size='10' value=''>");
			$("#list").append("<br>");
		})
		$("#delete").on("click", function(){
			$("#list").children().last().remove();
		})
	});

</script>



<div align="center">
	<form action="${path}update/${ti_vo.ti_no}" method="post" name="input" enctype="multipart/form-data" onsubmit="return checkWrite();"> 
	
	<h4>정보 수정</h4>
	<table class="table">
		<thead class="table-group-divider">
		<tr>
			<th>이름</th>
			<td><input type="text" name="ti_name" size="30" value="${ti_vo.ti_name }"></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
			<img src="${imgPath}${ti_vo.ti_img }" width="80"><br>
			<input type="file" name="photo" value="${ti_vo.ti_img  }">
			<input type="hidden" name="ti_img" value="${ti_vo.ti_img  }">
			</td> 
		</tr>
		<tr>
			<th>값</th>
				<td><input type="button" value="추가" id="add">
				<input type="button" value="삭제" id="delete"></td>
		</tr>
		<tr>
		<th></th>
		<td>
		<c:forEach var="tid" items="${tid_list}">
			<input type="text" class="val" name="tid_value" size="10" value="${tid.tid_value }">
			<br>	
		</c:forEach>
		</td>
		</tr>	
		<tr id="list">
			<td></td>
		</tr>
		</thead>
	</table>
	<button>수정</button>
	</form>
</div>

<!-- 	경계선 -->
	<div style="height:100px"></div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>