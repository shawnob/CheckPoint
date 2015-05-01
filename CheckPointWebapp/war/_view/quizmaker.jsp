<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>Make a Quiz</title>

	<link href="_view/css/quizmakerStyle.css" rel="stylesheet" type="text/css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">
		function changeQuestionType() {
			//alert("Quiz type changed");
			var quizType = $("#quizTypeChooser").val();
			//alert("Quiz type is now " + quizType);
			if (quizType === "MC") {
				$("#multipleChoiceQuestion").css('display', 'block');
				$("#fillInTheBlankQuestion").css('display', 'none');
			} else if (quizType === "FIB") {
				$("#multipleChoiceQuestion").css('display', 'none');
				$("#fillInTheBlankQuestion").css('display', 'block');
			} else {
				$("#multipleChoiceQuestion").css('display', 'none');
				$("#fillInTheBlankQuestion").css('display', 'none');
			}
		}
		
		$(document).ready(function() {
			// Selectively enable/disable question type
			$("#quizTypeChooser").change(function() {
				changeQuestionType();
			});
			
			// Set initial quiz type
			changeQuestionType();
		});
	</script>
	
	#multipleChoiceQuestion, #fillInTheBlankQuestion {
		display: none;
	}
	</style>

</head>

<body>

  <div class="QuizMaker-card">
    <h1>CheckPoint</h1><br>
    <h2>Create A Quiz</h2>
  <form action="${pageContext.servletContext.contextPath}/quizmaker" method="post">
    
    <select name = "questionType" id="quizTypeChooser">
    	<option value="None" ${selectedNone}>Chose Type</option>
  		<option value="MC" ${selectedMC}>Multiple Choice</option>
  		<option value="FIB" ${selectedFIB}>Fill In The Blank</option>
	</select>
    
    
    <!-- form for multiple choice quiz question -->
    <div id="multipleChoiceQuestion">
    <input type="text" name="question" placeholder="Question" value="${MCquestion}"/>
    <input type="checkbox" name="select1" value="${select1}">
    <input type="text" name="choice1" placeholder="Choice 1" value="${choice1}"/>
    <input type="checkbox" name="select2" value="${select2}">
    <input type="text" name="choice2" placeholder="Choice 2" value="${choice2}"/>
    <input type="checkbox" name="select3" value="${select3}">
    <input type="text" name="choice3" placeholder="Choice 3" value="${choice3}"/>
    
    <input type="submit" name="submit" class="login login-submit" onsubmit="return false" value="Add New Question">
    <input type="submit" name="submit" class="login login-submit" value="Finish Quiz">
  </div>
  
  <!-- form for fill in the blank question -->
  <div id="fillInTheBlankQuestion">
  <input type="text" name="question" placeholder="Question" value="${FIBquestion}"/>
  <input type="text" name="FIBAnswer" placeholder="Answer" value="${FIBAnswer}"/>
  
  <input type="submit" name="submit" class="login login-submit" onsubmit="return false" value="Add New Question">
  <input type="submit" name="submit" class="login login-submit" value="Finish Quiz">
  </div>
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
