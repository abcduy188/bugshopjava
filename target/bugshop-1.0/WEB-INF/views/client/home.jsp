<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
	<div class="header-end" style="padding-top: 100px;">
		<div class="container">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox" style="height: 350px;">
					<%
					int i = 0;
					%>
					<c:forEach var="item" items="${slides.listResult }">

						<%
						i++;
						if (i == 1) {
						%>

						<div class="item active">
							<img src="${item.slide_image }" alt="..." />
							<div class="carousel-caption car-re-posn">
								<h3>AirMax</h3>
								<h4>You feel to fall</h4>
								<span class="color-bar"></span>
							</div>
						</div>
						<%
						} else {
						%>
						<div class="item">
							<img src="${item.slide_image }" alt="..." />
							<div class="carousel-caption car-re-posn">
								<h3>${item.slide_name }</h3>
								<h4>${item.slide_desc }</h4>
								<span class="color-bar"></span>
							</div>
						</div>
						<%
						}
						%>


					</c:forEach>

				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left car-icn" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right car-icn"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="feel-fall">
		<div class="container">
			<div class="pull-left fal-box">
				<div class=" fall-left">
					<h3>Fall</h3>
					<img src="<c:url value='/template/client/images/f-l.png'/>" alt="/"
						class="img-responsive fl-img-wid" />
					<p>
						Inspiration and innovation<br> for every athlete in the world
					</p>
					<span class="fel-fal-bar"></span>
				</div>
			</div>
			<div class="pull-right fel-box">
				<div class="feel-right">
					<h3>Feel</h3>
					<img src="<c:url value='/template/client/images/f-r.png'/>" alt="/"
						class="img-responsive fl-img-wid" />
					<p>
						Inspiration and innovation<br> for every athlete in the world
					</p>
					<span class="fel-fal-bar2"></span>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="shop-grid">
		<div class="container">
			<c:forEach var="item" items="${highlights.listResult}">
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

</body>