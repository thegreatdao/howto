<div class="tabular_data"><fmt:message key="category.categoryList"/></div>
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
				<sec:authorize	ifAnyGranted="ROLE_ADMIN">
				<div class="tooltip">
					<div>
						<a href="<c:url value="/category/form.html?id=${category.id}" />"><fmt:message key="edit"/></a>
						<a href="javascript:void(0);" class="delete"><fmt:message key="delete"/></a>
					</div>
					<div class="confirm_dialog">
						<a href="<c:url value="/category/delete.html?id=${category.id}" />" class="confirm"><fmt:message key="confirm"/></a>
						<a href="javascript:void(0);" class="cancel"><fmt:message key="cancel"/></a>
					</div>
				</div>
				</sec:authorize>
			</td>	
			<td><fmt:formatDate value="${category.createdDate}" pattern="yyyy-dd-MM k-mm"/></td>
			<td>${category.user.userName}</td>
		</tr>
	</c:forEach>
</table>

<sec:authorize	ifAnyGranted="ROLE_ADMIN">
<div id="action">
	<a href="<c:url value="/category/form.html" />"><img src="<c:url value="/images/application_add.png" />" id="action_img"/><fmt:message key="category.add.category"/></a>
</div>
</sec:authorize>
