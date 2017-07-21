<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String cPath = request.getContextPath();
	String page_id = (String) request.getAttribute("page_id");
	int pageNum = (int) request.getAttribute("pageNum");
	String page_name = (String) request.getAttribute("page_name");
	double count = (int) request.getAttribute("pageNum");
	int pages = (int) request.getAttribute("pages");

	ArrayList<Map<String, Object>> data = ImgDao.getInst().getPicboard(Integer.parseInt(page_id),
			(pageNum - 1) * 12, pageNum * 12);
	/* (pageNum - 1) * 8, pageNum * 8); */
%>
<jsp:include page="/resource.jsp"></jsp:include>
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
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 -->
				<a href="<%=cPath%>/index.do?page_id=<%=page_id%>" class="logo">
					<strong><%=page_id%></strong>님의 Blog
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
						<a href="<%=cPath%>/loginform.do?page_id=<%=page_id%>"
							class="logo">
							<span class="">로그인</span>
						</a>
					</li>

					<%
						} else {
					%>
					<li>
						<a href="<%=cPath%>/logout.do" class="logo">
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
							<a href="imgboardwriteform.do?page_id=<%=page_id%>"
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
							<%
								if (data != null) {
									for (int i = 0; i < (double) data.size(); i++) {
							%>
							<div class="<%if(data.size() == 1){%> 
										12u 
										<%}else if(data.size() == 2){%>
										6u 6u(medium) 6u(small) 12u(xsmall) 
										<%}else if(data.size() == 3){%>
										4u 6u(medium) 6u(small) 12u(xsmall)
										<%}else if(data.size() > 3){%>
										3u 4u(medium) 6u(small) 12u(xsmall)
										<%}%>">
							<!-- <div class="3u 4u(medium) 6u(small) 12u$(xsmall)"> -->
								<span class="image fit img-panel">	
									<a href="imgboarddetail.do?cont_id=<%=data.get(i).get("cont_id")%>&page_id=<%=page_id%>" class="image">
										<img src="<%=data.get(i).get("pic")%>" alt="" />
									</a>
									<h5>
										<a class="icon"	href="imgboarddetail.do?cont_id=<%=data.get(i).get("cont_id")%>&page_id=<%=page_id%>"><%=data.get(i).get("content_title")%></a>
									</h5>
									<ul class="alt">
										<li style="border-top: 1px solid black"></li>
									</ul>
								</span>
							</div>
							<%
								}
								} else {
							%>
							<div class="12u$" style="text-align:center">
								<h2>입력된 게시글이 없습니다.</h2>
							</div>
							<%
								}
							%> 
							<%-- <div class="3u 4u(medium) 6u(small) 12u$(xsmall)">
								<span class="image fit img-panel">
									<a href="#" class="image">
										<img src="<%=cPath%>/images/zok_01.jpg" alt="" />
									</a>
									<h5>
										<a class="icon" href="#">테스트용 이미지 이미지 이미지 테스트</a>
									</h5>
									<ul class="alt">
										<li style="border-top: 1px solid black"></li>
									</ul>
								</span>
							</div>
							<div class="3u 4u(medium) 6u(small) 12u$(xsmall)">
								<span class="image fit img-panel">
									<a href="#" class="image">
										<img src="<%=cPath%>/images/main_d2.jpg" alt="" />
									</a>
									<h5>
										<a class="icon" href="#">테스트용 이미지 이미지 이미지 테스트</a>
									</h5>
									<ul class="alt">
										<li style="border-top: 1px solid black"></li>
									</ul>
								</span>
							</div>
							<div class="3u 4u(medium) 6u(small) 12u$(xsmall)">
								<span class="image fit img-panel">
									<a href="#" class="image">
										<img src="<%=cPath%>/images/modal_01.jpg" alt="" />
									</a>
									<h5>
										<a class="icon" href="#">테스트용 이미지 이미지 이미지 테스트</a>
									</h5>
									<ul class="alt">
										<li style="border-top: 1px solid black"></li>
									</ul>
								</span>
							</div>
							<div class="3u 4u(medium) 6u(small) 12u$(xsmall)">
								<span class="image fit img-panel">
									<a href="#" class="image">
										<img src="<%=cPath%>/images/pa1.png" alt="" />
									</a>
									<h5>
										<a class="icon" href="#">테스트용 이미지 이미지 이미지 테스트</a>
									</h5>
									<ul class="alt">
										<li style="border-top: 1px solid black"></li>
									</ul>
								</span>
							</div> --%>
							
						</div>
					</div>
				</div>
				<%	if(data != null){ %>
				<div>
					<ul class="pagination" style="text-align: center">
						<li>
							<span class="button disabled">Prev</span>
						</li>
						<%
							for (int i = 1; i <= pages; i++) {
						%>
						<%
							if (pageNum == i) {
						%>
						<li>
							<a class="page active"
								href="boardlist.jsp?pageNum=<%=i%>&page_id=<%=page_id%>"><%=i%></a>
						</li>
						<%
							} else {
						%>
						<li>
							<a class="page"
								href="boardlist.jsp?pageNum=<%=i%>&page_id=<%=page_id%>"><%=i%></a>
						</li>
						<%
							}
						%>
						<%
							}
						%>
						<li>
							<a href="#" class="button">Next</a>
						</li>
					</ul>
				</div>
				<%}%>
				</section>
			</div>
		</div>

		<!-- Sidebar ##############################Sidebar#########################Sidebar-->
		<div id="sidebar">
			<jsp:include page="/navbar.jsp" />
		</div>

	</div>
	<script>
	function loginChk() {
	if (<%=request.getSession().getAttribute("id")%> == null){
		if(confirm("로그인이 필요합니다.")){
	        location.href = "<%=cPath%>/loginform.do?page_id=<%=page_id%>";
				}
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
	</script>
</body>
</html>