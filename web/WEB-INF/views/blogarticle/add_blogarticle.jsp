
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/5/13
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
   <form:form method="post" commandName="blogArticle" action="${pageContext.request.contextPath}/blogarticle/save">
     <form:input path="title"></form:input>
     <input value="Add" type="submit" />
   </form:form>

</body>
</html>
