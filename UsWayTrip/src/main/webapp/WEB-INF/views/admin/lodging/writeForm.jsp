<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

function check() {

//		이름 유효성 검사
	if(document.lodging.lodging_name.value == ""){
		alert("숙소 이름을 입력해 주세요");
		document.lodging.lodging_name.focus();
		return;
	} 		
		
//		주소 유효성 검사
	if(document.lodging.lodging_address.value == ""){
		alert("숙소 주소을 입력해 주세요");
		document.lodging.lodging_address.focus();
		return;
	} 		
		
		
//		위도 유효성 검사
	if(document.lodging.lodging_lat.value == ""){
		alert("위도를 입력해 주세요");
		document.lodging.lodging_lat.focus();
		return;
	} 	
	
		
//		위도 숫자 유효성 검사
	var wnpattern = /[0-9]/;
	if(!wnpattern.test(document.lodging.lodging_lat.value)){
		alert("위도는 숫자만 입력 가능합니다");
		document.lodging.lodging_lat.focus();
		return;
	}
		
//		위도 유효성 검사 체크
		var wpattern = /^-?([0-8]?[0-9]|90)(\.[0-9]{1,10})$/;

		if(!wpattern.test(document.lodging.lodging_lat.value)){
			alert("위도를 확인해주시기 바랍니다");
			form.document.lodging.lodging_lat.focus();
			return;
		}
		
//		경도 유효성 검사
	if(document.lodging.lodging_long.value == ""){
		alert("경도를 입력해 주세요");
		document.lodging.lodging_long.focus();
		return;
	}
	
//		경도 숫자 유효성 검사
	var gnpattern = /[0-9]/;

	if(!gnpattern.test(document.lodging.lodging_long.value)){
		alert("경도는 숫자만 입력 가능합니다");
		document.lodging.lodging_long.focus();
		return;
	}

//		경도 유효성 검사 체크
	var gpattern = /^-?([0-9]{1,2}|1[0-7][0-9]|180)(\.[0-9]{1,10})$/;

	if(!gpattern.test(document.lodging.lodging_long.value)){
		alert("경도를 확인해주시기 바랍니다");
		form.document.lodging.lodging_long.focus();
		return;
	}
	
	if(document.lodging.lodging_grade.value == ""){
		alert("성급을 입력해 주세요");
		document.lodging.lodging_grade.focus();
		return;
	} 
		
//		체크인 유효성 검사
	if(document.lodging.lodging_checkin.value == ""){
		alert("체크인 시간을 입력해 주세요");
		document.lodging.lodging_checkin.focus();
		return;
	}
	
//		체크인 유효성 검사 체크
	var chipattern = /^([1-9]|[01][0-9]|2[0-3]):([0-5][0-9])$/;

	if(!chipattern.test(document.lodging.lodging_checkin.value)){
		alert("체크인 시간을 확인해주시기 바랍니다");
		document.lodging.lodging_checkin.focus();
		return;
	}
		
//		체크아웃 유효성 검사
	if(document.lodging.lodging_checkout.value == ""){
		alert("체크아웃 시간을 입력해 주세요");
		document.lodging.lodging_checkout.focus();
		return;
	}

//		체크아웃 유효성 검사 체크
	var chopattern = /^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$/;

	if(!chopattern.test(document.lodging.lodging_checkout.value)){
		alert("체크아웃 시간을 확인해주시기 바랍니다");
		form.document.lodging.lodging_checkout.focus();
		return;
	}
		
//		숙소소개 유효성 검사
	if(document.lodging.lodging_content.value == ""){
		alert("숙소 소개를 입력해 주세요");
		document.lodging.lodging_content.focus();
		return;
	}
	
//		편의시설 유효성 검사
	if($("input:checkbox[name='facilities_no']").is(":checked")==false){
		alert("편의시설을 선택해주세요");
		$("input:checkbox[name='facilities_no']:eq(0)").focus();
		return;
	}
	
//		서비스 유효성 검사
	if($("input:checkbox[name='service_no']").is(":checked")==false){
		alert("서비스를 선택해주세요");
		$("input:checkbox[name='service_no']:eq(0)").focus();
		return;
	}
	
//		이용안내 유효성 검사
	if(document.lodging.lodging_info.value == ""){
		alert("이용 안내를 입력해 주세요");
		document.lodging.lodging_info.focus();
		return;
	}

//		취소 및 환불규정 유효성 검사
	if(document.lodging.lodging_refund.value == ""){
		alert("취소 및 환불규정을 입력해 주세요");
		document.lodging.lodging_refund.focus();
		return;
	}
	
//		조식 유효성 검사
	if(document.lodging.lodging_bprice.value == ""){
		alert("조식 가격을 입력해 주세요");
		document.lodging.lodging_bprice.focus();
		return;
	}
	
//		조식 숫자 유효성 검사
	var bppattern = /^[0-9]+$/; 

	if(!bppattern.test(document.lodging.lodging_bprice.value)){
		alert("조식 가격은 숫자만 입력 가능합니다");
		document.lodging.lodging_bprice.focus();
		return;
	}
	
//		숙소 이미지 유효성 검사
	if(document.lodging.imgs.value == ""){
		alert("숙소 이미지를 하나이상 선택하여 주세요");
		document.lodging.imgs.focus();
		return;
	}
	
//		대표 이미지 유효성 검사
	if(document.lodging.mainImg.value == ""){
		alert("대표 이미지를 하나이상 선택하여 주세요");
		document.lodging.mainImg.focus();
		return;
		
	}
	
		document.lodging.submit();
	}
