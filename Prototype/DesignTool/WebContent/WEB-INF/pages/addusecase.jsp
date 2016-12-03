<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Use Case</title>
<style>
body{
	background-color: #ADD8E6;
}
</style>
</head>
<body>
<h1>Project <s:property value="name"/></h1><br/>
<s:form action="addusecase" method="POST">
	<table>
	<tr><td><s:textfield label="Use Case Name" key="ucname" size="28"/></td></tr>
	<tr><td><s:textfield label="Use Case ID" key="id" size="28"/></td></tr>
	<tr><td><s:textarea label="Use Case Description" key="description" cols="30" rows="3"/></td></tr>
	<tr><td><s:textarea label="Actors" key="actors" cols="30" rows="3"/></td></tr>
	<tr><td><s:textarea label="Sub Use Cases" key="subusecases" cols="30" rows="3"/></td></tr>
	<tr><td><s:textarea label="Pre-requirements" key="prerequirements" cols="30" rows="3"/></td></tr>
	<tr><td><s:textarea label="Post-requirements" key="postrequirements" cols="30" rows="3"/></td></tr>
	<tr><td><s:radio label="Status" key="status" list="#{'1':'Open','2':'Closed'}" value="1"/></td></tr>
	<tr><td></td><td><s:submit value="Add a Use Case"/></td></tr>	
	</table>	
</s:form>
</body>
</html>