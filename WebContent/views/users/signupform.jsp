<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<script src="https://ucarecdn.com/libs/widget/3.1.0/uploadcare.full.min.js" charset="utf-8"></script>
<jsp:include page="/resource.jsp" />
<title>회원가입</title>
</head>
<style>
#imageUpload
{
    display: none;
}

#profileImage
{
    cursor: pointer;
}

#profile-container {
    width: 100%;
    height: 150px;
    overflow: hidden;
    /* webkit-border-radius: 10%;
    -moz-border-radius: 10%;
    -ms-border-radius: 10%;
    -o-border-radius: 10%;
    border-radius: 10%; */
}

#profile-container img {
    width: 100%;
    height: 150px;
}
.uploadcare--widget__button_type_open{
	display:none;
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
				<a href="home.do" class="logo">
					<strong>${page_id }</strong>님의 Blog
				</a>
				<ul class="icons">
					<li>
						<a href="home.do" class="logo">
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
				<section id="banner" style="padding-bottom : 0">
				<div class="content">
					<header style="text-align:center;">
					<h1 style="margin-bottom:0;">SIGNUP</h1>
					<input type="hidden" role="uploadcare-uploader" name="my_file" />
					<script>
					  UPLOADCARE_PUBLIC_KEY = 'demopublickey';
					</script>
					</header>
				</div>
				</section>
				<section id="banner" class="signup-input-reform">
				<div class="content">
					<form action="signup.do" method="post" class="signup_form" novalidate>
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="text" name="id" placeholder="Id">
						</div>
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="password" name="pwd" id="pwd" placeholder="Password">
						</div>
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="text" name="name" id="name" placeholder="Name">
						</div>
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="text" name="phone" id="phone" placeholder="Phone">
						</div>
						<div class="12u 12u$(xsmall) input-reform-bottom">
							<input type="email" name="email" id="email" placeholder="Email">
						</div>
						<div class="row uniform" style="text-align:-webkit-center;">
							<div class="6u 12u$(xsmall) input-reform-bottom">
								<input type="radio" name="gender" id="man" value="M">
								<label for="man">MAN</label>
							</div>
							<div class="6u 12u$(xsmall) input-reform-bottom">
								<input type="radio" name="gender" id="female" value="F">
								<label for="female">FEMALE</label>
							</div>
							<div class="4u input-reform-bottom">
								<div id="profile-container">
									<image id="profileImage" src="${pageContext.request.contextPath }/images/icons/default.png" />
								</div>
								<input id="imageUpload" type="file" name="profile_photo" placeholder="Photo" required="" capture>
								<input type="hidden" name="photo_value" id="photo_value" value="" />
								
								<!-- <label style="text-align: center;">PHOTO</label> -->
							</div>
							<div class="8u input-reform-bottom">
								<div id="profile-container">
									<textarea style="resize:none;" name="profile_cmt" id="profile_cmt" placeholder=""	rows="5"></textarea>
									<label style="text-align: center;">COMMENT</label>
								</div>								
							</div>							
							<div class="12u 12u$(xsmall)">
								<ul class="actions">
									<li>
										<input type="submit" value="회원가입" class="special button" />										
									</li>
								</ul>
							</div>
						</div>
					</form>
				</div>					
				</div>
				</section>
				<!-- Footer -->
				<footer id="footer">
				<p class="copyright" style="text-align: center; margin: 0">
					&copy; Untitled. All rights reserved. Demo Images:
					<a href="#">Unsplash</a>
					. Design:
					<a href="#">Cho.D.H</a>
					.
				</p>
				</footer>
			</div>
		</div>
<script>

/* 프로필 이미지 선택 */
$("#profileImage").click(function(e){
	$("#imageUpload").click();
	/* $(".uploadcare--widget__button_type_open").click() */
});

/* 프로필 이미지 선택시  이미지 팝업 및 변경*/
/* var file = uploadcare.fileFrom('url', 'http://example.com/image.png'); */
function fasterPreview( uploader ) {
    if ( uploader.files && uploader.files[0] ){
          $('#profileImage').attr('src', 
             window.URL.createObjectURL(uploader.files[0]) );
          console.log(window.URL.createObjectURL(uploader.files[0]));
          
          document.getElementById("photo_value").value=window.URL.createObjectURL(uploader.files[0]);
          console.log("input value : "+window.URL.createObjectURL(uploader.files[0]));
    }
}

$("#imageUpload").change(function(){
    fasterPreview( this );
    
});

$(".signup_form").submit(function(){
	//이벤트가 일어난 바로 그 폼을 선택해서 자손요소 중에서 textarea 요소를 찾아서 value 값 읽어오기 
	if(document.getElementById("photo_value").value == null || document.getElementById("photo_value").value == ''){
		document.getElementById("photo_value").value = "${pageContext.request.contextPath }/images/icons/default.png";
		/* alert('프로필 사진을 등록해 주세요.'); */
		console.log("default image : "+document.getElementById("photo_value").value);
		return true;
	}
});

/* $(".uploadcare--widget__button_type_open").hide(); */
</script>
</body>
</html>