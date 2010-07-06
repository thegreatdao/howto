<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="app_form">
	<fieldset>
		<legend><fmt:message key="category.form"/></legend>
		<form:form method="post" modelAttribute="category" action="save.html">

			<div>
				<c:if test="${not empty key}">
					<fmt:message key="key"/>
				</c:if>
				<label><fmt:message key="category.name"/>: <span class="small"><fmt:message key="category.name.add"/></span></label>
				<form:input path="name" id="category_name" />
				<form:hidden path="id"/>
			</div>
			
			<div class="form_error">
				<form:errors path="name"/>
			</div>
			
			<div>
				<button type="submit">
					<c:choose>
						<c:when test="${empty category.id}">
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