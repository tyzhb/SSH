<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>添加旅行社</title>

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
	<div align="center" style="background-color:#CCCCCC">
		<s:form action="doTravelAgencyAdd" enctype="multipart/form-data"
			method="post">
			<s:textfield name="travelAgency.agencyName" label="旅行社名称:" />
			<s:textfield name="travelAgency.address" label="旅行社地址:" />
			<s:textfield name="travelAgency.discription" label="描述:" />
			<s:textfield name="travelAgency.phone" label="电话:" />
			<s:file name="bussinessL" label="证书1"></s:file>
			<s:file name="texL" label="证书2"></s:file>
			<s:file name="codeL" label="证书3"></s:file>
			<s:submit value="确定"></s:submit>
		</s:form>
	</div>
</body>
</html>
