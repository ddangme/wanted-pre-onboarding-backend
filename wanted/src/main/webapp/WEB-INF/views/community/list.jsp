<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="row">
	<div class="col-lg-12" align="right">
		<button type="button" class="btn btn-primary" id="write-button">게시글 작성하기</button>
	</div>
	<div class="col-lg-12">
		<table class="table table-hover" id="table">
			<thead>
		    	<tr align="center">
					<th scope="col">제목</th>
					<th scope="col">본문</th>
					<th scope="col">작성자</th>
				</tr>
		  </thead>
		  <tbody>
		  	<c:if test="${communityList == null}">
				<tr align="center">
					<td colspan="3">게시물이 없습니다.</td>
				</tr>
		  	</c:if>
		  	<c:forEach var="community" items="${communityList}">
				<tr align="center">
					<th scope="row">${community.title}</th>
					<th scope="row">
						<a href="/community/${community.id}">${community.content}</a>
					</th>
					<th scope="row">${community.member.email}</th>
				</tr>
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
	<div class="col-lg-2 offset-lg-5">
		<ul class="pagination">
	    	<c:forEach begin="1" end="${communityListCount}" varStatus="loop">
				<li class="page-item active">
					<a class="page-link" href="/community/list/${loop.index}">${loop.index}</a>
				</li>
	    	</c:forEach>
	  </ul>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>