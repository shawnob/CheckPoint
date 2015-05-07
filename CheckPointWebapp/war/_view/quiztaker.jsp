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
    <h3>Question Number: ${questionnum}</h3>
    <!--<h3>Question Type: ${type}</h3> --!>         
    <h2>Question: ${question}</h2>    
    
    
    <c:if test="${type == 0}">
		<h3>Multiple Choice</h3>
    	
    		<h3>
    		<input type="checkbox" name="select1" value="${select1}">
    		${choice1}<br><br>
    		
    		<input type="checkbox" name="select2" value="${select2}">
    		${choice2}<br><br>
    		
    		<input type="checkbox" name="select3" value="${select3}">
    		${choice3}<br><br>
    		</h3>
    	
    	
        </c:if>
    	
    <c:if test="${type == 1}">
    	<h3>Fill in the Blank</h3>  
    	
    	<input type="text" name="answer" placeholder="Correct Choice" value="${answer}"/>
    	
	</c:if>
    
     
    
    <form action="${pageContext.servletContext.contextPath}/quiztaker" method="post">
    <input type="submit" name="submit" class="login login-submit" value="Submit">
  </form>
  
  <div class="quiztaker-failed">
		${result}
	</div>
  
  </div>
</div>


</body>

</html>