<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<%@ include file="_header.jsp"%>
<%
   // Set refresh, autoload time as 5 seconds
   response.setIntHeader("Refresh", 5);
%>
<body>
	<%@ include file="_menu.jsp"%>

	<div class="container">
		<h1>Task list</h1>
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Customer name</th>
					<th>Type of object to insure</th>
					<th>Estimated object value</th>
					<th>Task to perform</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customerCase" items="${customerCases}">
					<tr>
						<td><c:out value="${customerCase.name}" /></td>
						<td><c:out value="${customerCase.objectType}" /></td>
						<td><c:out value="${customerCase.estimatedValue}" /></td>
						<td><c:out value="${customerCase.nextTask}" /></td>
						<td><a class="btn btn-primary" role="button" href="<c:url value="/edit/${customerCase.id}"/>">Perform
								task</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script>
	if (('${title}' != null) && ('${title}' != '')){
		BootstrapDialog.alert({title: '${title}', message: '${message}'});
	}
</script>
</html>