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
	<!-- nav -->
	<nav class="nav bg-dark">
		<a class="nav-link active" href="#">세종대 로고</a>
	</nav>

	<!-- body -->
<body>
	<div class="container">
		<br> <br>
		<h2>증명발급 시스템 &nbsp;</h2>
		<hr>
		<div class="container">
			<form method="get" action="boxcheck.do">
				<div class="form-group">
					<label for="blockchain">블록체인 값</label> <input class="form-control"
						id="blockchain" type="text" placeholder="124bds943kogdjisdim3"
						readonly> <small id="emailHelp"
						class="form-text text-muted">블록체인 주소를 요청해주세요</small>
				</div>
				<div class="row">
					<div class="col-3">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="checkbox"
								id="inlineCheckbox1" value="certification"> <label
								class="form-check-label" for="inlineCheckbox1">재학</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="checkbox"
								id="inlineCheckbox2" value="diploma"> <label
								class="form-check-label" for="inlineCheckbox2">졸업</label>
						</div>
					</div>
					<div class="col-7"></div>

					<div class="col-2">
						<input type="submit" class="btn btn-primary" value="제출">
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
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