<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	function checkWrite() {
		
		const w = document.getElementById("w");
		
		
		formData = new FormData(w);
		
		if(document.write.agency_name.value == ""){
			alert("여행사이름을 입력하십시오!");
			return;
		}else if(document.write.agency_content.value == ""){
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
		
		document.write.submit();
	}
</script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center">
	<form action="${path }write" method="post" id = "w" name = "write" enctype="multipart/form-data">
		<table>
			<tr>
				<th width="60">여행사이름</th>
				<td><input type="text" name = "agency_name" size = "53"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea class="summernote" rows="15" cols="65" name="agency_content"></textarea>
				</td>
			</tr>
			<tr>
				<th width="60">프로필이미지</th>
				<td><input type="text" name = "agency_proimg" size = "53"><button onclick="document.location.href='${path }fileForm'">파일</button></td>
			</tr>
			<tr>
				<th width="60">메인이미지</th>
				<td><input type="text" name = "agency_mainimg" size = "53"><button onclick="document.location.href='${path }fileForm'">파일</button></td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="쓰기" onclick="javascript:checkWrite()">
		</div>
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



















