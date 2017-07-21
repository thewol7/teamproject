<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<jsp:include page="/resource.jsp" />
<title>메인 페이지</title>
</head>
<style>
</style>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 --> <a
					href="home.do" class="logo"
				>
					<strong>${page_id}</strong>님의 Blog
				</a>
				<ul class="icons">
					<%
						// test용.. != null / == null 바꿔서 로그인 로그아웃 표시 확인
						if (request.getSession().getAttribute("id") == null) {
					%>
					<li>
						<!-- 1. 로그인 정보가 없을 경우 로그인이 되게 한다. 
						2. 로그인창은 새창없이 이동한다. 
						3. 로그인창에서 회원가입 한다. -->
						<a href="loginform.do" class="logo">
							<span class="">로그인</span>
						</a>
					</li>

					<%
						} else {
					%>
					<li>
						<a href="logout.do" class="logo">
							<span class="">로그아웃</span>
						</a>
					</li>
					<%
						}
					%>
					<!-- 480사이즈 이하에서 사라지게 수정 필요 -->
					<li class="space">
						<i>|</i>
					</li>
					<li>
						<!-- 이웃 블로그 목록이 드롭다운 되어 표시되도록 하여 선택시 이동 되게 한다. -->
						<a href="#" class="logo" onclick="alert('준비중.. 누르지마')">
							<span class="">이웃블로그</span>
						</a>
					</li>
					<li class="space">
						<i>|</i>
					</li>
					<!-- 선택 했을때 sns 등록 창을 표시해 주고, 로그인 되어 있을 경우 팔로우 할수 있도록 수정한다. -->
					<li>
						<%-- href="https://twitter.com/search?q=<%=page_name %>조동휘" --%>
						<a href="https://twitter.com/hashtag/표예진" class="icon fa-twitter" target="_blank">
							<span class="label">Twitter</span>
						</a>
					</li>
					<li>
						<a href="https://www.facebook.com/PyoYejin" class="icon fa-facebook" target="_blank">
							<span class="label">Facebook</span>
						</a>
					</li>
					<li>
						<a href="https://www.instagram.com/yjiinp/?max_id=1522591597308815190"
							class="icon fa-instagram"
						>
							<span class="label">Instagram</span>
						</a>
					</li>
				</ul>
				</header>

				<!-- Banner -->
				<section id="banner">
				<div class="content">
					<header> <!-- 카운터 수가 가장 높은 것을 사진 게시판에서 가져온다. 우측에 사진이 표시되어야 하므로 꼭 사진게시판 중.. 
					 없을 경우 post가 없습니다.  -->
					<h1>Top post</h1>
					<p>돼지고기 먹고 온 썰</p>
					</header>
					<p class="text-overflow-5">돼지고기먹었다 맛있었다 그랬다 어어어 배불러 돼지고기먹었다 맛있었다 그랬다 어어어 배불러 돼지고기먹었다 맛있었다
						그랬다 어어어 배불러 돼지고기먹었다 맛있었다 그랬다 어어어 배불러 돼지고기먹었다 맛있었다 그랬다 어어어 배불러 돼지고기먹었다 맛있었다 그랬다 어어어 배불러 돼지고기먹었다
						맛있었다 그랬다 어어어 배불러 돼지고기먹었다 맛있었다 그랬다 어어어 배불러 돼지고기먹었다 맛있었다 그랬다 어어어 배불러</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
				</div>
				<span class="image object ">
					<!-- <img src="images/modal_05.jpg" alt="" /> -->
					<a href="#">
						<img src="images/sam_01.jpg" alt="" />
					</a>
				</span> </section>


				<!-- Section -->
				<section> <header class="major">
				<h2>Recent post</h2>
				</header>
				<div class="posts">
					<article> <a href="#" class="image">
						<img src="images/modal_01.jpg" alt="" />
					</a>
					<h3>oasperioresdo</h3>
					<p class="text-overflow-3">nean ornare velit lacus, ac varius enim lorem ullamcorper
						dolore. Proin aliquam facilisis ante interdum. Sed nulla amet nean ornare velit lacus, ac
						varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet 찍은
						사진입니다아 다다다다</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
					</article>
					<article> <a href="#" class="image">
						<img src="images/zok_01.jpg" alt="" />
					</a>
					<h3>asperiores do</h3>
					<p class="text-overflow-3">Aenean ornare velit lacus, ac varius enim lorem ullamcorper
						dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
					</article>
					<article> <a href="#" class="image">
						<img src="images/modal_03.jpg" alt="" />
					</a>
					<h3>orasperiores</h3>
					<p class="text-overflow-3">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Veritatis error magnam modi sint quibusdam asperiores aut libero non atque quisquam aliquam
						assumenda voluptatem illo dolore unde aliquid laudantium porro soluta.</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
					</article>
					<article> <a href="#" class="image">
						<img src="images/sijang_01.jpg" alt="" />
					</a>
					<h3>asperiores</h3>
					<p class="text-overflow-3">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Veritatis error magnam modi sint quibusdam asperiores aut libero non atque quisquam aliquam
						assumenda voluptatem illo dolore unde aliquid laudantium porro soluta.</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
					</article>
					<article> <a href="#" class="image">
						<img src="images/pa1.png" alt="" />
					</a>
					<h3>asperiores</h3>
					<p class="text-overflow-3">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Veritatis error magnam modi sint quibusdam asperiores aut libero non atque quisquam aliquam
						assumenda voluptatem illo dolore unde aliquid laudantium porro soluta.</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
					</article>
					<article> <a href="#" class="image">
						<img src="images/main_d3.jpg" alt="" />
					</a>
					<h3>asperiores</h3>
					<p class="text-overflow-3">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Veritatis error magnam modi sint quibusdam asperiores aut libero non atque quisquam aliquam
						assumenda voluptatem illo dolore unde aliquid laudantium porro soluta.</p>
					<ul class="actions">
						<li>
							<a href="#" class="button">Learn More</a>
						</li>
					</ul>
					</article>
				</div>
				</section>

			</div>
		</div>

		<!-- Sidebar ##############################Sidebar#########################Sidebar-->
		<div id="sidebar">
			<jsp:include page="/navbar.jsp" />
		</div>

	</div>
</body>
</html>