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
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				id="enrollment-tab" data-toggle="tab" href="#enrollment" role="tab"
				aria-controls="enrollment" aria-selected="true">재학</a></li>
			<li class="nav-item"><a class="nav-link" id="diploma-tab"
				data-toggle="tab" href="#diploma" role="tab" aria-controls="diploma"
				aria-selected="false">졸업</a></li>

		</ul>
		<div class="tab-content" id="myTabContent">

			<div class="tab-pane fade show active" id="enrollment"
				role="tabpanel" aria-labelledby="enrollment-tab">
				<br>
				<table class="table table-bordered">
					<thead class="thead-dark">
						<tr>
							<th scope="col">이름</th>
							<th scope="col">생년월일</th>
							<th scope="col">대학</th>
							<th scope="col">전공</th>
							<th scope="col">학년</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>이대길</td>
							<td>1993년 04월 12일</td>
							<td>경찰사법대학</td>
							<td>경찰행정학부</td>
							<td>2학년 재학</td>
						</tr>
						<tr>
							<td colspan="5" class="center text-center"><span
								class="d-inline-block text-center "> 2000.00.00 위 사람은
									세종대학교에 재학 중임이 증명되었습니다. <img src="#none" alt="세종대로고">
							</span></td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="tab-pane fade" id="diploma" role="tabpanel"
				aria-labelledby="diploma-tab">
				<div class="tab-pane fade show active" id="diploma" role="tabpanel"
					aria-labelledby="diploma-tab">
					<br>
					<table class="table table-bordered">
						<thead class="thead-dark">
							<tr>
								<th scope="col">이름</th>
								<th scope="col">생년월일</th>
								<th scope="col">대학</th>
								<th scope="col">학과</th>
								<th scope="col">입학년도</th>
								<th scope="col">졸업년도</th>
								<th scope="col">종류</th>
								<th scope="col">학위등록</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td>이대길</td>
								<td>1993년 04월 12일</td>
								<td>경찰사법대학</td>
								<td>경찰행정학부</td>
								<td>2012년 03월 02일</td>
								<td>2017년 02월 15일</td>
								<td>학사</td>
								<td>동국대2017(학) 5402</td>
							</tr>
							<tr>
								<td colspan="8" class="center text-center"><span
									class="d-inline-block text-center "> 2000.00.00 위 사람은
										세종대학교에서 졸업했음이 증명되었습니다. <img src="#none" alt="세종대로고">
								</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>


		</div>
	</div>

	<!-- submit -->
	<div class="container">
		<hr>
		<form method="post" action="emailSender">

			<div class="form-group">
				<label for="email">이메일</label> <input class="form-control"
					id="email" type="email" placeholder="이메일을 입력해주세요" name="sender">
			</div>
			<div class="row">

				<div class="col">
					<input class="btn float-right" type="submit" value="인증 요청">
					<script type="text/javascript">
						function result() {
							alert("발급이 완료되었습니다.");
						}
					</script>
				</div>
			</div>
	</div>
	</form>
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