<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>CheckPoint</title>

	<link href="_view/css/quiztakerStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="quiztaker-card">
    <h1>QuizTaker</h1><br>
                  <h3>${questionnum}</h3>          
    <h2>${question}</h2>      
    
    <form action="${pageContext.servletContext.contextPath}/quiztaker" method="post">
    
    <input type="text" name="answer" placeholder="Correct Choice" value="${answer}"/>
    <input type="submit" name="submit" class="login login-submit" value="Submit">
  </form>
  
  <div class="quiztaker-failed">
		${result}
	</div>
  
  </div>
</div>


</body>

</html>