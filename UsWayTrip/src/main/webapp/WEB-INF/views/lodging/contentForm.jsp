<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script>

	$(function(){

		$('span.label').on('DOMSubtreeModified propertychange', function(){
			if($(this).text() != ""){
				var value = $(this).text();
				$("#gro_no option").each(function(){
					if(value == $(this).text()){
						var price = $(this).data("price") * $("#payment_people").val();
						$("#payment_price").val(price)
						$("#price").text(price+"원")
						$("#gr_no").val($(this).data("no"))
					}				
				})	
			}			
		})
		
		$("#decrease,#increase").on("click", function(){
			var text = $('span.label').text();
			$("#gro_no option").each(function(){
				if(text == $(this).text()){
					var price = $(this).data("price") * $("#payment_people").val();
					$("#payment_price").val(price)
					$("#price").text(price+"원")
				}				
			})	
		})
	})
	
	function check(){
		if($("#checkIn").val() == ""){
			alert("체크인 날짜를 선택하세요");
			$("#checkIn").focus();
			return false;
		}else if($("#checkOut").val() == ""){
			alert("체크아웃 날짜를 선택하세요");
			$("#checkOut").focus();
			return false;
			
		}else if($("#gro_no").val() == "" || $("#gr_no").val() == ""){
			alert("객실 옵션을 선택하세요");
			$("#gro_no").focus();
			return false;
		}else if($("#payment_people").val() < 1){
			alert("인원을 입력하세요 ")
			$("#payment_people").focus();
			return false;
		}else if($("#payment_price").val() == ""){
			alert("가격에 오류가 있습니다. 다시 설정하세요")
			return false;
		}
		
	}
	
