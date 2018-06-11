<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta name=viewport content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="css/core2.css" media="only screen and (min-width:800px)">
<title>My Social Network</title>
<style>
.splash {
	position: relative;
	width: 100%; height: 100%;
	background-position: 50%;
	background-size: auto 100%;
	background-repeat: no-repeat;
	background-image: url("images/back.png");
}
.splash .darker {
	z-index: 5;
	position: absolute;
	left: 0; top: 0; 
	width: 100%; height: 100%;
	opacity: 0.25;
	background-color: black;
}
.splash .logo {
	z-index: 10;
	position: absolute;
	width: 70%; top: 42%;
	margin: 0 15%;
	padding: 10px 15px;
	box-sizing : border-box;	
	text-align: center;
	font-size: 1.2em;
	color: white;
	border: 3px solid white;
	border-radius: 30px;
}
</style>
</head>
<body>
    <div class="splash">
    	<div class="darker"></div>
    	<div class="logo">My Social Network</div>
	</div>
</body>
</html>

<script src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	setTimeout(function() {
		$("html").fadeOut("slow", function() {
			window.location.href = "login";
		});
	}, 3000);
});
</script>