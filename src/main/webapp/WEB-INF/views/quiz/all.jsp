<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>All Quizzes</h1>
 
 	<a href="<c:url value='/quizzes/create'/>"> Add a quiz</a>
 	
	<c:if test="${not empty lists}">
 
		<ul class="paged-list">
			<c:forEach var="listValue" items="${lists}">
				<li><a href="<c:url value='/quizzes/getbyid?id=${listValue.quizId}'/>"> ${listValue.quizName}</a>&nbsp;&nbsp;&nbsp;
					<a style="font-size:80%;color:red" href="<c:url value='/quizzes/delete?id=${listValue.quizId}'/>"> Delete</a></li>
			</c:forEach>
		</ul>
 
	</c:if>
</body>
</html>