</script>

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
	<!-- 주소 api -->
<!-- <input type="text" name="" class="postcodify_postcode5" value="" /> -->
<!-- <button id="postcodify_search_button">검색</button><br /> -->
<!-- <input type="text" name="" class="postcodify_address" value="" /><br /> -->
<!-- <input type="text" name="" class="postcodify_details" value="" /><br /> -->
<!-- <input type="text" name="" class="postcodify_extra_info" value="" /><br /> -->
	
	
	<h3>숙소 등록</h3>
	<div align="center" style="padding-top:180px;">
		<form action="${cpath }/admin/lodging/insertLodging" name="lodging" method="post" enctype="multipart/form-data">
			<table class="boardTable">
				<tr>
					<th>숙소 이름</th>
					<td><input  type="text" name="lodging_name" ></td>
				</tr>
				<tr>
					<th>숙소 종류</th>
					<td>
						<select name="lt_no">
							<c:forEach var="type" items="${lodTypeList }" >
								<option value="${type.lt_no }" >${type.lt_name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>숙소지역</th>
					<td>
						<select name="place_no">
							<c:forEach var="place" items="${placeList }" >
									<option value="${place.place_no }" >${place.place_name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>숙소 주소</th>
					<td><input type="text" class="postcodify_address"  name="lodging_address" placeholder="구 부터 적어주세요" id="postcodify_search_button"/></td>
				</tr>
				
				<tr>
					<th>위도</th>
					<td><input type="number" name="lodging_lat" step="0.0000000000000000000001" /></td>
				</tr>
				<tr>
					<th>경도</th>
					<td><input type="number" name="lodging_long" step="0.0000000000000000000001" /></td>
				</tr>
				
				<tr>
					<th>등급</th>
					<td><input type="text" name="lodging_grade" placeholder="성급을 적어주세요."/></td>
				</tr>
				
				<tr>
					<th>체크인</th>
					<td><input type="text" name="lodging_checkin"/></td>
				</tr>
				<tr>
					<th>체크아웃</th>
					<td><input type="text" name="lodging_checkout" /></td>
				</tr>
				
				<tr>
					<th>최저가 보장 여부</th>
					<td>
						<input type="radio" value="y" name="lodging_minp"/>예
						<input type="radio" value="n" name="lodging_minp" checked/>아니오
					</td>
				</tr>
				
				<tr>
					<th>숙소 소개</th>
					<td><textarea placeholder="내용을 입력하세요."  name = "lodging_content" style="width: 450px; height: 450px"></textarea></td>
				</tr>
				
				<tr>
					<th>편의시설</th>
						<td>
							<c:forEach var="facilities" items="${facilitieList }" >
								<input type="checkbox" value="${facilities.facilities_no}" name="facilities_no"/>${facilities.facilities_name}
							</c:forEach>
						</td>
				</tr>
				
				<tr>
					<th>서비스</th>
						<td>
							<c:forEach var="service" items="${serviceList }" >
								<input type="checkbox" value="${service.service_no}" name="service_no"/>${service.service_name}
							</c:forEach>
						</td>
				</tr>
				
				<tr>
					<th>이용안내</th>
					<td><textarea placeholder="내용을 입력하세요."  name = "lodging_info" style="width: 450px; height: 450px"></textarea></td>
				</tr>
				<tr>
					<th>취소 및 환불 규정</th>
					<td><textarea placeholder="내용을 입력하세요."  name = "lodging_refund" style="width: 450px; height: 450px"></textarea></td>
				</tr>
				<tr>
					<th>조식 가격</th>
					<td><input type="text" name="lodging_bprice" placeholder="가격을 입력해주세요"/>원</td>
				</tr>
				<tr>
					<th>활성화 여부</th>
					<td>
						<input type="radio" value="y" name="lodging_active"/>예
						<input type="radio" value="n" name="lodging_active" checked/>아니오
					</td>
				</tr>
				<tr>
					<th>숙소 이미지 등록</th>
					<td><input type='file'  name="imgs" multiple="multiple"></td>
				</tr>
				<tr>
					<th>대표이미지 선택</th>
					<td><input type="file" name = "mainImg" size = "400"/></td>
				</tr>
			</table>
		<button type="button" onclick="check()">등록</button>
		<button type ="button" onclick="location.href='${lodPath}listForm'">숙소 목록</button>
		</form>
	</div>
	<hr>
	
<!-- 	경계선 -->
	<div style="height:100px"></div>

	
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>