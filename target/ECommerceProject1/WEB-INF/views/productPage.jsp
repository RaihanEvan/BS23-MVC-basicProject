<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<html>
<style>
    button {
        display: block;
        width: 115px;
        height: 25px;
        background: #4E9CAF;
        padding: 10px;
        text-align: center;
        border-radius: 5px;
        color: white;
        font-weight: bold;
        line-height: 25px;
    }
</style>
<%--<%--%>
<%--    if(session.getAttribute("username")==null){--%>
<%--        response.sendRedirect("/LoginServlet");--%>
<%--    }--%>
<%--%>--%>
<head>
    <title>Showing All Products</title>
</head>
<body>
<br>

    <div class="w3-top">
        <div class="w3-bar w3-blue w3-card w3-right-align w3-large">
            Welcome "${username}"
            <a href="/LogoutServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">LOGOUT</a>


        <%--            <%--%>
<%--                if(session.getAttribute("username")==null){--%>
<%--                    response.sendRedirect("/LoginServlet");--%>
<%--                }--%>
<%--            %>--%>
<%--            <div class="w3-bar w3-blue w3-card w3-left-align w3-large">--%>

<%--            <c:choose>--%>
<%--                <c:when test="${session!=null}">--%>

<%--                &lt;%&ndash;                <c:when test="${username == 'admin' && password == 'admin'}">&ndash;%&gt;--%>
<%--                    <a href="/LogoutServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">LOGOUT</a>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    View Only--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--                </div>--%>
        </div>
    </div>
<br>
<table align="center" border=1 class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Manufacturer</th>
        <th>Warranty</th>
        <th>Price</th>
        <th colspan="2">Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach  items="${products}" var="product">
        <tr>
            <td><c:out value="${product.pid}" /></td>
            <td><c:out value="${product.name}" /></td>
            <td><c:out value="${product.quantity}" /></td>
            <td><c:out value="${product.manufacturer}" /></td>
            <td><c:out value="${product.warranty}" /></td>
            <td><c:out value="${product.price}" /></td>
<%--            <button type="button" onclick="Location.href=''" class="btn btn-warning">Update Product</button>--%>
<%--            <button type="button" class="btn btn-danger">Delete Product</button>--%>


            <%
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
            %>
            
        <c:choose>
<%--            <c:when test="{<%=username%> == 'admin' && <%=password%> == 'admin'}">--%>
            <c:when test="${username == 'admin' && password == 'admin'}">
                <td>
                    <a class="button" href="ECommerceServlet?action=update&pid=<c:out value="${product.pid}"/>">Update</a>
                </td>
                <td>
                    <a class="button" href="ECommerceServlet?action=delete&pid=<c:out value="${product.pid}"/>">Delete</a>
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    -Only Admin can UPDATE-
                </td>
                <td>
                    -Only Admin can DELETE-
                </td>
            </c:otherwise>
        </c:choose>

        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="button" href="/ECommerceServlet?action=create">Create New Product</a>
</body>
</html>