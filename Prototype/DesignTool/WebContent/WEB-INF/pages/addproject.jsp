<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Creation Page</title>
<style>
body{
	background-color: #ADD8E6;
}
</style>
</head>
<body>
<h1><s:property value="message"/></h1><br/>
<s:form action="addproject" method="POST">
	<table>
	<tr><td><s:textfield label="Project Name" key="name" size="28"/></td></tr>
	<tr><td><s:textarea label="Project Description" key="description" cols="30" rows="8"/></td></tr>
	<tr><td></td><td><s:submit value="Add a Project"/></td></tr>	
	</table>
</s:form>
</body>
</html>