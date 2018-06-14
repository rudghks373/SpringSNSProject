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
.page-msg {
	display: table;
	float: left;
	width: 100%;
	height: calc(100% - 90px);
}
.page-msg .desc {
	display: table-cell;
	text-align: center;
	vertical-align: middle;
}
.hide {
	display: none;
}
.feed {
	float: left;
	width: 100%;
	padding: 15px 0;
	box-sizing: border-box;	
	background-color: white;
	border: 1px solid #ddd;
}
.feed .face {
	float: left;
	width: 40px; height: 40px;
	border: 1px solid #ddd;
	border-radius: 40px;
	background-image: url("images/contact.jpg");
}
.feed .name {
	float: left;
	margin-left: 15px;
	line-height: 42px;
	font-size: 1.1em;
	font-weight: bold;
}
.feed .desc {
	float: left;
	width: 100%;
	padding: 15px 0px;
	box-sizing: border-box;	
}
.page-hdr .back {
	position: absolute;
	left: 10px; top: 16px;
	width: 24px; height: 24px;
	background-image: url("images/btn-back.png");
	background-size: 50%;
	background-position: 50%;
	background-repeat: no-repeat;
	cursor: pointer;
}
.page-hdr .ctxmnu {
	position: absolute;
	right: 10px; top: 18px;
	width: 20px; height: 20px;
	background-size: 20px 20px;
	background-position: 50%;
	background-repeat: no-repeat;
	cursor: pointer;
}
.page-hdr .ctxmnu.pen {
	background-image: url("images/pen.png");
}

.page-hdr .navicon {
	position: absolute;
	left: 10px; top: 16px;
	width: 24px; height: 24px;
	background-image: url("images/navicon.png");
	background-size: 24px 24px;
	background-position: 50%;
	background-repeat: no-repeat;
	cursor: pointer;
}
</style>
</head>
<body style="background-color: #eee">
	<div class="page-hdr"> MySNS
		<div class="navicon" onclick="showMenu()"></div>
		<div class="ctxmnu pen" onclick="writeNew()"></div>
	</div>
	<div class="page-mnu">
		<div class="menu" onclick="onSelect('logout')">로그아웃</div>
		<div class="menu" onclick="onSelect('close')">닫기</div>
	</div>
	<div id="--empty-msg" class="page-msg">
		<div class="desc">작성글이 존재하지 않습니다.</div>
	</div>
	<div id="--feed-list" class="section"></div>
</body>
</html>

<script src="js/jquery-1.12.0.min.js"></script>
<script src="js/core.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$.ajax({
		url : 'sessioncheck', //내가 보내는 서버주소(컨트롤러)
		dataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태
		type : 'POST', 
		data : null, //내가 서버로 보내는 데이터
		success: function (data) { 
			if (data == "OK") {
                console.log("세션값있음")
			}
			else if (data == "NO") {
				alert("로그인이 필요합니다.");
				location.replace("login");
			}			
	      }
   });
});
	

function showMenu(hide) {
	if (hide == false) {
		$(".page-mnu").css("left", "-240px");
	}
	else {
		$(".page-mnu").css("left", 0);
	}
}

function writeNew() {
	window.location.href = "write.html";
}

function onSelect(menu) {
	if (menu == "logout") {
		logout();
	}
	showMenu(false);
}

function logout() {
	if(confirm("로그아웃 하시겠습니까?") == true) {
		
	var sessiondelete = "sessiondelete";
	
		$.ajax({
			url : "sessioncheck", //내가 보내는 서버주소(컨트롤러)
			dataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태
			type : 'POST',
			data : sessiondelete, //내가 서버로 보내는 데이터
			success: function (data) { 
				if (data == "deleteOK") {
					window.location.replace("login");
				}
				
		    }
	   });
		
    }
}

function showFeeds(list) {
	var str = "";
	for (var i=0; i<list.length; i++) {
		str += showFeed(list[i]);
	}
	$("#--feed-list").html(str);
}

function showFeed(feed) {
	var str = "<div class='feed mbot-10'>";
	
	str += "<div class='section phor-16'>";
	str += "<div class='face flex-embed'></div>";
	str += "<div class='name'>" + feed.id + "</div>";
	str += "<div class='desc'>" + feed.desc + "</div>";
	str += "</div>";
	
	var images = feed.images;
	if (images.length == 1) {
		str += "<div class='section'>";
		str += "<div class='flex-embed r16by9' style='background-image: url(\"" + getUrl(feed, 0) + "\")'></div>";
		str += "</div>";
	}
	else if (images.length == 2) {
		str += "<div class='grid-50'>";
		str += "<div class='flex-embed' style='background-image: url(\"" + getUrl(feed, 0) + "\")'></div>";
		str += "</div>";
		str += "<div class='grid-50'>";
		str += "<div class='flex-embed' style='background-image: url(\"" + getUrl(feed, 1) + "\")'></div>";
		str += "</div>";
	}
	else if (images.length == 3) {
		str += "<div class='grid-66'>";
		str += "<div class='flex-embed' style='background-image: url(\"" + getUrl(feed, 0) + "\")'></div>";
		str += "</div>";
		str += "<div class='grid-33'>";
		str += "<div class='flex-embed' style='background-image: url(\"" + getUrl(feed, 1) + "\")'></div>";
		str += "</div>";
		str += "<div class='grid-33'>";
		str += "<div class='flex-embed' style='background-image: url(\"" + getUrl(feed, 2) + "\")'></div>";
		str += "</div>";
	}
	
	str += "</div>";
	return str;
}

function getUrl(feed, index) {
	return "images/" + feed.id + "/" + feed.images[index];
}

</script>