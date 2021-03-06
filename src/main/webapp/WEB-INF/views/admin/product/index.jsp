<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>

							<th>Name</th>
							<th>Category</th>
							<th>Image</th>
							<th>Status</th>
							<th>Highlights</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="item" items="${model.listResult}">
							<tr>

								<td>${item.name}</td>
								<td>${item.categoryName}</td>
								<td><img alt="" src="${item.image}" height="100px"></td>
								<td><c:if test="${item.status == false }">
										<c:url var="activeStatus" value="/admin/product/activestatus">
											<c:param name="id">${item.iD}</c:param>
										</c:url>
										<a href='${activeStatus}'><i class="fa fa-pencil-square-o"
											aria-hidden="true"></i><span
											class="fa-toggle-styling fa fa-solid fa-toggle-off"></span></a>

									</c:if> <c:if test="${item.status == true }">
										<c:url var="unactivestatus"
											value="/admin/product/unactivestatus">
											<c:param name="id">${item.iD}</c:param>
										</c:url>
										<a href='${unactivestatus}'><i
											class="fa fa-pencil-square-o" aria-hidden="true"></i><span
											class="fa-toggle-styling fa fa-solid fa-toggle-on"></span></a>

									</c:if></td>
								<td><c:if test="${item.highlights == false }">
										<c:url var="activehighlights"
											value="/admin/product/activehighlights">
											<c:param name="id">${item.iD}</c:param>
										</c:url>
										<a href='${activehighlights}'><i
											class="fa fa-pencil-square-o" aria-hidden="true"></i><span
											class="fa-toggle-styling fa fa-solid fa-toggle-off"></span></a>

									</c:if> <c:if test="${item.highlights == true }">
										<c:url var="unactivehighlights"
											value="/admin/product/unactivehighlights">
											<c:param name="id">${item.iD}</c:param>
										</c:url>
										<a href='${unactivehighlights}'><i
											class="fa fa-pencil-square-o" aria-hidden="true"></i><span
											class="fa-toggle-styling fa fa-solid fa-toggle-on"></span></a>

									</c:if></td>
								<td><c:url var="updateNewURL" value="/admin/product/edit">
										<c:param name="id">${item.iD}</c:param>
									</c:url> <c:url var="deleteCate" value="/admin/product/delete">
										<c:param name="id">${item.iD}</c:param>
									</c:url> <a class="btn btn-sm btn-primary btn-edit"
									data-toggle="tooltip" title="C???p nh???t b??i vi???t"
									href='${updateNewURL}'><i class="fa fa-pencil-square-o"
										aria-hidden="true"></i>Ch???nh s???a </a> <a id="deleteProduct"
									class="deleteProduct" data-target="#deleteP"
									data-toggle="modal" data-path="${deleteCate}">Delete</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>

<div class="modal fade" id="deleteP" tabindex="-1" role="basic"
	aria-hidden="true" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true"></button>
				<h4 class="modal-title">Delete Confirmation</h4>
			</div>
			<div class="modal-body">Are you sure you want to delete this
				item?</div>
			<div class="modal-footer">
				<button data-dismiss="modal" type="button" class="btn btn-default">Cancel</button>
				<button id="btnContinue" type="button" class="btn btn-primary">Delete</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var path_to_delete;

	$(".status").click(function(e) {
		path_to_delete = $(this).data('path');
	});
	$(".deleteProduct").click(function(e) {
		path_to_delete = $(this).data('path');
	});
	$('#btnContinue').click(function() {
		window.location = path_to_delete;
	});
</script>