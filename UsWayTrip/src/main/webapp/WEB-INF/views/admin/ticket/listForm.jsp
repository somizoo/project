<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>


<section class="page-title">
  <div class="page-title-img bg-img bg-overlay-darken" style="background-image: url(${pageContext.request.contextPath}/resources/img/pages/page-title-bg6.jpg);">
    <div class="container">
      <div class="row align-items-center justify-content-center" style="height: 200px;">
        <div class="col-lg-6">
          <div class="page-title-content">
            <div class="title-border">
              <h2 class="text-uppercase text-white font-weight-bold">Tour Packages</h2>
            </div>
            <p class="text-white mb-0"></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



<section class="bg-smoke py-10">
  <div class="container">
    <div class="row">
      <c:choose>
         <c:when test="${empty list }">
            <tr>
               <th align="center" colspan="9">상품이 없습니다</th>
            </tr>
         </c:when>
         <c:otherwise>
            <c:forEach var="vo" items="${list }">
                  <div class="col-md-6 col-lg-4 mb-5">
                      <div class="card card-hover position-relative">
                         <a href="${ cpath }/admin/ticket/content/${vo.ticket_no}"> <!--  class="position-relative" -->
                           <img class="card-img-top lazyestload position-relative overflow-hidden" data-src="${imgPath}${vo.ticket_img }" src="${imgPath}${vo.ticket_img }" alt="Card image cap">
                        </a>
                        <c:if test="${map eq null }">
                           <a href="#">
                              <img class="position-absolute top-0 end-0"src="${cpath}/resources/icon/dataimagesvg+xm.svg" style="height: 30px;">
                           </a>
                        </c:if>
                        <c:if test="${map ne null }">
                           <c:forEach var="i" items="${map }">
                                 <c:if test="${vo.ticket_no == i.key }">
                                    <c:choose>
                                      <c:when test="${i.value == true }">
                                         <a href="#">
                                             <img class="position-absolute top-0 end-0" src="${cpath}/resources/icon/datafullimagesvg+xm.svg" style="height: 30px;">
                                          </a>
                                      </c:when>
                                      <c:otherwise>
                                         <a href="#">
                                             <img class="position-absolute top-0 end-0" src="${cpath}/resources/icon/dataimagesvg+xm.svg" style="height: 30px;">
                                          </a>
                                      </c:otherwise>
                                   </c:choose>
                                 </c:if> 
                          </c:forEach>
                       </c:if>      
                        <small class="position-absolute top-0 end-55 m-3 p-1 border bg-gray">
                          <ul class="list-unstyled d-flex text-white font-weight-bold mb-0">
                            <li class="border-right border-white pe-2 float-right">${vo.ticket_priceSticker }</li>
                          </ul>
                        </small>
                        
                       <div class="card-body px-4">
                      
                        <div class="mb-5" align="left">${vo.tsc_name } &nbsp · &nbsp ${vo.place_name }</div>
                        <h5>
                          <a href="${ cpath }/admin/ticket/content/${vo.ticket_no}" class="card-title text-uppercase">${vo.ticket_title }</a>
                        </h5>
                        
                                   <c:choose>
               <c:when test="${vo.review_star == 0}">
                  <img src="${cpath}/resources/icon/ic1.svg" width="25">후기 이벤트
               </c:when>
               <c:otherwise>
               <ul class="list-unstyled d-flex mt-auto text-warning mb-0">
                  <c:forEach begin="1" end="${vo.review_star }">
                               <li>
                                 <i class="fa fa-star me-1" aria-hidden="true"></i>
                               </li>
                  </c:forEach>
                 <li>
                   <p> &nbsp ${vo.review_star } (${vo.cnt })</p>
                 </li>
               </ul>
               </c:otherwise>
            </c:choose>
                        <div class="d-flex justify-content-between align-items-center">
                          <div>
                            <span class="text-primary">${vo.to_price }원 </span><span class="mb-0 text-capitalize">/ 1인</span>
                          </div>
                          <div>
                             <c:if test="${!empty vo.ticket_confirmation}">
                                 <p>${vo.ticket_confirmation }</p>
                             </c:if>
                             <input type="button" data-bs-target="#inquiry" class="btn btn-xs btn-outline-secondary text-uppercase" value="수정" onclick="document.location.href='${ cpath }/admin/ticket/updateForm/${vo.ticket_no }'">
                        <a href="${cpath}/admin/ticket/deleteForm/${vo.ticket_no }" onclick="return confirm('삭제 하시겠습니까??');">삭제</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  </c:forEach>
            </c:otherwise>
         </c:choose>
       </div>      
     </div>
  
<div align="center">
   <input type="button" value="추가" onclick="document.location.href='${cpath}/admin/ticket/writeForm'">
   <button type="button" onclick="document.location.href='${cpath }/admin/ticketSubCategory/listForm/'">카테고리 추가</button>
   <button type="button" onclick="document.location.href='${cpath }/admin/ticketEvent/listForm/'">이벤트 추가</button>
   <button type="button" onclick="document.location.href='${cpath }/admin/ticketInfo/listForm/'">정보 추가</button><br>
</div>
  
</section>




<%@ include file="/WEB-INF/views/layout/footer.jsp" %>