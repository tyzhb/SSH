<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

<title>旅行社修改界面</title>

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
		<h3>修改</h3>
		<form action="doTravelAgencyUpdate" enctype="multipart/form-data"
			method="post">
			<table border="1" width="80%">
				<tr>
					<td>旅行社名称:</td>
					<td><input type="text" name="travelAgency.agencyName"
				value="<%=request.getParameter("agencyName")%>" /></td>
				</tr>
				<tr>
					<td>旅行社地址:</td>
					<td><input
				type="text" name="travelAgency.address"
				value="<%=request.getParameter("address")%>" /></td>
				</tr>
				<tr>
					<td>描 述:</td>
					<td><input type="text"name="travelAgency.discription"value="<%=request.getParameter("discription")%>" /></td>
				</tr>
				<tr>
					<td>电话:</td>
					<td><input type="text"
				name="travelAgency.phone" value="<%=request.getParameter("phone")%>" /></td>
				</tr>
				<tr>
					<td>证书1:</td>
					<td><input type="file" name="bussinessL"/></td>
				</tr>
				<tr>
					<td>证书2:</td>
					<td><input type="file" name="texL"/></td>
				</tr>
				<tr>
					<td>证书3:</td>
					<td><input type="file" name="codeL"/></td>
				</tr>
			</table>
			<input type="hidden" name="idKey" id="idKey" value="<%=request.getParameter("idKey")%>" />
			<input type="hidden" name="state" id="state" value="<%=request.getParameter("state")%>" />
			<input type="submit"value="确定" />
		</form>
	</div>
</body>
</html>
