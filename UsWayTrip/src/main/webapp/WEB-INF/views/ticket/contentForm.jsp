<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>

$(function(){
    $("#paymentBtn").on("click", function(){
      $("#payment").submit(); 
    })
    
    
    //위시리스트 저장
    $("#wishListWrite").on("click",function(){	
    	let value = $(this);
			$.ajax({
				type : "POST",
				url : "${cpath}/wishList/write",
				data : {"product_no" : "${vo.ticket_no}", "product_sort" : "t"},
				success:function(data){
					if(data == 1){
						alert("로그인 후 이용가능합니다.")
						window.location.href="${cpath}/member/loginForm"
					}else if(data == 2){
						alert("위시리스트 저장 완료");
						value.children("img").attr("src", "${cpath}/resources/icon/datafullimagesvg+xm.svg");
						value.attr("id", "wishListDelete")
						window.location.reload();
					}else if(data == 3){
						alert("위시리스트 저장 실패")
					}
					
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("위시리스트 저장 실패2");				
				}
			})
		})
		
	//위시리스트 삭제
    $("#wishListDelete").on("click",function(){	
    	let value = $(this);
			$.ajax({
				type : "POST",
				url : "${cpath}/wishList/delete",
				data : {"product_no" : "${vo.ticket_no}", "product_sort" : "t"},
				success:function(data){
					if(data == 2){
						alert("위시리스트 삭제 완료");
						value.children("img").attr("src", "${cpath}/resources/icon/dataimagesvg+xm.svg");
						value.attr("id", "wishListWrite")
						window.location.reload();
					}else if(data == 3){
						alert("위시리스트 삭제 실패")
					}
					
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("위시리스트 삭제 실패2");				
				}
			})
		})
   
})


</script>


<section class="py-10" style="display: flex;">   
    <div class="container" style="box-sizing: border-box; width: 30%;">
   </div>
   
   <div class="container" style="box-sizing: border-box; margin-right: 10px;" align="center">
     <div class="row d-flex justify-content-center">
      <div class="main-wrapper single-package-right-sidebar">
        </div>
        </div>
    <div class="col-md-9 col-lg-10">
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
                  <img src="${path }${tij.ti_img}" width="40">${tij.ti_img}
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
         </div>   
         
         <form method="post" id="payment" name="payment" action="${cpath }/paymentForm">
         <input type="hidden" name="product_no" value="${vo.ticket_no }" />
         <input type="hidden" name="product_sort" value="t" />


         <c:forEach var="to" items="${toList }">
         <input type="hidden" name="to_nums" value="${to.to_no }" />
         <div class="flex-column flex-lg-rowborder p-2 border" >
            <div style="margin: 10px">
               <a class="text-left" href='${cpath}/ticketOption/updateForm/${to.to_no}'>
               ${to.to_title }</a>
            </div>
            <div>
            ${to.to_content }
            </div>
            
            <div>
               ${to.to_price }원
            </div>
            <div class="count-input mx-auto">
                  <a class="incr-btn" data-action="decrease" href="javascript:void(0)">–</a>
                  <input class="quantity" type="number" value="0" name="cnts" readonly>
                  <a class="incr-btn" data-action="increase" href="javascript:void(0)">+</a>
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
         
         <!-- 리뷰 -->
            <div class="m-5"></div>
   
         
           <div class="media flex-column flex-lg-row align-items-lg-center p-4">
            <p align="left">${vo.ticket_user }</p>
         </div>
               
           <hr style="background:gray;">
           
            <div class="media flex-column flex-lg-row align-items-lg-center p-4">
            <p align="left">${vo.ticket_refund }</p>
         </div>
   
         <hr style="background:gray;">
         
          <div class="d-flex align-items-center mb-6">
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
                  <div >
                  <c:forEach begin="1" end="5" step="1" varStatus="vs">
                          <c:if test="${vs.index <= r.review_star}">
                        <span class="text-warning">
                                 <i class="fa fa-star" aria-hidden="true"></i>
                               </span>
                          </c:if>
                      </c:forEach>
                      <span> ${r.review_uname}</span>
                       <div class="review-text">
                       ${r.review_regdate}
                       </div>
                      <p class="review-context-text"> ${r.review_content}</p>
                       </div>
                     </div>
               </c:forEach>
            
            </c:otherwise>
         </c:choose>
         
         <div class="mt-5" align="center">
               <button type="button" onclick="document.location.href='${cpath }/ticket/listForm'">목록</button>
            </div>
       </div> 
    </div>
    <div class="container" style="box-sizing: border-box;">
       <div class="col-md-6 col-lg-5 order-2">
           
             <div class="card border">
               <div class="form-group">
                 <div align="center">
                    <label for="inputTime" class="mt-3" ><strong>${to_price }</strong>원부터</label>
                    <br>
                      <div class="mt-4">구매 후 즉시 확정됩니다.</div> 
                 
                    <button type="button" onclick="location.href='javascript:void(0)';"
                      class="btn btn-hover btn-lg btn-block btn-outline-light text-uppercase m-3"  style="background-color:rgb(255,204,153);">
                         <c:if test="${empty map }">
                           <a href="javascript:void(0);" id="wishListWrite">
                              <img src="${cpath}/resources/icon/dataimagesvg+xm.svg" style="height: 30px;">
                           </a>
                        </c:if>
                        <div>
                         <span class="text-left">
                         <c:if test="${map ne null }">
                           <c:forEach var="i" items="${map }">
                                 <c:if test="${vo.ticket_no == i.key }">
                                    <c:choose>
                                      <c:when test="${i.value == true }">
                                         <a href="javascript:void(0);" id="wishListDelete">
                                             <img class="" src="${cpath}/resources/icon/datafullimagesvg+xm.svg" style="height: 30px;">
                                          </a>
                                      </c:when>
                                      <c:otherwise>
                                         <a href="javascript:void(0);" id="wishListWrite">
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
                    <button type="submit"  class="btn btn-hover btn-lg btn-block btn-outline-secondary text-uppercase"><span class="text-left">결제하기</span>
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