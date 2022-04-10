<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>
</head>
<div class="container" style="padding-top: 120px;">
	<div class="col-md-12 grid-gallery">
		<c:forEach var="item" items="${productlist.listResult}">
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
											<c:param name="id">${item.iD}</c:param>
										</c:url>'>Quick
						view</a>
				</div>
			</div>
		</c:forEach>





		<div class="clearfix"></div>
	</div>
</div>