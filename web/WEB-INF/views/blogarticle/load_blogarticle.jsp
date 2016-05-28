<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/5/15
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script language="javascript">
  function getIframeData(){
    document.form1.test.value=HtmlEdit.document.body.innerHTML;
  }
  function sentIframeData(){
    HtmlEdit.document.body.innerHTML=document.form1.test.value;
  }
  function doB(){
    HtmlEdit.focus();
    var sel = HtmlEdit.document.selection.createRange();
    insertHTML("<b>"+sel.text+"</b>");
  }
  function insertHTML(html) {
    if (HtmlEdit.document.selection.type.toLowerCase() !="none"){
      HtmlEdit.document.selection.clear() ;
    }
    HtmlEdit.document.selection.createRange().pasteHTML(html) ;
  }
  document.onreadystatechange()
  {
    HtmlEdit.document.designMode="On";
  }
</script>

  <jsp:include page="../common/top.jsp" />

  <h1>The Bootstrap BLog</h1>
<form action="test.asp?act=add"method="post"name="form1">

  <IFRAME id=HtmlEdit style="WIDTH: 100%; HEIGHT: 296px"marginWidth=0 marginHeight=0>
  </IFRAME>
  <textarea name="test"rows="10"id="test"style="width:100%;"></textarea>
  <br>
  <input type="submit"name="Submit"value="提交">
  <input type="button"value="iframe->textarea"onClick="getIframeData()">
  <input type="button"value="textarea->iframe"onClick="sentIframeData()">
  <input type="button"value="B"onClick="doB()">
</form>


</body>
</html>
