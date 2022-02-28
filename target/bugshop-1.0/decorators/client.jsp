<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>N-Air</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="N-Air Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

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
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet"
	href="<c:url value ='/template/client/css/flexslider.css'/>"
	type="text/css" media="screen" />

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
	<%@ include file="/common/client/header.jsp"%>
	<dec:body />
	<%@ include file="/common/client/footer.jsp"%>
</body>
</html>