<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>index.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>

<body>
	<div align="center" style="background-color:#CCCCCC">
		<h3>用户查找</h3>
		<form method="get" name="showtravelagency"
			action="doTravelAgencySearch">
			<table>
				<tr>
					<td>旅行社名称：</td>
					<td><input type="text" name="agencyName" id="agencyName" />
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="查找" /><input
						type="reset" value="重填" /></td>
			</table>
		</form>
	</div>

</body>
</html>
