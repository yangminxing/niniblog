<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/5/13
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Test Content ${blogarticle.content}
<form:form method="post" commandName="blogarticle" action="${pageContext.request.contextPath}/blogarticle/save/${blogArticle.id}">
  <form:input path="title"></form:input>
  <input value="Add" type="submit" />
</form:form>
</body>
</html>
