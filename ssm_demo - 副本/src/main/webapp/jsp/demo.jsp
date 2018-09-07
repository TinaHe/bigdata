<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP pagegd. <br>
    <b id = "qustion"></b>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
(function($) {
	$(function(){
	  $.ajax({
		url: "${pageContext.request.contextPath}/stdQuestion/getQuestion.action",
		type: "POST",
		dataType: "JSON",
		success: function(data){
			$("#qustion").html(data.rows.stdQuestion);		
		}
	}); 
    });
}(jQuery)); 
</script>
  </body>
</html>


