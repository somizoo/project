<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(f) {
		if(f.word.value ==""){
			alter("검색어를 입력해주세요.")
			f.word.focus();
			return false;
		}else if(f.dateRange.value = ""){
			alter('날짜를 선택해주세요.');
			f.dateRange.focus();
			return false;
		}else{
			return true;
		}
	}
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	
<div class="main-wrapper hotels-list-left-sidebar">

<!-- ====================================
———	PACKAGES SECTION
===================================== -->
<section class="bg-smoke py-10">
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="row">
          <div class="col-md-6 col-lg-12">
            <div class="mb-6 bg-white px-3 py-6 border-top border-top-5 border-primary rounded">
              <h4 class="text-uppercase font-weight-bold">Search</h4>

            <!-- -----------!!!!!!!!!!!!!!!검색창 -->
               <form class="" action="${cpath}/lodging/listForm" method="get" onsubmit="return check(this)">
                <div class="mb-5">
                  <input type="text" class="form-control border-top-0 border-start-0 border-end-0 ps-0" 
                      aria-describedby="textHelp" placeholder="지역, 숙소 이름을 찾아보세요" id = "word" name="word" value="${map.word == null? '': map.word}">
                <!-- 																							검색어 띄워주기	-->
                </div>

                <div class="form-group form-group-icon form-group-icon-dark mb-5">
                  <input type="date" class="form-control daterange-picker sidebar-daterange-picker text-uppercase" 
                  autocomplete="off" id = "dateRange1" name="dateRange1" placeholder="Check in" value="${map.dateRange1}"/>
                </div>

                <div class="form-group form-group-icon form-group-icon-dark mb-5">
                  <input type="date" class="form-control daterange-picker sidebar-daterange-picker text-uppercase"
                    name="dateRange2" id = "dateRange2" autocomplete="off" value="${map.dateRange2}" placeholder="Check out" />
                </div>   

                <div class="form-group mb-5">
                  <div class="row align-items-center">
                    <label
                      class="control-label count-control-label col-5 col-lg-12 col-xl-4 text-uppercase mb-0 mb-lg-4 mb-xl-0 text-lg-center">Adults</label>
                
                    <div class="col-7 col-lg-12 col-xl-7">
                      <div class="count-input me-0 mx-lg-auto me-xl-0">
                        <a class="incr-btn" data-action="decrease" href="javascript:void(0)">–</a>
                        <input class="quantity" id = "adult_count" type="number" name="adult_count" value="${map.adult_count == null? 1: map.adult_count}">
                        <a class="incr-btn" data-action="increase" href="javascript:void(0)">+</a>
                      </div>
                    </div>
                  </div>
                </div>

              
              <!-- ----------------------검색 폼 -->
           

          
              <h4 class="text-uppercase font-weight-bold">Filter by</h4>
				<!-- ---------------------------------폼 -->

              <div class="accordion" id="accordionOne">
                <div class="card">
                  <div class="card-header" id="headingOne">
                    <h5 class="icon-bg" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true"
                      aria-controls="collapseOne">
                      <span>종류</span>
                    </h5>
                  </div>
            
                  <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionOne">
                    <div class="card-body">
                    
                     <c:forEach var="type" items="${lodTypeList }" >
						<div class="form-check custom-form-check">
							<c:choose>
								<c:when test="${type.lt_no == map.lt_no }">
									<input class="form-check-input" type="radio" name="lt_no" checked="checked" value="${type.lt_no }" >${type.lt_name}
								</c:when>
								<c:otherwise>
									<input class="form-check-input" type="radio" name="lt_no" value="${type.lt_no }" >${type.lt_name}
								</c:otherwise>
							</c:choose>
	                        <label class="form-check-label" for="flexCheckDefault6">
	                        </label>
                      	</div>
					</c:forEach>
					
                    </div>
                  </div>
                </div>
            
                <div class="card">
                  <div class="card-header" id="headingTwo">
                    <h5 class="icon-bg collapsed" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false"
                      aria-controls="collapseTwo">
                      <span>시설</span>
                    </h5>
                  </div>
            
                  <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionOne">
                    <div class="card-body">
                    
                    <!-- -!!!!!!!!!!!!!!!!!!!!!11- -->
                    
                    <c:forEach var="facilities" items="${facilitieList }" >
						<div class="form-check custom-form-check">
							<c:set var="check" value="true"/>
							<c:forEach var="f" items="${map.facilities_no }">
								<c:if test="${f == facilities.facilities_no }">
									<input class="form-check-input" type="checkbox" value="${facilities.facilities_no}" name="facilities_no" checked="checked"/>${facilities.facilities_name}
									<c:set var="check" value="false"/>
								</c:if>
							</c:forEach>
							<c:if test="${check }">
								<input class="form-check-input" type="checkbox" value="${facilities.facilities_no}" name="facilities_no"/>${facilities.facilities_name}
							</c:if>                 
	                        <label class="form-check-label" for="flexCheckDefault6">
	                        </label>
                      	</div>
					</c:forEach>
                      
                    </div>
                  </div>
                </div>
                
                
                <!--  -->
                <div class="card">
                  <div class="card-header" id="headingThree">
                    <h5 class="icon-bg collapsed" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false"
                      aria-controls="collapseTwo">
                      <span>서비스</span>
                    </h5>
                  </div>
            
                  <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-bs-parent="#accordionOne">
                    <div class="card-body">
                    
                    	<c:forEach var="service" items="${serviceList }" >
	                      <div class="form-check custom-form-check">
         					<c:set var="check" value="true"/>
							<c:forEach var="f" items="${map.service_no }">
								<c:if test="${f == service.service_no }">
									<input class="form-check-input" type="checkbox" value="${service.service_no}" checked="checked" name="service_no"/>${service.service_name}
									<c:set var="check" value="false"/>
								</c:if>
							</c:forEach>
							<c:if test="${check }">
								<input class="form-check-input" type="checkbox" value="${service.service_no}" name="service_no"/>${service.service_name}
							</c:if>     
	                        <label class="form-check-label" for="flexCheckDefault6">
	                        </label>
	                      </div>
						</c:forEach>
                      
                    </div>
                  </div>
                </div>
                
                <!-- ----- -->
           		<fmt:parseNumber var="star" value="${map.star }" integerOnly="true"/>
                <div class="card">
                  <div class="card-header" id="headingFourth">
                    <h5 class="icon-bg collapsed" data-bs-toggle="collapse" data-bs-target="#collapseFourth" aria-expanded="false"
                      aria-controls="collapseFourth">
                      <span>별점</span>
                    </h5>
                  </div>
            		
                  <div id="collapseFourth" class="collapse" aria-labelledby="headingFourth" data-bs-parent="#accordionOne">
                    <div class="card-body">
                      <div class="form-check custom-form-check">
                        <input class="form-check-input" type="radio" value="5" id="flexCheckDefault12" name="star" ${star == 5 ? "checked='checked'" : '' }>
                        <label class="form-check-label" for="flexCheckDefault12">
                          <span class="text-warning">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                          </span>
                    
                          <span class="ms-1">
                            (5)
                          </span>
                        </label>
                      </div>

                      <div class="form-check custom-form-check">
                        <input class="form-check-input" type="radio" value="4" id="flexCheckDefault13" name="star"  ${star == 4 ? "checked='checked'" : "" } >
                        <label class="form-check-label" for="flexCheckDefault13">
                          <span class="text-warning">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                          </span>
                    
                          <span class="ms-1">
                            (4)
                          </span>
                        </label>
                      </div>

                      <div class="form-check custom-form-check">
                        <input class="form-check-input" type="radio" value="3" id="flexCheckDefault14" name="star"  ${star == 3 ? "checked='checked'" : "" }>
                        <label class="form-check-label" for="flexCheckDefault14">
                          <span class="text-warning">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                          </span>
                    
                          <span class="ms-1">
                            (3)
                          </span>
                        </label>
                      </div>

                      <div class="form-check custom-form-check">
                        <input class="form-check-input" type="radio" value="2" id="flexCheckDefault15" name="star" ${star == 2 ? "checked='checked'" : "" }>
                        <label class="form-check-label" for="flexCheckDefault15">
                          <span class="text-warning">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                          </span>
                    
                          <span class="ms-1">
                            (2)
                          </span>
                        </label>
                      </div>

                      <div class="form-check custom-form-check">
                        <input class="form-check-input" type="radio" value="1" id="flexCheckDefault16" name="star"  ${star == 1 ? "checked='checked'" : "" }>
                        <label class="form-check-label" for="flexCheckDefault16">
                          <span class="text-warning">
                            <i class="fa fa-star" aria-hidden="true"></i>
                          </span>
                    
                          <span class="ms-1">
                            (1)
                          </span>
                        </label>
                      </div>
	                   	                    </div>
                  </div>
                </div>
              </div>
              <div class="d-grid">
         	<button type="submit" class="btn btn-block btn-xs btn-outline-secondary text-uppercase">Search</button>
        	</div>
  		 	</form>
  		 	<!-- ----------폼  -->
            </div>
            
          </div>
          
          
        </div>
      </div>
