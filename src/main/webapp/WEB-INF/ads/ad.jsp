<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style>
        .redButton{
            color: red;
            background-color: red;
            border-radius: 50%;
            height: 25px;
            width: 25px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">

    <%--<c:forEach var="showAd" items="${showAd}">--%>
        <div class="col-md-6">
            <h1><c:out value ="${sessionScope.showAd.title}"></c:out></h1>
            <%--<h5>Posted by: ${sessionScope.showAd.userid}</h5>--%>
            <h6>Description: </h6>
                <p><c:out value ="${sessionScope.showAd.description}"></c:out></p>
            <form action="/delete" method="POST">
                <label for="adId">delete</label>
                <input id="adId" name="adId" type="submit" class="redButton" value=${sessionScope.showAd.id}>
            </form>
            <%--<form action="/viewuser" method="POST">--%>
                <%--<label for="viewUser">View Poster</label>--%>
                <%--<input id="viewUser" name="viewUser" type="submit" value=${sessionScope.showAd.userid}>--%>
            <%--</form>--%>
        </div>
    <%--</c:forEach>--%>
</div>

</body>

</html>
