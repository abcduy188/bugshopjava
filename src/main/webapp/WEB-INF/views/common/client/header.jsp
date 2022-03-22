<%@ page import="com.bugshop.utils.SecurityUtils"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="container">
		<div class="header-top">
			<div class="logo">
				<a href="index.html">N-AIR</a>
			</div>
			<security:authorize access="isAnonymous()">
				<div class="login-bars">
					<a class="btn btn-default log-bar"
						href="<c:url value='/dang-ky' />" role="button">Sign up</a> <a
						class="btn btn-default log-bar"
						href="<c:url value='/dang-nhap' />" role="button">Login</a>
					<div class="cart box_1">
						<a href="<c:url value ='/gio-hang'/>">
							<h3>
								<c:if test="${Cart != null  }">
									<div class="total">
										<span class=""><fmt:formatNumber value="${TotalP}"
												type="currency" currencySymbol="VND" currencyCode="VND" /></span>(${TotalQ })
									</div>

								</c:if>
								<c:if test="${Cart == null  }">
									<div class="total">
										<span class="">0</span>(0)
									</div>

								</c:if>
							</h3>
						</a>
						<p>
							<a href="<c:url value ='/gio-hang'/>" class="simpleCart_empty">
								Cart</a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>

			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<div class="login-bars">
					<a class="btn btn-default log-bar" href="register.html"
						role="button">Welcome <%=SecurityUtils.getPrincipal().getName()%></a>
					<a class="btn btn-default log-bar" href="<c:url value='/thoat' />"
						role="button">Logout</a>
					<div class="cart box_1">
						<a href="<c:url value ='/gio-hang'/>">
							<h3>
								<c:if test="${Cart != null  }">
									<div class="total">
										<span class=""><fmt:formatNumber value="${TotalP}"
												type="currency" currencySymbol="VND" currencyCode="VND" /></span>(${TotalQ })
									</div>

								</c:if>
								<c:if test="${Cart == null  }">
									<div class="total">
										<span class="">0</span>(0)
									</div>

								</c:if>
							</h3>
						</a>
						<p>
							<a href="<c:url value ='/gio-hang'/>" class="simpleCart_empty">
								Cart</a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>

			</security:authorize>



			<div class="clearfix"></div>
		</div>
		<!---menu-----bar--->
		<div class="header-botom">
			<div class="content white">
				<nav class="navbar navbar-default nav-menu" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="clearfix"></div>
					<!--/.navbar-header-->

					<div class="collapse navbar-collapse collapse-pdng"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav nav-font">
							<c:forEach var="item" items="${catelist.listResult}">
								<li class="dropdown"><a
									href='<c:url value='/danh-muc'>
											<c:param name="id">${item.iD}</c:param>
										</c:url>'>${item.categoryName}</a></li>
							</c:forEach>
							<div class="clearfix"></div>
						</ul>
						<div class="clearfix"></div>
					</div>
					<!--/.navbar-collapse-->
					<div class="clearfix"></div>
				</nav>
				<!--/.navbar-->
				<div class="clearfix"></div>
			</div>
			<!--/.content--->
		</div>
		<!--header-bottom-->
	</div>
</div>