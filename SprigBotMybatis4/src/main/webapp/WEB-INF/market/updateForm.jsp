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
	<div style="margin: 100px 100px; width: 300px;">
		<form action="update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num }"> 
			<table class="table table-bordered">
				<tr>
					<th>상품명</th>
					<td>
						<input type="text" name="sang" class="form-control"
						style="width: 120px;" required="required" value="${dto.sang }">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<input type="text" name="price" class="form-control"
						style="width: 150px;" required="required" value="${dto.price }">
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td>
						<input type="file" name="photoupload" class="form-control"
						style="width: 200px;">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">수정</button>
						<button type="button" class="btn btn-info"
						onclick="location.href='list'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>