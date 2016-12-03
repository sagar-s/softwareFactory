<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Define Policies and Roles Page</title>
<style>
body{
	background-color: #ADD8E6;
}
</style>
</head>
<body>
<h1>Define policies and roles for Use case</h1>
<s:form action="policiesandroles" method="POST">
	<table style="width-100%">
	<tr><th>List of contributors:</th></tr>
	<tr><td><s:textfield key="email1" label="Email ID " size="28"/></td><td><s:radio name="role1" label="Role" list="#{'development manager':'Development Manager','solution manager':'Solution Manager', 'architect':'Architect', 'QA':'QA'}" value="1"/></td><td><s:textfield label="Start Date" key="startdate1" size="28"/></td><td><s:textfield label="End Date" key="enddate1" size="28"/></td></tr>
	<tr><td><s:textfield key="email2" label="Email ID " size="28"/></td><td><s:radio name="role2" label="Role" list="#{'development manager':'Development Manager','solution manager':'Solution Manager', 'architect':'Architect', 'QA':'QA'}" value=""/></td><td><s:textfield label="Start Date" key="startdate2" size="28"/></td><td><s:textfield label="End Date" key="enddate2" size="28"/></td></tr>
	<tr><td><s:textfield key="email3" label="Email ID " size="28"/></td><td><s:radio name="role3" label="Role" list="#{'development manager':'Development Manager','solution manager':'Solution Manager', 'architect':'Architect', 'QA':'QA'}" value="1"/></td><td><s:textfield label="Start Date" key="startdate3" size="28"/></td><td><s:textfield label="End Date" key="enddate3" size="28"/></td></tr>
	<tr><td><s:textfield key="email4" label="Email ID " size="28"/></td><td><s:radio name="role4" label="Role" list="#{'development manager':'Development Manager','solution manager':'Solution Manager', 'architect':'Architect', 'QA':'QA'}" value="1"/></td><td><s:textfield label="Start Date" key="startdate4" size="28"/></td><td><s:textfield label="End Date" key="enddate4" size="28"/></td></tr>
	<s:submit value="Send Email Notifications"/>	
	</table>
</s:form>
</body>
</html>