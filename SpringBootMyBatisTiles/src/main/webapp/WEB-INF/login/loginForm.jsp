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
<form action="loginprocess" method="post" style="margin: 100px 100px;">
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<th width="80">아이디</th>
			<th><input type="text" class="form-control" name="id" required="required" autofocus="autofocus"
			placeholder="아이디" value="${sessionScope.saveok==null?'':sessionScope.myid }"></th>
		</tr>
		<tr>
			<th width="80">비밀번호</th>
			<th><input type="password" class="form-control" name="pass" placeholder="비밀번호"></th>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="checkbox" name="savechk" ${sessionScope.saveok==null?'':'checked' }>아이디저장
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-outline-primary">로그인</button>
				<button type="button" class="btn btn-outline-info"
				onclick="location.href='/member/form'">회원가입</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>