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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="margin:50px 150px;">
		<table class="table table-bordered" style="width: 600px;">
			<tr>
				<td>
					<h3><b>${dto.subject }</b>
					<span style="font-size: 15pt; color: gray; float: right;">
						<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
						<br>조회수: ${dto.readcount }
					</span>
					</h3>
					<br>
					<span>작성자: ${dto.name }(${dto.myid })</span>
					<c:if test="${dto.uploadfile!='no' }">
					<span style="float: right;"><a href="download?clip=${dto.uploadfile }">
					<i class="bi bi-file-earmark-arrow-down"></i><b>${dto.uploadfile }</b></a></span>
					</c:if>
				</td>
			</tr>
			
			<tr>
				<td>
					<c:if test="${ext }">
					<img alt="" src="../savefile/${dto.uploadfile }" style="width: 200px;">
					</c:if>
					<br>
					<pre>${dto.content }</pre>
					<br>
				</td>
			</tr>
			<tr>
				<td align="center">
				<c:if test="${sessionScope.loginok!=null }">
				<button type="button" class="btn btn-outline-primary"
				onclick="location.href='form'">글쓰기</button>
				</c:if>
				<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid }">
				<button type="button" class="btn btn-outline-warning"
				onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-outline-danger"
				onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</c:if>
				<button type="button" class="btn btn-outline-info"
				onclick="location.href='list?currentPage=${currentPage }'">목록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>