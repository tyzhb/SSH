<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加导游</title>
</head>

<body>
	<div align="center" style="background-color:#CCCCCC">
		<h3>添加导游</h3>
		<form action="doTourGuideAdd" method="post">
			<table width="60%" border="1">
				<tr>
					<td width="40%">导游证编号：</td>
					<td width="60%"><input name="serialNo" type="text" />
					</td>
				</tr>
				<tr>
					<td>旅行社：</td>
					<td><input name="agentName" type="text" />
					</td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input name="username" type="text" />
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="password" type="text" />
					</td>
				</tr>
			</table>
			<input type="submit" value="确定" />


		</form>

	</div>
</body>
</html>