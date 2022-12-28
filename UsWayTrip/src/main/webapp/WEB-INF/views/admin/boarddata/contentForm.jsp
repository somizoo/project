<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${bdpath }/deleteForm/${bdvo.board_no}/${bdvo.bd_no}';
	}
	
</script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<!-- 	경계선 -->
	<div style="height:100px"></div>
	
<!-- ====================================
———	PAGE TITLE
===================================== -->
<section class="page-title" style="padding-top: 17%">
  <div class="page-title-img bg-img" style="background-image: url(${pageContext.request.contextPath}/resources/img/pages/boardbackground.png);">
    <div class="container">
      <div class="row align-items-center justify-content-center" style="height: 200px;">
        <div class="col-lg-6">
          <div class="page-title-content">
            <div class="title-border">
              <h2 class="text-uppercase text-black font-weight-bold">${bdvo.bd_title }</h2>
            </div>
            <p class="text-white mb-0"></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
  
  <!-- ====================================
———	BOOKING SECTION
===================================== -->
<section class="bg-smoke py-8 py-lg-9">
  <div class="container">
	<tr>
		<td>
			<span style="padding-left: 30%" class="me-1"><i class="far fa-calendar-alt" aria-hidden="true"></i></span>
			<span>Date:</span>&nbsp;&nbsp;&nbsp;
			<span class="text-gray-color">${bdvo.bd_upload }</span><br><br><br><br><br>
		</td>
	</tr>
	<tr>
		<td>
			<p style="padding-left: 30%" class="mb-0">${bdvo.bd_content }</p><br><br>
		</td>
	</tr>
      <div class="card-footer bg-transparent">
        <div class="row">
          <div style="padding-left: 30%">
			<!-- 11.26 수정 버튼 추가 -->
			<input type="button" value="수정" onclick="location.href='${bdpath }/updateForm/${bdvo.board_no }/${bdvo.bd_no}'">
			<input type="button" value="삭제" onclick="deleteAction()">
		</div>
        </div>
      </div>
  </div>
</section>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>