<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<div class="container" style="padding-top: 100px;">
	<div class="col-md-12 grid-gallery">
		<c:forEach var="item" items="${model}">
			<div class="col-md-4 grid-stn simpleCart_shelfItem">
				<!-- normal -->
				<div class="ih-item square effect3 bottom_to_top">
					<div class="bottom-2-top">
						<div class="img">
							<img src="${item.image}" alt="/" class="img-responsive gri-wid">
						</div>
						<div class="info">
							<div class="pull-left styl-hdn">
								<h3>${item.name }</h3>
							</div>
							<div class="pull-right styl-price">
								<p>

									<a href="#" class="item_add"><span
										class="glyphicon glyphicon-shopping-cart grid-cart"
										aria-hidden="true"></span> <span class=" item_price"><fmt:formatNumber
												value="${item.price}" type="currency" currencySymbol="VND"
												currencyCode="VND" /> </span></a>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- end normal -->
				<div class="quick-view">
					<a
						href='<c:url value='/san-pham/${item.seoTitle}'>
											<c:param name="id">${item.id}</c:param>
										</c:url>'>Quick
						view</a>
				</div>
			</div>
		</c:forEach>





		<div class="clearfix"></div>
	</div>
	
		<style>
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	text-decoration: none;
}

.button1 {
	border-radius: 2px;
}

.button2 {
	border-radius: 4px;
}

.button3 {
	border-radius: 8px;
}

.button4 {
	border-radius: 12px;
}

.button5 {
	border-radius: 50%;
}
</style>
	<div>
		<h4>Total Items: ${totalItems} - Page: ${currentPage } of
			${totalPages }</h4>
		<c:forEach begin="1" end="${totalPages }" var="i">
			<c:url var="page" value="/san-pham?page=${i}"></c:url>
			<a href="${page}" class="button button1">${i }</a>
		</c:forEach>
	</div>
</div>