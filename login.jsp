<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My JSP Page</title>
    <%@include file="component/all_css.jsp" %>
    <style type="text/css">
        .card-sh {
            box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body class="bg-light">
<%@include file="component/navbar.jsp" %>
<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card card-sh">
                <div class="card-header">
                    <center>
                        <p1 class="text-center fs-3">Login page</p1>
                    </center>
                    <c:if test="${not empty message}">
                        <p class="text-center text-danger fs-4 ">${message}</p>
                        <c:remove var="message"/>
                    </c:if>
                </div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class="mb-3">
                            <label>Enter email id</label>
                            <input type="email" name="email" class="form-control">
                            <label>Enter password</label>
                            <input type="password" name="password" class="form-control">
                        </div>
                        <button class="btn btn-success col-md-12">Login</button>
                    </form>
                    <div class="text-center mt-3">Don't have account <a href="register.jsp"
                                                                        class="text-decoration-none">Create one</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
