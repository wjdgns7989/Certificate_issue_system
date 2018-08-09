<!doctype html>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.tomato.dto.DiplomaDTO"%>
<%@page import="com.tomato.dto.EnrollmentDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>

<head>
<title>blockChain</title>
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
		<a class="nav-link active" href="http://www.sejong.ac.kr">세종대학교</a>
	</nav>

	<!-- body -->
<body>

	<%
		EnrollmentDTO enrollmentDTO = (EnrollmentDTO) request.getAttribute("enrollment");
		DiplomaDTO diplomaDTO = (DiplomaDTO) request.getAttribute("diploma");
		session.setAttribute("enrollment", enrollmentDTO);
		session.setAttribute("diploma", diplomaDTO);

		String time = (String) session.getAttribute("time");
	%>

	<div class="container">
		<br> <br>
		<h2>증명발급 시스템 &nbsp;</h2>
		<hr>

		<br>
		<%
			if (enrollmentDTO != null) {
		%>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">종류</th>
					<th scope="col">이름</th>
					<th scope="col">생년월일</th>
					<th scope="col">대학교</th>
					<th scope="col">전공</th>
					<th scope="col">학년</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="small"><%=enrollmentDTO.getNo()%></td>
					<td class="small"><%=enrollmentDTO.getType()%></td>
					<td class="small"><%=enrollmentDTO.getName()%></td>
					<td class="small"><%=enrollmentDTO.getDateOfBirth()%></td>
					<td class="small"><%=enrollmentDTO.getCollege()%></td>
					<td class="small"><%=enrollmentDTO.getMajor()%></td>
					<td class="small"><%=enrollmentDTO.getGrade()%></td>
				</tr>
				<tr>
					<td colspan="7" class="center text-center"><span
						class="d-inline-block text-center "> <%=time%> 위 사람은
							세종대학교에 재학 중임이 증명되었습니다. <img
							src="http://sejong.ac.kr/img/common/h1_top_logo01.gif"
							alt="세종대로고">
					</span></td>
				</tr>
			</tbody>
		</table>

		<%
			}
		%>

		<br>
		<%
			if (diplomaDTO != null) {
		%>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">종류</th>
					<th scope="col">이름</th>
					<th scope="col">생년월일</th>
					<th scope="col">학교</th>
					<th scope="col">학과</th>
					<th scope="col">입학년도</th>
					<th scope="col">졸업년도</th>
					<th scope="col">학위</th>
					<th scope="col">학위번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="small"><%=diplomaDTO.getNo()%></td>
					<td class="small"><%=diplomaDTO.getType()%></td>
					<td class="small"><%=diplomaDTO.getName()%></td>
					<td class="small"><%=diplomaDTO.getDateOfBirth()%></td>
					<td class="small"><%=diplomaDTO.getCollege()%></td>
					<td class="small"><%=diplomaDTO.getMajor()%></td>
					<td class="small"><%=diplomaDTO.getDateOfMatriculation()%></td>
					<td class="small"><%=diplomaDTO.getDateOfGraduation()%></td>
					<td class="small"><%=diplomaDTO.getNameOfDegree()%></td>
					<td class="small"><%=diplomaDTO.getDegreeRegistrationNo()%></td>
				</tr>
				<tr>
					<td colspan="10" class="center text-center"><span
						class="d-inline-block text-center "> <%=time%>위 사람은
							세종대학교에서 졸업했음이 증명되었습니다. <img
							src="http://sejong.ac.kr/img/common/h1_top_logo01.gif"
							alt="세종대로고">
					</span></td>
				</tr>
			</tbody>
		</table>

		<%
			}
		%>
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
					<input class="btn btn-primary float-right" type="submit"
						value="인증 요청">
					<script type="text/javascript">
						function result() {
							alert("발급이 완료되었습니다.");
						}
					</script>
				</div>
			</div>
		</form>
	</div>


	<script type="text/javascript">
		
	</script>
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