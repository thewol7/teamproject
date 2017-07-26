<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="inner">

	<!-- Search -->
	<section id="search" class="alt">
	<form method="post" action="#" target="_blank">
		<!-- 게시물 검색이 가능하게 구현한다. -->
		<input type="text" name="query" id="query" placeholder="Search" />
	</form>
	</section>

	<!-- Menu -->
	<nav id="menu"> 
	<header class="major">
		<h2>
			Menu&nbsp;&nbsp;		
		</h2>
	</header> 
	<c:if test="${not empty id }">
	<!-- 관리페이지 아이콘/session.name navber에 추가함. 추후 업데이트 페이지 구성 -->
	<!-- 이미지 아이콘은 업로드 시 사이즈를 조절하여 40x40 혹은 50x50으로.. 상황봐서 크기 조절 -->
	<header style="margin-bottom:20px">
			<ul class="icons">
				<li>					
					<a href="${pageContext.request.contextPath }/mnt.do">
						<img id="profile_img_main" src="${session.profile_img }" alt="" />
					</a>
				</li>
				<li id="profile_name">
					<a href="${pageContext.request.contextPath }/mnt.do" class="icon">${session.name }</a>
					<i>
					<%-- <fmt:parseDate value="${session.create_date }" var="dateTmp" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${dateTmp}" pattern="yyyy-MM-dd"/> --%>				
					${session.create_date }
					</i>
				</li>				
			</ul>	
	</header> 
	</c:if>
	<ul>
		<li>
			<c:choose>
				<c:when test="${not empty id }">
					<a href="${pageContext.request.contextPath }/home.do?page_id=${id}">HOME</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/home.do">HOME</a>
				</c:otherwise>
			</c:choose>
		</li>
		<li>
			<span class="opener">게시판</span>
			<ul>
				<li>					
					<a href="${pageContext.request.contextPath }/views/board/boardlist.do">자유	게시판</a>
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
					<a href="${pageContext.request.contextPath }/views/picboard/imgboardlist.do?pageNum=1">2014-02-베트남</a>
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
			<a href="${pageContext.request.contextPath }/guestboard/list.do">방명록</a>
		</li>
		<li>
			<a
				href="http://cafe.daum.net/dotax/FGFP/9109?q=%C8%F7%BE%EE%B7%CE%C1%EE%20%BF%C0%BA%EA%20%B4%F5%20%C5%B9%BD%BA">시공의
				폭풍으로</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/random.do">랜덤 테스트(임시)</a>
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



