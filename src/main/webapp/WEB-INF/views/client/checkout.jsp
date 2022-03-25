<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<div class="check">
	<div class="container">
	<div class="col-md-6 reg-form">
		<div class="container">
			<div class="reg" >
				 <form:form action="checkout" method="POST" modelAttribute="user">
				 <form:hidden path="customer_id"/>
					<ul>
						<li class="text-info">Email </li>
						<li><form:input type="text" name="ship_email" class="ship_email" path="shipping_email"/></li>
					</ul>
					<ul>
						<li class="text-info">Họ tên người nhận: </li>
						<li><form:input type="text" class="ship_name" path="shipping_name"/></li>
					 </ul>
                     <ul>
						<li class="text-info">Số điện thoại: </li>
						<li><form:input type="text" class="ship_phone" path="shipping_phone"/></li>
					</ul>				 
					<ul>
						<li class="text-info">Địa chỉ nhận hàng: </li>
						<li><form:input type="text" class="ship_address" path="shipping_address"/></li>
					</ul>
				
					<ul>
						<li class="text-info">Ghi chú thêm:</li>
						<li><form:input type="text" class="ship_note" path="order_note"/></li>
					</ul>
                    <ul>
                        <li class="text-info">Chọn hình thức</li>
                        <form:select path="shipping_type" >
                           <form:option value="0" label="Tiền mặt"/>  
                           <form:option value="1" label="Thanh toán"/>  
                        </form:select>
                    </ul>					
					<input type="submit" class="send_order" value="Xác nhận đặt hàng">
				</form:form>
			</div>
		</div>
	</div>
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
			<h1>Giỏ hàng của tôi</h1>

			<c:if test="${Cart != null || Cart.size() != 0}">
				<c:forEach var="item" items="${Cart }">
					<div class="cart-header">
						<div class="close1"
							data-id="<c:url value='/delete-cart/${item.key }'/>">

							<span class="glyphicon glyphicon-remove" aria-hidden="true"><a
								href='#'></a> </span>
						</div>
						<div class="cart-sec simpleCart_shelfItem">
							<div class="cart-item cyc">
								<img src="${item.value.products.image }" class="img-responsive"
									alt="" />
							</div>
							<div class="cart-item-info">
								<ul class="qty">
									<li>
										<p>${item.value.products.name }</p>
									</li>
									<li>
										<p>
											Số lượng :<input type="number"
												value="${item.value.quantity }"
												style="width: 50px; text-align: center" min="1"
												id="quantity-cart-${item.key }">
										</p>
										<button onclick="EditQuantityCart();" data-id="${item.key }"
											type="button" class="btn btn-default editcart">Edit</button>
									</li>
									<li>
										<p>
											Tổng cộng :
											<fmt:formatNumber
												value="${item.value.products.promotionPrice * item.value.quantity }"
												type="currency" currencySymbol="VND" currencyCode="VND" />
										</p>
									</li>
								</ul>
							</div>
							<div class="clearfix"></div>

						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${Cart == null || Cart.size() == 0 }">
				Giỏ hàng trống, vui lòng mua gì đó
				<a class="order" href="<c:url value='/trang-chu' />">Buy sth</a>
			</c:if>



		</div>



		<div class="clearfix"></div>
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