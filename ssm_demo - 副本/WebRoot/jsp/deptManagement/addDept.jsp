<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门添加</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/dept/saveDept.action">
		<div style="float: left; height: 47px; width: 300px;">
			<div style="float: left; height: 25px; line-height: 25px; text-align: right; vertical-align: middle; width: 107px;">部门名称：</div>
			<div style="float: left; text-align: left; width: 183px;">
				<input type="text" name="deptName"
					value='' />
			</div>
		</div>
		<div style="float: left; height: 47px; width: 300px;">
			<div style="float: left; height: 25px; line-height: 25px; text-align: right; vertical-align: middle; width: 107px;">上级部门：</div>
			<div style="float: left; text-align: left; width: 183px;">
				<input type="text" name="parentDeptId"
					value='' />
			</div>
		</div>
		<div style="margin-top:10px;">
		    <input class="button" type="submit" value="新建" id="creatOrEdit" />
		    <input class="button" type="button" value="删除" id="deleteSelected" />
		</div>	
	</form>

</body>
</html>