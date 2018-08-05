<!doctype>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if ((boolean) request.getAttribute("isTrue")) {
	%>
	<script type="text/javascript">
		alert("데이터가 확인되었습니다. 시스템을 종료합니다.");
		parent.window.open('about:blank', '_self').close();
	</script>
	<%
		}
		if (!(boolean) request.getAttribute("isTrue")) {
	%>
	<script type="text/javascript">
		alert("데이터가 위조되었습니다!!! 시스템을 종료합니다.");
		parent.window.open('about:blank', '_self').close();
	</script>
	<%
		}
	%>
</body>
</html>