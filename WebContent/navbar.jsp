<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String cPath = request.getContextPath();
	String page_id = request.getParameter("page_id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>Insert title here</title>
</head>
<style>
</style>
<script>
</script>
<body>
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
				<a href="<%=cPath%>/index.do?page_id=<%=page_id %>">HOME</a>
			</li>
			<li>
				<span class="opener">게시판</span>
				<ul>
					<li>
						<a href="<%=cPath%>/board/boardlist.do?page_id=<%=page_id%>">자유
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
						<a href="<%=cPath%>/board/imgboardlist.do?page_id=<%=page_id%>">2014-02-베트남</a>
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
				<a href="<%=cPath%>/board/visboardlist.do?page_id=<%=page_id%>">방명록</a>
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
				<a href="<%=cPath%>/mgt/management.jsp">관리</a>
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
</body>
</html>