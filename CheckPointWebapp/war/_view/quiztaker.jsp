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
                  <h3>Question # Var</h3>          
    <h2>Question Variable:</h2>      
    
    <form action="${pageContext.servletContext.contextPath}/quiztaker" method="post">
    
    <!-- <input type="text" name="choiceA" placeholder="Choice 1" value="${choiceA}"/>
    <input type="text" name="choiceB" placeholder="Choice 2" value="${choiceB}"/>
    <input type="text" name="choiceC" placeholder="Choice 3" value="${choiceC}"/> -->
    
    <input type="text" name="choiceD" placeholder="Correct Choice" value="${correctChoice}"/>
    <input type="submit" name="submit" class="login login-submit" value="Submit">
  </form>
  
  <div class="quiztaker-failed">
		${result}
	</div>
  
  </div>
</div>


</body>

</html>