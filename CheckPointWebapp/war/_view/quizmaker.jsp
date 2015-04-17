<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>Make a Quiz</title>

	<link href="_view/css/quizmakerStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="QuizMaker-card">
    <h1>CheckPoint</h1><br>
    <h2>Create A Quiz</h2>
  <form action="${pageContext.servletContext.contextPath}/quizmaker" method="post">
    <input type="text" name="question" placeholder="Question" value="${question}"/>
    <input type="text" name="choiceA" placeholder="Choice 1" value="${choiceA}"/>
    <input type="text" name="choiceB" placeholder="Choice 2" value="${choiceB}"/>
    <input type="text" name="choiceC" placeholder="Choice 3" value="${choiceC}"/>
    <input type="text" name="choiceD" placeholder="Correct Choice" value="${correctChoice}"/>
    
    <input type="submit" name="submit" class="login login-submit" value="Submit">
  </form>
  
  <div class="QuizMaker-failed">
		${result}
	</div>
	
 <!-- <div class="QuizMaker-help">
    <a href="http://localhost:8081/checkpoint/register">Register</a> - <a href="#">Forgot Password</a>
  </div>
</div>-->

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

</body>

</html>