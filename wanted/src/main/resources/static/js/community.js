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
			id: $("#update-button").data("id")
		}
		$.ajax({
			url: "/community",
			method: "PUT",
			data: JSON.stringify(formData),
			contentType: "application/json",
			success: function(data) {
				if (data != null) {
					alert("게시물이 수정되었습니다.");
					return location.href="/community/" + data;
				} else {
					alert("게시물 수정에 실패하였습니다.");
				}
			}
		});
	}
});

$("#delete").click(function() {
	if (confirm("게시물을 삭제하시겠습니까?")) {
		var id = $("#delete").data("id");
		$.ajax({
			url: "/community/" + id,
			type: "DELETE",
			success: function(data) {
				if (data == "0") {
					location.href="/community/list";
					alert("게시물이 삭제되었습니다.");
				} else {
					alert("게시물 삭제에 실패하였습니다.");
				}
			}
		});
	}
});