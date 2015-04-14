<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<form action="loginController/login.do" method="post">
		UserID : <input type="text" name="userID"/><br/>
		UserPassword : <input type="password" name="userPassword"/><br/>
		<input type="submit" value="로그인">	
	</form>

</body>
</html>
