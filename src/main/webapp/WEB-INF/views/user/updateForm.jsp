<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form>
		<input type="hidden" id="id" value="${principal.user.id }" />
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				value="${principal.user.username}" class="form-control"
				id="username" placeholder="Enter Username" readonly>
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				value="${principal.user.password}" class="form-control"
				id="password" placeholder="Enter Password">
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email"
				value="${principal.user.email}" class="form-control" id="email"
				placeholder="Enter Email">
		</div>
		<div class="form-check">
			<input type="checkbox" class="form-check-input" id="check"> <label
				class="form-check-label" for="exampleCheck1">Remember me</label>
		</div>
		<br />
	</form>
	<button id="btn-update" class="btn btn-primary text-center"
		style="width: 10em; float: none; margin: 0 auto">회원수정완료</button>

</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>