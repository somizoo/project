<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<script>
   
//숫자만 입력 정규식
var ck = /^[0-9]+$/;
var ck2 = /^[\.0-9]+$/; // 소수점 정규식


function check(gr) {
      var count = 0;
   
      if(gr.gr_name.value == ""){
         alert("객실 이름을 입력해주세요");
         gr.gr_name.focus();
         return false;
      }else if(gr.mainImg.value == ""){
         alert("객실 대표이미지를 선택해주세요");
         gr.mainImg.focus();
         return false;
      }else if(gr.imgs.value == ""){
         alert("객실 이미지를 선택해주세요");
         gr.imgs.focus();
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

   return true;
   
}
</script>
	<div align="center" style="padding-top:180px;">
		${lodging.lodging_name }
		<h3>객실 등록</h3>
		<form action="${AgrPath}writeGuestRoom" name="gr" method="post" enctype="multipart/form-data" onsubmit="return check(this)">
			<input type="hidden" value="${no}" name="lodging_no"/>
			<div>
				객실 이름
				<input  type="text" name="gr_name" >
				<hr>	
			
				객실 대표이미지
				<input type='file'  name="mainImg" >
				<hr>
			
				객실 이미지
				<input type="file" name = "imgs" multiple="multiple"/>
				<hr>
				<div>
				인원
					<p>
					<span> 기준 인원<input type="text" name="gr_ap"/></span> / 
					<span> 최대 인원<input type="text" name="gr_mp"/></span>
					</p>
				</div>
				<hr>
				무료취소 
				<textarea placeholder="내용을 입력하세요."  name = "gr_freecancel" style="width: 450px; height: 450px"></textarea>
				<hr>
				객실 상세
				<textarea placeholder="내용을 입력하세요."  name = "gr_content" style="width: 450px; height: 450px"></textarea>
				<hr>
				편의시설
				<c:forEach var="am" items="${amenitieList }" >
					<input type="checkbox" value="${am.amenities_no}" name="amenitie"/>${am.amenities_name}
				</c:forEach>
				<hr>	
				침대 개수
				<ul>
					<c:forEach var="bed" items="${bedList }">
						<li>${bed.bed_type } <input class="bed" type="text" name="bed" value="${bed.bed_no }"/>개</li>
						<input type="hidden" name="bed_no" value="${bed.bed_no}">
					
					</c:forEach>
				</ul>
				전망
				<select name="gr_ot">
					<c:forEach var="ot" items="${otList }">
						<option value="${ot.ot_no }" >${ot.ot_type}</option>
					</c:forEach>
				</select>
				객실 크기
				<input type="text" name="gr_size"/>m²
				<hr>
				객실 총 갯수
				<input type="text" name="gr_count"/>
			</div>
		<button type="submit" >등록</button>
		<button type="button" onclick ="location.href='${AlodPath}listForm/${no}'">취소</button>
		</form>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>