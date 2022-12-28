<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- ====================================
———	PAGE TITLE
===================================== -->
<section class="page-title" style="padding-top: 25%">
  <div class="page-title-img bg-img" style="background-image: url(${pageContext.request.contextPath}/resources/img/pages/boardbackground.png);">
    <div class="container">
      <div class="row align-items-center justify-content-center" style="height: 200px;">
        <div class="col-lg-6">
          <div class="page-title-content">
            <div class="title-border">
              <h2 class="text-uppercase text-black font-weight-bold">무엇을 도와드릴까요?</h2>
            </div>
            <p class="text-white mb-0"></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


<!-- ====================================
——— TRAVEL TIPS SECTION
===================================== -->

<section class="py-9 py-md-10">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-lg-4">
        <div class="card card-transparent mb-7">
          <a href="blog-single-right-sidebar.html" class="position-relative">
            <img class="card-img-top rounded lazyestload" data-src="${pageContext.request.contextPath}/resources/img/blog/blog-01.jpg" src="${pageContext.request.contextPath}/resources/img/blog/blog-01.jpg"
              alt="Card image cap">
            <div class="card-img-overlay card-hover-overlay rounded"></div>
          </a>

          <div class="card-body py-6">
            <h3 class="mb-4">
              <span href="blog-single-right-sidebar.html" class="text-capitalize text-dark hover-text-primary">공지사항</span>
            </h3>

            <div class="meta-post-sm mb-4">
              <ul class="list-unstyled d-flex flex-wrap mb-0">
              </ul>
            </div>

            <c:forEach var="dto" begin="0" end="${fn:length(list) }" items="${list }">
				<c:if test="${dto.board_no eq 1 }">
					<a href="${bdpath }contentForm/1/${dto.bd_no}">${dto.bd_title }</a><br>
				</c:if>
			</c:forEach>
          </div>

			<c:set var="c1" value="0"/>
			<c:forEach var="l" items="${list}">
				<c:if test="${l.board_no == 1 || l.board_no == 2}">
					<c:set var="c1" value="${c1+1}"/>
				</c:if>
			</c:forEach>
			
			<c:set var="c2" value="0"/>
			<c:forEach var="l2" items="${list}">
				<c:if test="${l2.board_no == 4 || l2.board_no == 5}">
					<c:set var="c2" value="${c2+1}"/>
				</c:if>
			</c:forEach>

          <div class="card-footer px-5">
            <a href="${boardpath }noticeListForm/1/2" class="btn btn-sm btn-outline-secondary text-uppercase">${c1 }개의 질문 모두보기 ></a>
          </div>
        </div>
      </div>

      <div class="col-md-6 col-lg-4">
        <div class="card card-transparent mb-7">
          <a href="blog-single-right-sidebar.html" class="position-relative">
            <img class="card-img-top rounded lazyestload" data-src="${pageContext.request.contextPath}/resources/img/blog/blog-02.jpg" src="${pageContext.request.contextPath}/resources/img/blog/blog-02.jpg" alt="Card image cap">
            <div class="card-img-overlay card-hover-overlay rounded"></div>
          </a>
        
          <div class="card-body py-6">
            <h3 class="mb-4">
              <span href="blog-single-right-sidebar.html" class="text-capitalize text-dark hover-text-primary">항공권 문의</span>
            </h3>
        
            <div class="meta-post-sm mb-4">
              <ul class="list-unstyled d-flex flex-wrap mb-0">
              </ul>
            </div>
        
			<c:forEach var="dto4" begin="0" end="${fn:length(list) }" items="${list }">
				<c:if test="${dto4.board_no eq 4 }">
					<a href="${bdpath }contentForm/4/${dto4.bd_no}">${dto4.bd_title }</a><br>
				</c:if>
			</c:forEach>
          </div>
			
			
          <div class="card-footer px-5">
            <a href="${boardpath }noticeListForm/4/5" class="btn btn-sm btn-outline-secondary text-uppercase">${c2 }개의 질문 모두보기 ></a>
          </div>
        </div>
      </div>

      <div class="col-md-6 col-lg-4">
        <div class="card card-transparent mb-7">
          <a href="blog-single-right-sidebar.html" class="position-relative">
            <img class="card-img-top rounded lazyestload" data-src="${pageContext.request.contextPath}/resources/img/blog/blog-03.jpg" src="${pageContext.request.contextPath}/resources/img/blog/blog-03.jpg" alt="Card image cap">
            <div class="card-img-overlay card-hover-overlay rounded"></div>
          </a>
        
          <div class="card-body py-6">
            <h3 class="mb-4">
              <span href="blog-single-right-sidebar.html" class="text-capitalize text-dark hover-text-primary">여행 문의</span>
            </h3>
        
            <div class="meta-post-sm mb-4">
              <ul class="list-unstyled d-flex flex-wrap mb-0">
                <li class="meta-tag me-4 mb-1">
              </ul>
            </div>
        
			<c:forEach var="dto7" begin="0" end="${fn:length(list) }" items="${list }">
				<c:if test="${dto7.board_no eq 7}">
					<a href="${bdpath }contentForm/7/${dto7.bd_no}">${dto7.bd_title }</a><br>
				</c:if>
			</c:forEach>
          </div>
        	
        	<c:set var="c3" value="0"/>
			<c:forEach var="l3" items="${list}">
				<c:if test="${l3.board_no == 7 || l3.board_no == 8}">
					<c:set var="c3" value="${c3+1}"/>
				</c:if>
			</c:forEach>
			
			<c:set var="c4" value="0"/>
			<c:forEach var="l4" items="${list}">
				<c:if test="${l4.board_no == 13 || l4.board_no == 14}">
					<c:set var="c4" value="${c4+1}"/>
				</c:if>
			</c:forEach>
        	
          <div class="card-footer px-5">
            <a href="${boardpath }noticeListForm/7/8" class="btn btn-sm btn-outline-secondary text-uppercase">${c3 }개의 질문 모두보기 ></a>
          </div>
        </div>
      </div>

      <div class="col-md-6 col-lg-4">
        <div class="card card-transparent mb-7 mb-lg-0">
          <a href="blog-single-right-sidebar.html" class="position-relative">
            <img class="card-img-top rounded lazyestload" data-src="${pageContext.request.contextPath}/resources/img/blog/blog-04.jpg" src="${pageContext.request.contextPath}/resources/img/blog/blog-04.jpg" alt="Card image cap">
            <div class="card-img-overlay card-hover-overlay rounded"></div>
          </a>
      
          <div class="card-body py-6">
            <h3 class="mb-4">
              <span href="blog-single-right-sidebar.html" class="text-capitalize text-dark hover-text-primary">여행상품 FAQ</span>
            </h3>
      
            <div class="meta-post-sm mb-4">
              <ul class="list-unstyled d-flex flex-wrap mb-0">
                <li class="meta-tag me-4 mb-1">
              </ul>
            </div>
      
			<c:forEach var="dto13" begin="0" end="${fn:length(list) }" items="${list }">
				<c:if test="${dto13.board_no eq 13 }">
					<a href="${bdpath }contentForm/13/${dto13.bd_no}">${dto13.bd_title }</a><br>
				</c:if>
			</c:forEach>
          </div>
      
          <div class="card-footer px-5">
            <a href="${boardpath }noticeListForm/13/14" class="btn btn-sm btn-outline-secondary text-uppercase">${c4 }개의 질문 모두보기 ></a>
          </div>
        </div>
      </div>

      <div class="col-md-6 col-lg-4">
        <div class="card card-transparent mb-7 mb-md-0">
          <a href="blog-single-right-sidebar.html" class="position-relative">
            <img class="card-img-top rounded lazyestload" data-src="${pageContext.request.contextPath}/resources/img/blog/blog-05.jpg" src="${pageContext.request.contextPath}/resources/img/blog/blog-05.jpg" alt="Card image cap">
            <div class="card-img-overlay card-hover-overlay rounded"></div>
          </a>
      
          <div class="card-body py-6">
            <h3 class="mb-4">
              <span href="blog-single-right-sidebar.html" class="text-capitalize text-dark hover-text-primary">여행자 신뢰센터</span>
            </h3>
      
            <div class="meta-post-sm mb-4">
              <ul class="list-unstyled d-flex flex-wrap mb-0">
                <li class="meta-tag me-4 mb-1">
              </ul>
            </div>
      
			<c:forEach var="dto19" begin="0" end="${fn:length(list) }" items="${list }">
				<c:if test="${dto19.board_no eq 19}">
					<a href="${bdpath }contentForm/19/${dto19.bd_no}">${dto19.bd_title }</a><br>
				</c:if>
			</c:forEach>
          </div>
      		
      		<c:set var="c5" value="0"/>
			<c:forEach var="l5" items="${list}">
				<c:if test="${l5.board_no == 19}">
					<c:set var="c5" value="${c5+1}"/>
				</c:if>
			</c:forEach>
      		
          <div class="card-footer px-5">
            <a href="${boardpath }noticeListForm/19/20" class="btn btn-sm btn-outline-secondary text-uppercase">${c5 }개의 질문 모두보기 ></a>
          </div>
        </div>
      </div>
    </div>
  </div>

</section>



  </div><!-- element wrapper ends -->
  
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
