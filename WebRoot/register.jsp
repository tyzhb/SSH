<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	String incode = (String) request.getParameter("code");
	String rightcode = (String) session.getAttribute("rCode");

	if (incode != null && rightcode != null) {
		if (incode.equals(rightcode)) {
			out.println("验证码输入正确！");
		} else {
			out.println("验证码输入不正确，请重新输入！");
		}
	}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

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
	<div align="center">用户注册</div>
	<div align="center">
		<s:form name="register" action="doRegister.action">
			<s:textfield name="userid" label="用户编号" />
			<s:textfield name="username" id="username" label="用户名" />
			<s:textfield name="password" label="密码" />
			<s:file label="请选择照片" />
			<img src="number.jsp" />
			<input type="text" name="code" />

			<s:submit value="注册" />
		</s:form>
	</div>

</body>
</html>
