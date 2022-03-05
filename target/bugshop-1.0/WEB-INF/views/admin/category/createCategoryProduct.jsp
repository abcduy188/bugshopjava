<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="success" value="/admin/category" />
<c:url var="failed" value="/admin" />
<c:url var="api" value="/admin/category/create" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form class="form-horizontal" role="form" modelAttribute="model">
		<div class="form-group">
			<form:input path="categoryName" id="categoryName" name="categoryName"
				placeholder="Teen danh muc" />
		</div>
		<div class="form-group">
			<form:input path="seoTitle" type="text" id="seoTitle" name="seoTitle" placeholder="SEO" />
		</div>
		<button type="submit" value="Create">
			Create</button>
	</form:form>

	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addNew(data);
			console.log(formData);
		});

		function addNew(data) {
			$.ajax({
				url : '${api}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${success}";
				},
				error : function(error) {
					window.location.href = "${failed}";
				}
			});
		}
	</script>
</body>
</html>