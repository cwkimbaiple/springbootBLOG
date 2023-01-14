<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<button class="btn btn-secondary text-center" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id }">
		<a href="/board/${board.id}/updateForm"
			class="btn btn-warning text-center">수정</a>
		<button id="btn-delete" class="btn btn-danger text-center">삭제</button>
	</c:if>
	<br /> <br />
	<div>
		글번호 : <span id="id"><i>${board.id}</i></span> 작성자 : <span><i>&nbsp;&nbsp;${board.user.username}</i></span>
		<br /> <br />
	</div>
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
</body>
</html>