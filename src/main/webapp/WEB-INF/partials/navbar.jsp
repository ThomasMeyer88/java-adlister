<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><form action="search" method="post">
                <label for ="search">Search</label>
                <input type="text" id="search" name="search">
                <input type="submit" name="search">
                </form>
            </li>
            <c:choose>
                <c:when test="${empty sessionScope.username}">
                    <li><a href="register">Register</a></li>
                    <li><a href="login">Login</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="profile">${sessionScope.username}</a></li>
                    <li><a href="ads/create">Create Ad</a></li>
                    <li><a href="logout">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>

<%--<c:choose>--%>
    <%--<c:when test="${empty user}">--%>
        <%--I see!  You don't have a name.. well.. Hello no name--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--<%@ include file="response.jsp" %>--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>
