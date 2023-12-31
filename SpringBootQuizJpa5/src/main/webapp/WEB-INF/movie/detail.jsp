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
	<div style="width: 800px; height: 550px; background-color: black;margin: 100px 100px;" >
		<table style="margin: 50px 50px;">
			<tr>
				<td rowspan="3">
					<img alt="" src="../moviephoto/${dto.mv_poster }" style="width: 250px;height: 400px;
					margin: 30px;">
				</td>
				<td>
					<h3 style="color: white;">${dto.mv_title }</h3>
				</td>
			</tr>
			<tr>
				<td>
					<h4 style="color: white;">감독 : ${dto.mv_director }</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4 style="color: white;">개봉일 : ${dto.mv_opendate }</h4>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" class="btn btn-outline-warning"
					onclick="location.href=''">수정</button>
					<button type="button" class="btn btn-outline-danger"
					onclick="location.href=''">삭제</button>
					<button type="button" class="btn btn-outline-info"
					onclick="location.href='list'">목록</button>
					<button type="button" class="btn btn-outline-primary"
					onclick="location.href='addform'">글쓰기</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>