<!-- --------------------- -->
      <div class="col-lg-9">
        <div class="mb-md-6">
          <div class="row align-items-center">
            <div class="col-md-6 col-xl-4">
              <div class="form-group mb-5 mb-md-0 bg-white">
                <div class="select-default select-category-2">
                  <select class="select-option">
                    <option>SORT BY PRICE</option>
                    <option>SORT BY RATING</option>
                    <option>SORT BY POPULARITY</option>
                  </select>
                </div>
              </div>
            </div>

            <div class="col-md-6 col-xl-8 d-none d-md-block">
              <div class="d-flex justify-content-md-end">
                <a href="" class="icon-md bg-primary rounded shadow">
                  <i class="fa fa-bars text-white" aria-hidden="true"></i>
                </a>

                <a href="hotels-grid-left-sidebar.html" class="icon-md bg-white rounded shadow ms-3">
                  <i class="fa fa-th text-gray-color" aria-hidden="true"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
	<!-- 리스트 시작 -->
		<c:forEach var="data" items="${lodgingList }">
	        <div class="media media-list-view media-border flex-column flex-md-row align-items-stretch mb-5 lodging-list-card"
	        >
	          <div class="media-img position-relative">
	            <img class="img-fluid position-relative lazyestload" data-src="${imgPath } ${data.lodging_mainimg }" src="${imgPath } ${data.lodging_mainimg }" alt="${data.lodging_name }">
	          </div>
	  
	          <div class="media-body">
	            <div class="row">
	              <div class="col-md-7 col-xl-8 position-relative">
	                <h4>
	                  <a class="media-title" href="${lodgingUPath }contentForm/${data.lodging_no}">${data.lodging_name }</a>
	                </h4>
	                
	                
	                <div class="rating-view">
	                <c:forEach var="rv" items="${reviewMap}">
	                	<c:if test="${rv.key == data.lodging_no }">
						<c:forEach begin="1" end="5" step="1" varStatus="vs">
	                  		<c:if test="${vs.index <= rv.value.star}">
								<span class="text-warning">
	                            	<i class="fa fa-star" aria-hidden="true"></i>
	                          	</span>

		                    </c:if>
	                  	</c:forEach>
	                  	</c:if>
	                  </c:forEach>
						
		                <c:set var="idx" value="0"/>
						<c:forEach var="rv" items="${reviewMap}">
							<c:if test="${rv.key == data.lodging_no }">
							<c:set var="idx" value="${idx+1}"/>
			                  <span class="content-view text-uppercase border-right-0 ps-1">(Reviews ${rv.value.count})</span>
			                </c:if>
		                 </c:forEach>
						<c:if test="${idx == 0 }">
							후기 이벤트
						</c:if>
	                </div>
	        
	        		<c:set var="idx" value="0"/>
	        			<p class="mb-md-0">
						<c:forEach var="rv" items="${reviewMap}">
							<c:if test="${rv.key == data.lodging_no }">
								<c:set var="idx" value="${idx+1}"/>
	                			${rv.value.star} (${rv.value.count}) ・
	                		</c:if>
		                 </c:forEach>
		                 <c:if test="${idx == 0 }">
						후기 이벤트 ・
						</c:if>
	                		${data.lodging_grade } ・ ${data.lodging_address }</p>
	                <c:if test="${data.lodging_minp =='y'}">
		                <div class="date-view">
		                  <span> 최저가 보장</span>
		                </div>
					</c:if>
	              </div>
	        
	              <div class="col-md-5 col-xl-4" style="min-width: 140px; min-height: 180px;">
	                <div class="bg-primary text-center p-3 view-details lodging-list-price-card" style="min-width: 140px; min-height: 180px;" >
	                	<c:set var="idx1" value="0"/>
							<div class="text-box-price">
								<c:forEach var="pr" items="${priceList}">
								<c:choose>
									<c:when test="${pr.product_no == data.lodging_no && pr.sale != 0}">
										<c:set var="idx1" value="${idx1+1}"/>
										${pr.coupon_figure} → ${pr.cost}<br>
		                  				<h2 class="text-white h3">     <fmt:formatNumber value="${pr.sale }" type="number"/>원</h2>
		                  				${pr.coupon_figure}쿠폰 적용가
		                  			</c:when>
		                  			<c:when test="${pr.product_no == data.lodging_no}">
										<c:set var="idx1" value="${idx1+1}"/>
										<h2 class="text-white h3"> <fmt:formatNumber value="${pr.cost }" type="number"/>원</h2>
									</c:when>
								</c:choose>
								</c:forEach>
							</div>
	                 
	                  <div class="d-grid gap-2">
	                    <a href="${lodgingUPath }contentForm/${data.lodging_no}"
	                      class="btn btn-xs btn-outline-white btn-booking text-uppercase">Details</a>
	                  </div>
	                </div>
	              </div>
	              
	              
	            </div>
	          </div>
	        </div>
        </c:forEach>
	<!-- 리스트 종료 -->
      </div>
    </div>
  </div>

  <!-- ====================================
