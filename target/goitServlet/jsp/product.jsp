<%--
  Created by IntelliJ IDEA.
  User: Inna
  Date: 04.11.2017
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product:</h1>
<br/>
<p>ID: <%=request.getAttribute("productId")%>
<br/>
<p>Name: <%=request.getAttribute("name")%>
<br/>
<p>Price: <%=request.getAttribute("price")%>
<br/>
<p>Manufacturer: <%=request.getAttribute("manufacturer")%>
<br/>

</body>
</html>
