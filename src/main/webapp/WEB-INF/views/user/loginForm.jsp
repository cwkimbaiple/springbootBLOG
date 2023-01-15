<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				name="username" class="form-control" id="username"
				placeholder="Enter Username">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				name="password" class="form-control" id="password"
				placeholder="Enter Password">
		</div>
		<br />
		<button class="btn btn-primary text-center">로그인</button>
		<a
			href="https://kauth.kakao.com/oauth/authorize?client_id=f4c1e20ba097c5b3d0ab62d483765d2d&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img
			height="38px" src="/image/kakao_login_medium_narrow.png" /></a>
	</form>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>