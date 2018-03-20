<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
	<form:form modelAttribute = "language" method = "POST" action = "/edit/${id}" >
		<br><form:label path = "name">Name
		<form:errors path = "name"/>
		<form:input path = "name"/></form:label>
		
		<br><form:label path = "creator">Creator
		<form:errors path = "creator"/>
		<form:input path = "creator"/></form:label>
		
		<br><form:label path = "version">Version
		<form:errors path = "version"/>
		<form:input path = "version"/></form:label>
		<br><input type="submit" value="Submit"/>
	</form:form>
	<a href = "/">Go back to dashboard</a>
</body>
</html>