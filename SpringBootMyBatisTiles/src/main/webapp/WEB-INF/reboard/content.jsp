<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<style type="text/css">
    .likes {
        cursor: pointer;
    }
</style>
<html>
<script type="text/javascript">
    $(function () {
        $("div.likes").click(function () {
            //alert("click");
            var thumb = $(this).find("i").attr("class");

            if (thumb == 'bi bi-hand-thumbs-up-fill') {
                $(this).find("i").attr("class", "bi bi-hand-thumbs-up-fill hi").css("color", "red");
            } else {
                $(this).find("i").attr("class", "bi bi-hand-thumbs-up-fill").css("color", "black");
            }


            var num = $(this).attr("num");

            $.ajax({
                type: "GET",
                url: "updatelikes",
                dataType: "json",
                data: {"num": num},
                success: function (data) {
                    $("div.likes").find("b").text(data.likes);
                }
            })
        });
    })
</script>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
</head>
<body>
<div style="width: 600px; margin: 50px 100px;">
    <table class="table table-bordered">
        <tr>
            <td>
                <h2>${dto.subject}</h2>
                <b>${dto.name}(${dto.id})</b><br>
                <span style="color:gray; font-size: 0.8em;">
                    <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    조회:${dto.readcount}
                </span>
            </td>
        </tr>
        <tr>
            <td>
                <pre>${dto.content}</pre>
                <br><br>
                <c:if test="${dto.photo!='no'}">
                    <c:forEach var="photo" items="${dto.photo}">
                        <img src="../rephoto/${photo}" width="100" class="img-thumbnail">
                    </c:forEach>
                </c:if><br><br>
                <div class="likes" num="${dto.num}">
                    <i class="bi bi-hand-thumbs-up-fill"></i>&nbsp;&nbsp;
                    좋아요<b>${dto.likes}</b>
                </div>
            </td>
        </tr>
        <tr>
            <td align="center">
                <button type="button" class="btn btn-outline-success"
                        onclick="location.href='form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">
                    답글
                </button>
                <c:if test="${sessionScope.loginok!=null&&sessionScope.myid==dto.id}">
                    <button type="button" class="btn btn-outline-warning"
                            onclick="location.href=''">수정
                    </button>
                    <button type="button" class="btn btn-outline-danger"
                            onclick="location.href=''">삭제
                    </button>
                </c:if>
                <button type="button" class="btn btn-outline-info"
                        onclick="location.href='list?currentPage=${currentPage}'">목록
                </button>
                <c:if test="${sessionScope.loginok!=null}">
                    <button type="button" class="btn btn-outline-primary"
                            onclick="location.href='form'">글쓰기
                    </button>
                </c:if>
            </td>
        </tr>
    </table>
</div>
</body>
</html>