<%@ include file="common/header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<p>
		<c:if test="${error == true}">
			<b class="error">Invalid login or password.</b>
		</c:if>
	</p>

	<form method="POST" action="<c:url value='j_spring_security_check'/>" >
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="j_username" id="j_username" size="30" maxlength="40" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>


<p>
<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/>
</p>	

<%@ include file="common/footer.jsp" %>