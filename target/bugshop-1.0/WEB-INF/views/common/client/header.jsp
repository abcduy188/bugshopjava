<%@ page import="com.bugshop.utils.SecurityUtils"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class=" header" style="margin-bottom: 100px;">
	<div class="container fixed-top">
		<nav class="navbar navbar-expand-lg navbar-white bg-white"
			style="height: 100px;">
			<div class="logo">
				<a href="<c:url value='/trang-chu' />"> <img alt=""
					src="template/login/images/logo.png" style="width: 150px;"></a>

			</div>
			<form style="margin-left: 20px;width: 250px;" method="get"
				action="<c:url value = "/tim-kiem"/>" class="d-flex">
				<input class="form-control me-2" id="txt" name="name" type="search"
					placeholder="Search" aria-label="Search">
				<button id="button-id" class="btn btn-outline-success" type="submit">Search</button>
			</form>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#movieNavbar" aria-controls="navbarSupportedContent"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="movieNavbar">
				<ul class="navbar-nav mr-auto ml-auto">
					<c:forEach var="item" items="${catelist.listResult}">
						<li class="dropdown"><a
							href='<c:url value='/danh-muc'>
											<c:param name="id">${item.iD}</c:param>
										</c:url>'>${item.categoryName}</a></li>
					</c:forEach>
					<div class="clearfix"></div>
				</ul>

			</div>
			<security:authorize access="isAnonymous()">
				<div class="login-bars">
					<a class="btn btn-primary log-bar"
						href="<c:url value='/dang-ky' />" role="button">Sign up</a> <a
						class="btn btn-default log-bar"
						href="<c:url value='/dang-nhap' />" role="button" style="color: blue;background: border-box;border: 0.5px solid;">Login</a>
					<div class="cart box_1">
						<a  href="<c:url value ='/gio-hang'/>">
							<h3 >
								<c:if test="${Cart != null  }">
									<div class="total" style="color: black;">
										<span class=""><fmt:formatNumber value="${TotalP}"
												type="currency" currencySymbol="VND" currencyCode="VND" /></span>(${TotalQ })
									</div>

								</c:if>
								<c:if test="${Cart == null  }">
									<div class="total"  style="color: black;">
										<span class="">0</span>(0)
									</div>

								</c:if>
							</h3>
						</a>
						<p>
							<a href="<c:url value ='/gio-hang'/>" class="simpleCart_empty">
								<i style="color: black;font-size: 20px;" class="fa-solid fa-cart-arrow-down"></i></a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<div class="login-bars">
					<a class="btn btn-success log-bar" href="register.html"
						role="button">Welcome <%=SecurityUtils.getPrincipal().getName()%></a>
					<a class="btn btn-default log-bar" href="<c:url value='/thoat' />"
						role="button" style="color: blue;background: border-box;border: 0.5px solid;">Logout</a>
					<div class="cart box_1">
						<a href="<c:url value ='/gio-hang'/>">
							<h3>
								<c:if test="${Cart != null  }">
									<div class="total" style="color: black;">
										<span class=""><fmt:formatNumber value="${TotalP}"
												type="currency" currencySymbol="VND" currencyCode="VND" /></span>(${TotalQ })
									</div>
								</c:if>
								<c:if test="${Cart == null  }">
									<div class="total" style="color: black;">
										<span class="">0</span>(0)
									</div>

								</c:if>
							</h3>
						</a>
						<p>
							<a href="<c:url value ='/gio-hang'/>" class="simpleCart_empty">
								<i style="color: black;font-size: 20px;" class="fa-solid fa-cart-arrow-down"></i></a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>
			</security:authorize>
			<div class="clearfix"></div>
		</nav>
	</div>
</header>

