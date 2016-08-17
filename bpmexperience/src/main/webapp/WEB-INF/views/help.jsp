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
				insurance must paid out in full, i.e. that some event will occur
				that destroys the property completely.</p>

			<p>Use the following guidelines:</p>
			<ul>
				<li>if the ratio amount bought / estimated current value is
					greater than 1, the risk is high</li>
				<li>if the year built is lower than 1990 and the object is a
					house, the risk is high, if the object is an office, the risk is
					medium, if the object is a garage or factory, the risk is low</li>
				<li>if the year built is lower than 1980, the risk is high</li>
				<li>if the object is located in an urban area, the risk is high</li>
			</ul>

			<ul>
				<li>For high risk, the payout rate should be 0.001% or higher</li>
				<li>For medium risk, the payout rate should be in the range
					0.0005% to 0.001%</li>
				<li>For low risk, the payout rate should be lower than 0.0005%</li>
			</ul>
		</c:if>

		<c:if test="${userRole == 2}">
			<h1>You are an account manager</h1>
			<p>Account managers are responsible for deciding whether or not a
				client will get an insurance. If the insurance is rejected, the
				account manager also provides a brief motivation as to why the
				insurance is rejected.</p>

			<p>Use the following guidelines:</p>
			<ul>
				<li>an insurance for objects with high risk and a value over
					500,000 should be rejected</li>
				<li>an insurance for objects with medium risk and a value over
					1,000,000 should be rejected</li>
				<li>an insurance for objects with low risk and a value less
					than 500,000 should be accepted</li>
				<li>an insurance in a high risk area (postal code) with a high
					value should be rejected</li>
				<li>an insurance with a bad amount bought / current value ratio
					should be rejected</li>
				<li>an insurance for objects greater than 1,000,000 must always
					be approved by a second person</li>
				<li>an insurance that is accepted based on non-clear-cut
					criteria must always be approved by a second person</li>
			</ul>
		</c:if>
		
		<c:if test="${userRole == 3}">
			<h1>You are an administrator</h1>
			<p>Administrators are responsible for writing acceptance and
				rejection letters. The acceptance or rejection letter must start
				with &ldquo;Dear &lt;applicants name&gt;&rdquo;, end with &ldquo;Sincerely, &lt;your
				name&gt;&rdquo;, contain a clear statement as to whether the insurance was
				accepted or rejected and why it was accepted or rejected. Never
				mention an applicant's personal characteristics, such as age or
				income, in the letter.</p>
		</c:if>
		
	</div>

</body>
</html>