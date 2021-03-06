<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<c:url var="api" value="/admin/product/create" />
<div class="container-fluid">
	<div class="card">
		<div class="card-body">
			<div class="card-title">Product</div>
			<hr>
			<form:form modelAttribute="model" enctype="multipart/form-data"
				action="${api}">
				<div class="form-group">
					<label for="input-1">Name: </label>
					<form:input path="name" type="text" class="form-control"
						id="title" onkeyup="ChangeToSlug();" />
				</div>
				<div class="form-group">
					<label for="input-2">seoTitle</label>
					<form:input path="SeoTitle" type="text" class="form-control" id="slug" readonly="true"/>
				</div>
				<div class="form-group">
					<label for="input-3">Image</label>
					<form:input path="imagefile" id="imagefile" type="file"
						cssClass="form-control" />
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
					<label for="input-1">cpu: </label>
					<form:input path="cpu" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<label for="input-1">vga: </label>
					<form:input path="vga" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<label for="input-1">ram: </label>
					<form:input path="ram" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<label for="input-1">monitor: </label>
					<form:input path="monitor" type="text" class="form-control" />
				</div>
				<div class="form-group">
					<form:select path="categoryId" id="categoryId"
						style="background: white;">
						<form:option style="background: white;" value=""
							label="-- Ch???n Th??? lo???i --" />
						<form:options style="background: white;" items="${categories}" />

					</form:select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-light px-5">
						<i class="icon-lock"></i> Create
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

			//L???y text t??? th??? input title
			title = document.getElementById("title").value;

			//?????i ch??? hoa th??nh ch??? th?????ng
			slug = title.toLowerCase();

			//?????i k?? t??? c?? d???u th??nh kh??ng d???u
			slug = slug.replace(/??|??|???|???|??|??|???|???|???|???|???|??|???|???|???|???|???/gi, 'a');
			slug = slug.replace(/??|??|???|???|???|??|???|???|???|???|???/gi, 'e');
			slug = slug.replace(/i|??|??|???|??|???/gi, 'i');
			slug = slug.replace(/??|??|???|??|???|??|???|???|???|???|???|??|???|???|???|???|???/gi, 'o');
			slug = slug.replace(/??|??|???|??|???|??|???|???|???|???|???/gi, 'u');
			slug = slug.replace(/??|???|???|???|???/gi, 'y');
			slug = slug.replace(/??/gi, 'd');
			//X??a c??c k?? t??? ?????t bi???t
			slug = slug
					.replace(
							/\`|\~|\!|\#|\||\$|\%|\^|\&|\*|\(|\)|\+|\=|\,|\.|\/|\?|\>|\<|\'|\"|\???|\:|\;|_/gi,
							'');
			//?????i kho???ng tr???ng th??nh k?? t??? g???ch ngang
			slug = slug.replace(/ /gi, "-");
			//?????i nhi???u k?? t??? g???ch ngang li??n ti???p th??nh 1 k?? t??? g???ch ngang
			//Ph??ng tr?????ng h???p ng?????i nh???p v??o qu?? nhi???u k?? t??? tr???ng
			slug = slug.replace(/\-\-\-\-\-/gi, '-');
			slug = slug.replace(/\-\-\-\-/gi, '-');
			slug = slug.replace(/\-\-\-/gi, '-');
			slug = slug.replace(/\-\-/gi, '-');
			//In slug ra textbox c?? id ???slug???
			document.getElementById('slug').value = slug;
		}
	</script>