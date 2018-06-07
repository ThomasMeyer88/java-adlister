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
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">

            <form action="ads" method="post">
                <label for="adInfo">${ad.title}</label>
                <input id="adInfo" name="adInfo" type="submit" value=${ad.id}>
                    <%--<p>${ad.description}</p>--%>
                    <%--<form action="/delete" method="POST">--%>
                    <%--<label for="adId">delete</label>--%>
                    <%--<input id="adId" name="adId" type="submit" class="redButton" value=${ad.id}>--%>
                    <%--</form>--%>
            </form>


    </c:forEach>
</div>

</body>

</html>
