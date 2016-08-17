<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url value="/edit" var="submitActionUrl" />
	<form:form modelAttribute="customerCase" action="${submitActionUrl}" method="post">
		<spring:bind path="name">
			<label>Name</label>
			<form:input path="id" type="text" id="id" placeholder="Id" />
			<form:input path="name" type="text" id="name" placeholder="Name" />
		</spring:bind>
		<spring:bind path="estimatedValue">
			<label>Risk estimate</label>
			<div>
				<label>
                    <form:radiobutton path="estimatedValue" value="1" /> Low
				</label>
                <label>
                	<form:radiobutton path="estimatedValue" value="2" /> Medium
				</label>
                <label>
                	<form:radiobutton path="estimatedValue" value="3" /> High
				</label>
			</div>
		</spring:bind>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form:form>
</body>
</html>