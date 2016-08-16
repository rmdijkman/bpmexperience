<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Home</title>
	</head>
<body>
	<h1>User management</h1>
	
	<table>
		<c:forEach var="customerCase" items="${customerCases}">
			<tr>
				<td>
					<c:out value="${customerCase.name}"/>
				</td>
				<td>
					<a href="<c:url value="/delete/${customerCase.id}"/>" >Delete case</a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty customerCases}">
			no users added yet.
		</c:if>
	</table>
	
	<a href="<c:url value="/add"/>" >Add new case</a>
</body>
</html>
