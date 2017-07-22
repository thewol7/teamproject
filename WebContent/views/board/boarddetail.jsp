<%@page import="server.board.dao.PriboardDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="server.dao.ServerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String cPath = request.getContextPath();
	
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
.comment{
		position: relative;
	}
	
.comment .reply_icon {
	position: absolute;
	width: 15px;
	height: 15px;
	top: 0px;
	left: -30px;
	border-left: 1px solid black;
	border-bottom: 1px solid black;
}

.comment form {
	display: none;
}
</style>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 -->
				<a href="${pageContext.request.contextPath }/home.do" class="logo">
					<strong>${info.name }</strong>님의 Blog
				</a>
				<ul class="icons">
					<c:choose>
						<c:when test="${empty id }">
							<li>
								<!-- 1. 로그인 정보가 없을 경우 로그인이 되게 한다. 
								2. 로그인창은 새창없이 이동한다. 
								3. 로그인창에서 회원가입 한다. -->
								<a href="${pageContext.request.contextPath }/loginform.do" class="logo">
									<span class="">로그인</span>
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="${pageContext.request.contextPath }/logout.do" class="logo">
									<span class="">로그아웃</span>
								</a>
							</li>
						</c:otherwise>
					</c:choose>
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
				<section style="padding-top : 3em">
				<div class="box 12u$" style="padding-bottom: 22px; min-height: 500px;">
					<h4 style="margin-bottom:0">
						<p>${result.content_title }</p>
					</h4>
					<ul class="alt">
						<li></li>
						<li></li>
					</ul>
					<%-- <div class="12u$">
							<textarea name="ckContent" id="ckContent" placeholder="content"
								rows="20"></textarea>
							<script type="text/javascript">
								UPLOADCARE_PUBLIC_KEY = '07c3ee3ce257b7a7ce86';
								CKEDITOR.replace('ckContent');
								/* CKEDITOR.config.toolbarCanCollapse = false; */
								CKEDITOR.instances.ckContent.setData('<p><%=data.get(0).get("content_content") %></p>');
								/* CKEDITOR.config.readOnly = true; */
							</script>
						</div>  --%>
					<p class="image">${result.content_content }</p>
				</div>
				<!-- Break -->
				<div class="12u$" style="text-align: right">
					<ul class="actions">
					<c:if test="${ id eq page_id }">
						<li style="text-align: right">
							<input type="button" class="special" onclick="mvUpdateForm()" value="수정" />
						</li>
						<li style="text-align: right">
							<input type="button" class="special" onclick="mvDeleteForm()" value="삭제" />
						</li>
					</c:if>
						<li>
							<input type="reset" onclick="backTolist()" value="돌아가기" />
						</li>				
					</ul>
				</div>
				<!-- ////////////// comment /////////////////////////////////////////////////// -->

				<div class="comments">			
						<div class="comment" style="margin-left: 50px">
							<div class="reply_icon"></div>
							<ul class="alt">
								<li>
									<a class="icon" href="">${info.name }</a>
									<i>2017-06-02</i>
									<a class="rep icon" href="javascript:">답글</a>
								</li>
								<li>
									<p style="margin-bottom: 0 !important">Lorem ipsum dolor sit.</p>
								</li>
							</ul>
							<form class="repForm" method="post" action="#">
								<ul class="alt">
								<%-- <c:if test="${empty id }">
									<li>로그인 후 글을 남겨주세요</li>
								</c:if>
								<c:if test="${not empty id }"> --%>
									<li>
										<a class="icon" href="">${info.name }</a>
									</li>
								<%-- </c:if> --%>
								</ul>
								<div class="row uniform">
									<div class="10u 9u(medium) 9u(small) 12u$(xsmall)" style="padding-top: 0">
										<textarea style="resize: none" name="content" id="content"	placeholder="COMMENT" rows="2"></textarea>
									</div>
									<!-- Break -->
									<div class="2u 2u(medium) 3u(small)">
										<ul class="actions">
										<!-- 덧글 작성자 -->
											<input type="hidden" name="writer" value="${info.name }"/>
											<!-- 덧글 그룹 -->
											<input type="hidden" name="ref_group" value="${result.cont_id }" />											
											<input type="hidden" name="comment_group" value="${tmp.comment_group }" />
											<input class="button small" type="submit" value="COMMENT" onclick="return loginChk()" />
										</ul>
									</div>
								</div>
							</form>
						</div>
					<form method="post" action="${pageContext.request.contextPath }/views/board/boardcomment.do">
						<ul class="alt">
							<c:if test="${empty id }">
								<li>로그인 후 글을 남겨주세요</li>
							</c:if>
							<c:if test="${not empty id }">
								<li>
									<a class="icon" href="">#${info.name }</a>
								</li>
							</c:if>
						</ul>
						<div class="row uniform">
							<div class="10u 9u(medium) 9u(small) 12u$(xsmall)" style="padding-top: 0">
								<textarea style="resize: none" name="content" id="content" placeholder="COMMENT" rows="2"></textarea>
							</div>
							<!-- Break -->
							<div class="2u 2u(medium) 2u(small)">
								<ul class="actions">
									<!-- 덧글 작성자 -->
									<input type="hidden" name="writer" value="${info.name}" />
									<!-- 덧글 그룹 -->
									<input type="hidden" name="ref_group" value="${result.cont_id }" />
									<!-- 덧글 게시판 번호 일반 게시판 1, img게시판 2-->
									<input type="hidden" name="board_id" value="1" /> 
									<input class="button small" type="submit" value="COMMENT" onclick="return loginChk()" />
								</ul>
							</div>
						</div>
					</form>
				</div>
				</section>
			</div>
		</div>

		<!-- Sidebar ##############################Sidebar#########################Sidebar-->
		<div id="sidebar">
			<jsp:include page="/navbar.jsp" />
		</div>

	</div>
	<script>
	function backTolist() {
		location.href = "${pageContext.request.contextPath }/views/board/boardlist.do";
	};
	function mvUpdateForm() {
		location.href = "${pageContext.request.contextPath }/views/board/boardupdateform.do?cont_id=${result.cont_id}";
	}
	function mvDeleteForm(){
		location.href="${pageContext.request.contextPath }/views/board/boarddelete.do?cont_id=${result.cont_id}";
	}
	
	
	// 로그인 안되어 있을때 글쓰기 클릭시 실행할 함수
	/* var Id = ${empty id}; */
	function loginChk() {
		if (${empty id}){
			if(confirm("로그인이 필요합니다.")){
		        location.href = "${pageContext.request.contextPath }/loginform.do";
			}
			return false;
		} else {
			return true;
		}
	}
	
	$('.tools-container').hide();

	//덧글 달기 혹은 취소 버튼을 눌렀을때 실행할 함수 등록 
	$(".comments .rep").click(
			function() {
				if (${empty id}){
					if(confirm("로그인이 필요합니다.")){
				        location.href = "${pageContext.request.contextPath }/loginform.do";
					}
					return false;
				}
				if ($(this).text() == "답글") {
					console.log("누름");
					/* $(this).text("취소").parent().parent().parent().find("form").slideToggle(); */
					/* $(".repForm").slideToggle().text("취소"); */
					/* $(this).text("취소").toggleClass(".repForm"); */
					$(".repForm").slideToggle()
					$(this).text("취소");
				} else {
					console.log("누름");
					/* $(this).text("답글").parent().parent().parent().find("form").slideToggle(); */
					$(".repForm").slideToggle()
					$(this).text("답글");
					/* $(this).text("답글").toggleClass(".repForm"); */
				}
			});
	</script>
</body>
</html>