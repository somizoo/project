<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
		function check() {
//			이름 유효성 검사
			if(document.content.lodging_name.value == ""){
				alert("숙소 이름을 입력해 주세요");
				document.content.lodging_name.focus();
				return;
			}
			
//			위도 유효성 검사
			if(document.content.lodging_lat.value == ""){
				alert("위도를 입력해 주세요");
				document.content.lodging_lat.focus();
				return;
			} 		
				
//				위도 숫자 유효성 검사
			var wnpattern = /[0-9]/;
			if(!wnpattern.test(document.content.lodging_lat.value)){
				alert("위도는 숫자만 입력 가능합니다");
				document.content.lodging_lat.focus();
				return;
			}
				
//				위도 유효성 검사 체크
				var wpattern = /^-?([0-8]?[0-9]|90)(\.[0-9]{1,10})$/;

				if(!wpattern.test(document.content.lodging_lat.value)){
					alert("위도를 확인해주시기 바랍니다");
					form.document.content.lodging_lat.focus();
					return;
				}
				
				
//				경도 유효성 검사
			if(document.content.lodging_long.value == ""){
				alert("경도를 입력해 주세요");
				document.content.lodging_long.focus();
				return;
			}
			
//				경도 숫자 유효성 검사
			var gnpattern = /[0-9]/;

			if(!gnpattern.test(document.content.lodging_long.value)){
				alert("경도는 숫자만 입력 가능합니다");
				document.content.lodging_long.focus();
				return;
			}

//				경도 유효성 검사 체크
			var gpattern = /^-?([0-9]{1,2}|1[0-7][0-9]|180)(\.[0-9]{1,10})$/;

			if(!gpattern.test(document.content.lodging_long.value)){
				alert("경도를 확인해주시기 바랍니다");
				form.document.content.lodging_long.focus();
				return;
			}
				
//				주소 유효성 검사
			if(document.content.lodging_address.value == ""){
				alert("숙소 주소을 입력해 주세요");
				document.content.lodging_address.focus();
				return;
			}
			
			if(document.content.lodging_grade.value == ""){
				alert("성급을 입력해 주세요");
				document.lodging.lodging_grade.focus();
				return;
			} 	
//				체크인 유효성 검사
			if(document.content.lodging_checkin.value == ""){
				alert("체크인 시간을 입력해 주세요");
				document.content.lodging_checkin.focus();
				return;
			}
			
//				체크인 유효성 검사 체크
			var chipattern = /^([1-9]|[01][0-9]|2[0-3]):([0-5][0-9])$/;

			if(!chipattern.test(document.content.lodging_checkin.value)){
				alert("체크인 시간을 확인해주시기 바랍니다");
				document.content.lodging_checkin.focus();
				return;
			}
				
//				체크아웃 유효성 검사
			if(document.content.lodging_checkout.value == ""){
				alert("체크아웃 시간을 입력해 주세요");
				document.content.lodging_checkout.focus();
				return;
			}

//				체크아웃 유효성 검사 체크
			var chopattern = /^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$/;

			if(!chopattern.test(document.content.lodging_checkout.value)){
				alert("체크아웃 시간을 확인해주시기 바랍니다");
				form.document.content.lodging_checkout.focus();
				return;
			}
			
//				숙소소개 유효성 검사
			if(document.content.lodging_content.value == ""){
				alert("숙소 소개를 입력해 주세요");
				document.content.lodging_content.focus();
				return;
			}
			
//				편의시설 유효성 검사
			if($("input:checkbox[name='facilities_no']").is(":checked")==false){
				alert("편의시설을 선택해주세요");
				$("input:checkbox[name='facilities_no']:eq(0)").focus();
				return;
			}
			
//				서비스 유효성 검사
			if($("input:checkbox[name='service_no']").is(":checked")==false){
				alert("서비스를 선택해주세요");
				$("input:checkbox[name='service_no']:eq(0)").focus();
				return;
			}
			
//				이용안내 유효성 검사
			if(document.content.lodging_info.value == ""){
				alert("이용 안내를 입력해 주세요");
				document.content.lodging_info.focus();
				return;
			}

//				취소 및 환불규정 유효성 검사
			if(document.content.lodging_refund.value == ""){
				alert("취소 및 환불규정을 입력해 주세요");
				document.content.lodging_refund.focus();
				return;
			}
			
//				조식 유효성 검사
			if(document.content.lodging_bprice.value == ""){
				alert("조식 가격을 입력해 주세요");
				document.content.lodging_bprice.focus();
				return;
			}

//				조식 숫자 유효성 검사
			//      조식 숫자 유효성 검사
  		 var bppattern = /^[0-9]+$/;

			if(!bppattern.test(document.content.lodging_bprice.value)){
				alert("조식 가격은 숫자만 입력 가능합니다");
				document.content.lodging_bprice.focus();
				return;
			}
			
			document.content.submit();
		
		}
		
		function deleteAction() {
			var check = confirm("삭제 하시겠습니까?");
			
			if(!check){
				return;
			}
//	 		여기 부분 수정 필요
			location.href = "${loAPath}delete/${lodPlaceOne.lodging_no}";
		}
