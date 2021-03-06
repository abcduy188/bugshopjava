<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
.abc {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: none;
	background-color: #3CBC8D;
	color: white;

}
</style>
<div class="container" style="margin-top: 100px; font-size: 20px">
	<div class="main-body">
		<!-- Breadcrumb -->
		<nav aria-label="breadcrumb" class="main-breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Home</a></li>
				<li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>
				<li class="breadcrumb-item active" aria-current="page">User
					Profile</li>
			</ol>
		</nav>

		<div class="row gutters-sm">
			<div class="col-md-4 mb-3">
				<div class="card">
					<div class="card-body">
						<div class="d-flex flex-column align-items-center text-center">
							<img
								src="data:image/png;base64,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"
								alt="Admin" class="rounded-circle" width="150">
							<div class="mt-3">
								<h4>${model.name}</h4>

								<p class="text-muted font-size-sm">${model.address }</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card mb-3">
					<div class="card-body" >
						<c:url value="/updateuser" var="action">
						</c:url>
						<form:form action="${action}" modelAttribute="model" method="post"
							class="mx-1 mx-md-4">
							<form:hidden path="iD" />
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Email</h5>
								</div>
								<div class="col-sm-9 text-secondary">Email</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">H??? t??n</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<form:input path="name" class="abc" type="text" />
								</div>
							</div>


							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">S??? ??i???n tho???i</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<form:input path="phone" class="abc" type="text" name="phone" />
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">?????a ch???</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<form:input path="address" class="abc" type="text"
										name="address" />
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<input type="submit" style="width: 100%"
										class="btn btn-default" value="C???p nh???t">
								</div>
							</div>
						</form:form>
					</div>
					<a href="{{URL::to ('/doi-mat-khau') }}" class="btn btn-default">?????i
						m???t kh???u</a>
				</div>
			</div>

			<div style="min-width: 700px; font-size: 20px;">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>M?? ????n h??ng</th>
							<th>T??nh tr???ng ????n h??ng</th>
							<th>Ng??y ?????t</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${listOrders}">
							<tr>

								<td>${item.order_code }</td>

								<td><c:if test="${item.status == 1 }">
										<span style="color: green">????n h??ng m???i</span>
									</c:if> <c:if test="${item.status != 1 }">
										<span style="color: crimson">???? x??? l??</span>
									</c:if></td>
								<td>
								${item.createDate }
								</td>
								<td><a href="<c:url value="/details-order/${item.order_id }" />">Chi
										ti???t</a></td>
							</tr>

						</c:forEach>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>