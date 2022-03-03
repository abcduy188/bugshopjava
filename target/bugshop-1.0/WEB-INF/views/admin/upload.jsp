<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload demo</h1>
	<c:url value ="/admin/upload" var="action"/>
	<form:form method="post" action="${action}" modelAttribute="image" enctype="multipart/form-data">
	
			<form:input path="file" id="file" type="file"/>
			<input type="submit" value="theem san pham"/>
	</form:form>
</body>
</html>