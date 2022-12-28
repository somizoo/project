package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import amenities.AmenitiesVO;
import bed.BedVO;
import common.ImgPath;
import common.RedirectPath;
import common.ScriptUtil;
import common.Util;
import common.ViewPath;
import guestroom.GuestRoomService;
import guestroom.GuestRoomVO;
import guestroomamenities.GuestRoomAmenitiesVO;
import guestroombed.GuestRoomBedVO;
import guestroomimg.GuestRoomImgVO;
import guestroomoption.GuestRoomOptionVO;
import img.ImgVO;
import lodging.LodgingVO;
import managercoupon.ManagerCouponVO;
import outlook.OutLookVO;
@Controller
public class GuestRoomController {
	private GuestRoomService grService;
	
	@Autowired
	private ServletContext application;
	
	public GuestRoomController(GuestRoomService grService) {
		this.grService = grService;
	}
	// 객실 리스트로 이동하는 메소드
	@RequestMapping("/admin/guestRoom/listForm/{no}")
	public String grList(Model model,@PathVariable("no")int lodno) {
		List<GuestRoomVO> grList = grService.grList(lodno);
		List<GuestRoomBedVO> grbedAllList = grService.grbedAllList();
		List<AmenitiesVO> grAmAllList = grService.grAmAllList();
		LodgingVO lodging = grService.lodgingOne(lodno);
		
		model.addAttribute("grList",grList);
		model.addAttribute("grPath",RedirectPath.A_GR);
		model.addAttribute("lodPath",RedirectPath.A_LODGING);
		model.addAttribute("imgPath",ImgPath.GUEST);
		model.addAttribute("grbedAllList",grbedAllList);
		model.addAttribute("grAmAllList",grAmAllList);
		model.addAttribute("lodging",lodging);
		
		return ViewPath.A_GR +"listForm.jsp";
	}
	//객실 등록 폼으로 이동하는 메소드
	@RequestMapping("/admin/guestRoom/write/{no}")
	public String grWrite(Model model, @PathVariable("no")int no) {
		List<AmenitiesVO> amenitieList = grService.amList();
		List<BedVO> bedList = grService.bedList();
		List<OutLookVO> otList = grService.otList();
		LodgingVO lodging = grService.lodgingOne(no);
		
		model.addAttribute("AgrPath",RedirectPath.A_GR);
		model.addAttribute("AlodPath",RedirectPath.A_LODGING);
		model.addAttribute("amenitieList",amenitieList);
		model.addAttribute("bedList",bedList);
		model.addAttribute("otList",otList);
		model.addAttribute("no", no);
		model.addAttribute("lodging",lodging);
		
		return ViewPath.A_GR +"writeForm.jsp";
	}
	
