<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<script>
	$(function(){
		$("input[name=reviewStar]").click(function(){
			$("input[name=review_star]").val($(this).val());
		})
	})

</script>
<div align="center">
	<form name="write" id="write" action="${ path }write" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${lodging_no }" name="product_no" />
		<input type="hidden" value="" name="review_star" />
		<input type="hidden" value="${no }" name="member_no"/>
		<input type="hidden" value="${uname }" name="review_uname" />
		<input type="hidden" value="1" name="agency_no" />
		
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
					<th>여행사</th>
					<td></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="등록" onclick="document.write.submit();">
						<input type="reset" value="리셋">  
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>