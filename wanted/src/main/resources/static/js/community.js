$("#write-button").click(function() {
	location.href="/community/write";
});

$("#write").click(function() {
	if (confirm("게시물을 작성하시겠습니까?")) {
		var formData = {
			title: $("#title").val(),
			content: $("#content").val(),
			memberId: localStorage.getItem("login")
		}
		$.ajax({
			url: "/community",
			method: "POST",
			data: JSON.stringify(formData),
			contentType: "application/json",
			success: function(data) {
				if (data != null) {
					alert("게시물이 작성되었습니다.");
					return location.href="/community/" + data;
				} else {
					alert("게시물 작성에 실패하였습니다.");
				}
			}
		});
	}
});

$("#update-button").click(function() {
	if (confirm("게시물을 수정하시겠습니까?")) {
		var formData = {
			title: $("#title").val(),
			content: $("#content").val(),
			id: $("#update-button").data("id"),
			memberId: localStorage.getItem("login")
		};
		$.ajax({
			url: "/community",
			method: "PUT",
			data: JSON.stringify(formData),
			contentType: "application/json",
			success: function(data) {
				if (data == null || data == "") {
					alert("게시물이 수정되었습니다.");
					return location.href="/community/" + $("#update-button").data("id");
				} else {
					alert("게시물 수정 권한이 없습니다.");
				}
			}
		});
	}
});

$("#delete").click(function() {
	if (confirm("게시물을 삭제하시겠습니까?")) {
		var formData = {
			id: $("#delete").data("id"), 
			memberId: localStorage.getItem("login")
		};
		$.ajax({
			url: "/community/" + $("#delete").data("id"),
			type: "DELETE",
			data: JSON.stringify(formData),
			contentType: "application/json",
			success: function(data) {
				if (data == null || data == "") {
					alert("게시물이 삭제되었습니다.");
					location.href="/community/list";
				} else {
					alert("게시물 삭제 권한이 없습니다.");
				}
			}
		});
	}
});