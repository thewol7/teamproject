<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="/resource.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>Insert title here</title>
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
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 -->
				<a href="${pageContext.request.contextPath}/index.do" class="logo">
					<strong>${info.name}</strong>님의 Blog
				</a>
				<ul class="icons">
					<c:if test="${empty id}">
						<li>
						<a href="${pageContext.request.contextPath}/loginform.do"
							class="logo">
							<span class="">로그인</span>
						</a>
					</li>
					</c:if>
					
					<c:if test="${!empty id}">
						<li>
							<a href="${pageContext.request.contextPath}/logout.do" class="logo">
								<span class="">로그아웃</span>
							</a>
						</li>
					</c:if>

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

				<!-- Section -->
				<section style="padding-top:2em">
				<div class="row">
					<div class="6u 6u(small)">
						<h2 class="h-header">사진게시판</h2>
					</div>
					<div class="6u 6u(small)" style="text-align: right">
						<h4>
							<a href="${pageContext.request.contextPath}/views/picboard/imgboardwriteform.do"
								class="button special" onclick="return loginChk()">새글쓰기</a>
						</h4>
					</div>
				</div>
				<div class="box alt">
					<ul class="alt">
						<li style="border-top: 2px solid black"></li>
					</ul>
					<div class="row">
						<div class="row grid-gallery">
							<c:if test="${!empty data }">
								<c:forEach var="tmp" items="${data}">
									<div class='
										<c:choose>	
											<c:when test="${fn:length(data) eq 1}">
												12u
											</c:when>
											<c:when test="${fn:length(data) eq 2}">
												6u 6u(medium) 6u(small) 12u(xsmall)
											</c:when>
											<c:when test="${fn:length(data) eq 3}">
												4u 6u(medium) 6u(small) 12u(xsmall)
											</c:when>
											<c:otherwise>
												3u 4u(medium) 6u(small) 12u(xsmall)
											</c:otherwise>
										</c:choose>
									'>
								
								<span class="image fit img-panel">	
									<a href="imgboarddetail.do?cont_id=${tmp.cont_id}" class="image">
										<img src="${tmp.pic}" alt="" />
									</a>
									<h5>
										<a class="icon"	href="imgboarddetail.do?cont_id=${tmp.cont_id }">${tmp.content_title}</a>
									</h5>
									<ul class="alt">
										<li style="border-top: 1px solid black"></li>
									</ul>
								</span>
								</div>
								</c:forEach>
							</c:if>
							<c:if test="${empty data }">
								<div class="12u$" style="text-align:center">
									<h2>입력된 게시글이 없습니다.</h2>
								</div>
							</c:if>
						</div>
					</div>
				</div>
				</section>
				<!-- pagination -->
				<ul class="pagination">
					<c:choose>
						<c:when test="${startPageNum ne 1 }">
							<li>
								<a href="imgboardlist.do?pageNum=${startPageNum-1 }">&laquo;</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="disabled">
								<a href="javascript:">&laquo;</a>
							</li>
						</c:otherwise>
					</c:choose>
					
					<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
						<c:choose>
							<c:when test="${i eq pageNum }">
								<li class="active">
									<a href="imgboardlist.do?pageNum=${i }">${i }</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="imgboardlist.do?pageNum=${i }">${i }</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${endPageNum lt totalPageCount }">
							<li>
								<a href="imgboardlist.do?pageNum=${endPageNum+1 }">&raquo;</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="disabled">
								<a class="muted" href="javascript:">&raquo;</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		
		<!-- Sidebar ##############################Sidebar#########################Sidebar-->
		<div id="sidebar">
			<jsp:include page="/navbar.jsp" />
		</div>
	</div>
	<script>
	function loginChk() {
		if (${id} == null){
			if(confirm("로그인이 필요합니다.")){
		        location.href = "${pageContext.request.contextPath}/loginform.do";
				return false;
			} else {
				return true;
			}
		}

		$(".img-panel").imgLiquid({
			fill : true,
			horizontalAlign : "center",
			verticalAlign : "center"
		});
	}
	</script>
</body>
</html>