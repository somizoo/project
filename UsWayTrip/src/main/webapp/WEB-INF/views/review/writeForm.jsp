<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script>
	$(function(){
		$("input[name=reviewStar]").click(function(){
			$("input[name=review_star]").val($(this).val());
		})
	})
	
	function checkWrite(){
		
		if($("input[name=reviewStar]:radio:checked").length < 1){
			alert("별점을 체크해 주세요!");
			$("input[name=reviewStar]:radio:eq(0)").focus();
			return;
		}else if(document.write.review_content.value == ""){
			alert("내용을 입력해 주세요!");
			document.write.review_content.focus();
			return;
		}
		
		var imgFile = $('#imgs').val();
		var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|svg)$/;
		
		if($('#imgs').val() == "") {
			alert("첨부파일을 넣어주세요!");
		    $("#imgs").focus();
		    return;
		}
		
		if(imgFile != "" && imgFile != null) {
		    
		    if(!imgFile.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능!");
		        return;
		    }
		}

		document.write.submit();
		
	}

</script>
<div align="center">
	<form name="write" id="write" action="${ path }write" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${product_no }" name="product_no" />
		<input type="hidden" value="" name="review_star" />
		<input type="hidden" value="${member_no }" name="member_no"/>
		<input type="hidden" value="${uname }" name="review_uname" />
		<input type="hidden" value="${agency_no }" name="agency_no" />
		
		<table  class="table caption-top">
			<caption>후기 등록</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>별점</th>
					<td>
						<fieldset>
							<span class="text-bold">별점을 선택해주세요</span>
							<input type="radio" name="reviewStar" value="5" id="rate1"><label for="rate1">★</label
							><input type="radio" name="reviewStar" value="4" id="rate2"><label for="rate2">★</label
							><input type="radio" name="reviewStar" value="3" id="rate3"><label for="rate3">★</label
							><input type="radio" name="reviewStar" value="2" id="rate4"><label for="rate4">★</label
							><input type="radio" name="reviewStar" value="1" id="rate5"><label for="rate5">★</label>
						</fieldset>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${ uname }</td>
				</tr>			
				<tr>
					<th>내용</th>
					<td>
						<textarea name="review_content" rows="15" cols="65"></textarea>
					</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type="file" name="imgs" multiple="multiple"/></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="등록" onclick="javascript:checkWrite();">
						<input type="button" value="이전 페이지" onclick="history.back();">  
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>