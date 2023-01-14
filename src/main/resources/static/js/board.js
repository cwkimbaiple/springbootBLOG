let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
/*		$("#btn-login").on("click", () => {
			this.login();
		});*/
	},

	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			console.log(resp.status);
			if (resp.status === 200) {
				alert("글쓰기가 완료 되었습니다.");
				location.href = "/";
			} else {
				alert("글쓰기에 실패하였습니다.");
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}

/*	login: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};
		console.log(data);
		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			console.log(resp);
			if (resp.status === 200) {
				alert("로그인이  완료 되었습니다.");
				location.href = "/";
			} else {
				alert("로그인에 실패하였습니다.");
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}*/
}

index.init();