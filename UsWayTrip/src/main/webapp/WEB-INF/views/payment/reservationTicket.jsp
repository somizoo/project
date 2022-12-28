<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
   $(function(){
      $("#payment_card").on("keyup", function(){
         let str = $(this).val();
         let tmp = '';
         str= str.replace(/[^0-9]/g, '');
         if( str.length < 5){
               $(this).val(str);
           }else if(str.length < 9){
               tmp += str.substr(0, 4);
               tmp += '-';
               tmp += str.substr(4);
               $(this).val(tmp);
           }else if(str.length < 13){
               tmp += str.substr(0, 4);
               tmp += '-';
               tmp += str.substr(4, 4);
               tmp += '-';
               tmp += str.substr(8, 4);
               $(this).val(tmp);
           }else{
               tmp += str.substr(0, 4);
               tmp += '-';
               tmp += str.substr(4, 4);
               tmp += '-';
               tmp += str.substr(8, 4);
               tmp += '-';
               tmp += str.substr(12);
               $(this).val(tmp);
           }
          
      })
      
   });


   function cardClick(card){
      let cardCompany = $(card).attr("id");
        $('#payment_bank').val(cardCompany);
 
   }
   
   function check(){
      let form = document.payment;
      if(form.card_name.value == ""){
         alert("카드 이름을 입력하세요")
         form.card_name.focus();
         return false;
      }else if(form.payment_card.value == "" || form.payment_card.value.length < 19){
         alert("카드번호가 잘못되었습니다. 다시 입력하세요")   
         form.payment_card.focus();
         return false;
      }else if(form.cvv.value == ""){
         alert("CVV번호를 입력하세요")
         form.cvv.focus();
         return false;
      }else if(form.payment_bank.value == ""){
         alert("카드사를 선택하세요")
         return false;
      }else if(form.validity.value == ""){
         alert("유효기간을 선택하세요")
         form.validity.focus();
         return false;
      }else if(form.password.value == ""){
         alert("카드 비밀번호를 입력하세요")
         form.password.focus();
         return false;
      }else{
         form.submit();
      }
   }
   
</script>
<div class="main-wrapper booking-step-2">
<section class="py-8 py-md-10">
  <div class="container">
    <div class="row">
      <div class="col-md-7 col-lg-8 order-1 order-md-0">
        <h3 class="text-capitalize mb-5">결제 정보</h3>
          
           <div class="mb-5">
            <div class="row">
              <div class="col mb-2 pe-1 px-lg-1">
                <div class="media">
                  <div class="media-content w-100">
                    <img class="media-img rounded w-100" data-src="${imgTicket }${ticketVO.ticket_img}" src="${imgTicket }${ticketVO.ticket_img}" alt="${ticketVO.ticket_title }">
                    <p>${ticketVO.ticket_title }</p>
                    <p>
                       <c:set var="val" value="${ticketVO.ticket_valid }"/>
                        	유효기간 ${fn:substring(val, 0, 10) }
                    </p>
                    <c:forEach var="t" items="${to_title }" varStatus="status">
                       <div>
	                       <c:out value="${t} " />
	                       <c:out value="${to_price[status.index]}원" />
	                       <c:out value="${cnts[status.index]}매" />
	                       
                       </div>
                    </c:forEach>
                  </div>
                </div>
              </div>
              <hr> 
               
                 <div class="form-group">
                    <h4>이용 안내</h4>
                 </div>
              <div class="col mb-2 pe-1 px-lg-1">
                <div class="media">
                  <div class="media-content w-100">
                    <p>
                       꼭 가져오세요 !
                       <br>
                       신분증, 본인 명의 신용카드
                    </p>
                    <hr>
                    <p>${ticketVO.ticket_precautions }</p>
                    <hr>
                    <h4>환불 안내</h4>
                     <p>${ticketVO.ticket_refund}</p>
                    <hr>
                    <h4>이용자 명</h4>
                    <p>${uname }</p>
                  </div>
                </div>
              </div>
              
            </div>
          </div>

      </div>

          <div class="card-footer mt-6">
            <h2 class="mb-0">
              <span>총 금액:</span>
              <span class="text-primary font-weight-bold"><fmt:formatNumber value="${totalPrice }" type="number"/>원</span>
            </h2>
          </div>
          <br>
          <button type="button" onclick="return check();" class="btn btn-primary text-uppercase">결제</button>
        </div>
      </div>
    </div>
  </div> 
</section>

</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>