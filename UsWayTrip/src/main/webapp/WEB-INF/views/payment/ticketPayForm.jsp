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
    	  return false;
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
    
        <form action="${cpath }/payment/payment" method="post" id="payment" name="payment">
          <input type="hidden" name="product_no" value="${product_no }" />
          <input type="hidden" name="product_sort" value="${product_sort }"/>
          <input type="hidden" name="member_no" value="${member_no}"/>

          <input type="hidden" name="payment_price" value="${totalPrice }" />
          <input type="hidden" name="payment_bank" id="payment_bank" value="" />
          <input type="hidden" name="product_sort" value="t" />
          
          
          
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
                    <c:forEach var="t" items="${toList }" varStatus="status">
                       <div>
	                       <c:out value="${t.to_title} " />
	                       <c:out value="${t.to_price}원" />
	                       <c:out value="${cnt[status.index]}매" />
	                       
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
          
          <hr>
          <div class="mb-8">
            <h3 class="text-capitalize mb-5">카드 정보</h3>
            <div class="row">
              <div class="col-lg-6">
                <div class="form-group">
                  <label for="inputName">카드 이름</label>
                  <input type="text" name="card_name" class="form-control border-0 bg-smoke">
                </div>
              </div>
            
              <div class="col-lg-6">
                <div class="form-group">
                  <label for="inputNumber">카드 번호</label>
                  <input type="text" id="payment_card" name="payment_card" class="form-control border-0 bg-smoke" maxlength="19">
                </div>
              </div>
            
              <div class="col-lg-6">
                <div class="form-group">
                  <label for="inputName">CVV</label>
                  <input type="text" id="cvv" class="form-control border-0 bg-smoke" maxlength="3">
                </div>
              </div>
            
              <div class="col-lg-6">
                <div class="form-group">
                  <label for="inputNumber">카드사</label>
                  <div class="row">
                    <div class="col-3 pe-lg-1 pe-xl-3">

                      <div class="img-overlay rounded">
                        <img class="w-100 lazyestload" data-src="${cpath }/resources/img/booking/master-card.jpg" src="${cpath }/resources/img/booking/master-card.jpg" alt="master-card">
                        <a href="javascript:;" class="hover-img-overlay-dark " id="master-card" onclick="cardClick(this)" ></a>
                      </div>
                    </div>

                    <div class="col-3 px-lg-2 px-xl-3">
                      <div class="img-overlay rounded">
                        <img class="w-100 lazyestload" data-src="${cpath }/resources/img/booking/discover.jpg" src="${cpath }/resources/img/booking/discover.jpg" alt="discover">
                        <a href="javascript:;" class="hover-img-overlay-dark" id="discover" onclick="cardClick(this)"></a>
                      </div>
                    </div>

                    <div class="col-3 px-lg-2 px-xl-3">
                      <div class="img-overlay rounded">
                        <img class="w-100 lazyestload" data-src="${cpath }/resources/img/booking/visa.jpg" src="${cpath }/resources/img/booking/visa.jpg" alt="visa">
                        <a href="javascript:;" class="hover-img-overlay-dark" id="visa" onclick="cardClick(this)"></a>
                      </div>
                    </div>

                    <div class="col-3 ps-lg-1 ps-xl-3">
                      <div class="img-overlay rounded">
                         <img class="w-100 lazyestload" data-src="${cpath }/resources/img/booking/paypal.jpg" src="${cpath }/resources/img/booking/paypal.jpg" alt="paypal">
                        <a href="javascript:;" class="hover-img-overlay-dark" id="paypal" onclick="cardClick(this)"></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-lg-6">
                <label for="exampleInputText">유효 기간</label>
                <div class="form-group form-group-icon form-group-icon-default">
                  <i class="far fa-calendar-alt" aria-hidden="true"></i>
                  <input type="text" id="validity" class="form-control border-0 bg-smoke" name="dateRange" value="" placeholder="DD/MM/YY">
                </div>
              </div>

              <div class="col-lg-6">
                <div class="form-group">
                  <label for="inputName">비밀 번호</label>
                  <input type="password" id="password" class="form-control border-0 bg-smoke" maxlength="4">
                </div>
              </div>
            </div>
          </div>
        </form>
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