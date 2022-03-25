<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<div class="check">
	<div class="container">

		<div class="col-md-3 cart-total">
			<a class="continue" href='<c:url value='/trang-chu'/>'>Tiếp tục mua hàng</a>
			<div class="price-details">
				<h3>Price Details</h3>
				<span>Tổng tiền</span> <span class="total1"><fmt:formatNumber
						value="${TotalP}" type="currency" currencySymbol="VND"
						currencyCode="VND" /></span>

			</div>
			<hr class="featurette-divider">
			<ul class="total_price">
				<li class="last_price">
					<h4>TOTAL</h4>
				</li>

				<li class="last_price"><span><fmt:formatNumber
							value="${TotalP}" type="currency" currencySymbol="VND"
							currencyCode="VND" /></span></li>
				<div class="clearfix"></div>
			</ul>
			<div class="clearfix"></div>
			<a class="order" href="<c:url value='/dat-hang' />">Đặt hàng</a>
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
	</div>
</div>
<script>
	$(document).ready(function(c) {
		$('.close1').on('click', function(c) {
			var id = $(this).data('id');
			window.location.href = id;
			$('#class-product-' + id).fadeOut('slow', function(c) {
				$('#class-product-' + id).remove();

			});
		});
		$('.editcart').on("click", function() {

			var id = $(this).data('id');
			var quantity = $("#quantity-cart-" + id).val();
			window.location.href = "edit-cart/" + id + "/" + quantity;
		})
	});
</script>