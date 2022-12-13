<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<script>
	$(function(){
		$("#createCode").on("click",function(){	
			$.ajax({
				type : "POST",
				url : "${path}createCoupon",
				success:function(data){
					$("#mc_code").val(data);
					$("#code").text(data);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("쿠폰코드 생성 실패");				
				}
			})
		})
	})
	
	function checkWrite() {	
	
	if(document.write.mc_name.value == ""){
		alert("쿠폰명을 입력해 주십시오!")
		document.write.mc_name.focus();
		return;
	}else if(document.write.mc_code.value == ""){
		alert("코드를 생성해 주십시오!")
		document.write.mc_code.focus();
		return;
	}else if(document.write.mc_start.value == ""){
		alert("유효기간을 입력해 주십시오!")
		document.write.mc_start.focus();
		return;
	}else if(document.write.mc_end.value == ""){
		alert("유효기간을 입력해 주십시오!")
		document.write.mc_end.focus();
		return;
	}else if(document.write.mc_sort.value == ""){
		alert("옵션을 선택해 주십시오!")
		document.write.mc_sort.focus();
		return;
	}else if(document.write.mc_sort.value == "0"){
		if(document.write.mc_figure.value == ""){
			alert("할인율을 입력해 주십시오!")
			document.write.mc_figure.focus();
			return;
		}
	}else if(document.write.mc_sort.value == "1"){
		if(document.write.mc_figure.value == ""){
			alert("할인금액을 입력해 주십시오!")
			document.write.mc_figure.focus();
			return;
		}
	}
	
	var ck = /^[-\.0-9]+$/;
	
	if (!ck.test(document.write.mc_figure.value)) {
	    alert("숫자만 입력 가능합니다.");
	    document.write.mc_figure.focus();
	    return;
	}
	if(document.write.mc_active.value == ""){
		alert("활성여부를 선택해 주십시오!")
		document.write.mc_active.focus();
		return;
	}
	
	document.write.submit();
	
	
	

}
	
</script>
<div align="center" style="padding-top: 20%">
	<form name="write" id="write" action="${ path }write" method="post">
		<input type="hidden" name="mc_code" id="mc_code" value="" />
		
		<table  class="table caption-top">
			<caption>쿠폰 등록</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>쿠폰명</th>
					<td>
						<input type="text" name="mc_name" />
					</td>
				</tr>
				<tr>
					<th>쿠폰코드</th>
					<td><span id="code"></span><input type="button" id="createCode" value="코드생성"></td>
				</tr>			
				<tr>
					<th>유효기간</th>
					<td>
						<input type="date" name="mc_start" /> ~ <input type="date" name="mc_end" />
					</td>
				</tr>
				<tr>
					<th>할인유무</th>
					<td>
						<select name="mc_sort" id="mc_sort" >
							<option value="">선택</option>
							<option value="0">퍼센트</option>
							<option value="1">가격</option>
						</select>
						<input type="text" name="mc_figure" id="mc_figure" value="" />
					</td>
				</tr>
				<tr>
					<th>활성여부</th>
					<td>
						<input type="radio" name="mc_active" value="0" />활성
						<input type="radio" name="mc_active" value="1" />비활성
					</td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="등록" onclick="javascript:checkWrite();">
						<input type="reset" value="리셋">  
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>