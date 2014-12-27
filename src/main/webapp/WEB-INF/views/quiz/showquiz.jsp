<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
	<h1>Quiz </h1>
    Name: ${q.quizName}
    <br/><br/>
    
    <a href="<c:url value='/quizzes/getall'/>"> All quizzes</a>
</body>
</html>