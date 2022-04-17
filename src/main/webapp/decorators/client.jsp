<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>N-Air</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="N-Air Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	 






</script>
<meta charset utf="8">
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Fredoka+One'
	rel='stylesheet' type='text/css'>

<!--fonts-->
<link href="<c:url value ='/template/client/css/form.css'/>"
	rel="stylesheet" type="text/css" media="all" />
<!--bootstrap-->
<link href="<c:url value ='/template/client/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css">
<!--coustom css-->
<link href="<c:url value ='/template/client/css/style.css'/>"
	rel="stylesheet" type="text/css" />
<!--shop-kart-js-->
<script src="<c:url value ='/template/client/js/simpleCart.min.js'/>"></script>
<!--default-js-->
<script src="<c:url value ='/template/client/js/jquery-2.1.4.min.js'/>"></script>
<!--bootstrap-js-->
<script src="<c:url value ='/template/client/js/bootstrap.min.js'/>"></script>

<!-- FlexSlider -->
<script src="<c:url value ='/template/client/js/imagezoom.js'/>"></script>
<script defer
	src="<c:url value ='/template/client/js/jquery.flexslider.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value ='/template/client/css/flexslider.css'/>"
	type="text/css" media="screen" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>
<!--script-->
</head>
<body>
	<!-- Header -->
	<%@ include file="/WEB-INF/views/common/client/header.jsp"%>
	<dec:body />
	<%@ include file="/WEB-INF/views/common/client/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>