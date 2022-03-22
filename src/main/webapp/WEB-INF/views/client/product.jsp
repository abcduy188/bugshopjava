<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<div class="showcase-grid">


	<div class="container">
		<div class="col-md-8 showcase">
			<div class="flexslider">
				<ul class="slides">
					<li data-thumb="${productlist.image}">
						<div class="thumb-image">
							<img src="${productlist.image}" data-imagezoom="true"
								class="img-responsive" style="height: 400px; width: auto">
						</div>
					</li>
				
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="col-md-4 showcase">
			<div class="showcase-rt-top">
				<div class="pull-left shoe-name">
					<h3>${productlist.name}</h3>
					<p></p>
					<h4 style="color: red">
						<fmt:formatNumber value="${productlist.price }" type="currency"
							currencyCode="VND" />
					</h4>
				</div>
				<div class="pull-left rating-stars">
					<ul>
						<li><a href="#" class="active"><span
								class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
						<li><a href="#" class="active"><span
								class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
						<li><a href="#" class="active"><span
								class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<hr class="featurette-divider">
			<div class="shocase-rt-bot">
				<ul>
					<li class="ad-2-crt simpleCart_shelfItem"><a
						class="btn item_add" href="<c:url value='/add-cart/${productlist.iD}'/>" role="button">Add To Cart</a> <a
						class="btn" href="#" role="button">Buy Now</a></li>
				</ul>
			</div>
			<div class="showcase-last">
				<h3>product details</h3>
				<ul>
					<li>${ productlist.description }</li>

				</ul>

			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="specifications">
	<div class="container">
		<h3>Item Details</h3>
		<div class="detai-tabs">
			<!-- Nav tabs -->
			<ul class="nav nav-pills tab-nike" role="tablist">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">Highlights</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">Description</a></li>
				<li role="presentation"><a href="#messages"
					aria-controls="messages" role="tab" data-toggle="tab">Terms &
						conditiona</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">
					<p>The full-length Max Air unit delivers excellent cushioning
						with enhanced flexibility for smoother transitions through
						footstrike.</p>
					<p>Dynamic Flywire cables integrate with the laces and wrap
						your midfoot for a truly adaptive, supportive fit.</p>
				</div>
				<div role="tabpanel" class="tab-pane" id="profile">
					<p>Nike is one of the leading manufacturer and supplier of
						sports equipment, footwear and apparels. Nike is a global brand
						and it continuously creates products using high technology and
						design innovation. Nike has a vast collection of sports shoes for
						men at Snapdeal. You can explore our range of basketball shoes,
						football shoes, cricket shoes, tennis shoes, running shoes, daily
						shoes or lifestyle shoes. Take your pick from an array of sports
						shoes in vibrant colours like red, yellow, green, blue, brown,
						black, grey, olive, pink, beige and white. Designed for top
						performance, these shoes match the way you play or run. Available
						in materials like leather, canvas, suede leather, faux leather,
						mesh etc, these shoes are lightweight, comfortable, sturdy and
						extremely sporty. The sole of all Nike shoes is designed to
						provide an increased amount of comfort and the material is good
						enough to provide an improved fit. These shoes are easy to
						maintain and last for a really long time given to their
						durability. Buy Nike shoes for men online with us at some
						unbelievable discounts and great prices. So get faster and run
						farther with your Nike shoes and track how hard you can play.</p>
				</div>
				<div role="tabpanel" class="tab-pane" id="messages">The images
					represent actual product though color of the image and product may
					slightly differ.</div>
			</div>
		</div>
	</div>
</div>

<div class="you-might-like">
	<div class="container">
		<h3 class="you-might">Sản phẩm liên quan</h3>

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