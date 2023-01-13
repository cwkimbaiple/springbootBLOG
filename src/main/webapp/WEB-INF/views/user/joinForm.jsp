<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="card text-center" style="width: 100%; padding-bottom: 10px">
	<form style="width: 30%; float: none; margin: 0 auto">
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text"
				class="form-control" id="username" placeholder="Enter Username">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password"
				class="form-control" id="password" placeholder="Enter Password">
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email"
				class="form-control" id="email" placeholder="Enter Email">
		</div>
		<div class="form-check">
			<input type="checkbox" class="form-check-input" id="check"> <label
				class="form-check-label" for="exampleCheck1">Remember me</label>
		</div>
		<br />
	</form>
	<button id="btn-save" class="btn btn-primary text-center" style="width: 20%; float: none; margin: 0 auto">회원가입완료</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>