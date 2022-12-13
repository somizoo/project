<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		}else if(document.input.ticket_user.value == ""){
			alert("이용 안내를 입력하십시오!");
			document.input.ticket_user.focus();
			return false;
		}else if(document.input.ticket_refund.value == ""){
			alert("취소 및 환불을 입력하십시오!");
			document.input.ticket_refund.focus()
			return false;;
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

<div align="center">
   <form action="${cpath }/admin/ticket/update/${vo.ticket_no }" method="post" name="input" enctype="multipart/form-data"> <!-- enctype="multipart/form-data" -->
   <h4>상품 수정</h4>
   <table class="table">
      <thead class="table-group-divider">
      <tr>
         <th>제목</th>
         <td><input type="text" size="70" name="ticket_title" value="${vo.ticket_title }"></td>
      </tr>
      <tr>
         <th>카테고리</th>
         <td align="left">
         <select name="tsc_no">
              <option value="${vo.tsc_no }" selected disabled hidden>${vo.tsc_name }</option>
            <c:forEach var="tsc_vo" items="${tsc_list }">
            <c:if test="${tsc_vo.tsc_no ne vo.tsc_no }">
                  <option value="${tsc_vo.tsc_no }">${tsc_vo.tsc_name }</option>
            </c:if>
            </c:forEach>
         </select>
         </td>
      </tr>
      <tr>
      <tr>
         <th>지역</th>
         <td align="left">
         <select name="place_no">
<%--               <option value="${vo.place_no }" selected disabled hidden>${vo.place_name }</option> --%>
            <c:forEach var="place_vo" items="${place_list }">
               <option value="${place_vo.place_no }" <c:if test="${vo.place_no == place_vo.place_no }">selected</c:if>>${place_vo.place_name }</option>
            </c:forEach>
         </select>
         </td>
      </tr>
      
      <tr>
         <th>유효기간</th>
         <td align="left"><input type="button" id="show" name="ticket_valid" value="유효기간">
         <c:set var="val" value="${vo.ticket_valid }"/>
         <input type="date" id="date" name="date" value="${fn:substring(val, 0, 10) }">
         <input type="button" name="ticket_valid" id="hide" value="유효기간 x"></td>
      </tr>
      <tr>
         <th>즉시확정</th>
         <td align="left">${vo.ticket_confirmation}
         <c:if test="${vo.ticket_confirmation eq '즉시확정'}">
            <input type="checkbox" name="ticket_confirmation" value="즉시확정" checked>${vo.ticket_confirmation}
         </c:if>
         </td>
      </tr>
      <tr>
         <th>가격 스티커</th>
         <td align="left">
         <c:if test="${vo.ticket_priceSticker eq '최저가 보장제'}">
            <input type="radio" name="ticket_priceSticker" value="최저가 보장제" checked>최저가 보장제
            <input type="radio" name="ticket_priceSticker" value="무료 취소">무료 취소
            <input type="radio" name="ticket_priceSticker" value="">없음</c:if>
         <c:if test="${vo.ticket_priceSticker eq '무료 취소'}">
            <input type="radio" name="ticket_priceSticker" value="최저가 보장제">최저가 보장제
            <input type="radio" name="ticket_priceSticker" value="무료 취소" checked>무료 취소
            <input type="radio" name="ticket_priceSticker" value="">없음</c:if>
         <c:if test="${vo.ticket_priceSticker eq ''}">
            <input type="radio" name="ticket_priceSticker" value="최저가 보장제">최저가 보장제
            <input type="radio" name="ticket_priceSticker" value="무료 취소">무료 취소
            <input type="radio" name="ticket_priceSticker" value="" checked>없음</c:if>
         </td>
      </tr>
            <tr>
         <th>티켓 종류 선택</th>
         <td align="left">
         <c:if test="${vo.to_type eq 0}">
            <input type="radio" name="to_type" value="0" checked>티켓
            <input type="radio" name="to_type" value="1">달력 + 티켓
            <input type="radio" name="to_type" value="2">달력 + 인원
            <input type="radio" name="to_type" value="3">달력 + 옵션
         </c:if>
         <c:if test="${vo.to_type eq 1}">
            <input type="radio" name="to_type" value="0">티켓
            <input type="radio" name="to_type" value="1" checked>달력 + 티켓
            <input type="radio" name="to_type" value="2">달력 + 인원
            <input type="radio" name="to_type" value="3">달력 + 옵션
         </c:if>
         <c:if test="${vo.to_type eq 2}">
            <input type="radio" name="to_type" value="0">티켓
            <input type="radio" name="to_type" value="1">달력 + 티켓
            <input type="radio" name="to_type" value="2" checked>달력 + 인원
            <input type="radio" name="to_type" value="3">달력 + 옵션
         </c:if>
         <c:if test="${vo.to_type eq 3}">
            <input type="radio" name="to_type" value="0">티켓
            <input type="radio" name="to_type" value="1">달력 + 티켓
            <input type="radio" name="to_type" value="2">달력 + 인원
            <input type="radio" name="to_type" value="3" checked>달력 + 옵션
         </c:if>
         </td>
      </tr>
<%--       <tr>
         <th>이벤트</th>
         <td align="left">
            <c:forEach var="te_list" items="${te_list }">
               <c:forEach var="te_no" items="${te_no }">
                  <c:if test="${te_no eq te_list.te_no }">
                     <input type="checkbox" value="${te_list.te_no }" name="te_event" checked>${te_list.te_name }
                  </c:if>
                  <c:if test="${te_no ne te_list.te_no }">
                     <input type="checkbox" value="${te_list.te_no }" name="te_event">${te_list.te_name }
                  </c:if>
               </c:forEach>
            </c:forEach>
         </td>
      </tr> --%>      
       <tr>
         <th>이벤트</th>
         <td align="left">
            <c:forEach var="te_list" items="${te_list}"> 
                     <c:set var="loop" value="false"/>
                     <input type="checkbox" value="${te_list.te_no }" name="te_event"
                       <c:forEach var="te_no" items="${te_no }">
                           <c:if test="${loop eq false }"> 
                               ${te_no eq te_list.te_no ? "checked" : ""} 
                              <c:set var="loop" value="${te_no eq te_list.te_no ? true : false }"/> 
                           </c:if>
                        </c:forEach>
                     > ${te_list.te_name }
                     </c:forEach>
            </td>
         </tr>       
<%--       <tr>
         <th>상품 정보</th>
         <td align="left">   
         <c:forEach var="ti" items="${ti_list }" varStatus="status">
            ${ti.ti_name }
            <select name="${status.index}">
              <option value="${ti.ti_no }" selected disabled hidden>${tid.tid_value }</option>
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
      </tr> --%>
      <tr>
         <th>유의 사항</th>
         <td><textarea rows="10" cols="70" name="ticket_precautions">${vo.ticket_precautions }</textarea></td>   
      </tr>
         <tr>
       <th>상세 내용</th> <!-- 덜함 -->
         <td>
         <c:forEach var="vo" items="${multiImg }">
            <img src="${cpath }/resources/upload/product/ticket/${vo.img_name}" width="400"><br>
         </c:forEach>
         <input type="file" name="listPhoto" size = "400" multiple="multiple">
         </td>
      </tr> 
      <tr>
      <th>코스 소개</th>
         <!-- 썸머노트 -->
         <td><textarea rows="10" cols="70" name="ticket_route">${vo.ticket_route }</textarea></td>
      </tr>
      <tr>
      <th>이용 안내</th>
         <td><textarea rows="10" cols="70" name="ticket_user">${vo.ticket_user }</textarea></td>
      </tr>
      <tr>
         <th>취소 및 환불 규정 내용</th>
            <td><textarea rows="10" cols="70" name="ticket_refund">${vo.ticket_refund }</textarea></td>
         </tr>
      <tr>
      <th>메인 이미지</th>
         <td colspan="3">
            <img src="${cpath }/resources/upload/product/ticket/mainimg/${vo.ticket_img}" width="400" download><br>
            <input type="file" name="photo" size = "400" multiple="multiple">
         </td>
         </thead>
      </table>
      <input type="button" value="수정" onclick="checkWrite()">
   </form>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>