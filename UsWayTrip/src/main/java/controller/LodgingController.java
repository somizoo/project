package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import amenities.AmenitiesVO;
import common.ImgPath;
import common.Paging;
import common.RedirectPath;
import common.ScriptUtil;
import common.Util;
import common.ViewPath;
import facilities.FacilitiesVO;
import guestroom.GuestRoomVO;
import guestroombed.GuestRoomBedVO;
import guestroomimg.GuestRoomImgVO;
import guestroomoption.GuestRoomOptionVO;
import img.ImgVO;
import lodging.LodgingService;
import lodging.LodgingVO;
import lodgingfacilities.LodgingFacilitiesVO;
import lodgingservice.LodgingServiceVO;
import lodgingtype.LodgingTypeVO;
import managercoupon.ManagerCouponVO;
import place.PlaceVO;
import price.priceVO;
import review.ReviewVO;
import service.ServiceVO;


@Controller
public class LodgingController {
	private LodgingService lodgingService;
	
	@Autowired
	private ServletContext application;
	
	public LodgingController(LodgingService lodgingService) {
		this.lodgingService = lodgingService;
	}
	
	// 등록된 숙소 검색후 listFrom으로 이동하는 메소드
		@RequestMapping(value = {"/admin/lodging/listForm", "/lodging/listForm"})
		public String lodgingList(Model model, HttpServletRequest request,
				@RequestParam(value="facilities_no",required = false) List<Integer> facilities_no,
				@RequestParam(value="service_no",required = false) List<Integer> service_no,
				@RequestParam Map<String, Object> map){
			
			
			
			map.put("page", map.get("page")==null ? 1:Integer.valueOf((String)map.get("page")));
			map.put("word", map.get("word")==null||map.get("word").equals("") ? null:map.get("word"));
			map.put("adult_count", map.get("adult_count")==null||map.get("adult_count").equals("") ? 1:map.get("adult_count"));
			map.put("dateRange1", map.get("dateRange1")==null||map.get("dateRange1").equals("") ? null:map.get("dateRange1"));
			map.put("dateRange2", map.get("dateRange2")==null||map.get("dateRange2").equals("") ? null:map.get("dateRange2"));
			
			
			
			System.out.println(map.get("page"));
			System.out.println(map.get("word"));
			System.out.println(map.get("dateRange1"));
			System.out.println(map.get("dateRange2"));
			System.out.println(map.get("adult_count"));
			System.out.println(map.get("star"));
			System.out.println(map.get("lt_no"));
			map.put("facilities_no",facilities_no);
			map.put("service_no",service_no);
			System.out.println(map.get("facilities_no"));
			
			int lodgingCount = lodgingService.getTotal(map);
			
			Paging paging = new Paging((Integer)map.get("page"), lodgingCount);
			
			map.put("first", paging.getFirst());
			map.put("last", paging.getLast());
			
			List<LodgingVO> lodgingList = null;
			lodgingList = lodgingService.lodgingList(map);
			//////////////////////////////////////////////////////////
			// 숙소 no 리스트
			List<Integer> grnoList = new ArrayList<Integer>();
			for(LodgingVO v :lodgingList ) {
				grnoList.add(v.getLodging_no());
			}
			
			// 숙소 번호 , (별점, 후기갯수)
			Map<Integer, ReviewVO> reviewMap = new HashMap<Integer, ReviewVO>();
			
			for(int no : grnoList) {
				ReviewVO review = lodgingService.lodgingReview(no);
				if(review != null) {
					reviewMap.put(no, review);
				}
			}
			// 숙소 번호, 객실 옵션 최저가격
			List<priceVO> priceList = lodgingService.lodpriceList();
			
			for(priceVO v: priceList) {
				ManagerCouponVO cupon = lodgingService.getlodcupon(v.getProduct_no());
				if(cupon != null) {
					// 할인율 string 2% / 2000원
					String discount ="";
					if(cupon.getMc_sort() == 0) { // 퍼센트
						discount = cupon.getMc_figure() + "%";
						v.setCoupon_figure(discount);
					}else { // 원
						discount = cupon.getMc_figure() + "원";
						v.setCoupon_figure(discount);
					}
					// 할인가 
			int sale = 0;
			if(cupon.getMc_sort() == 0 ) { // 퍼센트
				sale = v.getCost() * (100 - cupon.getMc_figure()) /100;
				v.setSale(sale);
			}else { // 원
						sale = v.getCost() - cupon.getMc_figure();
						v.setSale(sale);
					}
				}
			}
					
		// 12.06 추가
		//check박스,option (전체)
		List<ServiceVO> serviceList = lodgingService.serviceList();
		List<FacilitiesVO> facilitieList = lodgingService.FacilitieList();
		List<LodgingTypeVO> lodTypeList = lodgingService.lodTypeList();

		String lodgingAPath = RedirectPath.A_LODGING;
		String lodgingUPath = RedirectPath.U_LODGING;
		String groPath = RedirectPath.A_GRO;
		String grPath = RedirectPath.A_GR;
		/* 22.12.05 추가*/
		String url = "";
		
		model.addAttribute("lodgingList",lodgingList);
		model.addAttribute("imgPath",ImgPath.LODGING);
		model.addAttribute("groPath",groPath);
		model.addAttribute("grPath",grPath);
		model.addAttribute("reviewMap",reviewMap);
		model.addAttribute("priceList",priceList);
		/* 22.12.05 추가*/
		model.addAttribute("lodgingAPath",lodgingAPath);
		model.addAttribute("lodgingUPath",lodgingUPath);
		model.addAttribute("groPath",groPath);
		model.addAttribute("grPath",grPath);
		model.addAttribute("paging", paging);
		
		// 12.06 추가
		model.addAttribute("serviceList", serviceList);
		model.addAttribute("facilitieList", facilitieList);
		model.addAttribute("lodTypeList", lodTypeList);
		
		model.addAttribute("map", map);
		
		/* 22.12.05 추가*/
		if(request.getServletPath().equals("/admin/lodging/listForm")) {
			url= ViewPath.A_LIDGING +"listForm.jsp";
		}else {
			url = ViewPath.U_LIDGING +"listForm.jsp";
		}
			return url;
		}
	
