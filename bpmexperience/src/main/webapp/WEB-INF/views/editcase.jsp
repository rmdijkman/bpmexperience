<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="_header.jsp"%>
<body>
	<%@ include file="_menu.jsp"%>
	<div class="container">
	<h1>Perform task</h1>	
	<spring:url value="/edit" var="submitActionUrl" />
	<form:form modelAttribute="customerCase" action="${submitActionUrl}" method="post">
		<form:input path="id" type="hidden" id="id"/>
		<form:input path="nextTask" type="hidden" id="nextTask"/>
		<div class="row form-group extra-top-space">
			<label class="col-sm-3">Name:</label>
			<div class="col-sm-9">			
				<c:out value="${customerCase.name}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-3">Address:</label>
			<div class="col-sm-9">
				<c:out value="${customerCase.address}" />,&nbsp;
				<c:out value="${customerCase.postalCode}" />&nbsp;
				<c:out value="${customerCase.city}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-3">Age:</label>
			<div class="col-sm-9">			
				<c:out value="${customerCase.age}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-3">Annual income:</label>
			<div class="col-sm-9">
				<c:out value="${customerCase.annualIncome}" />
			</div>
		</div>
		<div class="row form-group extra-top-space">
			<label class="col-sm-3">Object type:</label>
			<div class="col-sm-9">
				<c:out value="${customerCase.objectType}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-3">Object bought for:</label>
			<div class="col-sm-9">
				<c:out value="${customerCase.amountBought}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-3">Object value estimated at:</label>
			<div class="col-sm-9">
				<c:out value="${customerCase.estimatedValue}" />
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-3">Object build year:</label>
			<div class="col-sm-9">
				<c:out value="${customerCase.yearBuilt}" />
			</div>
		</div>
		<div class="row form-group extra-top-space">
			<spring:bind path="riskEstimate">
				<label class="col-sm-3">Risk estimate</label>
				<div class="col-sm-9">
					<label>
        	            <form:radiobutton path="riskEstimate" value="1" /> Low
					</label>
       	        	<label>
	           	    	<form:radiobutton path="riskEstimate" value="2" /> Medium
					</label>
   	    	        <label>
       	    	    	<form:radiobutton path="riskEstimate" value="3" /> High
					</label>
				</div>
			</spring:bind>
		</div>
		<div class="row form-group">
			<spring:bind path="payoutRate">
				<label class="col-sm-3">Payout rate</label>
				<div class="col-sm-9">
					<form:input class="form-control" path="payoutRate" type="text" id="payoutRate"/>
				</div>
			</spring:bind>
		</div>
		<div class="row form-group">
			<spring:bind path="approvalState">
				<label class="col-sm-3">Approval</label>
				<div class="col-sm-9">
					<label>
        	            <form:radiobutton path="approvalState" value="1" /> Accept
					</label>
       	        	<label>
           	    		<form:radiobutton path="approvalState" value="2" /> Reject
					</label>
				</div>
			</spring:bind>
		</div>
		<div class="row form-group">
			<spring:bind path="reason">
				<label class="col-sm-3">Rejection reason</label>
				<div class="col-sm-9">
					<form:input class="form-control" path="reason" type="text" id="reason"/>
				</div>
			</spring:bind>
		</div>
		<div class="row form-group">
			<spring:bind path="requiresSecondary">
				<label class="col-sm-3">Requires secondary check</label>
				<div class="col-sm-9">
					<form:checkbox path="requiresSecondary" value="Java"/>
				</div>
			</spring:bind>
		</div>		
		<div class="row form-group">
			<spring:bind path="acceptanceLetter">
				<label class="col-sm-3">Acceptance letter</label>
				<div class="col-sm-9">
					<form:textarea class="form-control" path="acceptanceLetter" type="text" id="acceptanceLetter" rows="5"/>
				</div>
			</spring:bind>
		</div>
		<div class="row form-group">
			<spring:bind path="rejectionLetter">
				<label class="col-sm-3">Rejection letter</label>
				<div class="col-sm-9">
					<form:textarea class="form-control" path="rejectionLetter" type="text" id="rejectionLetter" rows="5"/>
				</div>
			</spring:bind>
		</div>
		<div class="row form-group extra-top-space">
			<div class="col-sm-12">
	        	<input class="btn btn-primary" type="submit" value="Submit" />
    	    	<input class="btn btn-default" type="reset" value="Reset" />
    	    </div>
        </div>
    </form:form>
    </div>
</body>
</html>