<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

  <meta charset="UTF-8">

  <title>${courseName}- Settings</title>

	<link href="${pageContext.servletContext.contextPath}/_view/css/CourseStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

  <div class="index-card">
    <h1>${courseName}- Settings</h1><br>
    
    <form action="${pageContext.servletContext.contextPath}/courseSettings" method="post">
    <input type="text" name="StudentName" placeholder="Student Name" value="${StudentName}"/>
    <input type="submit" name="AS" value="Add Student">
  	</form>
    
    <div class = "index-task">
    <a href="${pageContext.servletContext.contextPath}/course/${CourseName}">Return to course page</a>
    </div>
  
</div>


</body>

</html>