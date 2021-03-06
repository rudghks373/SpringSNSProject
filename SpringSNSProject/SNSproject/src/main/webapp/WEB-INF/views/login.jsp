<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta name=viewport content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="css/core2.css" media="only screen and (min-width:800px)">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>My Social Network</title>
</head>
<body>
	<div class="page-hdr">로그인</div>
	<div class="section bg-eee phor-24">
		<input id="--id" class="form-txt mtop-30 " type="text" placeholder="아이디 (휴대폰번호)">
		<input id="--pass" class="form-txt mtop-10 mbot-30" type="password" placeholder="패스워드">
		
		<div class="section mbot-30">
			<div class="form-submit" onclick="login()">MySNS에 로그인합니다.</div>
		</div>
		
		<div class="form-desc mbot-10">
			아직 아이디가 없으세요?<br> 
			간단한 가입 절차만으로 MySNS의 회원이 되실 수 있습니다.
		</div>
		<div class="form-btn mbot-30" onclick="signup()">회원가입</div>
	</div>
	<div class="page-footer">MYSNS COMPANY 2018</div>
</body>
</html>

<script src="js/jquery-1.12.0.min.js"></script>
<script src="js/core.js"></script>
<script type="text/javascript">
$(document).ready(function() {

});

function login() {
	
	if (check() == false) return;
	
	var logincheck = {
			
			"id": $("#--id").val().trim(),
    		"pass": $("#--pass").val().trim(),
    		
	};
	
    	$.ajax({
    		url : 'logincheck', //내가 보내는 서버주소(컨트롤러)
    		dataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태
    		type : 'POST', 
    		contentType : 'application/json; charset=UTF-8', //보내는 데이터 형태
    		data : JSON.stringify(logincheck), //내가 서버로 보내는 데이터
    		success: function (data) { 
    			if (data == "OK") {
    				location.replace("main");
    				
    			}
    			else if (data == "PS") {
    				alert("비밀 번호를 확인하십시오.");
    			}
    			else if (data == "noID") {
    				alert("가입된 회원이 아닙니다.");
    			}
    	    }
    	});
    	
   	}

function signup() {
	window.location.href = "signup.html";
}

function check() {
	var id = $("#--id").val().trim();
	if (id == "") {
		alert("아이디를 입력해주세요.");
		return false;
	}

	var pass = $("#--pass").val().trim();
	if (pass == "") {
		alert("패스워드를 입력해주세요.");
		return false;
	}
	return true;
}
</script>