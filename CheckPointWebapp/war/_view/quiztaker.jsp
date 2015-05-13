<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>

  <meta charset="UTF-8">

  <title>Good Luck!</title>


	<link href="${pageContext.servletContext.contextPath}/_view/css/quiztakerStyle.css" rel="stylesheet" type="text/css">
	

</head>

<body>

  <div class="quiztaker-card">
    <h1>QuizTaker</h1><br>
    
    <c:if test="${type != 3}">
    
    <h3>Question Number: ${questionnum+1}</h3>
    <h3>Total Correct: ${rcount}</h3>
    
    <c:if test="${check == 1}">
    	<h3>Last question: Correct</h3>
    </c:if>
    
    <c:if test="${check == 2}">
    	<h3>Last question: Incorrect</h3>
    </c:if>
         
    <h2>Question: ${question}</h2>    
    
    <form action="${pageContext.servletContext.contextPath}/quiztaker" method="post">
    <c:if test="${type == 0}">
		<h3>Multiple Choice</h3>
    	
    		<input type="submit" name="submited" class="login login-submit" value="${choice1}">
    		<br><br>
    		
    		<input type="submit" name="submited" class="login login-submit" value="${choice2}">
    		<br><br>
    		
    		<input type="submit" name="submited" class="login login-submit" value="${choice3}">
    		<br><br>
    		
    	
    	
        </c:if>
    	
    <c:if test="${type == 1}">
    	<h3>Fill in the Blank</h3>  
    	
    	<input type="text" name="submited" placeholder="Correct Choice" value="${submited}"/>
    	<input type="submit" name="submit" class="login login-submit" value="Submit">
	</c:if>
    </form>  
      
    </c:if>
    
     <form action="${pageContext.servletContext.contextPath}/quiztaker" method="post">
    
     <c:if test="${type == 3}">
     
     	<h2>Total Correct: ${rcount}</h2>
     	<h2>Total Questions: ${questionnum}</h2>
     	<input type="submit" name="submit" class="login login-submit" value="Submit">
     	
     </c:if>   
     </form>
      
	<div class="quiztaker-failed">
		${result}
	</div>
	
	  <div class="quiztaker-failed">
		${result}
	</div>
   
  
  </div>
</div>	


</body>

</html>
