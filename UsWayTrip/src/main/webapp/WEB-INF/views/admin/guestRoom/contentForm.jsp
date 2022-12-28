<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<script type="text/javascript">

   //숫자만 입력 정규식
   var ck = /^[0-9]+$/;
   var ck2 = /^[\.0-9]+$/; // 소수점 정규식
   
   function check(gr) {
      if(gr.gr_name.value == ""){
         alert("객실 이름을 입력해주세요");
         gr.gr_name.focus();
         return false;
      }else if(gr.gr_ap.value == ""){
         alert("기준인원을 입력해주세요");
         gr.gr_ap.focus();
         return false;
      }else if(!ck.test(gr.gr_ap.value)) {
          alert("숫자만 입력 가능합니다.");
          gr.gr_ap.focus();
          return false;
      }else if(gr.gr_mp.value == ""){
         alert("최대 인원을 입력해주세요");
         gr.gr_mp.focus();
         return false;
      }else if(!ck.test(gr.gr_mp.value)) {
          alert("숫자만 입력 가능합니다.");
          gr.gr_mp.focus();
          return false;
      }else if(gr.gr_freecancel.value == ""){
         alert("무료취소를 입력해주세요");
         gr.gr_freecancel.focus();
         return false;
      }else if(gr.gr_content.value == ""){
         alert("객실 상세를 입력해주세요");
         gr.gr_content.focus();
         return false;
      }else if($("input:checkbox[name='amenitie']").is(":checked")==false){
         alert("편의시설을 선택해주세요");
         $("input:checkbox[name='amenitie']:eq(0)").focus();
         return false;
      }else if(document.getElementsByName("bed").length > 0){
         const textBoxList = document.getElementsByName("bed");
          for(textBox of textBoxList) {
             if(textBox.value == "") {
                alert("침대갯수를 입력해주세요");
                textBox.focus();
                return false;
             }else if(!ck.test(textBox.value)){
                alert("숫자만 입력 가능합니다.");
                 textBox.focus();
                 return false;
             }else if(textBox.value <= 0){
                count = count + 1;
                if(document.getElementsByName("bed").length == count){
                   alert("1개 이상의 침대를 입력 해 주세요!");
                   textBox.focus();
                   return false;
                }
             }
          }
      }
         
      if(gr.gr_size.value == ""){
         alert("객실 크기를 입력해주세요");
         gr.gr_size.focus();
         return false;
      }else if(!ck2.test(gr.gr_size.value)) {
          alert("숫자만 입력 가능합니다.");
          gr.gr_size.focus();
          return false;
      }
      
      if(gr.gr_count.value == ""){
         alert("객실 총 갯수를 입력해주세요");
         gr.gr_count.focus();
         return false;
      }else if(!ck.test(gr.gr_count.value)) {
          alert("숫자만 입력 가능합니다.");
          gr.gr_count.focus();
          return false;
      }
      
      gr.submit();
   }

	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${grPath}delete/${lodroom.gr_no }/${lodroom.lodging_no }'; // 객실
		
	}
