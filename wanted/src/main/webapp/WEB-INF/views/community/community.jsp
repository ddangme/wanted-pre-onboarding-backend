<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="row">
	<div class="card border-light">
		<div class="card-header">${community.title}</div>
		<div class="card-header">${community.member.email}</div>
		<div class="card-body">
			<div align="right">
				<a href="/community/update/${community.id}">수정</a>
				<a href="" id="delete" data-id="${community.id}">삭제</a>
			</div>
			<p class="card-text">${community.content}</p>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>