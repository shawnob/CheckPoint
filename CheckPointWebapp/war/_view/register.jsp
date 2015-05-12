<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>CheckPoint-Register</title>

	<link href="_view/css/RegisterStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="register-card">
    <h1>CheckPoint</h1><br>
    <h2>Create Account</h2><br>
  <form action="${pageContext.servletContext.contextPath}/register" method="post">
    <input type="text" name="firstname" placeholder="Firstname" value="${firstname}"/>
    <input type="text" name="lastname" placeholder="Lastname" value="${lastname}"/>
    <input type="text" name="email" placeholder="Email Address" value="${email}"/>
    <input type="text" name="email2" placeholder="Confirm Email Address" value="${email2}"/>
    <input type="text" name="username" placeholder="Username" value="${username}"/>
    <input type="password" name="password" placeholder="Password" value="${password}"/>
    <input type="password" name="password2" placeholder="Confirm Password" value="${password2}"/>
    <input type="submit" name="submit" class="register register-submit" value="Create Account">
  </form>
  
  <div class="register-failed">
		${result}
	</div>
	
  <div class="register-help">
    <a href="http://localhost:8081/checkpoint/login">Already have account</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  

</body>

</html>