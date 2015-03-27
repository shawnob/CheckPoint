<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>CheckPoint</title>

	<link href="_view/css/LoginStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="login-card">
    <h1>CheckPoint</h1><br>
  <form action="${pageContext.servletContext.contextPath}/login" method="post">
    <input type="text" name="username" placeholder="Username" value="${username}"/>
    <input type="password" name="password" placeholder="Password" value="${password}"/>
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>
  
  <div class="login-failed">
		${result}
	</div>
	
  <div class="login-help">
    <a href="http://localhost:8081/checkpoint/register">Register</a> - <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

</body>

</html>