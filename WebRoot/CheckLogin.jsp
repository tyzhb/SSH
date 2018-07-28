<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("username") == null
			|| session.getAttribute("username").equals("")) {
		out.print("<script>alert('请先登录!');window.location.href('login.jsp');</script>");
	}
%>
