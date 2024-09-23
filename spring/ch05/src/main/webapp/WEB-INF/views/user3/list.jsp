<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>user3::list</title>
</head>
<body>
    <h3>User3 목록</h3>
    <a href="/ch05/">처음으로</a>
    <a href="/ch05/user3/register">등록</a>

    <table border ="1">
        <tr>
            <td>아이디</td>
            <td>이름</td>
            <td>생년월일</td>
            <td>전화번호</td>
            <td>나이</td>
            <td>관리</td>
        </tr>
        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.uid}</td>
            <td>${user.name}</td>
            <td>${user.birth}</td>
            <td>${user.hp}</td>
            <td>${user.age}</td>
            <td>
                <a href="/ch05/user3/modify?uid=${user.uid}">수정</a>
                <a href="/ch05/user3/delete?uid=${user.uid}">삭제</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
