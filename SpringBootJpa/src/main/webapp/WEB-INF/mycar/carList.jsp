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
	<div style="margin: 50px 100px;">
	
	<img alt="" src="../cat.gif">
		<button type="button" class="btn btn-info"
		onclick="location.href='carform'">자동차정보입력</button>
		<br><br>
		<h3 class="alert alert-info" style="width: 850px;">
			<b>총${totalCount }개의 자동차 정보가 있습니다.</b>
		</h3>
		<table class="table table-bordered" style="width: 850px;">
			<tr>
				<th width="50">번호</th>
				<th width="80">자동차명</th>
				<th width="30">색상</th>
				<th width="70">가격</th>
				<th width="80">구입일</th>
				<th width="150">등록일</th>
				<th width="120">편집</th>
			</tr>
			<tr>
				<c:forEach var="car" items="${list }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td>
						<a href="detail?num=${car.num }"><img alt="" src="../save/${car.carphoto }" style="width: 30px; height: 30px;"> ${car.carname }</a>
						</td>
						<td><div style="width: 30px; height: 30px; background-color:${car.carcolor }; border-radius:30px;"></div></td>
						<td><fmt:formatNumber value="${car.carprice }" type="currency"/></td>
						<td>${car.carguip }</td>
						<td><fmt:formatDate value="${car.guipday }" pattern="yyyy-MM-dd HH:mm"/></td>
						<td>
							<button type="button" class="btn btn-info btn-sm"
							onclick="location.href='updateform?num=${car.num}'">수정</button>
							<button type="button" class="btn btn-danger btn-sm"
							onclick="location.href='delete?num=${car.num}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>