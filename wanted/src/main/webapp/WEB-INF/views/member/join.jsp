<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="row">
	<div class="col-lg-4 offset-lg-4">
		<label for="email" class="form-label mt-4">Email</label>
		<input type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요.">
		<label for="password" class="form-label mt-4">Password</label>
		<input type="password" class="form-control" id="password" placeholder="비밀번호" autocomplete="off">
		<input type="password" class="form-control mt-2" id="password-check" placeholder="비밀번호 확인" autocomplete="off">
		<div class="row">
			<input type="button" class="btn btn-secondary mt-4" id="join" value="회원가입">
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>