	// 객실 , 객실 편의시설,객실 침대,객실 이미지 등록하는 메소드
	@RequestMapping("/admin/guestRoom/writeGuestRoom")
	public void insertGuestRoom(GuestRoomVO vo, Model model, HttpServletRequest request,HttpServletResponse response) {
//		vo.disp();
		String msg = "";
		String url ="";
		System.out.println(vo.getLodging_no());
		
		String content = vo.getGr_content();
		String freecancel = vo.getGr_freecancel();
		
		vo.setGr_content(content.replace("\r\n", "<br>"));
		vo.setGr_freecancel(freecancel.replace("\r\n", "<br>"));
		
		//파일을 저장할 경로
		String savePath = application.getRealPath("/resources/upload/product/guestRoom"); // 서브 이미지
		String savePath1 = application.getRealPath("/resources/upload/product/guestRoom/mainimg"); //메인 이미지
		
		ImgVO mainImg = Util.fileUpload(vo.getMainImg(), savePath1);
		vo.setGr_mainimg(mainImg.getImg_name());
		
		System.out.println(vo.getImgs().isEmpty());
		List<ImgVO> imgList = null;
		
		if(!vo.getImgs().isEmpty()) {
			imgList = Util.fileListUpload(vo.getImgs(), savePath);
		}
		
		// gr_no 값
		int no = grService.guestRoomInsert(vo);
		
		GuestRoomVO grvo = grService.guestOne(no);
		
		if(grvo != null) { // 객실 등록이 잘 됬으면 
			
			// 객실 편의시설 등록
			int[] amList = vo.getAmenitie();
			int graCheck =0;
			for(int v : amList) {
				GuestRoomAmenitiesVO gravo = new GuestRoomAmenitiesVO();
				gravo.setGr_no(no);
				gravo.setAmenities_no(v);
				graCheck = grService.graInsert(gravo);
				if(graCheck ==0) { // 객실 편의시설이 등록 안됬으면 
					// 객실 삭제 
					grService.grDelete(no);
					// 객실 편의시설 삭제 
					grService.gramDelete(no);
					msg = "등록에 실패했습니다";
					url = (String)request.getHeader("REFERER");
					break;
				}
				System.out.println("편의시설 등록");
			}
			if(graCheck !=0) { // 객실 편의시설 등록 됬을때
				// 객실 침대 등록 
				int bedCheck = 0; 
				int[] bedvalue = vo.getBed(); // 침대 갯수
				int[] bedno = vo.getBed_no(); // 침대 번호
				for (int i = 0; i < bedno.length; i++) {
					if(bedvalue[i] != 0) {
						GuestRoomBedVO grbvo = new GuestRoomBedVO();
						grbvo.setGr_no(no);
						grbvo.setBed_no(bedno[i]);
						grbvo.setGrb_cnt(bedvalue[i]);
						bedCheck = grService.grbInsert(grbvo);
						if(bedCheck ==0) {
							// 객실 삭제 
							grService.grDelete(no);
							// 객실 편의시설 삭제 
							grService.gramDelete(no);
							// 객실 침대 삭제
							grService.grbedDelete(no);
							msg = "등록에 실패했습니다";
							url = (String)request.getHeader("REFERER");
							break;
						}
						System.out.println("침대성공");
					}
				}
				if(bedCheck != 0) {
					
					if(!imgList.isEmpty()) {
						// 객실 이미지
						int imgCheck = 0;
						for (ImgVO img: imgList) {
							String name =  img.getImg_name();
							GuestRoomImgVO grivo = new GuestRoomImgVO();
							grivo.setGr_no(no);
							grivo.setGri_name(name);
							
							imgCheck = grService.grimgInsert(grivo);
							if(imgCheck == 0) {
								// 객실 삭제 
								grService.grDelete(no);
								// 객실 편의시설 삭제 
								grService.gramDelete(no);
								// 객실 침대 삭제
								grService.grbedDelete(no);
								// 객실 이미지 삭제 
								grService.grImgDelete(no);
								msg = "등록에 실패했습니다";
								url = (String)request.getHeader("REFERER");
								break;
							}
							System.out.println("사진 성공");
						}
						msg = "등록 되었습니다";
						url = RedirectPath.A_GR +"content/" + no;
						
					}
				}
			}
				
		}else {
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
	
	// 객실 정보 가지고 contentForm으로 이동하는 메소드
	@RequestMapping("/admin/guestRoom/content/{no}")
	public String grContentForm(@PathVariable("no")int grno,Model model) {
		// 객실이 가지고 있는 데이터
		GuestRoomVO lodroom = grService.guestOne(grno);
		List<GuestRoomBedVO> grBed = grService.guestBed(grno);
		List<AmenitiesVO> grAm = grService.guestAm(grno);
		List<GuestRoomImgVO> grImgs = grService.grImgs(grno); 
		// 객실 옵션 리스트
		List<GuestRoomOptionVO> groList = grService.groList(grno);
		
		ManagerCouponVO coupon = grService.getlodcupon(lodroom.getLodging_no());
		String coupon_figure = ""; // 2000원 / 10%
		if(coupon != null) {
			if(coupon.getMc_sort() == 0) {
				coupon_figure = coupon.getMc_figure() + "%";
			}else {
				coupon_figure = coupon.getMc_figure() + "원";
			}
		}
		
		if(!groList.isEmpty() && coupon != null) { // 객실 옵션이 있고 쿠폰이 있으면
			// 객실의 객실 옵션들 가져오기
			for(GuestRoomOptionVO gro : groList) {
				if(coupon.getMc_sort() == 0) { //퍼센트
					gro.setSale(gro.getGro_price() * (100 - coupon.getMc_figure()) /100);
				}else {// 원
					gro.setSale(gro.getGro_price() - coupon.getMc_figure());
				}
				gro.setCoupon_figure(coupon_figure);
			}
			
		}
		String content = lodroom.getGr_content();
		String freecancel = lodroom.getGr_freecancel();
		
		lodroom.setGr_content(content.replace("<br>", "\r\n"));
		lodroom.setGr_freecancel(freecancel.replace("<br>", "\r\n"));
		
		// 보여줘야할 데이터
		List<AmenitiesVO> amenitieList = grService.amList();
		List<BedVO> bedList = grService.bedList();
		List<OutLookVO> otList = grService.otList();
		
		// 
		model.addAttribute("grPath",RedirectPath.A_GR);
		model.addAttribute("groPath",RedirectPath.A_GRO);
		model.addAttribute("amenitieList",amenitieList);
		model.addAttribute("bedList",bedList);
		model.addAttribute("otList",otList);
		model.addAttribute("grImgs",grImgs);
		model.addAttribute("groList",groList);
		
		model.addAttribute("no",grno);
		model.addAttribute("lodroom",lodroom);
		model.addAttribute("grBed",grBed);
		model.addAttribute("grAm",grAm);
		
		model.addAttribute("imgPath",ImgPath.GUEST);
		model.addAttribute("imgsPath",ImgPath.GUESTSUB);
		
		
		return ViewPath.A_GR +"contentForm.jsp";	
	}
	
	// 객실 ,객실 침대, 객실 편의시설,객실 이미지는 아직 수정하는 메소드 
	@RequestMapping("/admin/guestRoom/update")
	public void grContentUpdate(GuestRoomVO vo, Model model, HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		String url ="";
//		vo.disp();
		int grno = vo.getGr_no();
		String content = vo.getGr_content();
		String freecancel = vo.getGr_freecancel();
		
		vo.setGr_content(content.replace("\r\n", "<br>"));
		vo.setGr_freecancel(freecancel.replace("\r\n", "<br>"));
		
		//아직 이미지 수정 안했음!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
		int upcheck = grService.grUpdate(vo);
		
		if(upcheck != 0) { // 객실 수정됬으면
			//기존 객실 침대 삭제
			grService.grbedDelete(grno);
			// 객실침대 수정 
			int[] bedvalue = vo.getBed(); // 침대 갯수
			int[] bedno = vo.getBed_no(); // 침대 번호
			
			for (int i = 0; i < bedno.length; i++) {
				if(bedvalue[i] != 0) {
					GuestRoomBedVO grbvo = new GuestRoomBedVO();
					grbvo.setGr_no(grno);
					grbvo.setBed_no(bedno[i]);
					grbvo.setGrb_cnt(bedvalue[i]);
					grService.grbInsert(grbvo);
				}
			}
			// 객실 편의시설 삭제
			grService.gramDelete(grno);
			// 객실 편의시설 등록
			int[] amList = vo.getAmenitie();
			for(int v : amList) {
				GuestRoomAmenitiesVO gravo = new GuestRoomAmenitiesVO();
				gravo.setGr_no(grno);
				gravo.setAmenities_no(v);
				grService.graInsert(gravo);
			}
			
			// 객실 메인 이미지 수정 
			
			//파일을 저장할 경로
			String savePath = application.getRealPath("/resources/upload/product/guestRoom"); // 서브 이미지
			String savePath1 = application.getRealPath("/resources/upload/product/guestRoom/mainimg"); //메인 이미지
			
			if(!vo.getMainImg().isEmpty()) { // 메인 이미지 수정을 원하면 
				ImgVO mainImg = Util.fileUpload(vo.getMainImg(), savePath1);
				vo.setGr_mainimg(mainImg.getImg_name());
				
				int imgCheck = grService.mainImgUpdate(vo);
				
			}
			for(MultipartFile f: vo.getImgs()) {
				if(!f.getOriginalFilename() .equals("")) {
					 // 파일 등록
					 List<ImgVO> imgList = Util.fileListUpload(vo.getImgs(), savePath);
					 // 이미지 테이블 insert
					 for(ImgVO img : imgList) {
						 String name =  img.getImg_name();
						 GuestRoomImgVO grivo = new GuestRoomImgVO();
						 grivo.setGr_no(grno);
						 grivo.setGri_name(name);
						 int imgCheck = grService.grimgInsert(grivo);
					 }
					 break;
				}	 
			}
			
			
			// 객실 이미지 추가
			msg = "수정 되었습니다";
			url = RedirectPath.A_GR +"content/" + grno;
			
		}else {
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
	// 객실, 객실 편의시설, 객실 침대 ,객실 이미지, 객실 옵션 삭제 메소드
	@RequestMapping("/admin/guestRoom/delete/{grno}/{lodno}")
	public void grDelete(@PathVariable("grno")int grno,@PathVariable("lodno")int lodno, Model model, HttpServletRequest request,HttpServletResponse response) {
		System.out.println(grno +"grno");
		System.out.println(lodno +"lodno");
		// 객실 삭제
		int grCheck = grService.guestRoomDelete(grno);
		System.out.println(grCheck);
		// 객실 옵션 삭제 
		
		int groCheck = grService.groDelete(grno);
		System.out.println(groCheck);
		// 객실 편의시설 삭제 
		int gramCheck = grService.gramDelete(grno);
		System.out.println(gramCheck);
		// 객실 침대 삭제
		int grbedCheck = grService.grbedDelete(grno);
		System.out.println(grbedCheck);
		// 객실 이미지 삭제 
		int griCheck = grService.grImgDelete(grno);
		System.out.println(griCheck);
		
		String msg = "객실이 삭제되었습니다";
		String url = RedirectPath.A_GR +"listForm/" + lodno;
		
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		try {
			ScriptUtil.alertAndMovePage(response, msg, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 객실 이미지 삭제하는 메소드
		@RequestMapping("/admin/guestRoom/imgDelete/{name}/{no}")
		public void imgDelete(@PathVariable("name")String imgname,@PathVariable("no")int no ,HttpServletRequest request,HttpServletResponse response,Model model) {
			String msg = "";
			String url ="";
			
			System.out.println(imgname);
			System.out.println(no);
			int delCheck = grService.imgDelete(imgname);
			
			if(delCheck != 0) {
				msg="사진 삭제 되었습니다.";
				url= RedirectPath.A_GR + "content/"+no;
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	