<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>NewAgencyInfo page</title>
</head>


<body>
		<s:form name="AgencyInfo" action="NewAgencyInfo.action">
		<s:textfield name="idKey" label="旅行社编号"></s:textfield>
		<s:textfield name="agencyName" label="旅行社名称" />
	 	<s:textfield name="address" label="旅行社地址" />
	 	<s:textfield name="discription" label="描述" />
	 	<s:textfield name="phone" label="联系方式" />
	 	<s:textfield name="bussinessLicense" label="营业执照" />
	 	<s:textfield name="texLicense" label="税务登记证" />
	 	<s:textfield name="codeLicense" label="机构组织代码证" />
	 	<s:submit value="提交"/>
	 	</s:form>
</body>

</html>