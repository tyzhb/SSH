<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login page</title>
</head>


<body>
		<s:form name="form1" action="doLogin.action">
		<s:textfield name="username" label="用户名"></s:textfield>
	 	<s:textfield name="password" label="密码" />
	 	<s:submit value="登录"/>
	 	</s:form>
</body>

</html>