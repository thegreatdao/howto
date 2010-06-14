<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="user_form">
	<fieldset>
		<legend><fmt:message key="user.form"/></legend>
		<form:form method="post" modelAttribute="user" action="save.html">

			<div>
				<label><fmt:message key="user.firstName"/>: <span class="small"><fmt:message key="user.firstName.add"/></span></label>
				<form:input path="firstName" id="first_name" />
				<form:hidden path="id"/>
			</div>
			
			<div class="form_error">
				<form:errors path="firstName"/>
			</div>
			
			<div>	
				<label><fmt:message key="user.lastName"/>: <span class="small"><fmt:message key="user.lastName.add"/></span></label>
				<form:input path="lastName" id="last_name" />
			</div>
			
			<div class="form_error">
				<form:errors path="lastName"/>
			</div>
			
			<div>
				<label><fmt:message key="user.age"/>: <span class="small"><fmt:message key="user.age.add"/></span></label>
				<form:input path="age" id="age" />
			</div>
			
			<div class="form_error">
				<form:errors path="age"/>
			</div>
			
			<div>
				<label><fmt:message key="user.gender"/>: <span class="small"><fmt:message key="user.gender.select"/></span></label>
				<div>
					<form:radiobuttons path="gender" id="gender" />
				</div>
			</div>
			
			<div class="clear"></div>
			<div class="radio_error">
				<form:errors path="gender"/>
			</div>

			<div>
				<label><fmt:message key="user.profile.homePage"/>: <span class="small"><fmt:message key="user.profile.homePage.add"/></span></label>
				<form:input path="profile.homePage" id="home_page" />
			</div>
			
			<div>
				<label><fmt:message key="user.profile.hobbies"/>: <span class="small"><fmt:message key="user.profile.hobbies.add"/></span></label>
				<form:input path="profile.hobbies" id="hobbies" />
			</div>
			
			<div>
				<label><fmt:message key="user.profile.bio"/>: <span class="small"><fmt:message key="user.profile.bio.add"/></span></label>
				<form:textarea path="profile.bio" id="bio" />
			</div>
			
			<div>									
				<button type="submit"><fmt:message key="user.signUp"/></button>
			</div>
			
		</form:form>
	</fieldset>

</div>
	<div class="clear"></div>