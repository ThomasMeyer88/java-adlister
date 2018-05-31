<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 5/31/18
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = request.getParameter("userName");
    String passW = request.getParameter("passWord");
    if(user != null && user.equalsIgnoreCase("admin") && passW != null && passW.equalsIgnoreCase("password")){
        response.sendRedirect("profile.jsp");
    }
%>
<html>
<head>
    <title>Login Test</title>
</head>
<body>
<h1>THIS IS THE LOGIN TEST</h1>
<form method="post" action="login.jsp">
    <label for="userName">Username</label>
    <input type="text" id="userName" name="userName">
    <label for="passWord">Password</label>
    <input type="text" id="passWord" name="passWord">

    <button type="submit">Submit Form</button>
</form>

</body>

</html>
