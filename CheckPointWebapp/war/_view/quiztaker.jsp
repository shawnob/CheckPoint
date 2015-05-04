<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>

  <meta charset="UTF-8">

  <title>CheckPoint</title>

	<link href="_view/css/quiztakerStyle.css" rel="stylesheet" type="text/css">
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">	
	
	function QType() {
			var qtype = ${type}.val();
			if (qtype === 0) {
				$("#multipleChoiceQuestion").css('display', 'block');
				$("#fillInTheBlankQuestion").css('display', 'none');
			} else if (qtype === 1) {
				$("#multipleChoiceQuestion").css('display', 'none');
				$("#fillInTheBlankQuestion").css('display', 'block');
			} else {
				$("#multipleChoiceQuestion").css('display', 'none');
				$("#fillInTheBlankQuestion").css('display', 'none');
			}
		}
	
		</script>
	
	
	

</head>

<body>

  <div class="quiztaker-card">
    <h1>QuizTaker</h1><br>
    <h3>Question Number: ${questionnum}</h3>
    <h3>Question Type: ${type}</h3>          
    <h2>Question: ${question}</h2>    
    
    
    <div id="multipleChoiceQuestion">
    	 <h3>mult</h3>  
    <div>
    
    <div id="fillInTheBlankQuestion">
    	<h3>blank</h3>  
    <div>
      
    
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