<%--
  Created by IntelliJ IDEA.
  User: Inna
  Date: 04.11.2017
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer</title>
</head>
<body>
<h1>Manufacturer:</h1>
<br/>
<p>ID: <%=request.getAttribute("manufacturerId")%>
    <br/>
<p>Name: <%=request.getAttribute("name")%>
    <br/>
</body>
</html>
