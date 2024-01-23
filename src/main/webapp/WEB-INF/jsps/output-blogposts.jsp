<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL: Jsp Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Blog Posts</title>
</head>
<body>
  <h1>Blog Posts</h1>
  <c:forEach items="${blogposts}" var="bp">
    <h2><c:out value="${bp.title}" /></h2>
    <p><c:out value="${bp.content}"/></p>
  </c:forEach>
</body>
</html>
