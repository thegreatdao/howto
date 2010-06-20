<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul>
	<li><a href="<c:url value="/" />">Home</a></li>
	<li><a href="<c:url value="/user/show.html" />">User</a></li>
	<li><a href="<c:url value="/role/show.html" />">Role</a></li>
	<li><a href="javascript:void(0);">Post</a></li>
	<li><a href="<c:url value="/category/show.html" />">Category</a></li>
</ul>

<div id="login">
	<sec:authorize ifNotGranted="ROLE_USER">
		<form action='/j_spring_security_check' method='post'>
		 <div>
		    <label><fmt:message key="user.userName"/>:</label>
		    <input type='text' name='j_username'/>
		    <label><fmt:message key="user.password"/>:</label>
		    <input type='password' name='j_password'/>
		    <input type='checkbox' name='_spring_security_remember_me'/><span><fmt:message key="user.remember.me" /></span>
		    <input name="submit" type="submit" value="<fmt:message key="user.login" />"/>
		   
		  </div>
		</form>
	</sec:authorize>
	<sec:authorize	ifAnyGranted="ROLE_USER">
		<div>
			<fmt:message key="user.welcome.back"/> <sec:authentication property="principal.username" /><a href="<c:url value="/j_spring_security_logout"/>"><fmt:message key="user.logout" /></a>			 
		</div>
	</sec:authorize>
</div>
