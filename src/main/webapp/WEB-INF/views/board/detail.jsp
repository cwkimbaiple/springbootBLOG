<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<button class="btn btn-secondary text-center" onclick="history.back()">돌아가기</button>
	<button id="btn-update" class="btn btn-warning text-center">수정</button>
	<button id="btn-delete" class="btn btn-danger text-center">삭제</button>
	<br/>
	<br/>
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr/>
	<div>
		<div>${board.content}</div>
	</div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
</body>
</html>