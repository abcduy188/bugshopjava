<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="api" value="/admin/product/edit" />
<div class="container-fluid">
	<div class="card">
		<div class="card-body">
			<div class="card-title">Product</div>
			<hr>
			<form:form modelAttribute="model" enctype="multipart/form-data"
				action="${api}">
				<form:hidden path="iD"/>
				<div class="form-group">
					<label for="input-1">Name: </label>
					<form:input path="name" type="text" class="form-control"
						id="title" onkeyup="ChangeToSlug();" />
				</div>
				<div class="form-group">
					<label for="input-2">seoTitle</label>
					<form:input type="text" class="form-control" id="slug"
						path="seoTitle" readonly="true" />
				</div>
				<div class="form-group">
					<label for="input-3">Image</label>
					<form:input path="imagefile" id="imagefile" type="file"
						cssClass="form-control" />
				</div>
				
				<div class="form-group">
					<label for="input-3">Old Image</label>
					<img alt="" src="${model.image }">
				</div>
				<div class="form-group">
					<label for="input-1">description: </label>
					<form:input path="description" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<label for="input-1">price: </label>
					<form:input path="price" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<label for="input-1">promotionPrice: </label>
					<form:input path="promotionPrice" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<form:select path="categoryId" id="categoryId"
						style="background: white;">
						<form:option style="background: white;" value=""
							label="-- Chọn Thể loại --" />
						<form:options style="background: white;" items="${categories}" />

					</form:select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-light px-5">
						<i class="icon-lock"></i> Edit
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
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
		title = document.getElementById("title").value;
		var price = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(1000);
	</script>