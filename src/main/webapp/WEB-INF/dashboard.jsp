<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>World Programming Languages</title>
</head>
<style>
	table, td{
		border: 2px solid black;
		padding: 10px;
		margin: 10px;
	}
</style>
<body>
	<table>
		<c:forEach items = "${languages}" var = "language" varStatus = "loop">
		<tr>
			<td><c:out value = "${language.name}"/></td>
			<td><c:out value = "${language.creator}"/></td>
			<td><c:out value = "${language.version}"/></td>
			<td><a href = "/${loop.index}">Show</a></td>
			<td><a href = "/delete/${loop.index}">Delete</a></td>
			<td><a href = "/edit/${loop.index}">Edit</a></td>
		</tr>
		</c:forEach>
	</table>
	<form:form modelAttribute = "language" method = "POST" action = "/new" >
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
</body>
</html>