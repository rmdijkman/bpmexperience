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
				<td><c:out value="${customerCase.id}" /></td>
				<td><c:out value="${customerCase.name}" /></td>
				<td><c:out value="${customerCase.address}" /></td>
				<td><c:out value="${customerCase.postalCode}" /></td>
				<td><c:out value="${customerCase.city}" /></td>
				<td><c:out value="${customerCase.objectType}" /></td>
				<td><c:out value="${customerCase.amountBought}" /></td>
				<td><c:out value="${customerCase.estimatedValue}" /></td>
				<td><c:out value="${customerCase.annualIncome}" /></td>
				<td><c:out value="${customerCase.yearBuilt}" /></td>
				<td><c:out value="${customerCase.age}" /></td>
				<td><a href="<c:url value="/edit/${customerCase.id}"/>">Edit case</a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty customerCases}">
			no users added yet.
		</c:if>
	</table>

	<a href="<c:url value="/add"/>">Add new case</a>
</body>
</html>
