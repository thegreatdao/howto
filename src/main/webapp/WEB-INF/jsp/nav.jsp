<ul>
	<li><a href="<c:url value="/" />">Home</a></li>
	<li><a href="<c:url value="/user/show.html" />">User</a></li>
	<li><a href="<c:url value="/role/show.html" />">Role</a></li>
	<li><a href="javascript:void(0);">Post</a></li>
	<li><a href="<c:url value="/category/show.html" />">Category</a></li>
</ul>

<div id="login">
	<form action='/j_spring_security_check' method='post'>
	 <div>
	    <label><fmt:message key="user.userName"/>:</label>
	    <input type='text' name='j_username' value='' />
	    <label><fmt:message key="user.password"/>:</label>
	    <input type='password' name='j_password'/>
	    <input type='checkbox' name='_spring_security_remember_me'/><span><fmt:message key="user.remember.me" /></span>
	    <input name="submit" type="submit" value="<fmt:message key="user.login" />"/>
	  </div>
	</form>
</div>
