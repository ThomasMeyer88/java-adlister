<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 5/31/18
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = request.getParameter("userName");
    String passW = request.getParameter("passWord");
    response.getWriter().println("<h1>Welcome back " + user + "</h1>");

%>
<html>
<head>
    <title>Profile</title>
</head>
<body>



</body>
</html>
