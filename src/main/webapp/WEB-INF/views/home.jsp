<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <link rel="stylesheet" href="home-css.css">--%>
<%--    <title>JSP Home Page</title>--%>
<%--</head>--%>
<%--<body class="header">--%>
<%--<img src="hbg1.jpg" alt="Page background">--%>
<%--<h1> This is Ecommerce Homepage for navigation</h1>--%>
<%--<h2>--%>
<%--    <a href="/WEB-INF/views/productFormPage.jsp" >I want to add Products</a><br>--%>
<%--        <a href="ECommerceServlet?action=productPage" >I want to see all Products</a>--%>
<%--&lt;%&ndash;            <a href="/views/productPage.jsp" >I want to delete/update Products/a>&ndash;%&gt;--%>
<%--</h2>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">
<title>HOME</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
    .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
    .fa-anchor,.fa-coffee {font-size:200px}
</style>
<body>
<div class="w3-top">
    <div class="w3-bar w3-red w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="/HomeServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">HOME</a>
        <a href="/ECommerceServlet?action=create" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">ADD </a>
        <a href="/ListServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">LIST </a>
        <a href="/LoginServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">LOGIN </a>

    </div>
</div>
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
    <h1 class="w3-margin w3-jumbo">Welcome to ECommerce Home Page</h1>
</header>

<div class="w3-row-padding w3-padding-64 w3-container">
    <div class="w3-content">
        <a href="/ECommerceServlet?action=create" class="w3-bar-item w3-button w3-padding-large">LET'S ADD A PRODUCT</a>&nbsp;
        <a href="/ListServlet" class="w3-bar-item w3-button w3-padding-large">LET'S LIST ALL PRODUCTS</a>
        <a href="/LoginServlet" class="w3-bar-item w3-button w3-padding-large">LOGIN </a>
    </div>
</div>
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>

</body>
</html>