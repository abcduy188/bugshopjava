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
		<form class="form-horizontal" role="form" id="formSubmit">
				<div class="form-group">
					<input id="categoryName" name="categoryName" placeholder="Teen danh muc"/>
				</div>
				<div class="form-group">
					<input  type="text" id="seoTitle" name="seoTitle" placeholder="SEO"/>
				</div>
				<button type="submit" value="Create"  id="btnAddOrUpdateNew">
				Create
				</button>
		</form>
		
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