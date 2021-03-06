<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>AndigitalTest</title>

    <%@ include file="head.jsp" %>

</head>

<body>

<%@ include file="brand.jsp" %>

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1></h1>
            </div>
            <form method="post" action="search" class="form-vertical">
				<label>Your Location</label>
				<br>
				<input type="text"  name="location" value="">
				<br>
				<label>Search for...</label>
				<input type="text"  name="searchterm" value="">
				<br>						
                <input type="submit" value="Search" class="btn"/>
            </form>


            <c:if  test="${!empty searchResultsList}">
                <h3>Here are the cloest Venues!</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Venue Name</th>
                        <th>Venue Contact No.</th>
                        <th>Venue Address</th>
                        <th>Venue Distance</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${searchResultsList}" var="result" varStatus="listpostion">
                        <tr>
                            <td>${result.venueName}</td>
                            <td>${result.contactNumber}</td>
                            <td>${result.address}</td>
                            <td>${result.distance}</td>
                            <td><form action="save/${listpostion.index}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="My Favourite"/></form></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
