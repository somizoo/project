<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<%-- <%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %> --%>

  <head>

    <!-- Plugins css Style -->
    <link href='${pageContext.request.contextPath}/resources/plugins/fontawesome-5.15.2/css/all.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/plugins/fontawesome-5.15.2/css/fontawesome.min.css' rel='stylesheet'>

    <!-- GOOGLE FONT -->
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700' rel='stylesheet'>

    <!-- CUSTOM CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/star.css" id="option_style" rel="stylesheet">


    <!-- FAVICON -->
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->

  </head>

  <!-- ====================================
  ———	COMING SOON SECTION
  ===================================== -->
  <section class="coming-soon" style="background-image: url(${pageContext.request.contextPath}/resources/img/coming-soon/coming-bg.jpg);">
    <div class="container">
      <div class="row flex-column justify-content-center align-items-center vh-100">
        <div class="coming-soon-logo">
          <a href="javascript:history.back (-1)">
            <img class="lazyestload" data-src="${pageContext.request.contextPath}/resources/img/logo-icon.png" src="${pageContext.request.contextPath}/resources/img/logo-icon.png" alt="logo.png">
          </a>
        </div>
        <!-- mt-10 pt-7 -->
        <div class="col-md-9 col-lg-7 col-xl-8 mt-md-6 mt-xl-10">
          <div class="coming-soon-content">
            <h1>준비 중 입니다</h1>
            <p>우리는 현재 웹사이트를 수정하는 작업을 진행 중입니다.<br> 우리가 모든 수정을 완료 하였을 때 알림을 받으려면<br> 아래에 이메일 주소를 입력해주시기 바랍니다.</p>
          </div>

          <div class="row justify-content-center">
            <div class="col-md-10">
              <form class="form-subscribe mb-6" action="index.html" method="post">
                <div class="input-group">
                  <input type="email" class="form-control form-search border-right-0" required="">
                    <button class="input-group-text border-0 btn bg-primary text-white text-uppercase px-3 px-md-6" type="submit">
                      제출
                    </button>
                </div>
              </form>
            </div>
          </div>

        </div>
      </div>
    </div>
  </section>
  
    <!-- Javascript -->
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/syotimer/jquery.syotimer.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/lazyestload/lazyestload.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/star.js"></script>