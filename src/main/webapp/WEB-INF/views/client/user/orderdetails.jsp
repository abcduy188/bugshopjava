<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="main-body">
		<!-- Breadcrumb -->
		<nav aria-label="breadcrumb" class="main-breadcrumb"
			style="margin-top: 100px">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Home</a></li>
				<li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>
				<li class="breadcrumb-item active" aria-current="page">User
					Profile</li>
			</ol>
		</nav>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Chi tiết đơn hàng</h6>
			</div>
			<div class="card-body">
				<div>
					<table class="table table-bordered" style="font-size: 15px">
						<thead>
							<tr>
								<th>Tên người đặt</th>
								<th>Tên người nhận</th>
								<th>Địa chỉ người nhận</th>
								<th>Số điện thoại người nhận</th>
								<th>Ghi chú</th>
								<th>Hình thức thanh toán</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Name</td>
								<td>${order.shipping_name }</td>
								<td>${order.shipping_address }</td>
								<td>${order.shipping_phone }</td>
								<td>${order.order_note }</td>
								<td><c:if test="${order.shipping_type == 1 }">
										<span style="color: green">Tiền mặt</span>
									</c:if> <c:if test="${order.shipping_type != 1 }">
										<span style="color: crimson">Chuyển khoản</span>
									</c:if></td>
								<td>
								<c:url var="cancelclient" value="/orders/cancel">
								<c:param name="id">${order.order_id }</c:param>
							</c:url>
								<c:if test="${order.status == 1 }">
										<a id="deleteUser" class="deleteUser" data-target="#cacel"
											data-toggle="modal"
											data-path="${cancelclient }">Hủy
											đơn</a>
									</c:if> <c:if test="${order.status != 1 }">
										<span style="color: crimson">Đã xử lí</span>
									</c:if></td>
							</tr>
						</tbody>
					</table>
				</div>
				<h5>Chi tiết hóa đơn</h5>
				<div class="table-responsive" style="font-size: 15px">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Tên sản phẩm</th>
								<th>Số lượng</th>
								<th>Tổng tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${listDetails }">
								<tr>

									<td>${item.product_name }</td>
									<td>${item.product_sales_quantity }</td>

									<td><fmt:formatNumber value="${item.product_price }"
											type="currency" currencySymbol="VND" currencyCode="VND" /></td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div class="modal fade" id="cacel" tabindex="-1" role="basic"
			aria-hidden="true" style="display: none;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Hủy đơn hàng</h4>
					</div>
					<div class="modal-body">bạn muốn hủy đơn hàng này?</div>
					<div class="modal-footer">
						<button data-dismiss="modal" type="button" class="btn btn-default">Cancel</button>
						<button id="btnContinueDelete" type="button"
							class="btn btn-primary">Delete</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	var path_to_delete;

	$(".deleteUser").click(function(e) {
		path_to_delete = $(this).data('path');
	});

	$('#btnContinueDelete').click(function() {
		window.location = path_to_delete;
	});
	$('#btnAccept').click(function() {
		window.location = path_to_delete;
	});
</script>