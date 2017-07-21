<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/resource.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/views/guestboard/list.jsp</title>
</head>
<body>
<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 -->
				<a href="/index.do?page_id=" class="logo">
					<strong>${usernamedto.name }</strong>님의 Blog
				</a>
				<ul class="icons">
					<%--
						// test용.. != null / == null 바꿔서 로그인 로그아웃 표시 확인
						if (request.getSession().getAttribute("id") == null) {
					--%>
					<c:if test="${empty sessionScope.id }">
					<li>
						<!-- 1. 로그인 정보가 없을 경우 로그인이 되게 한다. 
						2. 로그인창은 새창없이 이동한다. 
						3. 로그인창에서 회원가입 한다. -->
						
						<a href="/loginform.do?page_id=" class="logo">
							<span class="">로그인</span>
						</a>
						
					</li>
					</c:if>
					<c:if test="${not empty sessionScope.id }">
					<li>
						<a href="/logout.do" class="logo">
							<span class="">로그아웃</span>
						</a>
					</li>
					</c:if>
					<%--
						}
					--%>
					<!-- 480사이즈 이하에서 사라지게 수정 필요 -->
					<li class="space">
						<i>|</i>
					</li>
					<li>
						<!-- 이웃 블로그 목록이 드롭다운 되어 표시되도록 하여 선택시 이동 되게 한다.target="_blank" -->
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
						<a href="https://twitter.com/hashtag/표예진" class="icon fa-twitter"
							target="_blank">
							<span class="label">Twitter</span>
						</a>
					</li>
					<li>
						<a href="https://www.facebook.com/PyoYejin"
							class="icon fa-facebook" target="_blank">
							<span class="label">Facebook</span>
						</a>
					</li>
					<li>
						<a
							href="https://www.instagram.com/yjiinp/?max_id=1522591597308815190"
							class="icon fa-instagram">
							<span class="label">Instagram</span>
						</a>
					</li>
				</ul>
				</header>
				<!-- Banner -->
				<section style="padding-top : 3em">
				<ul class="alt">
					<c:if test="${empty id }">
					<li>
						로그인 후 방명록을 남겨주세요
					</li>
					</c:if>
					
					<li>
						<a class="icon" href="">${writernamedto.name }</a>
					</li>
					
				</ul>
				<form method="post" action="insert.do">
					<div class="row uniform">
						<div class="12u 12u$(xsmall)" style="padding-top: 0">
							<textarea style="resize: none" name="content" id="content"
								placeholder="안부글을 남겨주세요" rows="3"></textarea>
						</div>
						<!-- Break -->
						<div class="12u$" style="text-align: right">
							<ul class="actions">
								<li>
									<input type="submit" value="확인" class="special"
										/>
								</li>
								<!-- <input type="submit" value="확인" class="special"
										onclick="return loginChk()" />
								</li> -->
								<!-- <li>
									<input type="reset" onclick="backTolist()" value="취소" />
								</li> -->
							</ul>
						</div>
					</div>
				</form>
				<div class="12u$">
				<c:if test="${not empty list }">
					<c:forEach var = "tmp" items="${list }">
					
					<div class="box">
						<ul class="alt">
							<li>
								<a class="icon" href="">${tmp.name }</a>
								<i>${tmp.content_date }</i>
							</li>
							<li></li>
						</ul>
						<p>${tmp.content }</p>
					</div>
					</c:forEach>
					</c:if>
				</div>
				<ul class="pagination" style="text-align: center">
					<li>
						<span class="button disabled">Prev</span>
					</li>
					<li>
						<a href="#" class="button">Next</a>
					</li>
				</ul>
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