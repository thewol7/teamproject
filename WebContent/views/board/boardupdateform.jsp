<%@page import="server.dao.ServerDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cPath = request.getContextPath();

	int cont_id = (int) request.getAttribute("cont_id");
	int page_id = (int) request.getAttribute("page_id");

	System.out.println("jsp cont_id :" + cont_id);
	System.out.println("jsp page_id :" + page_id);

	ArrayList<Map<String, Object>> data = ServerDao.getInst().getPridetail(cont_id);
	boolean updateviewcount = ServerDao.getInst().updateviewcount(cont_id);
%>
<jsp:include page="/resource.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function backTolist() {
	location.href = "<%=cPath%>/board/boardlist.do?page_id=<%=page_id %>";
};
</script>
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header"> <!-- 나중에 관리 페이지 추가해서 메뉴 편집 가능하도록 해야함 --> <a
					href="<%=cPath%>/index.jsp?page_id=<%=page_id%>" class="logo"
				>
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
						<a href="<%=cPath%>/loginform.do?page_id=<%=page_id%>" class="logo">
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
				<section style="padding-top : 3em">
				<form method="post" action="#">
					<div class="row uniform">
						<div class="12u 12u$(xsmall)">
							<input type="text" name="title" id="title" value="<%=data.get(0).get("content_title")%>"
								placeholder="제목" maxlength="50"/>
						</div>
						<!-- Break -->
						<div class="12u$">
							<textarea name="ckContent" id="ckContent" placeholder="content"
								rows="20" value=""><%=data.get(0).get("content_content") %></textarea>
							<script type="text/javascript">				
								/* 개인 키값 입력 */
								UPLOADCARE_PUBLIC_KEY = '07c3ee3ce257b7a7ce86';
								CKEDITOR.replace('ckContent', {								
								    uploadcare: {
								        multiple: true
								    }
								});
							</script>
						</div>
						<!-- Break -->
						<div class="12u$" style="text-align: right">
							<ul class="actions">
								<li>
									<input type="submit" value="확인" class="special" />
								</li>
								<li>
									<input type="reset" onclick="backTolist()" value="취소" />
								</li>
							</ul>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- Sidebar ##############################Sidebar#########################Sidebar-->
		<div id="sidebar">
			<jsp:include page="/navbar.jsp" />
		</div>

	</div>
<script>
	function backTolist() {
		location.href = "boardlist.do?page_id=<%=page_id%>";
	};
	
	/* $("#submit").click(function(){ */
		function chkData(){
			/* onclick 이벤트 발생했을때 ckeditor 에 데이터를 확인함 */
			var ckData = CKEDITOR.instances.ckContent.getData();
			
			/* if(ckData == null){
				alert("ckData null");
			}else{
				alert("ckData:"+ckData);	
			} */
				
			/* 데이터가 없을 경우 알람 띄우기 */
			if(CKEDITOR.instances.ckContent.getData().length < 1){
				alert("내용을 입력해 주세요");
				return false;
			}else{
				/* 데이터가 있을 경우 데이터값을 input에 담아서 넘김 */
				/* document.form1.ckInput.value=ckData; */
				document.getElementById("ckValue").value=ckData;
				if(document.getElementById("ckValue").value == null){
					alert("ckValue null!!");
					return false;
				}else{
					alert("ckValue:"+document.getElementById("ckValue").value
							+" &&title:"+document.getElementById("title").value);
					return true;
				}	
			}
		}
</script>
</body>
</html>