<%@ include file="common/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="POST" action="profile.html" commandName="profileForm">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName"/></td>
				<td><span class="error"><form:errors path="firstName" /></span></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
				<td><span class="error"><form:errors path="lastName" /></span></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
				<td><span class="error"><form:errors
							path="city" /></span></td>
			</tr>

			<tr>
				<td>Birthday:</td>
				<td> <form:select path="day" items="${dayList}" /></td>
				<td> <form:select path="month" items="${monthList}" /></td>
				<td> <form:select path="year" items="${yearList}" /></td>
				<td><span class="error"><form:errors path="birthDay" /></span></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

<%@ include file="common/footer.jsp" %>