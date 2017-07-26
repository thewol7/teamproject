<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ucarecdn.com/libs/widget/3.1.0/uploadcare.full.min.js" charset="utf-8"></script>
<jsp:include page="/resource.jsp" />
<title>Insert title here</title>
</head>
<style>
#imageUpload
{
    display: none;
}

#profileImage, #profileImage2 
{
    cursor: pointer;
}

#profile-container {
    width: 150px;
    height: 150px;
    overflow: hidden;
    /* webkit-border-radius: 10%;
    -moz-border-radius: 10%;
    -ms-border-radius: 10%;
    -o-border-radius: 10%;
    border-radius: 10%; */
}

#profile-container img {
    width: 150px;
    height: 150px;
}

.image-preview-single {
  padding: 10px 0;
}
.image-preview-single > img {
  width: 150px;
  height: 150px;
  vertical-align: middle;
  /* visibility: hidden; */
  display: inline-block;
}

div.uploadcare--progress, div.uploadcare--progress_type_canvas{
	position : relative;
}
.uploadcare--progress__canvas{
	position: absolute;
	width: 40px;
	height: 40px;
	top: -5px;
	left:-100px;
}

.uploadcare--widget__button_type_open, 
.uploadcare--widget uploadcare--widget_option_clearable, 
.uploadcare--widget_status_loaded,
/* .uploadcare--widget__text, */
.uploadcare--widget__button_type_cancel{
	display:none;
}

</style>
<body>
<h3>test. test</h3>
<h3>test. 333</h3>
<%-- <div id="profile-container">
	<image id="profileImage" src="${pageContext.request.contextPath }/images/icons/default.png" />
	<input id="imageUpload" type="file" name="profile_photo" placeholder="Photo" required="" capture>
	<input type="hidden" name="photo_value" id="photo_value" value="" />								
	<!-- <label style="text-align: center;">PHOTO</label> -->
	<input type="hidden" role="uploadcare-uploader" name="my_file" />
	<script>
	  UPLOADCARE_PUBLIC_KEY = 'demopublickey';
	</script>	
</div>	 --%>

<div class="image-preview-single">
  <img id="profileImage2" src="${pageContext.request.contextPath }/images/icons/default.png" alt="">  
  <input type="hidden" role="uploadcare-uploader" data-clearable="" data-images-only="" data-public-key="1c86ca998ba22e75fbc6">
</div>
  
</body>
<script>
/* $("#profileImage").click(function(e){
	$("#imageUpload").click();
	$(".uploadcare--widget__button_type_open").click()
});*/

$("#profileImage2").click(function(e){
	/* $("#imageUpload").click(); */
	$(".uploadcare--widget__button_type_open").click();
});


function installWidgetPreviewSingle(widget, img) {
	  widget.onChange(function(file) {
	    /* img.css('visibility', 'hidden'); */
	    /* img.attr('src', ''); */
	    if (file) {
	      file.done(function(fileInfo) {
	        var size = '' + (img.width() * 2) + 'x' + (img.height() * 2);
	        var previewUrl = fileInfo.cdnUrl + '-/scale_crop/' + size + '/center/';
	        img.attr('src', previewUrl);
	        img.css('visibility', 'visible');
	      });
	    }
	  });
	}
$(function() {
  $('.image-preview-single').each(function() {
    installWidgetPreviewSingle(
      uploadcare.SingleWidget($(this).children('input')),
      $(this).children('img')
    );
  });
});
</script>
</html>