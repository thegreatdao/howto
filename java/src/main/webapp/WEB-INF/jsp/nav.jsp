<ul>
	<li><a href="<c:url value="/" />"><fmt:message key="home"/></a></li>
	<li><a href="<c:url value="/user/show.html" />"><fmt:message key="user"/></a></li>
	<li><a href="<c:url value="/role/show.html" />"><fmt:message key="role"/></a></li>
	<li><a href="<c:url value="/post/show.html" />"><fmt:message key="post"/></a></li>
	<li><a href="<c:url value="/category/show.html" />"><fmt:message key="category"/></a></li>
	<li><a href="<c:url value="/ria/index.html" />"><fmt:message key="ria"/></a></li>
	<li><a href="<c:url value="/report/index.html" />"><fmt:message key="report"/></a></li>
</ul>

<div id="login">
	<sec:authorize ifNotGranted="ROLE_USER">
		<form action="/j_spring_security_check" method="post">
			<div>
				<label><fmt:message key="user.userName"/>:</label>
				<input type="text" name="j_username"/>
				<label><fmt:message key="user.password"/>:</label>
				<input type="password" name="j_password"/>
				<input type="checkbox" name="_spring_security_remember_me"/><span><fmt:message key="user.remember.me" /></span>
				<input name="submit" type="submit" value="<fmt:message key="user.login" />"/>
			</div>
		</form>
	</sec:authorize>
	<sec:authorize	ifAnyGranted="ROLE_USER">
		<div>
			<fmt:message key="user.welcome.back"/>
			<sec:authentication property="principal.username" />
			<a href="<c:url value="/j_spring_security_logout"/>"><fmt:message key="user.logout" /></a>			 
		</div>
	</sec:authorize>
</div>

<div id="tagcloud"></div>
