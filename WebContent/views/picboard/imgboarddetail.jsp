<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resource.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>Insert title here</title>
</head>
<script>
	function backTolist() {
		location.href = "${pageContext.request.contextPath}/views/picboard/imgboardlist.do?";
	};
	function mvUpdateForm() {
		location.href = "${pageContext.request.contextPath}/views/picboard/imgboardupdateform.do?cont_id=${cont_id}";
	}
	function deletePic() {
		location.href = "${pageContext.request.contextPath}/views/picboard/imgboarddelete.do?cont_id=${cont_id}";
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
				<a href="${pageContext.request.contextPath}/index.jsp" class="logo">
					<strong>${info.name}</strong>님의 Blog
				</a>
				<ul class="icons">
					<c:if test="${empty id}">
					<li>
						<!-- 1. 로그인 정보가 없을 경우 로그인이 되게 한다. 
						2. 로그인창은 새창없이 이동한다. 
						3. 로그인창에서 회원가입 한다. -->
						<a href="${pageContext.request.contextPath}/loginform.do" class="logo">
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
				<!-- Banner -->
				<section style="padding-top : 3em">
				<div class="box 12u$" style="padding-bottom: 22px; min-height: 500px;">
					<div>
					<c:if test="${dto.prevNum ne 0 }">
						<a href="imgboarddetail.do?cont_id=${dto.prevNum }">이전글</a> |
					</c:if>
					<c:if test="${dto.nextNum ne 0 }">
						<a href="imgboarddetail.do?cont_id=${dto.nextNum }">다음글</a>
					</c:if>
					</div>
					
					<h4 style="margin-bottom:0">
						<p>${dto.content_title}</p>
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
					<p>${dto.content_content }</p>
				</div>
				<!-- Break -->
				<div class="12u$" style="text-align: right">
					<ul class="actions">
						<c:if test="${!empty id}">
						<li style="text-align: right">
							<input type="button" class="special" onclick="mvUpdateForm()" value="수정" />
						</li>
						<li style="text-align: right">
							<input type="button" class="special" onclick="deletePic()" value="삭제" />
						</li>
						</c:if>
						<li>
							<input type="reset" onclick="backTolist()" value="돌아가기" />
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