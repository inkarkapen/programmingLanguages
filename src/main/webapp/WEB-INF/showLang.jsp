<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Language</title>
</head>
<body>
	<p>Programming language name: <c:out value ="${language.name}"/></p>
	<p>Programming language creator: <c:out value ="${language.creator}"/></p>
	<p>Programming language version: <c:out value ="${language.version}"/></p>
	<p><a href = "/">Go back to dashboard</a></p>
</body>
</html>