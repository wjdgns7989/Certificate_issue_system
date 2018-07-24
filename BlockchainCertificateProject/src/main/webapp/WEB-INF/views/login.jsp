<%@ page language="java" contentType="text/html; charset=UTF-8" 
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<!-- JSTL의 if 문법 사용-->
<!-- 로그인 오류메시지 세션이 존재하면  메시지 출력-->
<c:if test="${!empty LOGIN_EXCEPTION}">
    <p>${LOGIN_EXCEPTION}</p>
</c:if>
 
<form action="${pageContext.request.contextPath}/login-request" method="post" target="_self">
    <label for="login_id">Id</label>
    <input type="text" name="login_id" id="login_id" autofocus maxlength="128">
    <label for="login_password">Password</label>
    <input type="password" name="login_password" id="login_password" maxlength="64">
    <button type="submit">로그인</button>    
</form>
</body>
</html>

