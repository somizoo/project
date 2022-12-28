<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	function check(g) {
		if(g.gro_name.value == ""){
			alert("옵션 이름을 입력해주세요");
			g.gro_name.focus();
			return false;
		}else if(g.gro_price.value ==""){
			alert("객실 옵션의 가격을 입력해주세요");
			g.gro_price.focus();
			return false;
		}
	
		var ck = /^[-\.0-9]+$/;
		
		if (!ck.test(g.gro_price.value)) {
		    alert("숫자만 입력 가능합니다.");
		    return false;
		}
		
		return true;
	}


</script>
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>
<div align="center" style="padding-top:180px;">
	${vo.gr_name }
	<h3>객실 옵션 등록</h3>
	<form action="${groPath}write" name="gro" method="post" onsubmit="return check(this)">
		<input type="hidden" value="${gr_no}" name="gr_no"/>
		<input type="hidden" value="${lod_no}" name="lodging_no"/>
		<div align="center">
			객실 옵션 이름
			<input type="text" name="gro_name"/>
			<hr>
			조식 포함 여부
			<input type="radio" value="y" name="gro_bf"/>예
			<input type="radio" value="n" name="gro_bf" checked/>아니오
			<br>※조식포함여부를 선택하시면 조식가격을 포함한 가격으로 산정됩니다.
			<hr>
			객실 가격
			<input type="text" name="gro_price" placeholder="가격을 입력해주세요"/>원
			<hr>
		</div>
		<button type="submit" >등록</button>
		<button type="button" onclick="location.href='${grPath}listForm/${lod_no}'">객실 리스트로 돌아가기</button>
	</form>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>