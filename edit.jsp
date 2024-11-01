<%@ page import="com.dao.ExpenseDao" %>
<%@ page import="com.db.HibernateUtil" %>
<%@ page import="com.entity.Expense" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@include file="../component/all_css.jsp" %>
    <title>Title</title>
    <style type="text/css">
        .card-sh {
            box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body class="bg-light">
<c:if test="${empty loginUser}" >
    <c:redirect url="../login.jsp"></c:redirect>
</c:if>
<% int id=Integer.parseInt(request.getParameter("id"));
    ExpenseDao expenseDao=new ExpenseDao(HibernateUtil.getSessionFactory());
    Expense expense =expenseDao.getExpenseById(id);
%>
<%@include file="../component/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card card-sh">
                <div class="card-header text-center">
                    <p1 class="fs-3 ">Edit Expense</p1>

                </div>
                <div class="card-body">
                    <form action="../updateExpense" method="post">
                        <div class="mb-3">
                            <label>Title</label>
                            <input type="text" name="title" class="form-control" value="<%=expense.getTitle()%>"/>
                        </div>
                        <div class="mb-3">
                            <label>Date</label>
                            <input type="date" name="date" class="form-control" value="<%=expense.getDate()%>"/>
                        </div>
                        <div class="mb-3">
                            <label>Time</label>
                            <input type="time" name="time" class="form-control" value="<%=expense.getTime()%>"/>
                        </div>
                        <div class="mb-3">
                            <label>Description</label>
                            <input type="text" name="description" class="form-control" value="<%=expense.getDescription()%>"/>
                        </div>
                        <div class="mb-3">
                            <label>Price</label>
                            <input type="text" name="price" class="form-control" value="<%=expense.getPrice()%>"/>
                        </div>
                        <input type="hidden" name="id" value="<%= expense.getId()%>">
                        <button class="btn btn-success col-md-12">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


