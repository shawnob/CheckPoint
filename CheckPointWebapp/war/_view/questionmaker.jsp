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
    
    <select>
  		<option value="MC">Multiple Choice</option>
  		<option value="FIB">Fill In The Blank</option>
	</select>
    
    
    
    
  <form action="${pageContext.servletContext.contextPath}/quizmaker" method="post">
    <input type="text" name="question" placeholder="Question" value="${question}"/>
    <input type="checkbox" name="select1" value="${select1}">
    <input type="text" name="choice1" placeholder="Choice 1" value="${choice1}"/>
    <input type="checkbox" name="select2" value="${select2}">
    <input type="text" name="choice2" placeholder="Choice 2" value="${choice2}"/>
    <input type="checkbox" name="select3" value="${select3}">
    <input type="text" name="choice3" placeholder="Choice 3" value="${choice3}"/>
    
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