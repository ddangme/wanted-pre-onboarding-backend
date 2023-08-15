<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="row">
	<div class="col-lg-12" align="right">
		<button type="button" class="btn btn-primary" id="write-button">게시글 작성하기</button>
	</div>
	<div class="col-lg-12">
		<table class="table table-hover">
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
	<div class="col-lg-4 offset-lg-4">
	  <ul class="pagination">
	    <li class="page-item disabled">
	      <a class="page-link" href="#">&laquo;</a>
	    </li>
	    <li class="page-item active">
	      <a class="page-link" href="#">1</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">2</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">3</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">4</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">5</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">&raquo;</a>
	    </li>
	  </ul>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>