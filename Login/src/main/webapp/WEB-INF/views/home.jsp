<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home 60102365 이건호</title>
	
</head>
<body>

<div style="margin:0 auto; border:1 solid">
	<div style="margin:5px; padding: 3px; border:1 solid; background-color: #88f">
	<h1>
		명지대학교 수강신청 시스템  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<P> Oracle DB로 작업했습니다. </P>
	</div>
	
	<div style="margin:5px; padding: 3px; border:1 solid">
		<form action="loginController/login.do" method="post">
			UserID : <input type="text" name="userID"/><br/>
			UserPassword : <input type="password" name="userPassword"/><br/>
			<input type="submit" value="로그인">	
		</form>
	
		<form action="loginController/createAccount.do" method="post">
			UserDBID : <input type="text" name="userDBID"/><br/>
			UserDBPassword : <input type="password" name="userDBPassword"/><br/>
			<input type="submit" value="계정생성">
		</form>
		
		<form action="loginController/createTable.do" method="post">
	 		<input type="submit" value="테이블 생성">
		</form>
	
		<form action="loginController/insertData.do" method="post">
	 		<input type="submit" value="데이터삽입">
		</form>
		
		<form action="loginController/updateData.do" method="post">
	 		<input type="submit" value="업데이트">
		</form>
		
		<form action="loginController/selectAll.do" method="post">
			<input type="submit" value="selectAll">
		</form>
		
		<form action="loginController/deleteId5.do" method="post">
	 		<input type="submit" value="id5 삭제">
		</form>
		
		<form action="loginController/dropTable.do" method="post">
	 		<input type="submit" value="테이블 삭제">
		</form>
	
		<form action="loginController/dropAccount.do" method="post">
			<input type="submit" value="계정삭제">
		</form>
	</div>
</div>
</body>
</html>
