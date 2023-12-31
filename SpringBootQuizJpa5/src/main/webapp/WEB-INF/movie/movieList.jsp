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
	<div class="alert alert-info" style="width: 1500px; margin: 50px 100px;">
		<b>저장된 영화가 없습니다.</b>
	</div>
</c:if>
<c:if test="${totalCount>0 }">
	<div class="alert alert-info" style="width: 1500px; margin: 50px 100px;">
		<b>총${totalCount }개의 정보가 있습니다.</b>
	</div>
	<table style="width: 1200px; margin: 0px 100px; background-color: black">
		<caption align="top" ><b style="color: white">개봉중인 영화정보</b></caption>
		<tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<td>
			<a href="detail?mv_num=${dto.mv_num }"><img alt="" src="../moviephoto/${dto.mv_poster }" style="width: 150px; height: 275px;
				margin: 50px 50px;"></a>
			</td>
			<c:if test="${i.count%5==0 }">
			</tr><tr>
			</c:if>
		</c:forEach>
		</tr>
	</table>
</c:if>
<div style="margin: 20px 100px;">
	<button type="button" class="btn btn-info"
	onclick="location.href='addform'">영화 작성</button>
</div>
</body>
</html>