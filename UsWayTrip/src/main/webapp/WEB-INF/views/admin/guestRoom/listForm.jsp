<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function deleteAction(no) {
		var check = confirm("삭제 하시겠습니까?");
	
		if(!check){
			return;
		}
	
		location.href = '${grPath}delete/'+ no +"/" +${lodging.lodging_no };
	}


</script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center" style="padding-top:180px;">
	${lodging.lodging_name }
	<h3>객실 리스트</h3>
	<button type="button" onclick="location.href='${grPath}write/${lodging.lodging_no }'" >객실 등록</button>
	<c:choose >
		<c:when test="${empty grList}">
			<p style="font-weight: bold;">등록된 객실이 없습니다.</p>
		</c:when>
			
		<c:otherwise>
			<c:forEach var="gr" items="${grList}" >
				<div>
					객실 번호 | ${gr.gr_no }
					<span><img src="${imgPath}${gr.gr_mainimg }" width="100px" height="100px"></span>
					객실 이름: <a href="${grPath }content/${gr.gr_no}">${gr.gr_name }</a>
					인원 : 기준인원 ${gr.gr_ap} / 최대인원${gr.gr_mp }
					침대 갯수 : 
					<c:forEach var="bed" items="${grbedAllList}" >
						<c:if test="${gr.gr_no == bed.gr_no}">
							${bed.bed_type} ${bed.grb_cnt} 
						</c:if>
					</c:forEach>
						<c:forEach var="am" items="${grAmAllList }"><!-- 객실이 가지고 있는편의시설  -->
							<c:if test="${gr.gr_no == am.gr_no}">${am.amenities_name} </c:if>
						</c:forEach>
						 ${gr.ot_type}
						 객실 갯수 ${gr.gr_count}
					</a>
					<button type="button" onclick="location.href='${grPath}content/${gr.gr_no}'" >수정</button>
					<button type="button" onclick="deleteAction(${gr.gr_no})">삭제</button>
				</div>
				<hr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<button type="button" onclick="location.href='${lodPath}listForm'" >숙소 목록</button>
	<button type="button" onclick="location.href='${lodPath}contentForm/${lodging.lodging_no }'">숙소 상세보기</button>
</div>		
<!-- 	경계선 -->
	
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>