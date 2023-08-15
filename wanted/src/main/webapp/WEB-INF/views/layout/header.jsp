<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Wanted Pre Onboarding Backend</title>
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/custom.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<style>
  		@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
	</style>
	<script type="text/javascript">
	</script>
</head>
<body>

<!-- GNB 영역 시작 -->
<nav class="navbar navbar-expand-lg fixed-top bg-primary" data-bs-theme="dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">
			Wanted Pre Onboarding Backend
		</a>
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav me-auto">
				<li class="nav-item">
					<a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/community/list">Community</a>
				</li>
			</ul>
			<div id="login-header">
				<input type="button" onclick="location.href='/login'" class="btn btn-primary" value="로그인">&nbsp;
			</div>
			<div id="logout-header" hidden="hidden">
				<input type="button" class="btn btn-primary" value="로그아웃" id="logout">&nbsp;
			</div>
		</div>
	</div>
</nav>
<!-- GNB 영역 끝 -->
<!-- 본문 영역 시작 -->
<div class="container">