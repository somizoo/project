<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="main-wrapper booking-step-2">
<section class="py-8 py-md-10">
  <div class="container">
    <div class="row">
      <div class="col-md-7 col-lg-8 order-1 order-md-0">
        <h3 class="text-capitalize mb-5">결제 정보</h3>
          <div class="mb-5">
            <div class="row">
              <div class="col mb-2 pe-1 px-lg-1">
                <div class="media" >
                  <div class="media-content w-100">
                    <img class="media-img rounded w-100" data-src="${imgGrPath }${grvo.gr_mainimg}" src="${imgGrPath }${grvo.gr_mainimg}" alt="${lodgingvo.lodging_name }">
	                <div style="display: flex; justify-content: space-between; margin-top: 18px;">
                    
	                    <div >
		                    <p>${grvo.gr_name }</p>
		                    <p>기준인원 : ${grvo.gr_ap }명 / 최대 인원 : ${grvo.gr_mp }명</p>
		                    <p>
	                    	<c:forEach var="bed" items="${grbList }">
	                    		${bed.bed_type } ${bed.grb_cnt } 
	                    	</c:forEach>
	                    	</p>
	                    	<p style="color:blue">가격 :<b><fmt:formatNumber value="${vo.payment_price }" type="number"/></b>원</p>
	                    </div>
	                <div>
	                    <a href="${reviewPath }writeForm?product_no=${vo.product_no}"
	                      class="btn btn-xs btn-outline-secondary btn-booking text-uppercase">리뷰쓰기</a>
		            </div>
                    </div>
                  </div>
                </div>
              </div>
              <hr>
              	<div class="form-group">
 	             	<h4>이용자 명</h4>
              	</div>
              <div class="col mb-2 pe-1 px-lg-1">
                <div class="media">
                  <div class="media-content w-100">
                    <p>${uname }</p>
                    <hr>
                   <h4>이용 안내</h4>
                    <p>
                    	꼭 가져오세요 !
                    	<br>
                    	신분증, 본인 명의 신용카드 
                    </p>
                    <hr>
                    <p>${lodgingvo.lodging_info}</p>
                    <p>${lodgingvo.lodging_content }</p>
                    <hr>
                    <h4>환불 안내</h4>
                     <p>${lodgingvo.lodging_refund}</p>
                    <hr>
                  </div>
                </div>
              </div>
             <div class="d-grid">
         		<button type="button" class="btn btn-block btn-xs btn-outline-secondary text-uppercase" 
         		onclick="location.href='${reviewPath}writeForm?product_no=${lodgingvo.lodging_no}'">리뷰쓰기</button>
        	</div>
				
				
            </div>
          </div>
      </div>
    </div>
  </div>
</section>

</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>