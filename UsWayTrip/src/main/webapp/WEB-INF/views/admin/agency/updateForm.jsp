<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<script type="text/javascript">

function checkUpdate() {
	
	const w = document.getElementById("w");
	
	
	formData = new FormData(w);

	if(document.write.bd_title.value == ""){
		alert("제목을 입력하십시오!");
		return;
	}else if(document.write.bd_content.value == ""){
		alert("내용을 입력하십시오!")
		return;
	}


	var appendTag = "";		
	for(var i = 0; i<jsonArray.length; i++){
	    var str = jsonArray[i];
	    
	    // str의 값 : common/getImg.do?savedFileName=bc395afe-2324-438d-ae68-1a0a75d0a431.png 
	    // '='를 기준으로 자른다.
	    var result = str.toString().split('=');
	    var newInput = document.createElement('input');
	    newInput.setAttribute("type","hidden");
	    newInput.setAttribute("name","fileList");
	    newInput.setAttribute("value",result[1]);
	    //appendTag+='<input type="hidden" name="fileList" value="' + result[i] + '">'
	    // result[1] : bc395afe-2324-438d-ae68-1a0a75d0a431.png
	    w.appendChild(newInput);
	}
	
	//console.log(w);
	document.write.submit();
	
}
</script>

<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
 	<div align="center">
 		<form action="${path }update/${agency_no}" method="post" id = "w" name = "write" enctype="multipart/form-data">
 			<table id="table">
			 	<tr>
			 		<td id="border">여행사 이름</td>
			 		<td id="border"><input type="text" name = "agency_name" value="${vo.agency_name }"></td>
			 	</tr>
			 	<tr>
			 		<td id="border">내용</td>
			 		<td id="border"><textarea class="summernote" rows="15" cols="65" name="agency_content"></textarea></td>
			 	</tr>
			 	<tr>
			 		<td id="border">프로필이미지</td>
			 		<td id="border"><input type="text" name = "agency_proimg" value="${vo.agency_proimg }"></td>
			 	</tr>
			 	<tr>
			 		<td id="border">메인이미지</td>
			 		<td id="border"><input type="text" name = "agency_mainimg" value="${vo.agency_mainimg }"></td>
			 	</tr>
			 	<tr>
			 		<td colspan="2" align="right" id="border">
			 			<input type="button" value = "수정" onclick="javascript:checkUpdate()">
			 			<input type="button" value = "돌아가기" onclick="location.href='${path }listForm">
			 		</td>
			 	</tr>
			 </table>
		</form>
 	</div>
<script type="text/javascript">
function textEdit(){
	   jsonArray = [];
	   $('.summernote').summernote({
	         height: 500,                 // 에디터 높이
	         minHeight: null,             // 최소 높이
	         maxHeight: null,             // 최대 높이
	         focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
	         lang: "ko-KR",					// 한글 설정
	        toolbar: [
	           // [groupName, [list of button]]
	           ['fontname', ['fontname']],
	           ['fontsize', ['fontsize']],
	           ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
	           ['color', ['forecolor','color']],
	           ['table', ['table']],
	           ['para', ['ul', 'ol', 'paragraph']],
	           ['height', ['height']],
	           ['insert',['picture','link','video']],
	           ['view', ['fullscreen', 'help']]
	         ],
	       fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
	       fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
	       callbacks: {
	         onImageUpload : function(files){
	        	   console.log("onImageUpload", JSON.stringify(files));
	               // 파일 업로드(다중업로드를 위해 반복문 사용)
	               for (var i = files.length - 1; i >= 0; i--) {
	                   uploadSummernoteImageFile(files[i], this);
	               }
	          }
	    } 
	 });

	   $('.summernote').summernote('fontSize', '24');

	   function uploadSummernoteImageFile(file, el) {
	       var data = new FormData();	
	       data.append("file",file);
	           $.ajax({
	             url: '${ pageContext.request.contextPath }/summer_image',
	             type: "POST",
	             enctype: 'multipart/form-data',
	             data: data,
	             cache: false,
	             contentType : false,
	             processData : false,
	             success : function(data) {
	                       var json = JSON.parse(data);
	                       console.log(json);
	                       $(el).summernote('editor.insertImage',json["url"]);
	                           jsonArray.push(json["url"]);
	                           jsonFn(jsonArray);
	                   },
	                   error : function(e) {
	                       console.log(e);
	                   }
	               });
	           }

	}

	function jsonFn(jsonArray){
		console.log(jsonArray);
	}

	$(document).ready(textEdit());
</script>