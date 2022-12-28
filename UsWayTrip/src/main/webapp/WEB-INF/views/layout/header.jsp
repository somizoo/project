<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>

<script src="${cpath }/resources/js/menu.js"></script>
<script src="${cpath}/resources/plugins/menuzord/js/menuzord.js"></script>

<script src="${cpath}/resources/plugins/selectric/jquery.selectric.min.js"></script>
<script src="${cpath}/resources/plugins/daterangepicker/js/moment.min.js"></script>
<script src="${cpath}/resources/plugins/daterangepicker/js/daterangepicker.min.js"></script>
<script src="${cpath}/resources/plugins/rateyo/jquery.rateyo.min.js"></script>
<script src="${cpath}/resources/plugins/lazyestload/lazyestload.js"></script>
<script src="${cpath}/resources/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="${cpath}/resources/js/star.js"></script>

<body id="body" class="up-scroll">

  <!-- ====================================
  ——— HEADER
  ===================================== -->
  <header class="header" id="pageTop">
    <!-- Menu Zord -->
    <nav class="nav-menuzord navbar-sticky">
      <div class="container clearfix">
        <div id="menuzord" class="menuzord">
          <a href="${cpath }/" class="menuzord-brand">
            <img class="lazyestload" data-src="${cpath }/resources/img/logo-color-big.png" src="${cpath }/resources/img/logo-color-big.png" alt="logo-img">
          </a>

          <div class="nav-item dropdown nav-item-left me-0">
            <button class="btn btn-xs btn-primary d-none d-lg-inline-block notify-toggler">
              <i class="fa fa-search text-white me-0" aria-hidden="true"></i>
            </button>
          
            <div class="dropdown-menu dropdown-menu-end dropdown-notify rounded-0">
              <form class="mb-0" action="index.html" method="post">
                <div class="input-group input-group-sm">
                  <input type="text" class="form-control form-control-sm rounded-0" required="" placeholder="Search...." aria-label="Search....">
                  <button class="btn bg-primary border-0 rounded-0" type="submit">
                    <span class="text-white text-uppercase font-weight-bold">Search</span>
                  </button>
                </div>
              </form>
            </div>
          </div>
          
          <ul class="menuzord-menu menuzord-right">
            <li class="">
              <a href="${cpath}/lodging/listForm">국내숙소</a> 
            </li>

            <li class="">
              <a href="${cpath}/ticket/listForm">투어·티켓</a>
            </li>

            <li class="">
              <a href="${cpath }/board/mainListForm">게시판</a>
              
            </li>
			
			<c:choose>
				<c:when test="${empty login}">
		            <li class="">
		              <a href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#login">로그인</a>
		            </li>
		
		            <li class="">
		                <a href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#signup">회원가입</a>
		            </li>
	            </c:when>
	            <c:otherwise>
	             <li class="">
		                <a href="${cpath }/wishList/listForm">위시리스트</a>
		            </li>
		             <li class="">
		              <a href="${cpath }/member/myPageForm">마이페이지</a>
		            </li>
		
		            <li class="">
		                <a href="${cpath }/member/logout">로그아웃</a>
		            </li>
		            
	            </c:otherwise>
            </c:choose>
	
			<c:if test="${role < 3 }">
            <li class="">
              <a href="${cpath }/admin/lodging/listForm">관리자페이지</a>
            </li>
            </c:if>

            <li class="py-4">
              <form class="d-lg-none" action="index.html" method="post">
                <div class="input-group input-group-sm">
                  <input type="text" class="form-control form-control-sm rounded-0" required="" placeholder="Search...." aria-label="Search....">
                  <button class="btn bg-primary border-0 rounded-0" type="submit">
                    <span class="text-white text-uppercase font-weight-bold">Search</span>
                  </button>
                </div>
              </form>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>

		