</script>
<section class="py-10">
  <div class="container">
    <div class="row">
      <div class="col-md-5 col-lg-4 order-2">
        <form class="" action="${cpath }/paymentForm" method="POST">
          <input type="hidden" name="product_no" value="${lodPlaceOne.lodging_no }" />
          <input type="hidden" name="product_sort" value="l" />
          <input type="hidden" name="member_no" value="${login }" />
          <input type="hidden" name="gr_no" id="gr_no" value="" />
          <input type="hidden" name="payment_price" id="payment_price" value="" />
          <input type="hidden" name="days" value="" />
              
          <div class="card border">
            <h2 class="card-header text-uppercase text-center bg-smoke border-bottom">
              	예약
            </h2>

            <div class="card-body px-3 py-4">
              <div class="border-bottom mb-5">
                <div class="form-group mb-5">
                  <div class="row">
                    <label for="inputTime" class="col-xl-5 col-form-label text-center text-xl-end px-2">체크인:</label>

                    <div class="col-xl-7">
                      <div class="form-group form-group-icon form-group-icon-category-2 mb-0">
                        <input type="date" class="" autocomplete="off" name="checkIn" id="checkIn" value=""
                          placeholder="MM/DD/YYYY">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="form-group mb-5">
                  <div class="row">
                    <label for="inputTime" class="col-xl-5 col-form-label text-center text-xl-end px-2">체크아웃:</label>

                    <div class="col-xl-7">
                      <div class="form-group form-group-icon form-group-icon-category-2 mb-0">
                        <input type="date" class="" autocomplete="off" name="checkOut" id="checkOut" value=""
                          placeholder="MM/DD/YYYY">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="form-group mb-5">
                  <div class="row">
                    <label for="inputText" class="col-xl-5 col-form-label text-center text-xl-end px-2">객실타입:</label>
                    <div class="col-xl-7">
                      <div class="form-group mb-0">
                        <div class="select-default select-category-2">
                          <select class="select-option" name="gro_no" id="gro_no">
                          <option value="">선택</option>
                           <c:forEach var="gro" items="${groMap}">
                           	<c:forEach var="o" items="${gro.value }">
                           		<option value="${o.gro_no }" data-no="${o.gr_no }" data-price="${o.gro_price }">${o.gro_name }</option>
                           	</c:forEach>
                           </c:forEach>
                          </select>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="form-group mb-5">
                  <div class="row align-items-center">
                    <label class="control-label col-xl-5 text-center text-xl-end">인원:</label>

                    <div class="col-xl-7">
                      <div class="count-input mx-auto">
                        <a class="incr-btn" id="decrease" data-action="decrease" href="javascript:void(0)">–</a>
                        <input class="quantity" type="number" id="payment_people" name="payment_people" value="1">
                        <a class="incr-btn" id="increase" data-action="increase" href="javascript:void(0)">+</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="d-flex justify-content-between border-bottom mb-5 pb-5">
                <span class="text-uppercase h4 mb-0">가격</span>
                <span class="font-weight-bold text-primary h3 mb-0" id="price">0원</span>
              </div>

              <div class="d-grid text-center px-4">
                <button type="submit" 
                  class="btn btn-hover btn-lg btn-outline-secondary text-uppercase" onclick="return check();">
                  	예약하기 <span class="ms-4"><i class="fa fa-angle-right" aria-hidden="true"></i></span>
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
         <div class="mt-8">
         <h2 class="text-uppercase mb-5" style="display:flex; justify-content:space-between; margin:0 !important;">${lodPlaceOne.lodging_name }
         	 
	          <button type="button" onclick="location.href='javascript:void(0)';"
	              class="btn btn-hover btn-outline-secondary text-uppercase">
	             	<a href="https://www.google.com/maps/search/?api=1&query=${lodPlaceOne.lodging_lat },${lodPlaceOne.lodging_long }" target="_blank">위치보기</a>
	         </button>
	          <h5>${lodPlaceOne.lodging_grade }</h5>
         </h2>
          <p class="mb-6">
          	<c:if test="${review != null}">
          		<c:forEach begin="1" end="5" step="1" varStatus="vs">
	                 	<c:if test="${vs.index <= review.star}">
							<span class="text-warning">
                           	<i class="fa fa-star" aria-hidden="true"></i>
                         	</span>
	                    </c:if>
	             </c:forEach>
            	${review.star}(${review.count})<br>
            </c:if>
          </p>
          <hr>
          <div class="mb-5" >
            <div class="row">
              <div class="col-lg-5" style="margin-bottom: 10px;">
                 <p>
                	<img src="${cpath }/resources/img/location.svg">
                 	<c:forEach var="place" items="${placeList }" >
						<c:if test="${place.place_name == lodPlaceOne.place_name }">
						${place.place_name}
						</c:if>
					</c:forEach>
                	 ${lodPlaceOne.lodging_address}
                 </p>
              </div>

              <div class="col-lg-5">
                <p>
                	 <img src="${cpath }/resources/img/time.svg">
               	 체크인 ${lodPlaceOne.lodging_checkin} ~ 체크아웃 ${lodPlaceOne.lodging_checkout}
                </p>
              </div>
              <hr>
            </div>
          </div>
        </div>
        
      <div class="col-md-7 col-lg-8">
        <div id="package-slider" class="owl-carousel owl-theme package-slider">
          <div class="item" >
            <img class="lazyestload" data-src="${imgLoPath}${lodPlaceOne.lodging_mainimg}" src="${imgLoPath}${lodPlaceOne.lodging_mainimg}" alt="image" style="width:756px; height:400px;">
          </div>
          
          <c:forEach var="img" items="${imgs}" >
	           <div class="item" >
	            <img class="lazyestload" data-src="${imgLosPath} ${img.img_name}" src="${imgLosPath} ${img.img_name}" alt="image" style="width:756px; height:400px;">
	          </div>
		  </c:forEach>
		</div>
		
		<hr>
		
        <div class="mb-6 ">
          <c:forEach var="gr" items="${lodgrList}">
          <div class="gr-content" style="">
          <h3 class="text-uppercase mb-5 gr-title">${gr.gr_name }</h3>
         	 <div class="px-lg-2 pb-3">
	            <div class="row row-cols-2 row-cols-md-3 row-cols-lg-5">
           			<div class="col mb-2 pe-1 px-lg-1" >
            				<div class="media img-overlay">
              				   <div class="media-content" style="width:150px; height:100px">
                  			 <img class="media-img rounded  lazyestload" data-src="${imgGrPath}${gr.gr_mainimg}" src="${imgGrPath}${gr.gr_mainimg}"
                     		 alt="Generic placeholder image" style="position:absil; width:100%; height:100%; object-fit: cover;"> 
                   			<a href="${imgGrPath}${gr.gr_mainimg}" data-fancybox="gallery" class="hover-img-overlay-dark"></a> 
		                  </div>
		                </div>
		              </div>
	            <c:forEach var="img" items="${grImgMap}"><!-- 이미지 -->
	                  <c:if test="${img.key == gr.gr_no}">
	                     <c:forEach var="i" items="${img.value }">
	             			 <div class="col mb-2 pe-1 px-lg-1">
	             				<div class="media img-overlay">
	               				   <div class="media-content " style="width:150px; height:100px">
		                  			 <img class="media-img rounded lazyestload" data-src="${imgGrsPath}${i.gri_name}" src="${imgGrsPath}${i.gri_name}"
		                     		 alt="Generic placeholder image" style="position:absil; width:100%; height:100%; object-fit: cover;"> 
		                   			<a href="${imgGrsPath}${i.gri_name}" data-fancybox="gallery" class="hover-img-overlay-dark"></a> 
				                  </div>
				                </div>
				              </div>
	                    </c:forEach>
	                  </c:if>
	               </c:forEach>
	            </div>
	          </div>
	      <div style="display: flex; justify-content: space-between; flex-wrap: wrap;">
		      <div >   
	          <h4 class="info-text">
	          	기준인원 ${gr.gr_ap } / 최대인원 ${gr.gr_mp }
	          </h4>
	          <h4 class="info-text">
	          <c:forEach var="bed" items="${grBedMap}">
						<c:if test="${bed.key == gr.gr_no }">
							<c:forEach var="b" items="${bed.value }">
								<p class="info-text">${b.bed_type} ${b.grb_cnt}</p>
							</c:forEach>
						</c:if>
					</c:forEach>
	          </h4>
	          <h4 class="info-text">
	          	<c:forEach var="am" items="${gramMap }">
					<c:if test="${am.key == gr.gr_no}">
						<c:forEach var="a" items="${am.value}">
							<span class="am">${a.amenities_name}</span>
						</c:forEach>
					</c:if>
				</c:forEach>
				<span class="am">${gr.ot_type}</span>
	          </h4>
	          </div>
