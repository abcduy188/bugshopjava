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
	<h1>Upload demo</h1>
	<%-- <c:url value="/admin/upload" var="action" />
	<form:form method="post" action="${action}" modelAttribute="image"
		enctype="multipart/form-data">

		<form:input path="file" id="file" type="file" />
		<input type="submit" value="theem san pham" />
	</form:form> --%>

	<form:form id="formSubmit" modelAttribute="image">
		<form:input path="file" id="file" type="file" />
		<button type="button" class="btn btn-light px-5" id="submit">
			<i class="icon-note"></i> Thêm sản phẩm
		</button>
	</form:form>

	<script>
	
		var imgbase64 ;
		var handleFileSelect = function(evt) {
			var files = evt.target.files;
			var file = files[0];

			if (files && file) {
				var reader = new FileReader();

				reader.onload = function(readerEvt) {
					var binaryString = readerEvt.target.result;
					imgbase64 = btoa(binaryString);
				};

				reader.readAsBinaryString(file);
			}
		};

		if (window.File && window.FileReader && window.FileList && window.Blob) {
			document.getElementById('file').addEventListener('change',
					handleFileSelect, false);
		} else {
			alert('The File APIs are not fully supported in this browser.');
		}
		$('#submit').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			formData.push({
				name : "base64",
				value : imgbase64
			});
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addNew(data);

		});

		function addNew(data) {
			$.ajax({
				url : '/admin/upload',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "/bugshop/admin";
				},
				error : function(error) {
					window.location.href = "/bugshop/admin";
				}
			});
		}
	</script>
</body>
</html>