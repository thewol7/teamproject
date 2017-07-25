<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ucarecdn.com/libs/widget/3.1.0/uploadcare.full.min.js" charset="utf-8"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- db에 저장하고 navbar메뉴에서 현재 id에 해당하는 사람 이름으로 저장된 메뉴를 불러온다 -->
	<form action="">
		추가할 메뉴
		<input type="text" name="menuAdd" id="maneAdd" />
		<button type="submit">저장</button>
	</form>
	<div>
		<h3>현재 메뉴목록</h3>
		<p>메뉴 추가/삭제</p>
	</div>

	<div>
		<p>프로필 이미지는 기본 50x50으로 줄여서 저장 // 테스트. 동작안함.</p>
		<form action="profileupdate.do" method="post">
			<!-- 프로필 이미지 업데이트 항목 -->
			<script>
				UPLOADCARE_PUBLIC_KEY = 'c51998378cdd90bd1018';
				UPLOADCARE_TABS = 'file url facebook gdrive dropbox instagram';
				UPLOADCARE_IMAGES_ONLY = true;
				UPLOADCARE_LOCALE_TRANSLATIONS = {
					buttons : {
						cancel : 'Cancel',
						remove : 'Remove',
						choose : {
							images : {
								one : 'Choose Profile img'
							}
						}
					}
				};
			</script>
			<input type="hidden" role="uploadcare-uploader" name="Profile"
				data-public-key="c51998378cdd90bd1018"
				data-tabs="file url facebook gdrive dropbox instagram"
				data-image-shrink="50x50 100%" 
				data-images-only="true"
				data-preview-step="false" 
				data-clearable="false"
				data-multiple="false" 
				data-system-dialog="false"
				data-crop="50x50 upscale" />
			<input type="submit" value="수정" class="button"/>
		</form>	
	</div>
</body>
</html>