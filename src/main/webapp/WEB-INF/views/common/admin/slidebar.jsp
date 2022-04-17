<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<c:url value="/" var="admin" />
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			SB Admin <sup>2</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href="index.html">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->


	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Đơn
				hàng</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href='<c:url value='/admin/orders'/>'>Danh
					sách đơn hàng</a>
			</div>
		</div></li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span>Sản phẩm</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">

				<a class="collapse-item" href="${admin}admin/product">Danh sách
					sản phẩm</a> <a class="collapse-item"
					href="${admin}admin/product/deleted">Sản phẩm đã xóa</a> <a
					class="collapse-item" href="${admin}admin/product/create">Thêm
					sản phẩm</a>
			</div>
		</div></li>
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsecate"
		aria-expanded="true" aria-controls="collapsecate"> <i
			class="fas fa-fw fa-wrench"></i> <span>Danh mục</span>
	</a>
		<div id="collapsecate" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">

				<a class="collapse-item" href="${admin}admin/category">Danh sách
					danh mục</a> <a class="collapse-item"
					href="${admin}admin/category/create">Thêm sản phẩm</a>
			</div>
		</div></li>
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseuser"
		aria-expanded="true" aria-controls="collapseuser"> <i
			class="fas fa-fw fa-cog"></i> <span>Người dùng</span>
	</a>
		<div id="collapseuser" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href='<c:url value='/admin/user'/>'>Danh
					sách người dùng</a>
			</div>
		</div></li>
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseslide"
		aria-expanded="true" aria-controls="collapseslide"> <i
			class="fas fa-fw fa-cog"></i> <span>Slides</span>
	</a>
		<div id="collapseslide" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href='<c:url value='/admin/slides'/>'>Danh
					sách slide</a>
						<a class="collapse-item" href='<c:url value='/admin/slides/create'/>'>Thêm slide</a>
			</div>
		</div></li>

</ul>
<!-- End of Sidebar -->