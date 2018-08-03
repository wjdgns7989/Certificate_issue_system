<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
</head>


<body>

	<%
		if ((Boolean) request.getAttribute("login") != null) {
	%>
	<script type="text/javascript">
				
					alert("아이디 또는 비밀번호가 틀렸습니다.")	
				
				</script>
	<%
		}
	%>

	<!-- nav -->
	<nav class="nav bg-dark">
		<a class="nav-link active" href="#">세종대 로고</a>
	</nav>

	<!-- body -->
	<div class="container">
		<br> <br>
		<h2>증명발급 시스템 &nbsp;</h2>
		<hr>
		<form method="post" name="user" action="loginCheck.do">
			<div class="form-group">
				<label for="exampleInputEmail1">아이디</label> <input type="text"
					name="id" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="아이디를 입력해주세요">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">패스워드</label> <input name="passwd"
					type="password" class="form-control" id="exampleInputPassword1"
					placeholder="패스워드를 입력해주세요">
			</div>
			<button class="btn btn-primary" onclick='login()'>로그인</button>
			<script type="text/JavaScript">
                function login() {
                    var form_data={
                        id:$('#id').val(),
                        passwd=$('#passwd').val()
                    };

                    alert(form_data)
                    $ajax({
                        type:'POST',
                        dataType:'json',
                        url:'loginCheck.do',
                        data:JSON.stringify(form_data),
                        success: function(data) {  alert("성공:"+data.KEY);},
        error:function(request,status,error){
                alert("code:"+request.status+"\n"+"error:"+error);}

                    });
                }
                </script>
		</form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
		integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
		crossorigin="anonymous"></script>
</body>

</html>