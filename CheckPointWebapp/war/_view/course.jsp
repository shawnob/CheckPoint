<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>${courseName}</title>

	<link href="${pageContext.servletContext.contextPath}/_view/css/CourseStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="index-card">
    <h1>${courseName}</h1><br>
    
    <c:if test="${userIsTeacher}">
    
    <a href="${pageContext.servletContext.contextPath}/courseSettings/${courseName}">Course Settings</a>
    
	<a href="http://localhost:8081/checkpoint/quizmaker">Create A Quiz</a><br>
	</c:if>
    
    <div class = "index-task">
    <a href="${pageContext.servletContext.contextPath}/index">Return to Index</a>
    </div>
  
</div>


</body>

</html>