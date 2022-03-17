<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
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
									</c:url>
									
									<c:url var="deleteCate" value="/admin/category/delete">
										<c:param name="id">${duy.iD}</c:param>
									</c:url>
									 <a class="btn btn-sm btn-primary btn-edit"
									data-toggle="tooltip" title="Cập nhật bài viết"
									href='${updateNewURL}'><i class="fa fa-pencil-square-o"
										aria-hidden="true"></i>Chỉnh sửa </a>
										
										<a id="deleteUser" class="deleteUser" data-target="#basic"
                                       data-toggle="modal"
                                       data-path="${deleteCate}">Delete</a>
										
										
										</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>

<div class="modal fade" id="basic" tabindex="-1" role="basic" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">Delete Confirmation</h4>
            </div>
            <div class="modal-body">
                Are you sure you want to delete this item?
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" type="button" class="btn btn-default">Cancel</button>
                <button id="btnContinue" type="button" class="btn btn-primary">Delete</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
var path_to_delete;

$(".status").click(function (e) {
    path_to_delete = $(this).data('path');
});
$(".deleteUser").click(function (e) {
    path_to_delete = $(this).data('path');
});
$('#btnContinue').click(function () {
    window.location = path_to_delete;
});
</script>
<!-- /.container-fluid -->