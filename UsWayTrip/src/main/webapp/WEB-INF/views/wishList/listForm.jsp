<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div style="padding-top : 20%"></div>
	
	<section class="bg-smoke py-10">
	  <div class="container">
	    <div class="row">
	      <div class="col-12">
	        <div class="row">
		<!-- -반복 시작-->
		<c:forEach var="data" items="${Tlist}">
	          <div class="col-md-6 col-lg-4 mb-5">
	            <div class="card card-hover">
	              <a href="${ cpath }/ticket/content/${data.ticket_no}" class="position-relative">
	                <img class="card-img-top lazyestload" data-src="${imgPath}${data.ticket_img }" src="${imgPath}${data.ticket_img }" alt="Card image cap">
	                <div class="card-img-overlay card-hover-overlay rounded-top d-flex flex-column">
	                  <ul class="list-unstyled d-flex mt-auto text-warning mb-1">
	                  	<c:forEach begin="1" end="5" step="1" varStatus="vs">
	                  		<c:if test="${vs.index <= data.review_star}">
			                  	<li>
			                      <i class="fa fa-star me-1" aria-hidden="true"></i>
			                    </li>
		                    </c:if>
	                  	</c:forEach>
	                  </ul>
	                  <h6 class="text-white font-weight-bold">(${data.cnt })</h6>
	                </div>
	              </a>
	
	              <div class="card-body">
	                <h5>
	                  <a href="${ cpath }/ticket/content/${data.ticket_no}" class="card-title text-uppercase">${data.ticket_title }</a>
	                </h5>
					<c:if test="${!empty data.ticket_confirmation}">
			               		<p class="mb-7">${data.ticket_confirmation }</p>
			         </c:if>
	                <div class="d-flex justify-content-between align-items-center">
	                  <div>
	                    <h3 class="text-primary">${data.to_price }원</h3>
	                  </div>   
	                </div>
	              </div>
	            </div>
	          </div>
	          </c:forEach>
		<!-- -반복 끝-->
	        </div>
	      </div>
	    </div>
	  </div>
</section>