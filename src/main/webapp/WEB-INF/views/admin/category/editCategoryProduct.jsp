<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
				<div class="form-group">
					<form:input path="categoryName" id="categoryName" name="categoryName" placeholder="${model.categoryName}"/>
				</div>
				<div class="form-group">
					<form:input path="seoTitle" type="text" id="seoTitle" placeholder="${model.seoTitle}"/>
				</div>
				<button type="submit" value="Create"  id="btnAddOrUpdateNew">
				Edit
				</button>
		</form:form>
		
		<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			console.log(formData);
		});
		</script>
</body>
</html>