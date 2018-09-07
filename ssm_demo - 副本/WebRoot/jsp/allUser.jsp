<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/page" prefix="page"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <script type="text/javascript" src="js/jquery.js"></script>  
    <title>用户列表</title>  
      
    <script type="text/javascript">  
    function del(id){  
    	alert("del 确认");
        $.get("<%=basePath%>user/delUser.action?id=" + id,function(data){
            if("success" == data.result){
                alert("删除成功");
                window.location.reload();
            }else{
                alert("删除失败");
            }
        });
    }
</script>  
  </head>  
    
  <body>  
    <h6><a href="<%=basePath%>/user/regist.action">添加用户</a></h6>  
    <table border="1">  
        <tbody>  
            <tr>  
                <th>姓名</th>  
                <th>性别</th>
                <th>电话</th> 
                <th>操作</th>  
            </tr>  
            <c:if test="${!empty userList }">  
                <c:forEach items="${userList}" var="user">  
                    <tr>  
                        <td>${user.userName }</td>  
                        <td>${user.sex }</td>  
                        <td>${user.phone }</td>  
                        <td>  
                            <a href="<%=basePath%>user/getUser.action?id=${user.id}">编辑</a>  
                            <a href="javascript:del('${user.id }')">删除</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>  
    <jsp:include page="/jsp/common/page.jsp" flush="true">  
  		<jsp:param name="url" value="user/getAllUser.action"/>
	</jsp:include>	
	
	<page:htmlPage pageNo="${pageNo}" url="user/getAllUser.action" totalSum="${totalSum}" showPage="10" pageSize="12"/>
	
   
  </body>  
</html> 


