<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
td {
	font-size: 25px;
}
</style>
<script type="text/javascript">
	$(function(){
		$(".photoUpdate").click(function(){
			//alert("클릭");
			$(this).prev().trigger("click");
		})
		
		$(".photoUpload").change(function(){
			var num=$(this).attr("num");
			alert(num);
			var form=new FormData();
			form.append("photo",$(this)[0].files[0]); //선택한 1개만 추가
			form.append("num",num);
			
			console.dir(form);
			
			$.ajax({
				type:"post",
				dataType:"html",
				url:"updatephoto",
				processData:false,
				contentType:false,
				data:form,
				success:function(){
					location.reload();
				}
			});
		})
	})
</script>
</head>
<body>
	<table class="table table-bordered" style="width: 700px;">
		<c:forEach var="dto" items="${list }">
			<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.id }">
				<tr>
					<td rowspan="6" align="center"><img alt="" src="../membersave/${dto.photo }"
						style="width: 300px;"><br>
						<input type="file" class="photoUpload" num="${dto.num }" style="display: none;">
						<button type="button" class="btn btn-outline-warning photoUpdate">사진수정</button></td>
					<td width="330">이름: ${dto.name }</td>
					<td rowspan="6" style="width: 70px;" valign="middle">
						<button type="button" class="btn btn-outline-warning">수정</button>
						<button type="button" class="btn btn-outline-danger">삭제</button>
					</td>
				</tr>
				<tr>
					<td width="330">id: ${dto.id }</td>
				</tr>
				<tr>
					<td width="330">번호: ${dto.hp }</td>
				</tr>
				<tr>
					<td width="330">주소: ${dto.addr }</td>
				</tr>
				<tr>
					<td width="330">이메일: ${dto.email }</td>
				</tr>
				<tr>
					<td width="330">가입일: <fmt:formatDate value="${dto.gaipday }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>