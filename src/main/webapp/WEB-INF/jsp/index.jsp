<%@ include file="common/header.jsp" %>

<h2 align="center">Das ist a simple blog</h2>
<br>
<br>


<sec:authorize ifAnyGranted="ROLE_MODERATOR">
	<a href="${pageContext.request.contextPath}/sec/moderation.html">Moderation page</a><br/>
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<a href="${pageContext.request.contextPath}/admin/admin-page.html">Admin page</a><br/>
</sec:authorize>

<%@ include file="common/footer.jsp" %>