</script>
<div align="center" style="padding-top:180px;">
<form action="${grPath }update" method="post" onsubmit="return check(this)" enctype="multipart/form-data">
	<input type="hidden" name="gr_no" value="${lodroom.gr_no}"/>
	<input type="hidden" name="lodging_no" value="${lodroom.lodging_no }">
	<div>
		<h4>${lodroom.lodging_name}</h4>
		${lodroom.gr_no}
		객실 이름
		<input  type="text" name="gr_name" value="${lodroom.gr_name}">
		<hr>	
		<div>
			객실 대표이미지
			<br>
			<img src="${imgPath}${lodroom.gr_mainimg}" width="100px" height="100px"/>
				${lodroom.gr_mainimg}
			<br>
			객실 이미지
			<c:forEach var="img" items="${grImgs}" >
				<div>
					<img src="${imgsPath} ${img.gri_name}" width="100px" height="100px">
					${img.gri_name}
					<a href="${grPath}imgDelete/${img.gri_name}/${lodroom.gr_no}">삭제</a>
				</div>
			</c:forEach>
		</div>
		객실 대표이미지 수정
		<input type='file'  name="mainImg" >
		객실 이미지 추가
		<input type="file" name = "imgs" multiple="multiple"/>
		<hr>
		<div>
		인원
		<span> 기준 인원<input type="text" name="gr_ap" value="${lodroom.gr_ap}"/></span> / 
		<span> 최대 인원<input type="text" name="gr_mp" value="${lodroom.gr_mp}"/></span>
		</div>
		<hr>
		무료취소 
		<textarea placeholder="내용을 입력하세요."  name = "gr_freecancel" style="width: 450px; height: 450px">${lodroom.gr_freecancel }</textarea>
		<hr>
		객실 상세
		<textarea placeholder="내용을 입력하세요."  name = "gr_content" style="width: 450px; height: 450px">${lodroom.gr_content }</textarea>
		<hr>
		편의시설
		<c:forEach var="ams" items="${amenitieList}">
			<c:set var="loop" value="false"/>
			<input type="checkbox" value="${ams.amenities_no}" name="amenitie" 
				<c:forEach var="checkam" items="${grAm}">
					<c:if test="${loop eq false }">
						${ams.amenities_no eq checkam.amenities_no ? "checked" : ""}
						<c:set var="loop" value="${ams.amenities_no eq checkam.amenities_no ? true : false }"/>
					</c:if>
				</c:forEach>
			> ${ams.amenities_name}
		</c:forEach>
		<hr>	
		침대 개수
		<ul>
		<c:forEach var="bed" items="${bedList}"><%-- 1234 --%>
			<c:forEach var="grbed" items="${grBed}"><%-- 24 --%>
					<c:if test="${ bed.bed_no == grbed.bed_no}">
						<c:set var="no" value="${grbed.grb_cnt }"/>
					</c:if>
			</c:forEach>
			${bed.bed_type}<input type="text"  name="bed" value= "${no }"> 
			<input type="hidden" name="bed_no" value="${bed.bed_no}">
			<c:set var="no" value="0"/>
		</c:forEach>
		</ul>
		전망
		<select name="gr_ot">
			<c:forEach var="ot" items="${otList }">
				<option value="${ot.ot_no }" <c:if test="${ot.ot_no  == lodroom.gr_ot }">selected</c:if>>${ot.ot_type}</option>
			</c:forEach>
		</select>
		객실 크기
		<input type="text" name="gr_size" value="${lodroom.gr_size}"/>m²
		<hr>
		객실 총 갯수
		<input type="text" name="gr_count" value="${ lodroom.gr_count}"/>
		
		<hr>
		<div>
		<button type="submit" >수정</button>
		<button type="button" onclick="deleteAction()">삭제</button>
		<button type="button" onclick="location.href='${grPath}listForm/${lodroom.lodging_no}'">객실 목록으로 이동</button>
		</div>	
	</div>
</form>
<hr>
		<h4><span>객실 옵션</span></h4> <button type="button" onclick="location.href='${groPath}writeForm/${lodroom.gr_no}/${lodroom.lodging_no}'">객실 옵션등록</button>
		<c:choose>
			<c:when test="${empty groList }">
				<p style="font-weight: bold;">등록된 객실옵션이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="gro" items="${groList }">
					<div>
					객실번호 : ${gro.gro_no}
					객실 옵션명 : <a href="${groPath}contentForm/${gro.gro_no }">${ gro.gro_name}</a>
					<c:choose>
						<c:when test="${gro.sale != 0}">
							${gro.coupon_figure} → ${gro.gro_price}<br>
							${gro.sale}<br>
							${gro.coupon_figure}쿠폰 적용가
						</c:when>
						<c:otherwise >
							${gro.gro_price}원
						</c:otherwise>
					</c:choose>
					${gro.gro_bf == 'y'? "조식포함": ""}
					
					<button type="button" onclick="location.href='${groPath}contentForm/${gro.gro_no }'" >수정</button>
					<button type="button" onclick="location.href='${groPath}delete/${gro.gro_no}/${lodroom.gr_no}'">삭제</button>
					</div>
				<hr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
</div>	



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>