<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC and Hibernate Template</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">

    <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">

</head>

<body>


<%@ include file="brand.jsp" %>

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1></h1>
            </div>


            <c:if  test="${!empty favouriteList}">
                <h3>Here are your favourite Venues!</h3>
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
                    <c:forEach items="${searchResultsList}" var="result">
                        <tr>
                            <td>${result.venueName}</td>
                            <td>${result.contactNumber}</td>
                            <td>${result.address}</td>
                            <td>${result.distance}</td>
                            <td><form action="delete/${result.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
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
