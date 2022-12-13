<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- ====================================
———	PAGE TITLE
===================================== -->
<section class="page-title" style="padding-top: 25%">
  <div class="page-title-img bg-img " style="background-image: url(${pageContext.request.contextPath}/resources/img/pages/boardbackground.png);">
    <div class="container">
      <div class="row align-items-center justify-content-center" style="height: 200px;">
        <div class="col-lg-6">
          <div class="page-title-content">
            <div class="">
              <h2 class="text-uppercase text-black font-weight-bold">UsWayTrip > ${vo1.board_name}</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- ====================================
———	POPULAR SECTION
===================================== -->
<section style="padding-top: 20%; padding-bottom: 40%">
  <div class="container">
    <div class="">
      <div class="row">
        <div class="col-md-6 col-lg-4">
          <a href="#">
            <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/blog/blog-0${b_no1 }.jpg" alt="Generic placeholder image">
          </a>
        </div>
        <div class="col-md-6 col-lg-8">
            <div class="row">
              <div class="col-md-6">
                <ul class="list-unstyled">
          			<h3 class="">${vo1.board_name}</h3>
          			
					<li class="media">
						<div></div>
						<div class="media-body">
							<c:forEach var="dto" begin="0" end="${fn:length(list) }" items="${list }">
								<c:if test="${dto.board_no eq b_no1 }">
									<a href="${bdpath }contentForm/${b_no1}/${dto.bd_no}">${dto.bd_title }</a><br>
								</c:if>
							</c:forEach>
							<br>
							<a href="${bdpath }detailNoticeListForm/${b_no1}" class="btn btn-sm btn-outline-secondary text-uppercase">문서 ${count1 }개 모두 보기</a>
						</div>
					</li>
					
				</ul>
              </div>
              <div class="col-md-6">
				<ul class="list-unstyled">
            	  <h3>${vo2.board_name}</h3>
            	  
					<li class="media">
						<div></div>
						<div class="media-body">
							<c:forEach var="dto2" begin="0" end="${fn:length(list) }" items="${list }">
								<c:if test="${dto2.board_no == b_no2 }">
									<a href="${bdpath }contentForm/${b_no2}/${dto2.bd_no}">${dto2.bd_title }</a><br>
								</c:if>
							</c:forEach>
							<br>
							<a href="${bdpath }detailNoticeListForm/${b_no2}" class="btn btn-sm btn-outline-secondary text-uppercase">문서 ${count2 }개 모두 보기</a>
						</div>
					</li>
					
				</ul>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</section>


  
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>