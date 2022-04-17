<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<c:url var="api" value="/admin/slides/create" />
<div class="container-fluid">
	<div class="card">
		<div class="card-body">
			<div class="card-title">Product</div>
			<hr>
			<form:form modelAttribute="model" enctype="multipart/form-data"
				action="${api}">
				<div class="form-group">
					<label for="input-1">Name: </label>
					<form:input path="slide_name" type="text" class="form-control"
						id="slide_name"  />
				</div>
				<div class="form-group">
					<label for="input-2">desc</label>
					<form:input path="slide_desc" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="input-3">Image</label>
					<form:input path="imagefile" id="imagefile" type="file"
						cssClass="form-control" />
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