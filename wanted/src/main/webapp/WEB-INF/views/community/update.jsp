<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="row">
	<form action="/community" method="POST" modelAttribute="community" id="write-form">
		<div class="col-lg-12">
			<label class="col-form-label mt-4" for="title">제목</label>
			<input class="form-control" name="title" placeholder="제목을 입력해주세요." id="title" value="${community.title}">
			<label class="form-label mt-4" for="content">본문</label>
			<textarea class="form-control" name="content" id="content" rows="15">${community.content}</textarea>
		</div>
		<div class="col-lg-12 mt-4" align="center">
			<input type="button" class="btn btn-primary" data-id="${community.id}" id="update-button" value="게시글 수정하기">
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>