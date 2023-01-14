let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		$("#btn-update").on("click", () => {
			this.update();
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
	},
	update: function() {
		
		let id = $("#id").val();
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		$.ajax({
			type: "PUT",
			url: "/api/board/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			console.log(resp.status);
			if (resp.status === 200) {
				alert("글수정이 완료 되었습니다.");
				location.href = "/";
			} else {
				alert("글수정이 실패하였습니다.");
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	deleteById: function() {
			let id= $("#id").text();
		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			console.log(resp.status);
			if (resp.status === 200) {
				alert("삭제가 완료 되었습니다.");
				location.href = "/";
			} else {
				alert("삭제가 실패하였습니다.");
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