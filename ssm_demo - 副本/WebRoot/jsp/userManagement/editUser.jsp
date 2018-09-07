<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      
    <title>编辑用户</title>
      
    <script type="text/javascript">
    function updateUser(){  
        var form = document.forms[0];  
        form.action = "<%=basePath%>user/updateUser.action";  
        form.method="post";  
        form.submit();  
    }  
</script>
  
  </head>
    
  <body>
    <h1>编辑用户</h1>
    <form action="" name="userForm">
        <input type="hidden" name="id" value="${user.id }"/>
        <input type="hidden" name="userCode" value="${user.userCode }"/>
        姓名：<input type="text" name="userName" value="${user.userName }"/>
        性别：<input type="text" name="sex" value="${user.sex }"/>
       电话：<input type="text" name="phone" value="${user.phone }"/> 
        <input type="button" value="编辑" onclick="updateUser()"/>
    </form>
  </body>
    
</html>