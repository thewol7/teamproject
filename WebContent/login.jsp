<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String page_id = (String)request.getParameter("page_id");
	String cPath = request.getContextPath();
	
	if(request.getSession().getAttribute("id")==null){%>
		<script>
			alert("아이디 혹은 비밀번호를 확인해주세요.");
			location.href="loginform.do?page_id=<%=page_id%>";
		</script>
	<%}else {%>
		<script>
			alert("로그인 완료.");
			location.href="index.do?page_id=<%=request.getSession().getAttribute("id")%>";
		</script>
	<%} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>