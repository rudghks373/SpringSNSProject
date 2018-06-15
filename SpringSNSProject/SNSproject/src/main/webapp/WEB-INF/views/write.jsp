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
	float: left;
	padding: 5px 20px;
	font-size: 0.9em;
	background-color: white;
	text-align: center;
	color: #24C;
	border: 1px solid #24C;
	border-radius: 8px;
	cursor: pointer;
}
.form-txbn .button2 {
	float: right;
    padding: 5px 20px;
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
		
		 <label class="tran_03">
         <div class="button" onclick="openImage()">사진추가</div>
         </label>
         <div class="button2">
            <input type="file" name="file" onchange="javascript:document.getElementById('file_route1').value=this.value">
			<input type="text" readonly="readonly" title="File Route" id="file_route1" placeholder="파일을 선택해 주세요.">
	     </div>		  
			  
		</div>
		<div id="--img-pane" class="image-pane mtop-10 mbot-20"></div>
		
		<div class="section mbot-30">
		<div class="form-submit" onclick="upload2()">작성글을 업로드합니다.</div>
		</div>
		
		<div class="form-btn mbot-30">
		<div class="button" onclick="maingo()">메인으로 돌아가기</div>
		</div>
	</div>
	<div class="page-footer">MYSNS COMPANY 2017</div>
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

function maingo() {
	location.replace("main");
}


var pagectx = {};
function start(id) {
	pagectx.id = id;
	
	ImageUploader.init("#--img-pane");
}

function openImage() {
    var form = $('#FILE_FORM')[0];
    var formData = new FormData(form);
    formData.append("fileObj", $("#FILE_TAG")[0].files[0]);
    formData.append("fileObj2", $("#FILE_TAG2")[0].files[0]);

    $.ajax({
        url: '',
                processData: false,
                contentType: false,
                data: formData,
                type: 'POST',
                success: function(result){
                    alert("업로드 성공!!");
                }
        });
}

function upload2() {
	if (check() == false) return;

	var id = "<%=(String)session.getAttribute("iogincheck")%>"
	var writedate = {
			"id":id,
			"jsonobj": $("#--desc").val().trim()
	};
	
	console.log(writedate);
	$(document).ready(function() {
		$.ajax({
			url :'writeupdata', //내가 보내는 서버주소(컨트롤러)
			dataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태
			type : 'POST', 
			data : JSON.stringify(writedate),
			contentType : 'application/json; charset=UTF-8',//내가 서버로 보내는 데이터
			success: function (data) { 
				if (data == "writeOK") {
					alert("글 작성 완료.");
					location.replace("main");
				}
				else if (data == "writeNO") {
					alert("로그인이 필요합니다.");
					location.replace("login");
				}			
		      }
	   });
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