<!-- 	          <div> -->
<!--                 <a href=" ${grPath}${lodPlaceOne.lodging_no }/${gr.gr_no}/${o.gro_no}"class="btn btn-xs btn-outline-secondary text-uppercase">자세히</a> --!>
<!--               </div> -->
          </div> 
          
          <hr>
		  <c:set var="idx" value="0"/>
		 <c:forEach var="gro" items="${groMap}"><!-- 객실 옵션 -->
		  <c:if test="${gro.key == gr.gr_no}">
                  <c:set var="idx" value="${idx+1}"/>
                     <c:forEach var="o" items="${gro.value }">
             <div style="display: flex; justify-content: space-between; flex-wrap: wrap;" class="border-bottom">
              <div style="display: flex;   flex-direction: column;  flex-wrap: wrap;">
		          	
	          	<h5 style="display : block">  ${o.gro_name }</h5>
	          	
	            <h5 class="text-left text-lg-right" style="display : block">
	            	<c:choose>
                       <c:when test="${o.sale != 0}"> 
                          <p class="text-gray-color font-weight-bold text-capitalize"><span style="color:red">${o.coupon_figure}</span> → <span style="text-decoration : line-through;"><fmt:formatNumber value="${o.gro_price }" type="number"/>원</span></p>
                          <p class="text-gray-color font-weight-bold text-capitalize sale-text"> ${o.sale}원</p>
                          <span class="text-gray-color font-weight-bold text-capitalize coupon" style="color: #1583db !important;"> ${o.coupon_figure}쿠폰 적용가</span>
                       </c:when>
                       <c:otherwise >
                           <p class="text-gray-color font-weight-bold text-capitalize sale-text"><fmt:formatNumber value="${o.gro_price }" type="number"/>원</p>
                       </c:otherwise>
                    </c:choose>
                    <c:if test="${o. gro_bf == 'y'}">
                    	<span class="text-gray-color font-weight-bold text-capitalize bf" style="color: #137b5e !important;">조식포함</span>            	            
                    </c:if>
	            </h5>
	          </div>
<!-- 	            <div> -->
<!--                 <a href=" ${lodPlaceOne.lodging_no }/${gr.gr_no}/${o.gro_no}"class="btn btn-xs btn-outline-secondary text-uppercase">예약</a> --!>
<!--               	</div> -->
          	</div>
	         </c:forEach>
               </c:if>
               
          </c:forEach>
		</div>
		  </c:forEach>
        </div>

        <div class="mb-7 border-bottom ">
          <h2 class="text-uppercase mb-6">숙소 소개</h2>
          <p class="mb-0 lod-service">${lodPlaceOne.lodging_content}</p>
        </div>
        
        <div class="mb-7 border-bottom lod-service" >
          <h2 class=" mb-6" >체크인/체크아웃</h2>
          <p class="lod-service">
			체크인- ${lodPlaceOne.lodging_checkin}/
			체크아웃-${lodPlaceOne.lodging_checkout}
		  </p>
        </div>
        
        <div class="mb-7 border-bottom " >
          <h2 class="mb-6">편의시설</h2>
            <div style="display: flex;">
             <c:forEach var="fac" items="${lodFacs}">
                <div style="display: flex; flex-direction: column; align-items: center; margin: 5px;">
                   <span>
                      <img src="${iconPath}${fac.facilities_img}">
                   </span>
                   <span class="lod-service">
                      ${fac.facilities_name} 
                 </span>
                </div>
           </c:forEach>
          </div>
        </div>
        
        <div class="mb-7 border-bottom " >
          <h2 class="mb-6">서비스</h2>
             <div style="display: flex;">
             <c:forEach var="ser" items="${lodServices}">
                <div  style="display: flex; flex-direction: column; align-items: center; margin: 5px;">
                   <span>
                      <img src="${iconPath}${ser.service_img}">
                   </span>
                   <span class="lod-service">
                      ${ser.service_name} 
                 </span>
                </div>
           </c:forEach>
           </div>
        </div>
        
        <div class="mb-7 border-bottom ">
          <h2 class="text-uppercase mb-6">이용안내</h2>
          <p class="mb-0 lod-service">${lodPlaceOne.lodging_info}</p>
        </div>
        <div class="mb-7 border-bottom ">
          <h2 class="text-uppercase mb-6">취소 및 환불규정</h2>
          <p class="mb-0 lod-service">${lodPlaceOne.lodging_refund}</p>
        </div>

            
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
						<div class="media-body  review-card-text" >
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
	                   <p class="review-context-text"> ${r.review_content}</p>
	                    </div>
	                  </div>
					</c:forEach>
				
				</c:otherwise>
			</c:choose>
      </div>
    </div>
  </div>
</section>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>