<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<script>
	function check(g) {
		if(g.gro_name.value == ""){
			alert("옵션 이름을 입력해주세요");
			g.gro_name.focus();
			return false;
		}else if(g.gro_bf.value == ""){
			alert("조식 포함 여부를 선택해주세요")
			g.gro_bf.focus();
			return false;
		}else if(g.gro_price.value==""){
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
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
// 		여기 부분 수정 필요
// 		location.href = '${groPath}delete/${gro.gro_no }'; // 객실 옵션
		location.href = '${groPath}delete/${vo.gro_no}/${vo.gr_no}'; // 객실
// 		location.href = ${groPath}+ 'delete/' +${gro.gro_no };
		
	}


</script>   
    
<%@ include file="/WEB-INF/views/layout/headerAdmin.jsp" %>

<div align="center" style="padding-top:180px;">
객실 옵션 번호 | ${vo.gro_no }
	<form action="${groPath}update" name="gro" method="post" onsubmit="return check(this)">
		<input type="hidden" value="${vo.gro_no }" name="gro_no"/>
			객실 옵션 이름
			<span class="search_in"><input type="text" name="gro_name" value="${ vo.gro_name}"/></span>
			<hr>
			조식 포함 여부
			<input type="radio" value="y" name="gro_bf" <c:if test="${vo.gro_bf =='y' }">checked</c:if>/>예
			<input type="radio" value="n" name="gro_bf" <c:if test="${vo.gro_bf =='n' }">checked</c:if> />아니오
			<br>※조식포함여부를 선택하시면 조식가격을 포함한 가격으로 산정됩니다.
			<hr>
			객실 가격
			<input type="text" name="gro_price" value="${vo.gro_price}"/>원
			<hr>
		
		<button type="submit" >수정</button>
		<button type="button" onclick="deleteAction()">삭제</button>
		<button type="button" onclick="location.href='${grPath}content/${vo.gr_no}'">객실로 돌아가기</button>
	
</form>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>