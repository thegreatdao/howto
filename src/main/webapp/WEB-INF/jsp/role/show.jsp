<div id="tabular_data"><fmt:message key="role.roleList"/></div>
<table>
	<thead>
		<tr>
			<th><fmt:message key="role.name"/></th>
			<th><fmt:message key="role.description"/></th>
		</tr>
	</thead>
	
	<c:forEach items="${roles}" var="role">
		<tr>
			<td>
				<span class="user_action">${role.name}</span>
				<div class="tooltip">
					<div>
						<a href="<c:url value="/role/form.html?id=${role.id}" />"><fmt:message key="edit"/></a>
						<a href="javascript:void(0);" class="delete"><fmt:message key="delete"/></a>
					</div>
					<div class="confirm_dialog">
						<a href="<c:url value="/role/delete.html?id=${role.id}" />" class="confirm"><fmt:message key="confirm"/></a>
						<a href="javascript:void(0);" class="cancel"><fmt:message key="cancel"/></a>
					</div>
				</div>
			</td>	
			<td>
				${role.description}
			</td>	
		</tr>
	</c:forEach>
</table>

<sec:authorize	ifAnyGranted="ROLE_ADMIN">
<div id="action">
	<a href="<c:url value="/role/form.html" />"><img src="<c:url value="/images/group_add.png" />" id="action_img"/><fmt:message key="role.add.role"/></a>
</div>
</sec:authorize>