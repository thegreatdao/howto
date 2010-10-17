<div class="title"><fmt:message key="post.postList"/></div>
<table>
	<thead>
		<tr>
			<th><fmt:message key="post.title"/></th>
			<th><fmt:message key="post.created.date"/></th>
			<th><fmt:message key="post.category.name"/></th>
			<th><fmt:message key="post.creator"/></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${posts}" var="post">
		<tr>
			<td>
				<span class="user_action">${post.title}</span>
				<div class="tooltip">
					<div>
						<a href="<c:url value="/post/form.html?id=${post.id}" />"><fmt:message key="edit"/></a>
						<a href="javascript:void(0);" class="delete"><fmt:message key="delete"/></a>
					</div>
					<div class="confirm_dialog">
						<a href="<c:url value="/post/delete.html?id=${post.id}" />" class="confirm"><fmt:message key="confirm"/></a>
						<a href="javascript:void(0);" class="cancel"><fmt:message key="cancel"/></a>
					</div>
				</div>
			</td>
			<td><fmt:formatDate value="${post.createdDate}" pattern="yyyy-dd-MM"/></td>
			<td>${post.category.name}</td>
			<td>${post.user.userName}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<sec:authorize	ifAnyGranted="ROLE_ADMIN">
	<div id="action">
		<a href="<c:url value="/post/form.html" />"><img src="<c:url value="/images/application_add.png" />" id="action_img"/><fmt:message key="post.add.post"/></a>
	</div>
</sec:authorize>