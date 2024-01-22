<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <h1>Hello World</h1>
    <p>Hello, <%=request.getParameter("name")%>!</p>
    <p>Hello, ${empty param.name ? 'World' : param.name}!</p>
</body>
</html>
