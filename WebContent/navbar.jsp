<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="inner">

	<!-- Search -->
	<section id="search" class="alt">
	<form method="post" action="#" target="_blank">
		<!-- 게시물 검색이 가능하게 구현한다. -->
		<input type="text" name="query" id="query" placeholder="Search" />
	</form>
	</section>

	<!-- Menu -->
	<!-- 나중에 관리자 페이지를 만들어서 메뉴 추가 가능하게 한다. -->
	<nav id="menu"> <header class="major">
	<h2>Menu</h2>
	</header> <!-- 		<header>
		<a href="#">		
			<h3><i class="fa fa-cog" aria-hidden="true"></i>&nbsp;관리</h3>
		</a>
	</header>	 -->
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/home.do">HOME</a>
		</li>
		<li>
			<span class="opener">게시판</span>
			<ul>
				<li>
					<a href="${pageContext.request.contextPath }/board/boardlist.do">자유
						게시판</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">동영상게시판</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">음악게시판</a>
				</li>
			</ul>
		</li>
		<li>
			<span class="opener">여행사진</span>
			<ul>
				<li>
					<a href="${pageContext.request.contextPath }/board/imgboardlist.do">2014-02-베트남</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">2015-12-일본</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">2016.05-홍콩</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">2016.05-대만</a>
				</li>
			</ul>
		</li>
		<li>
			<span class="opener">먹부림</span>
			<ul>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">종로</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">홍대</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">강남</a>
				</li>
				<li>
					<a href="#" onclick="alert('준비중.. 누르지마')">여기저기</a>
				</li>
			</ul>
		</li>
		<li>
			<a href="#" onclick="alert('준비중.. 누르지마')">취미</a>
		</li>
		<li>
			<a href="#" onclick="alert('준비중.. 누르지마')">파일자료실</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/board/visboardlist.do">방명록</a>
		</li>
		<li>
			<a
				href="http://cafe.daum.net/dotax/FGFP/9109?q=%C8%F7%BE%EE%B7%CE%C1%EE%20%BF%C0%BA%EA%20%B4%F5%20%C5%B9%BD%BA">시공의
				폭풍으로</a>
		</li>
		<li>
			<a
				href="http://cafe.daum.net/dotax/FGFP/9287?q=%C8%F7%BE%EE%B7%CE%C1%EE%20%BF%C0%BA%EA%20%B4%F5%20%C5%B9%BD%BA">시공의
				폭풍으로2</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/mgt/management.jsp">관리</a>
		</li>
	</ul>
	</nav>

	<!-- Footer -->
	<footer id="footer">
	<p class="copyright">
		&copy; Untitled. All rights reserved. Demo Images:
		<a href="#">Unsplash</a>
		. Design:
		<a href="#">Cho.D.H</a>
		.
	</p>
	</footer>

</div>