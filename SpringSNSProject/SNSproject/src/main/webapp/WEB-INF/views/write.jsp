<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name=viewport content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="css/core2.css" media="only screen and (min-width:800px)">
<title>My Social Network</title>
<style>
.form-mtxt {
	float: left;
	width: 100%;
	padding: 10px 15px;
	line-height: 1.5em;
	background-color: white;
	font-size: 1.1em;
	border: 1px solid #ddd;
	border-radius: 10px;
	outline: none;
}
.form-txbn {
	float: left;
	width: 100%;
}
.form-txbn .text {
	float: left;
	line-height: 32px;
}
.form-txbn .button {
	float: right;
	padding: 5px 20px;
	font-size: 0.9em;
	background-color: white;
	text-align: center;
	color: #24C;
	border: 1px solid #24C;
	border-radius: 8px;
	cursor: pointer;
}
.image-pane {
	float: left;
	width: 100%;
	min-height: 150px;
	padding: 5px;
	background-color: white;
	box-sizing: border-box;
	border: 1px solid #ddd;
	border-radius: 10px;
}
</style>
</head>
<body>
	<div class="page-hdr"> 글쓰기
		<div class="back" onclick="history.back()"></div>
	</div>
	<div class="section bg-eee phor-16">
		<textarea id="--desc" class="form-mtxt mtop-20 mbot-20" rows=5 placeholder="나누고자 하는 이야기를 올려보세요."></textarea>
		<div class="form-txbn">
			<div class="text">이미지 리스트</div>
			<div class="button" onclick="openImage()">사진추가</div>
		</div>
		<div id="--img-pane" class="image-pane mtop-10 mbot-20"></div>
		
		<div class="section mbot-30">
			<div class="form-submit" onclick="upload()">작성글을 업로드합니다.</div>
		</div>
	</div>
	<div class="page-footer">MYSNS COMPANY 2017</div>
</body>
</html>

<script src="js/jquery-1.12.0.min.js"></script>
<script src="js/core.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	AJAX.call("jsp/session.jsp", null, function (data) {
		var id = data.trim();
		if (id == "NA") {
			window.location.href = "login.html";
		}
		else {
			start(id);
		}
	});
});

var pagectx = {};
function start(id) {
	pagectx.id = id;
	
	ImageUploader.init("#--img-pane");
}

function openImage() {
	ImageUploader.open();
}

function upload() {
	if (check() == false) return;
	
	// make the HTTP request in a form of the "Form data"
	var params = new FormData();
	params.append("id", pagectx.id);
	params.append("desc", $("#--desc").val().trim());

	var images = ImageUploader.get();
	for(var i=0; i<images.length; i++) {
		params.append("image", images[i]);
	}
	
	AJAX.formCall("jsp/write.jsp", params, function(data) {
		alert("작성글을 업로드하였습니다.");
		history.back();
	});
}

function check() {
	var pass = $("#--desc").val().trim();
	if (pass == "") {
		alert("나누고자 하는 글을 입력해주세요.");
		return false;
	}
	return true;
}
</script>