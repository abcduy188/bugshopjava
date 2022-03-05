<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<c:url var="createCate" value="/admin/category/create">

	</c:url>
	<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
		title="Cập nhật bài viết" href='${createCate}'><i
		class="fa fa-pencil-square-o" aria-hidden="true"></i>Thêm danh mục</a>

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
							<th>${cate.categoryName}</th>
							<th>Name</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="duy" items="${model.listResult}">
							<tr>
								<td>${duy.categoryName}</td>
								<td><c:url var="updateNewURL" value="/admin/category/edit">
										<c:param name="id">${duy.iD}</c:param>
									</c:url> <a class="btn btn-sm btn-primary btn-edit"
									data-toggle="tooltip" title="Cập nhật bài viết"
									href='${updateNewURL}'><i class="fa fa-pencil-square-o"
										aria-hidden="true"></i>Chỉnh sửa </a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->