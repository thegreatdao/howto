<div style="margin-bottom: 10px; text-align: center; font-weight: bold;"><fmt:message key="user.userList"/></div>
<table>
	<thead>
		<tr>
			<th><fmt:message key="user.userName"/></th>
			<th><fmt:message key="user.firstName"/></th>
			<th><fmt:message key="user.lastName"/></th>
			<th><fmt:message key="user.age"/></th>
			<th><fmt:message key="user.gender"/></th>
			<th><fmt:message key="user.profile.bio"/></th>
			<th><fmt:message key="user.profile.hobbies"/></th>
			<th><fmt:message key="user.profile.homePage"/></th>
		</tr>
	</thead>
	
	<c:forEach items="${users}" var="user">
		<tr>
			<td>
				<span class="user_action">${user.userName}</span>
				<div class="tooltip">
					<a href="<c:url value="/user/form.html?id=${user.id}" />"><fmt:message key="edit"/></a><a href=""><fmt:message key="delete"/></a>
				</div>
			</td>	
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.age}</td>
			<td>${user.gender}</td>
			<td>${user.profile.bio}</td>
			<td>${user.profile.hobbies}</td>
			<td>${user.profile.homePage}</td>
		</tr>
	</c:forEach>
</table>

<div id="action">
	<a href="<c:url value="/user/form.html" />"><img src="<c:url value="/images/user_add.png" />" style="vertical-align: middle; margin-right: 6px;"/><fmt:message key="user.add.user"/></a>
</div>