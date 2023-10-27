<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
   href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu:wght@700&family=Nanum+Pen+Script&family=Single+Day&display=swap"
   rel="stylesheet">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3 class="alert alert-info">${totalCount }명의 회원이 있습니다.</h3>
<button type="button" class="btn btn-info" onclick="location.href='form'">회원 가입</button>
<table class="table table-sptriped" style="width: 900px;">
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="130">id</th>
		<th width="150">연락처</th>
		<th width="150">이메일</th>
		<th width="200">주소</th>
		<th width="150">가입일</th>
		<th width="100">강퇴</th>
	</tr>
	<c:forEach var="dto" items="${list }" varStatus="i">
		<tr>
			<td>${i.count }</td>
			<td>${dto.name }</td>
			<td>${dto.id }</td>
			<td>${dto.hp }</td>
			<td>${dto.email }</td>
			<td>${dto.addr }</td>
			<td><fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"/></td>
			<td><button type="button" class="btn btn-outline-danger"
			onclick="location.href=''">삭제</button></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>