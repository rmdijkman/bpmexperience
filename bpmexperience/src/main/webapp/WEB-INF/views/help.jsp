<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<%@ include file="_header.jsp"%>
<body>
	<%@ include file="_menu.jsp"%>

	<div class="container smallcontainer">
	
		<c:if test="${userRole == 1}">
			<h1>You are a risk manager</h1>
			<p>Risk managers compute the risk of providing the insurance.
				Please provide a rough estimate of the risk that is associated with
				the insurance in the category high, medium, or low. Also estimate
				the payout rate. The payout rate is the probability that the
				insurance must pay out. Use your own judgment.
				You should assess one case per 20 seconds.</p>
		</c:if>

		<c:if test="${userRole == 2}">
			<h1>You are an account manager</h1>
			<p>Account managers are responsible for deciding whether or not a
				client will get an insurance. If the insurance is rejected, the
				account manager also provides a brief motivation as to why the
				insurance is rejected. Use your own judgment.
				You should assess one case per 20 seconds.</p>
		</c:if>
		
		<c:if test="${userRole == 3}">
			<h1>You are an administrator</h1>
			<p>Administrators are responsible for writing acceptance and
				rejection letters. The acceptance or rejection letter must start
				with &ldquo;Dear &lt;applicants name&gt;&rdquo;, end with &ldquo;Sincerely, &lt;your
				name&gt;&rdquo;, contain a clear statement as to whether the insurance was
				accepted or rejected and why it was accepted or rejected. Never
				mention an applicant's personal characteristics, such as age or
				income, in the letter. You should write one letter per minute.
				</p>
		</c:if>
		
	</div>

</body>
</html>