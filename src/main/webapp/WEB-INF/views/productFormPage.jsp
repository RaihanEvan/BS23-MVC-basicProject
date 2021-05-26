<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%--                <%--%>
<%--                    if(session.getAttribute("username")==null) {--%>
<%--                        response.sendRedirect("/LoginServlet");--%>
<%--                    }--%>
<%--%>--%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Form Page</title>
</head>
<div class="w3-top">
    <div class="w3-bar w3-red w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="/HomeServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">HOME</a>
        <a href="/ECommerceServlet?action=create" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">ADD </a>
        <a href="/ListServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">LIST </a>
        <a href="/LoginServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">LOGIN </a>

    </div>
</div>
<body>
    <form action="/ECommerceServlet" method="POST">
        <h2 align="center">Product Details Form</h2>

        <div>
            <input type="hidden" placeholder="Product id" name="pid" id="pid" value="${product.pid}"/>
        </div>
        <div >
            <label for="name">Product Name</label>
            <input type="text" placeholder="Product Name" name="name" id="name" value="${product.name}"/>
        </div>

        <div>
            <label for="quantity">Quantity</label>
            <input type="text" placeholder="Quantity" name="quantity" id="quantity" value="${product.quantity}"/>
        </div>

        <div>
            <label for="manufacturer">Manufacturer</label>
            <input type="text" placeholder="Manufacturer" name="manufacturer" id="manufacturer"  value="${product.manufacturer}"/>
        </div>
        <div>
            <label for="warranty">Warranty</label>
            <input type="text" placeholder="Warranty" name="warranty" id="warranty" value="${product.warranty}" />
        </div>
        <div>
            <label for="price">Price</label>
            <input type="text" placeholder="Price" name="price" id="price" value="${product.price}" />
        </div>
        </br>

        <div>
            <input type="submit" value="Save"/>
            <input type="reset" value="Reset"/>
        </div>
    </form>


</form>
</body>
</html>