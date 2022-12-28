<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<script>
	function checkUpdate() {	
	
	if(document.update.mc_name.value == ""){
		alert("쿠폰명을 입력해 주십시오!")
		document.update.mc_name.focus();
		return;
	}else if(document.update.mc_start.value == ""){
		alert("유효기간을 입력해 주십시오!")
		document.write.mc_start.focus();
		return;
	}else if(document.update.mc_end.value == ""){
		alert("유효기간을 입력해 주십시오!")
		document.write.mc_end.focus();
		return;
	}else if(document.update.mc_sort.value == ""){
		alert("옵션을 선택해 주십시오!")
		document.write.mc_sort.focus();
		return;
	}else if(document.update.mc_sort.value == "0"){
		if(document.update.mc_figure.value == ""){
			alert("할인율을 입력해 주십시오!")
			document.update.mc_figure.focus();
			return;
		}
	}else if(document.update.mc_sort.value == "1"){
		if(document.update.mc_figure.value == ""){
			alert("할인금액을 입력해 주십시오!")
			document.update.mc_figure.focus();
			return;
		}
	}
	
	var ck = /^[-\.0-9]+$/;
	
	if (!ck.test(document.update.mc_figure.value)) {
	    alert("숫자만 입력 가능합니다.");
	    document.update.mc_figure.focus();
	    return;
	}
	
	document.update.submit();
	
	
	

}
	
</script>
<div align="center" style="padding-top: 20%">
	<form name="update" id="update" action="${ path }update" method="post">
		<input type="hidden" name="mc_no" id="mc_no" value="${ vo.mc_no}" />
		
		<table  class="table caption-top">
			<caption>쿠폰 수정</caption>
			<tbody class="table-group-divider">
				<tr>
					<th>쿠폰명</th>
					<td>
						<input type="text" name="mc_name" value="${vo.mc_name }" />
					</td>
				</tr>
				<tr>
					<th>쿠폰코드</th>
					<td>${vo.mc_code }</td>
				</tr>			
				<tr>
					<th>유효기간</th>
					<td>
						<input type="date" name="mc_start" value="${vo.mc_start }"/> ~ <input type="date" name="mc_end" value="${vo.mc_end }" />
					</td>
				</tr>
				<tr>
					<th>할인유무</th>
					<td>
						<select name="mc_sort" id="mc_sort" >
							<option value="">선택</option>
							<option value="0" <c:if test="${vo.mc_sort == 0 }">selected</c:if>>퍼센트</option>
							<option value="1" <c:if test="${vo.mc_sort == 1 }">selected</c:if>>가격</option>
						</select>
						<input type="text" name="mc_figure" id="mc_figure" value="${vo.mc_figure }" />
					</td>
				</tr>
				<tr>
					<th>활성여부</th>
					<td>
						<input type="radio" name="mc_active" value="0"  <c:if test="${vo.mc_active == 0 }">checked</c:if>/>활성
						<input type="radio" name="mc_active" value="1" <c:if test="${vo.mc_active == 1 }">checked</c:if> />비활성
					</td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="수정" onclick="javascript:checkUpdate();">
						<input type="button" value="삭제" onclick="location.href='${path}delete/${vo.mc_no }'" />
						<input type="button" value="목록" onclick="location.href='${path}listForm'" />
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</div>