</script>


<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div align="center" style="padding-top:180px;">
	<form action="${loAPath}update" name="content" method="post" enctype="multipart/form-data">
		<input type="hidden" name="lodging_no" value="${lodPlaceOne.lodging_no }"/>
		<h4>상품번호 | ${lodPlaceOne.lodging_no }</h4>
		<h4>
			<input type="text" value="${lodPlaceOne.lodging_name } " name="lodging_name"/> 
				<c:if test="${review != null}">
				${review.star}(${review.count})<br>
				</c:if>
		</h4>
		<select name="lt_no">
			<c:forEach var="lodtype" items="${lodTypeList }" >
					<option value="${lodtype.lt_no }" <c:if test="${lodtype.lt_no  == lodPlaceOne.lt_no }">selected</c:if>>${lodtype.lt_name}</option>
			</c:forEach>
		</select>
		<input type="text" value="${lodPlaceOne.lodging_grade }" name="lodging_grade" />
		위도<input type="number" name="lodging_lat" step="0.0000000000000000000001" value="${lodPlaceOne.lodging_lat }"/>
		경도<input type="number" name="lodging_long" step="0.0000000000000000000001" value="${lodPlaceOne.lodging_long }"/>
		<hr>
		숙소 주소
		<select name="place_no">
			<c:forEach var="place" items="${placeList }" >
					<option value="${place.place_no }" <c:if test="${place.place_name == lodPlaceOne.place_name }">selected</c:if>>${place.place_name}</option>
			</c:forEach>
		</select>
		<input type="text" value="${lodPlaceOne.lodging_address}" name="lodging_address" class="postcodify_address" id="postcodify_search_button"/> 
		<hr>
		<div>
			숙소 대표 이미지
			<div>
				<img src="${imgLoPath}${lodPlaceOne.lodging_mainimg}" width="100px" height="100px"/>
				${lodPlaceOne.lodging_mainimg }
			</div>
			숙소 이미지
			<c:forEach var="img" items="${imgs}" >
				<div>
				<img src="${imgLosPath} ${img.img_name}" width="100px" height="100px">
				${img.img_name} 
				<a href="${loAPath}imgDelete/${img.img_name}/${lodPlaceOne.lodging_no}">삭제</a>
				</div>
			</c:forEach>
			
		</div>
		숙소 대표이미지 수정
		<input type="file" name = "mainImg" size = "400"/>
		숙소 이미지 추가
		<input type='file'  name="imgs" multiple="multiple">
		<hr>
		최저가 보장 여부 
			<input type="radio" value="y" name="lodging_minp" <c:if test="${lodPlaceOne.lodging_minp eq 'y'}" >checked</c:if>/>예
			<input type="radio" value="n" name="lodging_minp" <c:if test="${lodPlaceOne.lodging_minp eq 'n'}" >checked</c:if>/>아니오
		<hr>
		<button type="button" onclick="location.href='${grPath}write/${lodPlaceOne.lodging_no}'">객실 등록</button>
		<c:choose >
			<c:when test="${empty lodgrList }">
				<p style="font-weight: bold;">등록된 객실이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<button type="button" onclick="location.href='${grPath}listForm/${lodPlaceOne.lodging_no}'">객실 목록</button>
				<c:forEach var="gr" items="${lodgrList}">
				<div>
					<img src="${imgGrPath}${gr.gr_mainimg}" width="100px" height="100px"/>
					
					<c:forEach var="img" items="${grImgMap}">
						<c:if test="${img.key == gr.gr_no}">
							<c:forEach var="i" items="${img.value }">
								<img src="${imgGrsPath}${i.gri_name}" width="100px" height="100px"/>
							</c:forEach>
						</c:if>
					</c:forEach>
					<h6>${gr.gr_no} |<a href="${grPath}content/${gr.gr_no}"> ${gr.gr_name}</a></h6>
					<p>기준인원 ${gr.gr_ap} / 최대인원${gr.gr_mp }</p>
					<c:forEach var="bed" items="${grBedMap}">침대
						<c:if test="${bed.key == gr.gr_no }">
							<c:forEach var="b" items="${bed.value }">
								${b.bed_type} ${b.grb_cnt}
							</c:forEach>
						</c:if>
					</c:forEach>
					<c:forEach var="am" items="${gramMap }">편의시설
						<c:if test="${am.key == gr.gr_no}">
							<c:forEach var="a" items="${am.value}">
								${a.amenities_name} 
							</c:forEach>
						</c:if>
					</c:forEach>
					${gr.ot_type}뷰
				</div>
				<hr>
				<c:set var="idx" value="0"/>
				<c:forEach var="gro" items="${groMap}">객실 옵션
				
					<c:if test="${gro.key == gr.gr_no}">
						<c:set var="idx" value="${idx+1}"/>
							<c:forEach var="o" items="${gro.value }">
								<div>
								${o.gro_name }
								<c:choose>
									<c:when test="${o.sale != 0}">
										${o.coupon_figure} → ${o.gro_price}<br>
										${o.sale}<br>
										${o.coupon_figure}쿠폰 적용가
									</c:when>
									<c:otherwise >
										${o.gro_price}원
									</c:otherwise>
								</c:choose>
									${o. gro_bf == 'y'? "조식포함": ""}
							
								</div>
							</c:forEach>
					</c:if>
				</c:forEach>
				<c:if test="${idx == 0 }">
					<p style="font-weight: bold;">등록된 객실옵션이 없습니다.</p>
				</c:if>
				
				<hr>
					
				</c:forEach>
			</c:otherwise>
		</c:choose>
		숙소 소개
		<textarea name = "lodging_content" style="width: 450px; height: 450px">${lodPlaceOne.lodging_content}</textarea>
		<hr>
		체크인/체크아웃
		체크인- <input type="text" name="lodging_checkin" value="${lodPlaceOne.lodging_checkin}"/>/
		체크아웃- <input type="text" name="lodging_checkout" value="${lodPlaceOne.lodging_checkout}"/>
		<hr>
		
		<h4>편의시설</h4>
		
		<c:forEach var="fac" items="${facilitieList}">
			<c:set var="loop" value="false"/>
			<input type="checkbox" value="${fac.facilities_no}" name="facilities_no" 
				<c:forEach var="checkFac" items="${lodFacs}">
					<c:if test="${loop eq false }">
						${fac.facilities_no eq checkFac.facilities_no ? "checked" : ""}
						<c:set var="loop" value="${fac.facilities_no eq checkFac.facilities_no ? true : false }"/>
					</c:if>
				</c:forEach>
			> ${fac.facilities_name}
		</c:forEach>
		<hr>
		<h4>서비스</h4>
		<c:forEach var="service" items="${serviceList}"> 
			<c:set var="loop" value="false"/>
			<input type="checkbox" value="${service.service_no}" name="service_no" 
				<c:forEach var="checkSer" items="${lodServices}">
					<c:if test="${loop eq false }">
						${service.service_no eq checkSer.service_no ? "checked" : ""}
						<c:set var="loop" value="${service.service_no eq checkSer.service_no ? true : false }"/>
					</c:if>
				</c:forEach>
			> ${service.service_name}
		</c:forEach>
 		<hr>
		<h4>이용안내</h4>
		<textarea name = "lodging_info" style="width: 450px; height: 450px">${lodPlaceOne.lodging_info}</textarea>
		<hr>
		<h4>취소 및 환불규정</h4>
		<textarea name = "lodging_refund" style="width: 450px; height: 450px">${lodPlaceOne.lodging_refund}</textarea>
		<hr>
		<div style="display: flex; justify-content: center;">
			<h4>후기</h4>
			<c:choose>
				<c:when test="${review != null}">
					${review.star}(${review.count})
				</c:when>
				<c:otherwise>
					등록된 후기가 없습니다.
				</c:otherwise>
			</c:choose>
		</div>
		<hr>
		<c:choose>
			<c:when test="${empty reviewList}"></c:when>
			<c:otherwise>
				<c:forEach var="rv" items="${reviewList}">
					${rv.review_star} ${rv.review_uname}<br>
					${rv.review_regdate }| 상품명<br>
					${rv.review_content}
					<hr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<hr>
		조식가격<input type="text" name="lodging_bprice" value="${lodPlaceOne.lodging_bprice}"/>원
		<hr>
		<button type="button" onclick="check()" >수정</button>
		<button type="button" onclick="deleteAction()">삭제</button>
		<button type="button" onclick="location.href ='${loAPath}listForm'">숙소 목록으로 이동</button>
	</form>
	<hr>

</div>	
	
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>