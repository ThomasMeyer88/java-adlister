<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 6/4/18
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Ad Display</h1>
    <div>
    <c:forEach var="ad" items="${ads}">
        <h1>${ad.title}</h1>
        <p>${ad.description}</p>
    </c:forEach>
    </div>

</body>
</html>
