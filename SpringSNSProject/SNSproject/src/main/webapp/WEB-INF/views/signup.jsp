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
</head>
<body>
	<div class="page-hdr">회원가입</div>
	<div class="section bg-eee phor-24">
		<input id="--name" class="form-txt mtop-30 " type="text" placeholder="이름">
		<input id="--id" class="form-txt mtop-10 " type="text" placeholder="아이디 ">
		<input id="--pass" class="form-txt mtop-10" type="password" placeholder="패스워드">
		<input id="--pass2" class="form-txt mtop-10 mbot-30" type="password" placeholder="패스워드 (확인)">
		
		<div class="section mbot-30">
			<div class="form-submit" onclick="signcehck()">MySNS에 가입합니다.</div>
		</div>
	</div>
	<div class="page-footer">MYSNS COMPANY 2017</div>
</body>
</html>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="js/core.js"></script>
<script type="text/javascript">
$(document).ready(function() {

});
//회원가입체크
function signcehck() {
    	
	if (check() == false) return;
	
    	var signinfo = {
    		"id": $("#--id").val().trim(),
    		"name": $("#--name").val().trim(),
    		"pass": $("#--pass").val().trim(),
    	};
    	
    	$.ajax({
    		url : 'signcheck', //내가 보내는 서버주소(컨트롤러)
    		dataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태
    		type : 'POST', 
    		contentType : 'application/json; charset=UTF-8', //보내는 데이터 형태
    		data : JSON.stringify(signinfo), //내가 서버로 보내는 데이터
    		success: function (data) { 
    			if (data == "EX") {
    				alert("이미 가입된 아이디입니다.");
    			
    			}
    			else if (data == "OK") {
    				alert("회원 가입이 완료되었습니다.");
    				window.location.href = "main";
    			        }
    			     }
    		
    	});
    	
   	}

function check() {
	var name = $("#--name").val().trim();
	if (name == "") {
		alert("이름을 입력해주세요.");
		return false;
	}

	var id = $("#--id").val().trim();
	if (id == "") {
		alert("아이디(휴대폰 번호)를 입력해주세요.");
		return false;
	}
	var pass = $("#--pass").val().trim();
	if (pass == "") {
		alert("패스워드를 입력해주세요.");
		return false;
	}

	var pass2 = $("#--pass2").val().trim();
	if (pass != pass2) {
		alert("입력된 두개의 패스워드가 일치하지 않습니다.");
		return false;
	}
	return true;
}
</script>