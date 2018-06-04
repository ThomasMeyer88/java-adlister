<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile");
        }
    }
%>
<html>
<head>
    <%--<jsp:include page="partials/head.jsp">--%>
        <%--<jsp:param name="title" value="Please Log In" />--%>
    <%--</jsp:include>--%>
</head>
<body>
    <%--<jsp:include page="partials/navbar.jsp" />--%>
    <div class="container">
        <h1>Please Log In</h1>
        <form action="login.jsp" method="POST">
                <label for="username">Username</label>
                <input id="username" name="username" type="text">

                <label for="password">Password</label>
                <input id="password" name="password" type="password">
            <input type="submit" value="Log In">
        </form>
    </div>
</body>
</html>
