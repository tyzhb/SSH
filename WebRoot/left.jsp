<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<title>导航栏</title>
<link rel="stylesheet" href="CSS/left_sidebar.css" type="text/css" />
<script type="text/javascript" src="JS/left_sidebar.js"></script>
</head>
<body>
	<div align="left">

		<%
			//String username = session.getAttribute("username").toString();
			//out.print("您好!" + username + "");
		%>
	
		<ul id="menu">
			<li class="item"><a href="javascript:void(0)" class="title"
				name="1">导游管理</a>
				<ul id="opt_1" class="optiton">
					<li><a href="./TourGuide/add.jsp" target="mainFrame">增加</a>
					</li>
					<li><a href="./TourGuide/delete.jsp" target="mainFrame">删除</a>
					</li>
					<li><a href="./TourGuide/modify.jsp" target="mainFrame">修改</a>
					</li>
					<li><a href="./TourGuide/search.jsp" target="mainFrame">查找</a>
					</li>
				</ul></li>
			<li class="item"><a href="javascript:void(0)" class="title"
				name="2">行程单管理</a>
				<ul id="opt_2" class="optiton">
					<li><a href="#">增加</a>
					</li>
					<li><a href="#">删除</a>
					</li>
					<li><a href="#">修改</a>
					</li>
					<li><a href="#">查找</a>
					</li>
				</ul></li>
			<li class="item"><a href="javascript:void(0)" class="title"
				name="3">审核管理</a>
				<ul id="opt_3" class="optiton">
					<li><a href="./Examine/NotExamine.jsp" target="mainFrame">未审核</a>
					</li>
					<li><a href="./Examine/Examined.jsp" target="mainFrame">已审核</a>
					</li>
					<li><a href="./Examine/ExaminedNotPass.jsp" target="mainFrame">未通过审核</a>
					</li>
				</ul></li>
			<li class="item"><a href="javascript:void(0)" class="title"
				name="4">旅行社管理</a>
				<ul id="opt_4" class="optiton">
					<li><a href="./TravelAgency/add.jsp" target="mainFrame">增加</a>
					</li>
					<li><a href="./TravelAgency/search.jsp" target="mainFrame">查找</a>
					</li>
				</ul></li>
			<li class="item"><a href="javascript:void(0)" class="title"
				name="5">系统设置</a>
				<ul id="opt_5" class="optiton">
					<li><a href="#">会员管理</a>
					</li>
					<li><a href="#">管理员设置</a>
					</li>
					<li><a href="#">退出</a>
					</li>
				</ul></li>
		</ul>
	</div>
</body>
</html>
