<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<div class="check">
	<div class="container">

		<div class="col-md-3 cart-total">
			<a class="continue" href="#">Tiếp tục mua hàng</a>
			<div class="price-details">
				<h3>Price Details</h3>
				<span>Tổng tiền</span> <span class="total1">VND</span> <span>Discount</span>
				<span class="total1">10%(Festival Offer)</span> <span>Delivery
					Charges</span> <span class="total1">150.00</span>
				<div class="clearfix"></div>
			</div>
			<hr class="featurette-divider">
			<ul class="total_price">
				<li class="last_price">
					<h4>TOTAL</h4>
				</li>

				<li class="last_price"><span>VND</span></li>
				<div class="clearfix"></div>
			</ul>
			<div class="clearfix"></div>
			<a class="order" href="#">Đặt hàng</a>
		</div>
		<div class="col-md-9 cart-items">
			<h1>Giỏ hàng của tôi ( )</h1>
			<form action="" method="POST">

				<div class="cart-header" id="class-product-{{$item['session_id']}}">
					<div class="close1" data-id="{{ $item['session_id'] }}">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"><a
							href="{{ url('/del-cart-ajax/' .$item['session_id']) }}"></a> </span>
					</div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<img src="{{ $item['product_image'] }}" class="img-responsive"
								alt="" />
						</div>
						<div class="cart-item-info">
							<ul class="qty">
								<li>
									<p>Name</p>
								</li>
								<li>

									<p>
										Số lượng :<input type="number" value="1"
											style="width: 50px; text-align: center" min="1">
									</p>
								</li>
								<li>
									<p>Tổng cộng : VND</p>
								</li>
							</ul>
							<div class="delivery">
								<p>Service Charges : Rs.190.00</p>
								<span>Delivered in 2-3 bussiness days</span>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>

					</div>
				</div>

				<div class="cart-header">
					<div class="cart-sec simpleCart_shelfItem">
						<input type="submit" id="btn_update_qty"
							class="btn btn-default btn-sm" value="Cập nhật giỏ hàng"
							name="update_qty" style="background: black; color: white;"
							onmouseover="this.style.color='red'"> <a class="order"
							href="{{ url('/delete-all-cart') }}">Xóa tất cả</a>
					</div>
				</div>
			</form>


		</div>
		
		<div class="col-md-3 cart-total">


			<span>Giỏ hàng trống</span> <a class="order"
				href="{{ url('/trang-chu') }}">Mua hàng</a>
		</div>

		


		<div class="clearfix"></div>
	</div>
</div>
<script>
	$(document).ready(function(c) {
		$('.close1').on('click', function(c) {
			var id = $(this).data('id');
			window.location.href = 'del-cart-ajax/' + id;
			$('#class-product-' + id).fadeOut('slow', function(c) {
				$('#class-product-' + id).remove();

			});
		});
	});
</script>