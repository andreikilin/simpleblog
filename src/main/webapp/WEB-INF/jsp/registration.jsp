<%@ include file="common/header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

	<h1>Sign Up</h1>

	<form:form method="POST" action="registration.html" commandName="regForm">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="userName"/></td>
				<td><span class="error"><form:errors path="userName" /></span></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
				<td><span class="error"><form:errors path="password" /></span></td>
			</tr>

			<tr>
				<td>Confirm Password:</td>
				<td><form:password path="confirmPassword" /></td>
				<td><span class="error"><form:errors
							path="confirmPassword" /></span></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><span class="error"><form:errors path="email" /></span></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	
<%@ include file="common/footer.jsp" %>