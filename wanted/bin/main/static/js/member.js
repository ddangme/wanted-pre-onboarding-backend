if (localStorage.getItem("login") != null) {
	$("#login-header").attr("hidden", true);
	$("#logout-header").attr("hidden", false);
} else {
	if (location.href != "http://localhost:8080/login") {
		alert("로그인 후 이용가능합니다. 로그인 페이지로 이동합니다.");
		location.href="/login";
	}
}

$("#login").click(function() {
	var formData = {
		email: $("#email").val(),
		password: $("#password").val()
	};
	$.ajax({
		url: "/login",
		method: "POST",
		data: JSON.stringify(formData),
		contentType: "application/json",
		success: function(data) {
			if (data == "-1") {
				return alert("존재하지 않는 계정입니다.\n확인 후 다시 시도해주세요.");
			}
			localStorage.setItem("login", data);
			return location.href="/community/list";
		}
	});
});

$("#join-form").click(function() {
	location.href="/join";
});

$("#join").click(function() {
	var formData = {
		email: $("#email").val(),
		password: $("#password").val()
	};
	$.ajax({
		url: "/join",
		method: "POST",
		data : JSON.stringify(formData),
		contentType: "application/json",
		success: function(data) {
			if (data == "" || data == null) {
				alert("회원가입에 성공했습니다. 로그인 페이지로 이동합니다.")
				return location.href="/login";
			} else {
				return alert(data);
			}
		}
	});
});

$("#logout").click(function() {
	if (confirm("로그아웃 하시겠습니까?")) {
		localStorage.removeItem("login");
		location.href="/login";
	}
});