package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import img.ImgVO;

public class Util {
	/*
	 * 22.11.24 단일 파일 업로드 기능
	 * @param 파일객체 , 저장 경로
	 * */
	public static ImgVO fileUpload(MultipartFile file, String savePath) {
		//파일을 저장할 경로
		if(file == null || file.isEmpty()) return null;
	    String filename = null;
	    String tmpname = null;
	    ImgVO vo = null;
	    tmpname = file.getOriginalFilename();
	    long time = System.currentTimeMillis();
        String ext = (tmpname.substring(tmpname.lastIndexOf(".")));
        filename = "usWayTrip_"+time + ext;
	         
         File saveFile = new File(savePath,filename);
         
         if(!saveFile.exists()) {
            saveFile.mkdirs();
         }
      
         try {
            file.transferTo(saveFile);
            vo = new ImgVO(0, filename, ext);
         }catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
         return vo;
	}
	
	/*
	 * 22.11.24 상품 이미지 다중 파일 업로드 기능
	 * @param 파일객체 , 저장 경로
	 * */
	public static List<ImgVO> fileListUpload(List<MultipartFile> list, String savePath) {
	
	  //파일을 저장할 경로
      String filename = null;
      List<String> filenames = new ArrayList<String>();
      List<ImgVO> Imglist = new ArrayList<ImgVO>();
      ImgVO vo = null;
      for(MultipartFile file : list) {
        filenames.add(file.getOriginalFilename());
      }
	      
      for (int i = 0; i < list.size(); i++) {
          // usWayTrip_시간.jsp
         String name = list.get(i).getOriginalFilename();
         
         long time = System.currentTimeMillis();
         
         filename = "usWayTrip_"+time + (name.substring(name.lastIndexOf(".")));
         String ext = (name.substring(name.lastIndexOf(".")));
         
         File saveFile = new File(savePath,filename);
         if(!saveFile.exists()) {
            saveFile.mkdirs();
         }
         try {
        	 list.get(i).transferTo(saveFile);
        	 vo = new ImgVO(0, filename, ext);
        	 Imglist.add(vo);
         }catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      return Imglist;
	}
	
	/*
	 * 22.11.25 단일 파일 삭제 기능
	 * @param 파일이름 , 저장 경로
	 * */
	public static boolean fileDelete(String filename, String savePath) {
        boolean check = false;
		File saveFile = new File(savePath,filename);
         try {
        	check = saveFile.delete();
         }catch (IllegalStateException e) {
            e.printStackTrace();
         }
         return check;
	}
	
	/*
	 *  22.12.01 사용자명 마스킹
	 * */
	public static String masking(String name) {
		if(name == null) return null;
		
		if(name != null && !"".equals(name)){
			// 이름 가운데 글자 마스킹
		    String middleMask = "";
		    // 이름이 외자 또는 4자 이상인 경우 분기
		    if(name.length() > 2){
		    	middleMask = name.substring(1, name.length()-1);
		    } else {
		    	middleMask = name.substring(1, name.length());
		    }
		    // 마스킹 변수 선언(*)
		    String masking = "";
		    // 가운데 글자 마스킹 하기위한 증감값
		    for(int i = 0; i < middleMask.length(); i++){
		    	masking += "*";
		    }
		    
		    if(name.length() > 2){
		    	name = name.substring(0,1)
		        	+ middleMask.replace(middleMask, masking)
		            + name.substring(name.length()-1, name.length());
		    } else {
		    	name = name.substring(0,1)
		        	+ middleMask.replace(middleMask, masking);
		    }
		}
		return name;
	}
	
}
