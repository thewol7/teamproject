<%@page import="server.dao.ServerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<jsp:include page="/resource.jsp" />
<title>로그인</title>
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
					href="/home.do?page_id=${page_id }" class="logo"
				>
					<strong>${page_id }</strong>님의 Blog
				</a>
				<ul class="icons">
					<li>
						<a href="/home.do?page_id=${page_id }" class="logo">
							<span class="">홈으로</span>
						</a>
					</li>
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
				<section id="banner" style="padding-bottom : 0">
				<div class="content">
					<header style="text-align:center">
					<h1 style="margin-bottom:0;">LOGIN</h1>
					</header>
				</div>
				</section>
				<section id="banner" class="login-input-reform">
				<div class="content">
					<form action="login.do" method="post" id="login_form">
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="text" name="id" id="id" value="" placeholder="아이디" />
						</div>
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="password" name="pwd" id="pwd" value="" placeholder="비밀번호" />
						</div>
						<div class="12u 12u$(xsmall)" style="text-align: center">
							<ul class="actions">
								<li>
									<input type="submit" value="로그인" class="special button" />
								</li>
							</ul>
						</div>
						<ul class="alt">
							<li></li>
							<li style="text-align: center">
								<h4>
									<a class="logo" href="signupform.do">회원가입</a>
								</h4>
							</li>
						</ul>
					</form>
				</div>
				</section>
				<!-- Footer -->
				<footer id="footer" style="text-align:center">
				<p class="copyright">
					&copy; Untitled. All rights reserved. Demo Images:
					<a href="#">Unsplash</a>
					. Design:
					<a href="#">Cho.D.H</a>
					.
				</p>
				</footer>
			</div>
		</div>
	</div>
</body>
</html>