———	PAGINATION
===================================== -->
<section class="pt-5 pt-md-7">
  <div class="container">
    <nav aria-label="Page navigation">
<ul class="pagination justify-content-center align-items-center">
<%--         	<c:set var="lodgingUPath" value="${lodgingUPath }"/> --%>
<%--         	<c:set var="paging.begin" value="${paging.begin -1 }"/> --%>
        	
	        <li class="page-item">
	          <a class="page-link" onclick="pageUrl(${paging.prev ? paging.page - 1 : '#'})">
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
			          <a class="page-link" onclick="pageUrl(${i})">${i }</a>
			        </li>
    			</c:otherwise>
    		</c:choose>
    	</c:forEach>
         <li class="page-item">
          <a class="page-link" onclick="pageUrl(${paging.next ? paging.page + 1 : '#'})">Next
            <i class="fas fa-long-arrow-alt-right d-none d-md-inline-block ms-md-1" aria-hidden="true"></i>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</section>
<script type="text/javascript">
	function pageUrl(i) {
		if(i == '#'){
			return;
		}
		var purl = "${lodgingUPath}listForm?page=" + i;
		console.log(purl);
		var param = '';
		var word = document.getElementById("word");
		if(word.value != ""){
			param += 'word=' + word.value;
		}
		var dateRange1 = document.getElementById("dateRange1");
		if(dateRange1.value != ""){
			if(param != ""){
				param += "&"
			}
			param += 'dateRange1=' + dateRange1.value;
		}
		var dateRange2 = document.getElementById("dateRange2");
		if(dateRange2.value != ""){
			if(param != ""){
				param += "&"
			}
			param += 'dateRange2=' + dateRange2.value;
		}
		var adult_count = document.getElementById("adult_count");
		if(adult_count.value != ""){
			if(param != ""){
				param += "&"
			}
			param += 'adult_count=' + adult_count.value;
		}
		
		var ltList = document.getElementsByName("lt_no");
		for(var i = 0; i < ltList.length; i++){
			if(ltList[i].checked){
				if(param != ""){
					param += "&"
				}
				param += 'lt_no=' + ltList[i].value;
			}
		}
		
		var fList = document.getElementsByName("facilities_no");
		for(var i = 0; i < fList.length; i++){
			if(fList[i].checked){
				if(param != ""){
					param += "&"
				}
				param += 'facilities_no=' + fList[i].value;
			}
		}
		
		var sList = document.getElementsByName("service_no");
		for(var i = 0; i < sList.length; i++){
			if(sList[i].checked){
				if(param != ""){
					param += "&"
				}
				param += 'service_no=' + sList[i].value;
			}
		}
		
		var stList = document.getElementsByName("star");
		for(var i = 0; i < stList.length; i++){
			if(stList[i].checked){
				if(param != ""){
					param += "&"
				}
				param += 'star=' + stList[i].value;
			}
		}
		
		
		if(param != ""){
			purl+= "&" + param;
		}
		location.href = purl;		
	}
</script>
</section>

</section>



  </div><!-- element wrapper ends -->

      <script>
        var d = new Date();
        var year = d.getFullYear();
        document.getElementById("copy-year").innerHTML = year;
      </script>
    </footer>

  
    <!-- Javascript -->
    <script src="assets/plugins/jquery/jquery-3.4.1.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/plugins/menuzord/js/menuzord.js"></script>
    
    
    
    <script src='assets/plugins/fancybox/jquery.fancybox.min.js'></script>
    
    <script src='assets/plugins/selectric/jquery.selectric.min.js'></script>
    <script src='assets/plugins/daterangepicker/js/moment.min.js'></script>
    <script src='assets/plugins/daterangepicker/js/daterangepicker.min.js'></script>
    <script src='assets/plugins/rateyo/jquery.rateyo.min.js'></script>
    <script src="assets/plugins/lazyestload/lazyestload.js"></script>
    
    
    
    
    
    
    
    
    <script src="assets/plugins/smoothscroll/SmoothScroll.js"></script>
    
    <script src="assets/js/star.js"></script>
  </body>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>