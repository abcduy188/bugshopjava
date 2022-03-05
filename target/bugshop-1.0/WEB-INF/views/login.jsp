<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="template/login/images/logodc2.png" alt="IMG"  href="<c:url value='/trang-chu' />">
				</div>
				
				<form action="j_spring_security_check" id="formLogin" method="post">
				<c:if test="${param.incorrectAccount!=null}">
					<div class="alert alert-danger" >	
							Tài khoản hoặc mật khẩu không đúng
					</div>
				</c:if>
				<c:if test="${param.accessDenied!=null}">
					<div class="alert alert-danger">	
							Không phải người quản trị!!
					</div>
				</c:if>
					<span class="login100-form-title"> LOGIN </span>
					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required">
						<input class="input100" type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập" required> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-user-circle"
							aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu" required> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Login</button>
					</div>
					<div class="text-center p-t-12">
						<a class="txt2" href="<c:url value='/trang-chu' />">
							Xem sản phẩm không cần đăng nhập</a>
					</div>
					<!-- <div class="text-center p-t-136">
						<a class="txt2" href="#"> Create your Account <i
							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div> -->
				</form>
			</div>
		</div>
	</div>

	<script src="<c:url value='/template/login/vendor/jquery/jquery-3.2.1.min.js'/>"></script>

	<script src="<c:url value='/template/login/vendor/bootstrap/js/popper.js'/>"></script>
	<script src="<c:url value='/template/login/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

	<script src="<c:url value='/template/login/vendor/select2/select2.min.js'/>"></script>

	<script src="<c:url value='/template/login/vendor/tilt/tilt.jquery.min.js'/>"></script>
	<script src="<c:url value='/template/login/js/main.js'/>"></script>
</body>
</html>