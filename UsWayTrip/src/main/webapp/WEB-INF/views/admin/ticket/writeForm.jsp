<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
    
<script type="text/javascript">

	function checkWrite() {

		if(document.input.ticket_title.value == ""){
			alert("제목을 입력하십시오!");
			document.input.ticket_title.focus();
			return false;
		}else if(document.input.tsc_no.value == ""){
			alert("카테고리를 입력하십시오!");
			document.input.tsc_no.focus();
			return false;
		}else if(document.input.place_no.value == ""){
			alert("지역을 입력하십시오!");
			document.input.place_no.focus();
			return false;
		}else if(document.input.ticket_priceSticker.value == ""){
			alert("스티커를 입력하십시오!");
			$("input[name=ticket_priceSticker]:radio:eq(0)").focus();
			return false;
		}else if(document.input.to_type.value == ""){
			alert("티켓 종류를 선택하십시오!");
			$("input[name=to_type]:radio:eq(0)").focus();
			return false;
		}else if($("input[name=te_event]:checkbox:checked").length < 1){
			alert("이벤트를 체크해 주세요!")
			$("input[name=te_event]:checkbox:eq(0)").focus();
			return false;
		}else if(document.input.te_event.length == 0){
			alert("이벤트를 입력하십시오!");
			document.input.te_event.focus();
			return false;
		}
		
		var imgFile1 = $('#listPhoto').val();
		var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|svg)$/;
		var imgFile2 = $('#photo').val();
		
		if($('#listPhoto').val() == "") {
			alert("상세 내용을 입력하십시오!");
		    $("#listPhoto").focus();
		    return false;
		}else if(imgFile1 != "" && imgFile1 != null) {
		    if(!imgFile1.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능!");
		        return false;
		    }
		}
		
		if(document.input.ticket_user.value == ""){
			alert("이용 안내를 입력하십시오!");
			document.input.ticket_user.focus();
			return false;
		}else if(document.input.ticket_refund.value == ""){
			alert("취소 및 환불을 입력하십시오!");
			document.input.ticket_refund.focus()
			return false;;
		}else if(document.input.photo.value == ""){
			alert("메인 이미지를 입력하십시오!");
			document.input.photo.focus();
			return false;
		}else if($('#photo').val() == "") {
			alert("상세 내용을 입력하십시오!");
		    $("#photo").focus();
		    return false;
		}else if(imgFile2 != "" && imgFile2 != null) {
		    if(!imgFile2.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능!");
		        return false;
		    }
		}
		
		document.input.submit();
	}

	$(document).ready(function() {
		$('#date').hide();
		$('#show').on("click", function(){
			$('#date').show();
		});
		$('#hide').on("click", function(){
			$('#date').hide();
		});
	});
   

    
</script>


