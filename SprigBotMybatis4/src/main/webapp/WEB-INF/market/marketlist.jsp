<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:if test="${totalCount==0 }">
	<div class="alert alert-info">
		<b>저장된 상품정보가 없습니다.</b>
	</div>
</c:if>
<c:if test="${totalCount>0 }">
	<div class="alert alert-info">
		<b>총${totalCount }개의 정보가 있습니다.</b>
	</div>
	<table class="table table-bordered" style="width: 700px;">
		<tr>
			<th width="60">번호</th>
			<th width="200">상품명</th>
			<th width="120">가격</th>
			<th width="200">입고일자</th>
			<th width="150">편집</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
		<tr>
			<td>
				${i.count }
			</td>
			<td>
				<img alt="" src="../save/${dto.photoname}" style="width: 50px; height: 50px;">
				${dto.sang }
			</td>
			<td>
			
				<fmt:formatNumber value="${dto.price }" type="currency"/>
			</td>
			<td>
				<fmt:formatDate value="${dto.ipgoday }" pattern="yyyy-MM-dd HH:mm"/> 
			</td>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-outline-danger"
				onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-outline-warning"
				onclick="location.href='delete'">삭제</button>
			</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
<div style="margin: 50px 100px;">
	<button type="button" class="btn btn-info"
	onclick="location.href='writeform'">글쓰기</button>
</div>
</body>
</html>