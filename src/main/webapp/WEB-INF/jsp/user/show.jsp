<div id="tabular_data"><fmt:message key="user.userList"/></div>
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
					<div>
						<a href="<c:url value="/user/form.html?id=${user.id}" />"><fmt:message key="edit"/></a>
						<a href="javascript:void(0);" class="delete"><fmt:message key="delete"/></a>
					</div>
					<div class="confirm_dialog">
						<a href="<c:url value="/user/delete.html?id=${user.id}" />" class="confirm"><fmt:message key="confirm"/></a>
						<a href="javascript:void(0);" class="cancel"><fmt:message key="cancel"/></a>
					</div>
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

<sec:authorize	ifAnyGranted="ROLE_ADMIN">
<div id="action">
	<a href="<c:url value="/user/form.html" />"><img src="<c:url value="/images/user_add.png" />" id="action_img"/><fmt:message key="user.add.user"/></a>
</div>
</sec:authorize>