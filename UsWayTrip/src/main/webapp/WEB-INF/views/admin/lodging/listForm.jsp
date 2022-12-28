<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script>
    
    function deleteAction(lodging_no) {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
// 		여기 부분 수정 필요
		location.href = '${lodgingAPath}delete/'+lodging_no;
// 		location.href = ${groPath}+ 'delete/' +${gro.gro_no };
	}
    
    </script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

	<div align="center" style="padding-top:180px;">
		<h3>숙소 목록</h3>
		<table>
			<tr >
            <th>번호</th>
            <th>이름</th>
            <th>성급</th>
            <th>주소</th>
            <th>대표 이미지</th>
            <th>금액</th>
            <th>회원 번호</th>
            <th>회원 이름</th>
            <th colspan="2">비고</th>
            
         </tr>
			<c:choose >
				<c:when test="${empty lodgingList }">
					<tr>
						<td colspan="14" align="center"><span style="font-weight: bold;">등록된 숙박업체가 없습니다.</span></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="data" items="${lodgingList }">
						<tr>
							<td>${data.lodging_no }</td>
							<td><a href="${cpath}/admin/lodging/contentForm/${data.lodging_no}">${data.lodging_name }</a></td>
							<td>
								<c:set var="idx" value="0"/>
								<c:forEach var="rv" items="${reviewMap}">
									<c:if test="${rv.key == data.lodging_no }">
										<c:set var="idx" value="${idx+1}"/>
										${rv.value.star} (${rv.value.count})
									</c:if>
								</c:forEach>
								<c:if test="${idx == 0 }">
									후기 이벤트
								</c:if>
							</td>
							<td>${data.lodging_grade }</td>
							<td>${data.lodging_address }</td>
							
							<td><img src="${imgPath}${data.lodging_mainimg }" width="100px" height="100px"> </td>
							<td>
								<c:set var="idx1" value="0"/>
								<c:forEach var="pr" items="${priceList}">
									<c:choose>
										<c:when test="${pr.product_no == data.lodging_no && pr.sale != 0}">
											<c:set var="idx1" value="${idx1+1}"/>
											${pr.coupon_figure} → ${pr.cost}<br>
											${pr.sale}<br>
											${pr.coupon_figure}쿠폰 적용가
										</c:when>
										<c:when test="${pr.product_no == data.lodging_no}">
											<c:set var="idx1" value="${idx1+1}"/>
											${pr.cost}원
										</c:when>
									</c:choose>
								</c:forEach>
								<c:if test="${idx1 == 0 }">
									준비중
								</c:if>
							</td>
							<td>${data.member_no }</td>
							<td>${data.member_name }</td>
							<!-- -0000000000 -->
							
							<td><button type="button" onclick="location.href ='${lodgingAPath}contentForm/${data.lodging_no}'">수정</button></td>
							<td><button type="button" onclick="deleteAction(${data.lodging_no})">삭제</button></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<button onclick="location.href='${lodgingAPath}insertForm'">등록하기</button>	
		
	</div>

<!-- 	경계선 -->
	<div style="height:100px"></div>
<!-- 페이징 -->
<section class="pt-5 pt-md-7">
  <div class="container">
    <nav aria-label="Page navigation">
      <ul class="pagination justify-content-center align-items-center">
<%--         	<c:set var="lodgingUPath" value="${lodgingUPath }"/> --%>
<%--         	<c:set var="paging.begin" value="${paging.begin -1 }"/> --%>
        	
	        <li class="page-item">
	          <a class="page-link" href="${paging.prev ? lodgingAPath += 'listForm?page=' += (paging.page - 1) : '#'}">
	            <i class="fas fa-long-arrow-alt-left d-none d-md-inline-block me-md-1" aria-hidden="true" ></i> Previous
	          </a>
	        </li>
        
    	<c:forEach var="i" begin="${paging.begin}" end="${paging.end }" step="1">
    		<c:choose>
    			<c:when test="${i == paging.page}">
    				<li class="page-item">
			          <a class="page-link active">${i}</a>
			        </li>
    			</c:when>
    			<c:otherwise>
    				<li class="page-item">
			          <a class="page-link"  href="${lodgingAPath}listForm?page=${i}">${i }</a>
			        </li>
    			</c:otherwise>
    		</c:choose>
    	</c:forEach>
         <li class="page-item">
          <a class="page-link" href="${paging.next ? lodgingAPath += 'listForm?page=' += (paging.page + 1): '#' }">Next
            <i class="fas fa-long-arrow-alt-right d-none d-md-inline-block ms-md-1" aria-hidden="true"></i>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</section>

</section>



  </div><!-- element wrapper ends -->

	
		
	
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>	
	