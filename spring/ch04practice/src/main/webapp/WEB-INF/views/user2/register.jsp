
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Register</title>
  </head>
  <body>
    <h3>User2 Register</h3>

    <a href ="/ch04practice/">처음으로</a>
    <a href ="/ch04practice/user2/list">목록</a>

  <form action="/ch04practice/user2/register" method="post">
    <table border="1">

      <tr>
        <td>아이디</td>
        <td><input type = "text" name ="uid"></td>
      </tr>
      <tr>
        <td>이름</td>
        <td><input type = "text" name ="uid"></td>
      </tr>
      <tr>
        <td>생년월일</td>
        <td><input type = "text" name ="uid"></td>
      </tr>
      <tr>
        <td>휴대폰</td>
        <td><input type = "text" name ="uid"></td>
      </tr>
      <tr>
        <td>나이</td>
        <td><input type = "text" name ="uid"></td>
      </tr>
      <tr>
        <td colspan="2" align="right">
          <input type = "submit" value = "등록하기">
        </td>
      </tr>

    </table>
  </form>

  </body>
</html>
