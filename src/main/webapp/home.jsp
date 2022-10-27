<%--
  Created by IntelliJ IDEA.
  User: xw
  Date: 2022/10/24
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
var request = new XMLHttpRequest();
request.open("get","http://127.0.0.1:8080/demo/user/findAll");
request.onreadystatechange=function () {
    if (request.readyState==4&&request.status==200){
        console.log(this.responseText);
    }
}
request.send();
</script>
</body>
</html>
