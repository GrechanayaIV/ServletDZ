<%@ page import="net.dybinka.model.Manufacturer" %><%--
  Created by IntelliJ IDEA.
  User: Inna
  Date: 01.11.2017
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Add Product</title>
</head>
<body>
<h2>add new product</h2>
<form action="addP" method="POST">
    <p>Input Name</p>
    <input type="text" name="name"/>
    <br>
    <p>Input Price</p>
    <input type="text" name="price"/>
    <br>
    <p>Input Manufacturer Name</p>
    <input type="text" name="manufacturer"/>
    <br>
    <input type="submit" value="Add"/>
</form>

</body>
</html>
