<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+sharp"  rel="stylesheet">
<style type="text/css">
	.my::after {
		content:"\e853"
		}
</style>
</head>
<body>
<c:import url="./template/header.jsp"></c:import>

	<h1>Index Page</h1>
	
	<h3>${member.name} 님 환영합니다
	<span class="material-icons-outlined">
		account_circle
	</span>
	</h3>
	
	<div>
		<c:if test="${not empty member}">
			<a class="my" href="./member/mypage">MyPage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		
		<c:if test="${empty member}">
			<a class="my" href="./member/mypage">MyPage</a>
			<a href="./member/join">Join</a>
		</c:if>	
		
	</div>
</body>
</html>