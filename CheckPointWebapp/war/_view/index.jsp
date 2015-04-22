<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>CheckPoint-index</title>

	<link href="${pageContext.servletContext.contextPath}/_view/css/IndexStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="index-card">
    <h1>CheckPoint</h1><br>
    <h2>Welcome, ${useyName}</h2>
    
    <div class = "quizOptionList">
	<a href="http://localhost:8081/checkpoint/quizmaker">Create A Quiz</a><br>
	<a href="http://localhost:8081/checkpoint/quiztaker">Take A Quiz</a><br>
	</div>
	
  <div class="index-task">
    <a href="http://localhost:8081/checkpoint/login">Log Out</a>
    
  </div>
</div>


</body>

</html>