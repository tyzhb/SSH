<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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

<title>My JSP 'findsuccess.jsp' starting page</title>

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
		<h3>旅行社信息列表</h3>
		<table border="1" width="80%">
			<tr>
				<td>id</td>
				<td>名称</td>
				<td>地址</td>
				<td>描述</td>
				<td>电话</td>
				<td>证书1</td>
				<td>证书2</td>
				<td>证书3</td>
				<td>状态</td>
				<td>删除</td>
				<td>修改</td>
			</tr>

			<s:iterator value="list" var="u">
				<tr bgcolor="#999999">
					<td><s:property value="#u.idKey" />
					</td>
					<td><s:property value="#u.agencyName" />
					</td>
					<td><s:property value="#u.address" />
					</td>
					<td><s:property value="#u.discription" />
					</td>
					<td><s:property value="#u.phone" />
					</td>
					<td><img alt="" src="./tmp/img/<s:property value="#u.idKey" />bL.jpg" width="300px" height="150px">
					</td>
					<td><img alt="" src="./tmp/img/<s:property value="#u.idKey" />cL.jpg" width="300px" height="150px">
					</td>
					<td><img alt="" src="./tmp/img/<s:property value="#u.idKey" />tL.jpg" width="300px" height="150px">
					</td>
					<td><s:property value="#u.state" />
					</td>
					<td><form action="doTravelAgencyDel" method="post">
					<input type="hidden" name="idKey" id="idKey" value=<s:property value="#u.idKey" />>
					<input type="submit" value="删除" />
					</form>
					</td>
					<td><form action="./TravelAgency/modify.jsp" method="post">
					<input type="hidden" name="idKey" id="idKey" value=<s:property value="#u.idKey" />>
					<input type="hidden" name="agencyName" id="agencyName" value=<s:property value="#u.agencyName" />>
					<input type="hidden" name="address" id="address" value=<s:property value="#u.address" />>
					<input type="hidden" name="discription" id="discription" value=<s:property value="#u.discription" />>
					<input type="hidden" name="phone" id="phone" value=<s:property value="#u.phone" />>
					<input type="hidden" name="texLicense" id="texLicense" value=<s:property value="#u.texLicense" />>
					<input type="hidden" name="codeLicense" id="codeLicense" value=<s:property value="#u.codeLicense" />>
					<input type="hidden" name="state" id="state" value=<s:property value="#u.state" />>
					<input type="submit" value="修改" />
					</form>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
