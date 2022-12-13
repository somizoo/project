<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>


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
              <h2 class="text-uppercase text-black font-weight-bold">UsWayTrip > ${vo.board_name}</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



<section class="bg-smoke py-8 py-lg-9">
  <div class="container">
    <div class="text-center section-title">
      <h2 class="text-uppercase font-weight-bold position-relative">
        <span class="bg-smoke">
          ${vo.board_name}
        </span>
      </h2>
    </div>
      	<c:forEach var="dto" items="${list}">
			<tr>
				<td>
					<a class="text-capitalize text-left" style="padding-left: 35%" href="${bdpath}contentForm/${b_no}/${dto.bd_no}">${dto.bd_title}</a><br><br>
				</td>
			</tr>
		</c:forEach>
	<tr>
		<td>
			<div style="padding-left: 40%">
				<button onclick="document.location.href='${bdpath }detailWriteForm/${b_no }'">공지사항 작성</button>
			</div>
		</td>
	</tr>
	<br><br>
	<div align="center">
		<tr>
			<td>도움이 더 필요하신가요?</td>
			<button> 문의내역</button>
		</tr>
	</div>
</div>
</section>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>