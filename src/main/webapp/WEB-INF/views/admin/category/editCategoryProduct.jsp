<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form class="form-horizontal" role="form" id="formSubmit"
		modelAttribute="model">
		<form:hidden path="iD"/>
		<div class="form-group">
			<form:input path="categoryName" id="title" name="categoryName"
				placeholder="${model.categoryName}" onkeyup = "ChangeToSlug();" />
		</div>
		<div class="form-group">
			<form:input path="seoTitle" type="text" id="slug"
				placeholder="${model.seoTitle}" />
		</div>
		<button type="submit">
			Edit</button>
	</form:form>
	<script>
		
		
		//slug
		function ChangeToSlug() {
			var title, slug;

			//Lấy text từ thẻ input title
			title = document.getElementById("title").value;

			//Đổi chữ hoa thành chữ thường
			slug = title.toLowerCase();

			//Đổi ký tự có dấu thành không dấu
			slug = slug.replace(/á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ/gi, 'a');
			slug = slug.replace(/é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ/gi, 'e');
			slug = slug.replace(/i|í|ì|ỉ|ĩ|ị/gi, 'i');
			slug = slug.replace(/ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ/gi, 'o');
			slug = slug.replace(/ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự/gi, 'u');
			slug = slug.replace(/ý|ỳ|ỷ|ỹ|ỵ/gi, 'y');
			slug = slug.replace(/đ/gi, 'd');
			//Xóa các ký tự đặt biệt
			slug = slug
					.replace(
							/\`|\~|\!|\#|\||\$|\%|\^|\&|\*|\(|\)|\+|\=|\,|\.|\/|\?|\>|\<|\'|\"|\”|\:|\;|_/gi,
							'');
			//Đổi khoảng trắng thành ký tự gạch ngang
			slug = slug.replace(/ /gi, "-");
			//Đổi nhiều ký tự gạch ngang liên tiếp thành 1 ký tự gạch ngang
			//Phòng trường hợp người nhập vào quá nhiều ký tự trắng
			slug = slug.replace(/\-\-\-\-\-/gi, '-');
			slug = slug.replace(/\-\-\-\-/gi, '-');
			slug = slug.replace(/\-\-\-/gi, '-');
			slug = slug.replace(/\-\-/gi, '-');
			//In slug ra textbox có id “slug”
			document.getElementById('slug').value = slug;
		}
	</script>
</body>
</html>