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
    
    <p>Courses you are a teacher in:<br>
    <c:forEach var="course" items="${TCourses}">
	<a href="${pageContext.servletContext.contextPath}/course/${course}"><c:out value="${course}"/></a><br>
	</c:forEach></p>
	
	<p>Courses you are a student in:<br>
    <c:forEach  items ="${SCourses}" var="course">
	<a href="${pageContext.servletContext.contextPath}/course/${course}"><c:out value="${course}"/></a><br>
	</c:forEach></p>

    
    <div class="index-submit">
	 <a href="${pageContext.servletContext.contextPath}/coursemaker">Create A Course</a>
	</div>

	
  <div class="index-task">
    <a href="http://localhost:8081/checkpoint/logout">Log Out</a>
    
  </div>
</div>


</body>

</html>
