<div id="tabular_data"><fmt:message key="category.categoryList"/></div>
<table>
	<thead>
		<tr>
			<th><fmt:message key="category.name"/></th>
			<th><fmt:message key="category.created.date"/></th>
			<th><fmt:message key="category.creator"/></th>
		</tr>
	</thead>
	
	<c:forEach items="${categories}" var="category">
		<tr>
			<td>
				<span class="user_action">${category.name}</span>
				<div class="tooltip">
					<a href="<c:url value="/user/form.html?id=${user.id}" />"><fmt:message key="edit"/></a><a href=""><fmt:message key="delete"/></a>
				</div>
			</td>	
			<td><fmt:formatDate value="${category.createdDate}" pattern="yyyy-dd-MM"/></td>
			<td>${category.user.userName}</td>
		</tr>
	</c:forEach>
</table>

<div id="action">
	<a href="<c:url value="/user/form.html" />"><img src="<c:url value="/images/application_add.png" />" id="action_img"/><fmt:message key="category.add.category"/></a>
</div>