<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
body{
	background-color: #ADD8E6;
}
#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: None;
}
</style>
</head>
<body>
<div id="login-box">
<s:property value="message"/>
<s:form action="login" method="POST">
	<table>
	<tr><td><s:textfield label="Username" key="username"/></td></tr>
	<tr><td><s:password label="password" key="password"/></td></tr>
	<tr><td></td><td><s:submit /></td></tr>
	</table>
</s:form>
</div>
</body>
</html>