<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<section class="py-10" style="display: flex;">   
    <div class="container" style="box-sizing: border-box; width: 30%;">
   </div>
   
   <div class="container" style="box-sizing: border-box; margin-right: 10px;" align="center">
     <div class="row d-flex justify-content-center">
      <div class="main-wrapper single-package-right-sidebar">
        </div>
        </div>
    <div class="col-md-7 col-lg-8">
     <div class="page-title-content" style="box-sizing: border-box;">
       <div class="text-black mb-0 float-left" style="text-align:left">${tsc_name }  >  ${place_name }</div>
          <div class="">
            <h2 class="text-uppercase text-black font-weight-bold" style="text-align:left;">${vo.ticket_title }</h2>
          </div>
         <div class="text-black mb-0 mt-3" style="text-align:left">
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
         
         
            <hr class="mt-3" style="background:gray;">
            
            <c:if test="${vo.ticket_confirmation != null}">
               <div style="width:100%;">
                  <img src="${cpath}/resources/icon/ic2.png" width="25">
               <strong class="fs-5">${vo.ticket_confirmation}</strong> 구매 즉시 예약 확정 (일부 상품 이용일 추가 예약 필요)
               </div>
            </c:if>
            </div>
            <hr style="background:gray;">
            
            <div align="left">
               <c:forEach var="tij" items="${tij_list }">
                  <div>
                  <img src="${path }${tij.ti_img}" width="40">
                  ${tij.tid_value}
               </div>
            </c:forEach>
            <c:if test="${vo.ticket_valid != null }">
            <c:set var="val" value="${vo.ticket_valid }"/>
               <div align="left">
                     <img src="${cpath}/resources/icon/ic3.svg">
                  유효기간 ${fn:substring(val, 0, 10) }
               </div>
            </c:if>
         </div>
            
            <hr style="background:gray;">
            
            
            <c:choose>
               <c:when test="${vo.ticket_precautions eq null}">
               </c:when>
               <c:otherwise>
                  <div class="media flex-column flex-lg-row align-items-lg-center border rounded p-4 mb-2" style="width:100%;">
                  <p align="left">${vo.ticket_precautions }</p>
                  </div>
               </c:otherwise>
            </c:choose>
      </div>
         
            
            <!-- ticketOption -->
            <div align="left" class="mb-3">
               <h3 class="mt-8" style="font-weight:800; display:inline-block;">티켓 선택</h3>
               <input type="button" onclick="document.location.href='${cpath }/admin/ticketOption/writeForm/${vo.ticket_no }/${to_vo.to_type}'" value="추가">
         </div>   
   
         <c:forEach var="to" items="${toList }">
         <div class="media flex-column flex-lg-row align-items-lg-center border p-2 border d-flex justify-content-between" style="display:flex; width:100%;">
            <div style="margin: 10px">
               <a class="text-left" href='${cpath}/admin/ticketOption/updateForm/${to.to_no}'>
               ${to.to_title }</a>
            </div>
            <div>
            ${to.to_content }
            </div>
            <div style="margin-left:10px;">
               ${to.to_price }원
            </div>
            <div>
               <input type="button" onclick="document.location.href='${cpath }/admin/ticketOption/deleteContent/${vo.ticket_no}/${to.to_no }'" value="삭제">
            </div>
         </div>
         </c:forEach>
      
         <div class="mt-5" >
          <h3 class="mt-8" style="font-weight:800; text-align: left;">상세 내용</h3>
         <c:forEach var="vo" items="${multiImg }">
            <div>
               <img src="${cpath }/resources/upload/product/ticket/${vo.img_name}" width="400" style="vertical-align:middle;">
            </div>
         </c:forEach>
         </div>
         
            <div class="m-5"></div>
   
         
           <div class="media flex-column flex-lg-row align-items-lg-center p-4">
            <p align="left">${vo.ticket_user }</p>
         </div>
               
           <hr style="background:gray;">
           
            <div class="media flex-column flex-lg-row align-items-lg-center p-4">
            <p align="left">${vo.ticket_refund }</p>
         </div>
   
         <hr style="background:gray;">
   
            <div align="center">
               <h3 class="mt-8" style="font-weight:800; text-align: left;">메인 이미지</h3>
            <img src="${cpath }/resources/upload/product/ticket/mainimg/${vo.ticket_img}" width="400"><br>
            <a href="${cpath }/resources/upload/product/ticket/mainimg/${vo.ticket_img}" download>${vo.ticket_img }</a>
         </div>
           <div class="d-flex mb-6" class="text-left">
            <h4 class="text-uppercase mb-0">
              <span class="me-3">Reviews
               <c:if test="${review != null}">
                 (${review.star})
               </c:if>
            </span>
            
            <c:if test="${review != null}">
               <c:forEach begin="1" end="5" step="1" varStatus="vs">
                       <c:if test="${vs.index <= review.star}">
                     <span class="text-warning">
                              <i class="fa fa-star" aria-hidden="true"></i>
                            </span>
                       </c:if>
                   </c:forEach>
            
            </c:if>
            
            </h4>
          </div>
          
         <c:choose>
            <c:when test="${empty reviewList}"></c:when>
            <c:otherwise>
               <c:forEach var="r" items="${reviewList}">
               <div class="media mb-6 review-card">
                  <div class="media-body" >
                  <c:forEach begin="1" end="5" step="1" varStatus="vs">
                          <c:if test="${vs.index <= r.review_star}">
                        <span class="text-warning">
                                 <i class="fa fa-star" aria-hidden="true"></i>
                               </span>
                          </c:if>
                      </c:forEach>
                      <span> ${r.review_uname}</span>
                       <div class="review-text">
                       ${r.review_regdate}| 상품명
                       </div>
                      <p > ${r.review_content}</p>
                       </div>
                     </div>
               </c:forEach>
            
            </c:otherwise>
         </c:choose>
         
         <div class="mt-5" align="center">
               <button type="button" onclick="document.location.href='${cpath }/admin/ticket/listForm'">목록</button>
            </div>
       </div> 
    </div>
    <div class="container" style="box-sizing: border-box;">
       <div class="col-md-6 col-lg-5 order-2">
           <form class="" action="index.html" method="GET">
             <div class="card border">
               <div class="form-group">
                 <div align="center">
                    <label for="inputTime" class=""><strong>${to_price }</strong>원부터</label>
                    <br>
                    <button type="button" onclick="location.href='';"
                     class="btn btn-hover btn-lg btn-block btn-outline-secondary text-uppercase"><span class="text-left">티켓 선택</span>
                      </button>
                      <div class="mt-4">구매 후 즉시 확정됩니다.</div> 
                 
                    <button type="button" onclick="location.href='';"
                      class="btn btn-hover btn-lg btn-block btn-outline-secondary text-uppercase m-3">
                         <c:if test="${map eq null }">
                           <a href="#">
                              <img class="position-absolute top-0 end-0"src="${cpath}/resources/icon/dataimagesvg+xm.svg" style="height: 30px;">
                           </a>
                        </c:if>
                        <div>
                         <span class="text-left">
                         <c:if test="${map ne null }">
                           <c:forEach var="i" items="${map }">
                                 <c:if test="${vo.ticket_no == i.key }">
                                    <c:choose>
                                      <c:when test="${i.value == true }">
                                         <a href="#">
                                             <img class="" src="${cpath}/resources/icon/datafullimagesvg+xm.svg" style="height: 30px;">
                                          </a>
                                      </c:when>
                                      <c:otherwise>
                                         <a href="#">
                                             <img class="" src="${cpath}/resources/icon/dataimagesvg+xm.svg" style="height: 30px;">
                                          </a>
                                      </c:otherwise>
                                   </c:choose>
                                 </c:if> 
                          </c:forEach>
                       </c:if>
                       위시리스트에 담기</span>
                       </div>
                    </button>    
                    <button type="button" onclick="location.href='${cpath}/ticket/payment';"
                   class="btn btn-hover btn-lg btn-block btn-outline-secondary text-uppercase"><span class="text-left">결제하기</span>
                 </button>    
                   <hr style="background:gray; width:100%;">
                 </div>
              </div>
            </div>
          </form>
        </div>
   </div>
</section>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>