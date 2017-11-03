<%@ page import="net.dybinka.controller.Manufacturer.EditManufacturerServlet" %><%--
  Created by IntelliJ IDEA.
  User: Inna
  Date: 01.11.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Manufacturer</title>
</head>
<body>
<h2>edit manufacturer</h2>
<form action="editM" method="POST">
    <p>Input new Name</p>
    <input type="text" name="name"/>
    <br>
    <input type="hidden" name="manufacturer_id" value="<%EditManufacturerServlet.class, %>"/>
    <input type="submit" value="update"/>
</form>

</body>
</html>
