<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>

	    <!-- SITE TITTLE -->
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Chrome">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Us Way Trip</title>
	
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
	
    <!-- Plugins css Style -->
    
<!--     animate -->
    <link type="text/css" href='${cpath}/resources/plugins/animate/animate.css' rel='stylesheet'>
    
<!--     bootstrap -->
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap.rtl.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap.rtl.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-grid.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-grid.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-grid.rtl.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-grid.rtl.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-reboot.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-reboot.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-reboot.rtl.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-reboot.rtl.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-utilities.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-utilities.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-utilities.rtl.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/bootstrap/css/bootstrap-utilities.rtl.min.css' rel='stylesheet'> --%>
    
<!--     daterangerpicker -->
    <link type="text/css" href='${cpath}/resources/plugins/daterangepicker/css/daterangepicker.css' rel='stylesheet'>
    
<!--     dzsparallaxer -->
    <link type="text/css" href='${cpath}/resources/plugins/dzsparallaxer/dzsparallaxer.css' rel='stylesheet'>
<%--     <link type="text/css" href='${cpath}/resources/plugins/dzsparallaxer/dzsprx_module_parallax_features.css' rel='stylesheet'> --%>
    
<!--     fancybox -->
<%--     <link type="text/css" href='${cpath}/resources/plugins/fancybox/fancyMorph.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fancybox/jquery.fancybox.css' rel='stylesheet'> --%>
    <link type="text/css" href='${cpath}/resources/plugins/fancybox/jquery.fancybox.min.css' rel='stylesheet'>
    
<!--     font-awesome -->
<%--     <link type="text/css" href='${cpath}/resources/plugins/font-awesome/css/font-awesome.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/font-awesome/css/font-awesome.min.css' rel='stylesheet'> --%>
    
<!--     fontawesome-5.15.2 -->
    <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/all.css' rel='stylesheet'>    
    <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/all.min.css' rel='stylesheet'>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/brands.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/brands.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/fontawesome.css' rel='stylesheet'> --%>
    <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/fontawesome.min.css' rel='stylesheet'>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/regular.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/regular.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/solid.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/solid.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/svg-with-js.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/svg-with-js.min.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/v4-shims.css' rel='stylesheet'> --%>
<%--     <link type="text/css" href='${cpath}/resources/plugins/fontawesome-5.15.2/css/v4-shims.min.css' rel='stylesheet'> --%>
    
<!--     isotope -->
<%--     <link type="text/css" href='${cpath}/resources/plugins/isotope/isotope.css' rel='stylesheet'> --%>
    <link type="text/css" href='${cpath}/resources/plugins/isotope/isotope.min.css' rel='stylesheet'>
    
<!--     menuzord -->
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/css/font-awesome.css" rel="stylesheet"> --%>
    <link type="text/css" href="${cpath}/resources/plugins/menuzord/css/menuzord.css" rel="stylesheet">
    <link type="text/css" href="${cpath}/resources/plugins/menuzord/css/menuzord-animations.css" rel="stylesheet">
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-border-bottom.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-border-boxed.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-border-left.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-border-top.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-border-top-bottom.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-bottom-trace.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-boxed.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-colored.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-dark.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-gradient.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-rounded-boxed.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-shadow.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-strip.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-subcolored.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/menuzord/skins/menuzord-top-bottom-boxed-border.css" rel="stylesheet"> --%>
    
<!--     no-ui-silder -->
<%--     <link type="text/css" href="${cpath}/resources/plugins/no-ui-slider/nouislider.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/no-ui-slider/nouislider.min.css" rel="stylesheet"> --%>
    
<!--     owl-carousel -->
    <link type="text/css" href="${cpath}/resources/plugins/owl-carousel/owl.carousel.min.css" rel="stylesheet">
    <link type="text/css" href="${cpath}/resources/plugins/owl-carousel/owl.theme.default.min.css" rel="stylesheet">
    
<!--     rateyo -->
<%--     <link type="text/css" href="${cpath}/resources/plugins/rateyo/jquery.rateyo.css" rel="stylesheet"> --%>
    <link type="text/css" href="${cpath}/resources/plugins/rateyo/jquery.rateyo.min.css" rel="stylesheet">
    
<!--     revoltion -->
    <link type="text/css" href='${cpath}/resources/plugins/revolution/css/settings.css' rel='stylesheet'>
    
<!--     select2 -->
<%--     <link type="text/css" href="${cpath}/resources/plugins/select2/css/select2.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"> --%>
    
<!--     selectric -->
    <link type="text/css" href="${cpath}/resources/plugins/selectric/selectric.css" rel="stylesheet">
    
<!--     slick -->
<%--     <link type="text/css" href="${cpath}/resources/plugins/slick/slick.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/plugins/slick/slick-theme.css" rel="stylesheet"> --%>
    
    
    <!-- CUSTOM CSS -->
    <link type="text/css" href="${cpath}/resources/css/style.css" rel="stylesheet">
    <link type="text/css" href="${cpath}/resources/css/star.css" id="option_style" rel="stylesheet">
<!--     아래는 id 설정 있는지 다시 봐야 한다 -->
<%--     <link type="text/css" href="${cpath}/resources/css/star.rtl.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/css/star-color1.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/css/star-color2.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/css/star-color3.css" rel="stylesheet"> --%>
<%--     <link type="text/css" href="${cpath}/resources/css/star-color4.css" rel="stylesheet"> --%>

    <!-- GOOGLE FONT -->
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700' rel='stylesheet'>

    <!-- FAVICON -->
    <link rel="shortcut icon" type="image/png" href="${cpath}/resources/img/favicon.png"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<!-- summernote를 위해서 추가해야 할 부분 -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<script type="text/javascript" src="${cpath}/resources/summernote/summernote-lite.js"></script>
	<script type="text/javascript" src="${cpath}/resources/summernote/lang/summernote-ko-KR.js"></script>
	<link type="text/css" rel="stylesheet" href="${cpath}/resources/summernote/summernote-lite.css">
	
</head>