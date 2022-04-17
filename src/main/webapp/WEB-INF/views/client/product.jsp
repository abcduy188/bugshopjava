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
<div class="showcase-grid" style="padding-top: 120px;">


	<div class="container">
		<div class="col-md-8 showcase">
			<div class="flexslider" style="width: 50%;">
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
						class="btn item_add" href="<c:url value='/add-cart/${productlist.iD}'/>" role="button">Thêm vào giỏ hàng</a> </li>
				</ul>
			</div>
			<div class="showcase-last">
				<h3>Chi tiết sản phẩm</h3>
				<ul>
					<li>${ productlist.description }</li>

				</ul>

			</div>
			<table class="table table-user-information" style="font-size: 14px;">
                <tbody>
                    <tr>        
                        <td>
                            <strong>
                               VGA                                             
                            </strong>
                        </td>
                        <td>
                            GTX
                        </td>
                    </tr>
                    <tr>    
                        <td>
                            <strong>
                                CPU                                                
                            </strong>
                        </td>
                        <td>
                          Intel i5-10300H
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                              RAM                                               
                            </strong>
                        </td>
                        <td>
                           4GB  
                        </td>
                    </tr>

                    <tr>        
                        <td>
                            <strong>
                                TRọng lượng
                            </strong>
                        </td>
                        <td>
                           2,3kg 
                        </td>
                    </tr>                                  
                </tbody>
            </table>
		</div>
		<div class="clearfix"></div>
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