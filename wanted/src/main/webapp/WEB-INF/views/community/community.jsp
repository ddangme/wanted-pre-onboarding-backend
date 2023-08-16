<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="row">
	<div class="card border-light">
		<div class="card-header">제목 : ${community.title}</div>
		<div class="card-header">작성자 : ${community.member.email}</div>
		<div class="card-header">작성 시각 : ${community.writeTime}</div>
		<c:if test="${community.updateTime != null}">
			<div class="card-header">수정 시각 : ${community.updateTime}</div>
		</c:if>
		<div class="card-body">
			<div align="right" id="member-check" hidden="hidden">
				<a href="/community/update/${community.id}">수정</a>
				<a href="" id="delete" data-id="${community.id}">삭제</a>
			</div>
			<p class="card-text">${community.content}</p>
		</div>
	</div>
	<div align="center">
		<button type="button" class="btn btn-primary" id="community-list">게시글 목록</button>
	</div>
</div>
<script type="text/javascript">
if (localStorage.getItem("login") == "${community.member.id}") {
	$("#member-check").attr("hidden", false);
}
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>