<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="app_form">
	<fieldset>
		<legend><fmt:message key="role.form"/></legend>
		<form:form method="post" modelAttribute="role" action="save.html">

			<div>
				<c:if test="${not empty key}">
					<fmt:message key="key"/>
				</c:if>
				<label><fmt:message key="role.name"/>: <span class="small"><fmt:message key="role.name.add"/></span></label>
				<form:input path="name" id="role_name" />
				<form:hidden path="id"/>
			</div>
			
			<div class="form_error">
				<form:errors path="name"/>
			</div>
			
			<div>
				<label><fmt:message key="role.description"/>: <span class="small"><fmt:message key="role.description.add"/></span></label>
				<form:input path="description" id="role_description" />
			</div>
			
			<div class="form_error">
				<form:errors path="description"/>
			</div>
			
			<div>
				<button type="submit">
					<c:choose>
						<c:when test="${empty role.id}">
							<fmt:message key="create"/>
						</c:when>
						<c:otherwise>
							<fmt:message key="update"/>
						</c:otherwise>
					</c:choose>
				</button>
			</div>
			
		</form:form>
	</fieldset>

</div>
<div class="clear"></div>