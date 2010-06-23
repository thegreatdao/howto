<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="app_form">
	<fieldset>
		<legend><fmt:message key="post.form"/></legend>
		<form:form method="post" modelAttribute="post" action="save.html">

			<div>
				<c:if test="${not empty key}">
					<fmt:message key="key"/>
				</c:if>
				<label><fmt:message key="post.title"/>: <span class="small"><fmt:message key="post.title.add"/></span></label>
				<form:input path="title" id="post_title" />
				<form:hidden path="id"/>
			</div>
			
			<div class="form_error">
				<form:errors path="title"/>
			</div>

			<div>
				<span style="display: none;" id="default_option_text"><fmt:message key="post.category.default.option"/></span>
				<label><fmt:message key="post.category"/>: <span class="small"><fmt:message key="post.category.add"/></span></label>
				<form:select path="categoryId" id="category_name">
					<form:option value="" label="--------" id="default_option"/>
					<form:options items="${categories}" itemLabel="name" itemValue="id"/>
				</form:select>
			</div>
			
			<div class="form_error">
				<form:errors path="category"/>
			</div>

			<div>
				<label><fmt:message key="post.body"/>: <span class="small"><fmt:message key="post.body.add"/></span></label>
				<form:textarea path="body" id="post_body" />
			</div>
			
			<div class="form_error">
				<form:errors path="body"/>
			</div>
			
			<div>
				<button type="submit">
					<c:choose>
						<c:when test="${empty post.id}">
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
<script type="text/javascript">
	$(
		function()
		{
			var defaultOptionValue = $('#default_option_text').text();
			$('#default_option').text(defaultOptionValue);
		}
	)
</script>