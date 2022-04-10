<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">abcduy</h1>


	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Chi tiết đơn hàng</h6>
		</div>
		<div class="card-body">
			<div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Tên người đặt</th>
							<th>Tên người nhận</th>
							<th>Địa chỉ người nhận</th>
							<th>Số điện thoại người nhận</th>
							<th>Ghi chú</th>
							
							<th>Tình trạng</th>
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
							<td>
							<c:if test="${order.status == 1 }">
									<span style="color: orange">Đang chờ</span>
								</c:if> <c:if test="${order.status == 2 }">
									<span style="color: green">Đang giao hàng</span>
								</c:if>
								<c:if test="${order.status == 0 }">
									<span style="color: crimson">Đã huỷ</span>
								</c:if>
							</td>
							<td><c:if test="${order.shipping_type == 1 }">
									<span style="color: green">Tiền mặt</span>
								</c:if> <c:if test="${order.shipping_type != 1 }">
									<span style="color: crimson">Chuyển khoản</span>
								</c:if></td>
							<c:url var="cancel" value="/admin/orders/cancel">
								<c:param name="id">${order.order_id }</c:param>
							</c:url>
							<c:url var="accept" value="/admin/orders/accept">
								<c:param name="id">${order.order_id }</c:param>
							</c:url>
							<td><a id="deleteUser" class="deleteUser"
								data-target="#cacel" data-toggle="modal" data-path="${cancel }">Hủy
									đơn</a> || <a id="deleteUser" class="deleteUser"
								data-target="#accept" data-toggle="modal"
								data-path=" ${accept }">Giao hàng</a></td>


						</tr>

					</tbody>
				</table>
			</div>
			<h5>Chi tiết hóa đơn</h5>
			<div class="table-responsive">
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
	<div class="modal fade" id="accept" tabindex="-1" role="basic"
		aria-hidden="true" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Chấp nhận</h4>
				</div>
				<div class="modal-body">Bạn muốn giao đơn hàng này?</div>
				<div class="modal-footer">
					<button data-dismiss="modal" type="button" class="btn btn-default">Cancel</button>
					<button id="btnAccept" type="button" class="btn btn-primary">Chấp
						nhận</button>
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