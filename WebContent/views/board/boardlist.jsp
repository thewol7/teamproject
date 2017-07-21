<%@page import="server.dao.ServerDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String cPath = request.getContextPath();
	int pageNum = (int) request.getAttribute("pageNum");
	String page_name = (String) request.getAttribute("page_name");
	double count = (int) request.getAttribute("pageNum");
	int pages = (int) request.getAttribute("pages");
	String page_id = (String) request.getAttribute("page_id");
	
	ArrayList<Map<String, Object>> data = ServerDao.getInst()
			.getPriboard(Integer.parseInt(request.getParameter("page_id")), (pageNum - 1) * 15, pageNum * 15);
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
<script>
	// 로그인 안되어 있을때 글쓰기 클릭시 실행할 함수
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
</script>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 -->
				<a href="<%=cPath%>/index.do?page_id=<%=page_id %>" class="logo">
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
						<a href="<%=cPath%>/loginform.do?page_id=<%=page_id %>" class="logo">
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
				<!-- Banner -->
				<section style="padding-top:2em">
				<div class="row">
					<div class="6u 6u(small)">
						<h2 class="h-header">게시판</h2>
					</div>
					<div class="6u 6u(small)" style="text-align: right">
						<h4>
							<a href="<%=cPath%>/board/boardwriteform.do?page_id=<%=page_id%>"
								class="button special" onclick="return loginChk()">새글쓰기</a>
						</h4>
					</div>
				</div>
				<div class="table-wrapper">
					<ul class="alt">
						<li></li>
						<li style="border-top: 2px solid black"></li>
					</ul>
					<table>
						<%-- <colgroup>
							<col width="40">
							<col width="300" />
							<col width="60" />
							<%
								//if(request.getSession().getAttribute("page_id").equals(page_id)){
							%>
							<col width="70" />
							<col width="60" />
							<col width="40" />
						</colgroup> --%>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
								if (data != null) {
									for (int i = 0; i < data.size(); i++) {
							%>
							<tr>
								<td><%=data.get(i).get("cont_id")%></td>
								<td>
									<!--  style="text-align:left" --> <a
										href="boarddetail.do?cont_id=<%=data.get(i).get("cont_id")%>&page_id=<%=page_id%>"
										class="icon">
										<%=data.get(i).get("content_title")%></a>
								</td>
								<td><%=page_name%></td>
								<td><%=data.get(i).get("content_date")%></td>
								<td><%=data.get(i).get("view_count")%></td>
							</tr>
							<%
								}
								}
							%> 
						</tbody>
					</table>
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