<div align="center" style="padding-top:180px;">
	<form action="${ cpath }/admin/ticket/write" method="post" name = "input" enctype="multipart/form-data"> 
	
	<h4>상품 추가</h4>
	<table class="table">
		<thead class="table-group-divider">
		<tr>
			<th>제목</th>
			<td><input type="text" name="ticket_title" size="70"></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td align="left">
			<select name="tsc_no">
  				<option value="" selected disabled hidden>선택안함</option>
				<c:forEach var="tsc_vo" items="${tsc_list }">
					<option value="${tsc_vo.tsc_no }">${tsc_vo.tsc_name }</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<th>지역</th>
			<td align="left">
			<select name="place_no">
  				<option value="" selected disabled hidden>선택안함</option>
				<c:forEach var="place_vo" items="${place_list }">
					<option value="${place_vo.place_no }">${place_vo.place_name }</option>
				</c:forEach>
			</select>
		</td>
		</tr>
		<tr>
			<th>유효기간</th>
			<td align="left"><input type="button" id="show" name="ticket_valid" value="유효기간">
			<input type="date" id="date" name="date">
			<input type="button" name="ticket_valid" id="hide" value="유효기간 x"></td>
		</tr>
		<tr>
			<th>즉시확정</th>
			<td align="left"><input type="checkbox" name="ticket_confirmation" value="즉시확정">즉시확정</td>
		</tr>
		<tr>
			<th>가격 스티커</th>
			<td align="left">
			<input type="radio" name="ticket_priceSticker" value="최저가 보장제">최저가 보장제
			<input type="radio" name="ticket_priceSticker" value="무료 취소">무료 취소
			<input type="radio" name="ticket_priceSticker" value="">없음
			</td>
		</tr>
		<tr>
			<th>티켓 종류 선택</th>
			<td align="left">
				<input type="radio" name="to_type" value="0">티켓
				<input type="radio" name="to_type" value="1">달력 + 티켓
				<input type="radio" name="to_type" value="2">달력 + 인원
				<input type="radio" name="to_type" value="3">달력 + 옵션
			</td>
		</tr>
		<tr>
			<th>이벤트</th>
			<td align="left">
				<c:forEach var="vo" items="${teList }">
					<input type="checkbox" value="${vo.te_no }" name="te_event">${vo.te_name }
				</c:forEach>
				<br>
			</td>
		</tr>
		<%-- <tr>
			<th>상품 정보</th>
			<td align="left">				
				<c:forEach var="ti" items="${ti_list }" varStatus="status">
					${ti.ti_name }
					<select name="${status.index}">
					 	<option value="-1" selected disabled hidden>선택안함</option>
						 	<c:forEach var="tid" items="${tid_list }">
							 	<c:if test="${ti.ti_no eq tid.ti_no}">
							 		<option value="${tid.tid_no }">${tid.tid_value }</option>
								</c:if>
							</c:forEach>
					</select>
					<br>
				</c:forEach>                                                
				<br>
			</td>
		</tr> --%>
		<tr>
			<th>상품 정보</th>
			<td align="left">	
			<c:forEach var="ti" items="${ti_list }" varStatus="status">
				${ti.ti_name }
				<select name="${status.index}">
				 	<option value="" selected disabled hidden>선택안함</option>
					<c:forEach var="kv" items="${map }">
						<c:if test="${ti.ti_no eq kv.key}">
							<c:forEach var="tid" items="${kv.value }">
								<option value="${tid.tid_no }">${tid.tid_value }</option>
							</c:forEach>
						</c:if>	
					</c:forEach> 	
				</select>	
				<br>
			</c:forEach>			
			</td>
		</tr>
		<tr>
		<!-- <th>회원 번호</th> -->
			<td><input type="hidden" name="member_no" value="1"></td>
		</tr>
		<tr>
		<!-- <th>구매 횟수</th> -->
			<td><input type="hidden" name="ticket_sold_cnt" value="1"></td>
		</tr>
		<tr>

		<tr>
		<th>유의 사항</th>
			<td><textarea rows="10" cols="70" name="ticket_precautions"></textarea></td>
		</tr>
		<tr>
 		<th>상세 내용</th>
			<td><div><input type="file" name="listPhoto" size = "400" multiple="multiple"></div></td>
		</tr> 
		<tr>
		<th>코스 소개</th>
			<td><textarea rows="10" cols="70" name="ticket_route"></textarea></td>
		</tr>
		<tr>
		<th>이용 안내</th>
			<td><textarea rows="10" cols="70" name="ticket_user"></textarea></td>
		</tr>
		<tr>
		<th>취소 및 환불 규정 내용</th>
			<td><textarea rows="10" cols="70" name="ticket_refund"></textarea></td>
		</tr>

		<tr>
		<th>메인 이미지</th>
			<td colspan="2">
				<input type="file" name="photo" size = "400" multiple="multiple">
			</td>
		</tr>
		</thead>
		</table>
		<input type="button" value="입력" onclick="checkWrite()">
	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