	// writeForm으로 이동하는 메소드
		@RequestMapping("/admin/lodging/insertForm")
		public String insertLodgingForm(Model model) {
			List<ServiceVO> serviceList = lodgingService.serviceList();
			List<FacilitiesVO> facilitieList = lodgingService.FacilitieList();
			List<PlaceVO> placeList = lodgingService.placeList();
			List<LodgingTypeVO> lodTypeList = lodgingService.lodTypeList();
			
			model.addAttribute("serviceList",serviceList);
			model.addAttribute("facilitieList",facilitieList);
			model.addAttribute("placeList",placeList);
			model.addAttribute("lodTypeList",lodTypeList);
			model.addAttribute("lodPath", RedirectPath.A_LODGING);
			model.addAttribute("grPath",RedirectPath.A_GR);
			
	
			
			return ViewPath.A_LIDGING +"writeForm.jsp";
			
		}
		

		// 숙소테이블에 데이터 추가, 파일 업로드, 하는 메소드
		@RequestMapping("/admin/lodging/insertLodging")
		public void insertLodging(LodgingVO vo, Model model, HttpServletRequest request,HttpServletResponse response) {
			int no = 21; // 멤버 임시 번호 -> 나중에 로그인 세션으로 수정 
//			int no = (Integer)request.getSession().getAttribute("login");
			vo.setMember_no(no);
			int idx = 0;
			String msg = "", url = "";
			System.out.println(vo.getLodging_active());
			
			String content = vo.getLodging_content();
			String info = vo.getLodging_info();
			String refund = vo.getLodging_refund();
			
			vo.setLodging_content(content.replace("\r\n", "<br>"));
			vo.setLodging_info(info.replace("\r\n", "<br>"));
			vo.setLodging_refund(refund.replace("\r\n", "<br>"));
			
			//파일을 저장할 경로
			String savePath = application.getRealPath("/resources/upload/product/lodging");
			String savePath1 = application.getRealPath("/resources/upload/product/lodging/mainimg");
		
			//단일파일 업로드후 반환값으로 메인이미지 값 세팅
			ImgVO mainImg = Util.fileUpload(vo.getMainImg(), savePath1);
			vo.setLodging_mainimg(mainImg.getImg_name());
			
			
			List<ImgVO> imgList = Util.fileListUpload(vo.getImgs(), savePath);
			
			int seq = lodgingService.lodgingInsert(vo);
			
			
			LodgingVO lodging = lodgingService.lodgingOne(seq);
			
			int facCheck = 0;
			int serviceCheck = 0;
			
			// 숙소시설 체크박스값 가져오기
			String[] facNo = request.getParameterValues("facilities_no");
			int[] fac_List = new int[facNo.length]; 
			idx = 0;
			for(String value : facNo) {
				fac_List[idx] = Integer.parseInt(value);
				idx++;
			}
			
			if(lodging != null) { // 숙소 insert 성공시
				// 숙소 시설등록
				for(int fac: fac_List) {
					LodgingFacilitiesVO lodfacvo = new LodgingFacilitiesVO();
					lodfacvo.setLodging_no(seq);
					lodfacvo.setFacilities_no(fac);
					facCheck = lodgingService.LodgingFacilitiesInsert(lodfacvo);
					
					if(facCheck == 0) { // 숙소시설 insest 실패했을때
						
						// 숙소 삭제
						lodgingService.lodgingDelete(seq);
						// 숙소 시설 삭제
						lodgingService.lodfacDelete(seq);
						
						msg = "등록에 실패했습니다";
						url = (String)request.getHeader("REFERER");
						break;
					}
					
				}
				
				if(facCheck !=0 ) { // 숙소 시설등록이 잘 됬다면 
					// 숙소 서비스 등록
					String[] serviceNo = request.getParameterValues("service_no");
					int[] service_List = new int[serviceNo.length]; 
					idx = 0;
					for(String value : serviceNo) {
						service_List[idx] = Integer.parseInt(value);
						idx++;
					}
					
					for(int value: service_List) {
						LodgingServiceVO loserviceVo = new LodgingServiceVO();
						loserviceVo.setLodging_no(seq);
						loserviceVo.setService_no(value);
						serviceCheck = lodgingService.LodgingServiceInsert(loserviceVo);
					
						if(serviceCheck == 0) { // 숙소 서비스 insest 실패했을때
							
							// 숙소 삭제
							lodgingService.lodgingDelete(seq);
							// 시설 삭제 
							lodgingService.lodfacDelete(seq);
							// 서비스 삭제
							lodgingService.lodserDelete(seq);
							
							msg = "등록에 실패했습니다";
							url = (String)request.getHeader("REFERER");
							break;
						}
					}//service for
					
					if(serviceCheck !=0) {// 시설 서비스 등록 성공시
						for (ImgVO img: imgList) {
							img.setProduct_no(seq);
							int imgCheck = lodgingService.imgInsert(img);
							
							if(imgCheck == 0) {// 이미지 테이블 insert 안됐을때
								
								// 숙소 삭제
								lodgingService.lodgingDelete(seq);
								//시설삭제
								lodgingService.lodfacDelete(seq);
								//서비스 삭제
								lodgingService.lodserDelete(seq);
								// 숙소 이미지 삭제
								lodgingService.lodimgDelete(seq);
								
								msg = "등록에 실패했습니다";
								url = (String)request.getHeader("REFERER");
								break;
								
							}
						
					}
					
					msg ="등록 되었습니다.";
					url = RedirectPath.A_LODGING + "contentForm/" +seq;
						
					}
				}
				
			}else {//숙소 insert가 실패했을시 
				
				msg = "등록에 실패했습니다";
				url = (String)request.getHeader("REFERER");
				
			}
			model.addAttribute("url",url);
			model.addAttribute("msg",msg);
			
			try {
				ScriptUtil.alertAndMovePage(response, msg, url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		// 저장되있는 숙소 정보 가지고 contentForm으로 이동하는 메소드
			@RequestMapping(value = {"/lodging/contentForm/{lodgingno}", "/admin/lodging/contentForm/{lodgingno}"})
			public String contentLodgingForm(@PathVariable("lodgingno")int no,Model model, HttpServletRequest request) {
				// 숙소가 가지고 있는값
				LodgingVO lodPlaceOne = lodgingService.lodPlaceOne(no);
				List<ServiceVO> lodServices = lodgingService.lodServices(no);
				List<FacilitiesVO> lodFacs = lodgingService.lodFacs(no);
				List<ImgVO> imgs = lodgingService.logImgs(no);
				List<ReviewVO> reviewList = lodgingService.reviewList(no);
				ReviewVO review = lodgingService.lodgingReview(no);
				/* 22.12.05 추가*/
				String url = "";
				
				String content = lodPlaceOne.getLodging_content();
				String info = lodPlaceOne.getLodging_info();
				String refund = lodPlaceOne.getLodging_refund();
				
				if(request.getServletPath().equals("/admin/lodging/contentForm/"+no)) {
					lodPlaceOne.setLodging_content(content.replace("<br>", "\r\n"));
					lodPlaceOne.setLodging_info(info.replace("<br>", "\r\n"));
					lodPlaceOne.setLodging_refund(refund.replace("<br>", "\r\n"));
				}
				
				//check박스,option (전체)
				List<ServiceVO> serviceList = lodgingService.serviceList();
				List<FacilitiesVO> facilitieList = lodgingService.FacilitieList();
				List<LodgingTypeVO> lodTypeList = lodgingService.lodTypeList();
				List<PlaceVO> placeList = lodgingService.placeList();
				
				// 숙소에 등록되있는 객실 정보 가져오기 
				List<GuestRoomVO> lodgrList = lodgingService.lodgrList(no);
				
				// 객실 no 배열
				List<Integer> grnoList = new ArrayList<Integer>();
				for(GuestRoomVO v :lodgrList ) {
					grnoList.add(v.getGr_no());
				}
				
				
				// 객실번호 , 객실 침대 리스트
				Map<Integer, List<GuestRoomBedVO>> grBedMap = new HashMap<Integer, List<GuestRoomBedVO>>();
				
				for(GuestRoomVO gr : lodgrList) {
					
					List<GuestRoomBedVO> grBedList = lodgingService.grbedList(gr.getGr_no());
					grBedMap.put(gr.getGr_no(),grBedList);
					
				}
				// 객실번호, 객실 편의시설 리스트
				Map<Integer, List<AmenitiesVO>> gramMap = new HashMap<Integer, List<AmenitiesVO>>();
				for(GuestRoomVO gr : lodgrList) {
					List<AmenitiesVO> gramList = lodgingService.gramList(gr.getGr_no());
					gramMap.put(gr.getGr_no(),gramList);
				}
				
				// 객실번호, 객실 이미지 리스트
				Map<Integer, List<GuestRoomImgVO>> grImgMap = new HashMap<Integer, List<GuestRoomImgVO>>();
				
				for(GuestRoomVO gr : lodgrList) {
					List<GuestRoomImgVO> grimgList = lodgingService.grimgList(gr.getGr_no());
					grImgMap.put(gr.getGr_no(),grimgList);
					
				}
				// 숙소가 가지고 있는 쿠폰 
				ManagerCouponVO cupon = lodgingService.getlodcupon(no);
				
				// 객실번호 , 객실옵션 리스트
				Map<Integer, List<GuestRoomOptionVO>> groMap = new HashMap<Integer, List<GuestRoomOptionVO>>();
				String coupon_figure = ""; // 2000원 / 10%
				
				if(cupon != null) {
					if(cupon.getMc_sort() == 0) {
						coupon_figure = cupon.getMc_figure() + "%";
					}else {
						coupon_figure = cupon.getMc_figure() + "원";
					}
				}
				
				for(GuestRoomVO gr : lodgrList) {
					// 객실의 객실 옵션들 가져오기
					List<GuestRoomOptionVO> groList = lodgingService.groList(gr.getGr_no());
					 if(!groList.isEmpty() && cupon != null) { // 객실 옵션이 있고 쿠폰이 있으면 
						 for(GuestRoomOptionVO gro : groList) {
							 if(cupon.getMc_sort() == 0) { //퍼센트
								 gro.setSale(gro.getGro_price() * (100 - cupon.getMc_figure()) /100);
							 }else {// 원
								 gro.setSale(gro.getGro_price() - cupon.getMc_figure());
							 }
							 gro.setCoupon_figure(coupon_figure);
						 }
						 groMap.put(gr.getGr_no(), groList);
							
					}else if(!groList.isEmpty()) { // 객실 옵션이 있으면 
						groMap.put(gr.getGr_no(), groList);
					}
				}
				
				model.addAttribute("lodPlaceOne",lodPlaceOne);
				model.addAttribute("lodServices",lodServices);
				model.addAttribute("lodFacs",lodFacs);
				model.addAttribute("imgs",imgs);
				model.addAttribute("serviceList", serviceList);
				model.addAttribute("facilitieList", facilitieList);
				model.addAttribute("placeList", placeList);
				model.addAttribute("lodTypeList", lodTypeList);
				model.addAttribute("grnoList", grnoList);
				model.addAttribute("review", review);
				
				
				model.addAttribute("imgLoPath",ImgPath.LODGING);
				model.addAttribute("imgLosPath",ImgPath.LODGINGSUB);
				model.addAttribute("imgGrPath",ImgPath.GUEST);
				model.addAttribute("imgGrsPath",ImgPath.GUESTSUB);
				/* 22.12.05 추가*/
				model.addAttribute("loAPath",RedirectPath.A_LODGING);
				model.addAttribute("loUPath",RedirectPath.U_LODGING);
				model.addAttribute("grPath",RedirectPath.A_GR);
				/*22.12.8 추가*/
//				model.addAllAttributes("grUPath" ,RedirectPath.U_GUEST);
				
				model.addAttribute("lodgrList",lodgrList);
				model.addAttribute("groMap",groMap);
				model.addAttribute("grBedMap",grBedMap);
				model.addAttribute("gramMap",gramMap);
				model.addAttribute("grImgMap",grImgMap);
				model.addAttribute("reviewList",reviewList);
				/* 22.12.09 추가*/
				model.addAttribute("iconPath",ImgPath.ICON);
				model.addAttribute("payPath", RedirectPath.U_PAYMENT);
				/* 22.12.05 추가*/
				if(request.getServletPath().equals("/admin/lodging/contentForm/"+no)) {
					url= ViewPath.A_LIDGING +"contentForm.jsp";
				}else {
					url = ViewPath.U_LIDGING +"contentForm.jsp";
				}
				return url;
				
			}
		// 숙소, 숙소시설,숙소 서비스 update하는 메소드
		@RequestMapping("/admin/lodging/update")
		public void lodgingUpdate(LodgingVO vo,HttpServletRequest request,HttpServletResponse response,Model model) {
//			vo.disp();
			System.out.println("!!");
			String msg ="";
			String url ="";
			// 숙소 업데이트 되면
			// 숙소 ㅅㅓ비스 싹 지우고 
			// 다시 숙소 서비스 insert
			// 숙소 편의시설 업데이트
			// 숙소 이미지 업데이트
			
			String content = vo.getLodging_content();
			String info = vo.getLodging_info();
			String refund = vo.getLodging_refund();
			
			vo.setLodging_content(content.replace("\r\n", "<br>"));
			vo.setLodging_info(info.replace("\r\n", "<br>"));
			vo.setLodging_refund(refund.replace("\r\n", "<br>"));
			
			int lodUpdateCheck = lodgingService.lodgingUpdate(vo);
			if(lodUpdateCheck !=0) { // 숙소가 업로드 되면
				// 숙소 서비스 삭제
				lodgingService.lodserDelete(vo.getLodging_no());
				// 숙소 서비스 insert
				for(int value: vo.getService_no()) {
					LodgingServiceVO loserviceVo = new LodgingServiceVO();
					loserviceVo.setLodging_no(vo.getLodging_no());
					loserviceVo.setService_no(value);
					int serviceCheck = lodgingService.LodgingServiceInsert(loserviceVo);
				}
				//숙소 시설 삭제
				lodgingService.lodfacDelete(vo.getLodging_no());
				//숙소 시설 insert
				for(int fac: vo.getFacilities_no()) {
					LodgingFacilitiesVO lodfacvo = new LodgingFacilitiesVO();
					lodfacvo.setLodging_no(vo.getLodging_no());
					lodfacvo.setFacilities_no(fac);
					int facCheck = lodgingService.LodgingFacilitiesInsert(lodfacvo);
				}
				// 사진 업로드
				//파일을 저장할 경로
				
				String savePath = application.getRealPath("/resources/upload/product/lodging");//서브
				String savePath1 = application.getRealPath("/resources/upload/product/lodging/mainimg");//메인
				
				if(!vo.getMainImg().isEmpty()) {
//					단일파일 업로드후 반환값으로 이미지 테이블 업데이트
					ImgVO mainImg = Util.fileUpload(vo.getMainImg(), savePath1);
					LodgingVO lodvo = new LodgingVO();
					lodvo.setLodging_mainimg(mainImg.getImg_name());
					lodvo.setLodging_no(vo.getLodging_no());
					int imgCheck = lodgingService.mainImgUpdate(lodvo);
				}
				for(MultipartFile f : vo.getImgs()) {
					 if(!f.getOriginalFilename() .equals("")) {
						 // 파일 등록
						 List<ImgVO> imgList = Util.fileListUpload(vo.getImgs(), savePath);
						 // 이미지 테이블 insert
						 for(ImgVO img:imgList) {
							 img.setProduct_no(vo.getLodging_no());
							 int imgCheck = lodgingService.imgInsert(img);
							 System.out.println(imgCheck);
						 }
						 break;
					 }
				 }
				
				msg ="수정이 완료되었습니다";
				url = RedirectPath.A_LODGING + "contentForm/" +vo.getLodging_no();
				
			}else {//숙소 업데이드 안됬을 시
				msg = "수정에 실패했습니다";
				url = (String)request.getHeader("REFERER");
			}
			model.addAttribute("url",url);
			model.addAttribute("msg",msg);
			
			try {
				ScriptUtil.alertAndMovePage(response, msg, url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
		// 숙소 이미지 삭제하는 메소드
		@RequestMapping("/admin/lodging/imgDelete/{name}/{no}")
		public void imgDelete(@PathVariable("name")String imgname,@PathVariable("no")int no ,HttpServletRequest request,HttpServletResponse response,Model model) {
			String msg = "";
			String url ="";
			
			int delCheck = lodgingService.imgDelete(imgname);
			
			if(delCheck != 0) {
				msg="사진 삭제 되었습니다.";
				url= RedirectPath.A_LODGING + "contentForm/"+no;
				
			}else {
				msg = "사진삭제 실패했습니다";
				url = (String)request.getHeader("REFERER");
			}
			
			model.addAttribute("url",url);
			model.addAttribute("msg",msg);
			
			try {
				ScriptUtil.alertAndMovePage(response, msg, url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 숙소 삭제,객실 삭제, 객실 옵션 삭제 메소드 
		@RequestMapping("/admin/lodging/delete/{no}")
		public void lodgingDelete(@PathVariable("no")int no ,HttpServletRequest request,HttpServletResponse response,Model model) {
			System.out.println("들어와싸");
			System.out.println(no);
			String msg = "";
			String url ="";
			
			// 숙소에 속해있는 객실 번호 
			List<Integer> grnoList = lodgingService.grnoList(no);
			System.out.println(grnoList.size());
			for(Integer num :grnoList) {
				System.out.println(num);
				// 객실의 이미지 삭제 
				lodgingService.grImgDelete(num);
				// 객실 편의시설 삭제
				lodgingService.grAmDelete(num);
				//객실 침대 삭제
				lodgingService.grBedDelete(num);
				// 객식 옵션 삭제 
				lodgingService.groDelete(num);
			}
			
			// 숙소 서비스 삭제
			lodgingService.lodserDelete(no);
			// 숙소 시설 삭제
			lodgingService.lodfacDelete(no);
			// 숙소 이미지 삭제 
			lodgingService.lodimgDelete(no);
			// 숙소 객실 삭제 
			lodgingService.grAllDelete(no);
			
			// 숙소 삭제 
			int lodDelCheck = lodgingService.lodgingDelete(no);
			
			msg="숙소 삭제 되었습니다";
			url= RedirectPath.A_LODGING + "listForm";
				
			
			model.addAttribute("url",url);
			model.addAttribute("msg",msg);
			
			try {
				ScriptUtil.alertAndMovePage(response, msg, url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}