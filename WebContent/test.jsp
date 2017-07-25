<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data"
      action="https://upload.uploadcare.com/submit/">
  <input type="hidden" name="UPLOADCARE_PUB_KEY" value="07c3ee3ce257b7a7ce86">
  <input type="hidden" name="UPLOADCARE_ACTION" value="https://uploadcare.com/accounts/settings/projects/07c3ee3ce257b7a7ce86/">
  <input type="hidden" name="UPLOADCARE_ACTION" value="1">
  <input type="file" name="my-file">
  <input type="submit" value="확인"/>
</form>
<script>

</script>
</body>
</html>