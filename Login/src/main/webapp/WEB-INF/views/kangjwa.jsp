<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kangjwa</title>
</head>
<body>

<h1>강좌개설 화면</h1>

${userSession.getID()}님 로그인.<br/>
${userSession.getName()} 교수님 안녕하세요!<br/><br/>

	<form action="${pageContext.request.contextPath}/KangjwaController/kangjwagaseol.do" method="post">
		강좌명 : <input type="text" name="kangjwaName"/><br/>
		강좌번호 : <input type="text" name="kangjwaNumber"/><br/>
		<input type="submit" value="강좌개설">
	</form>

<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>

</body>
</html>