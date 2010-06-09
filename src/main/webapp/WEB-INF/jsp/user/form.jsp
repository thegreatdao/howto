<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="user_form">
	<fieldset>
		<legend>User form</legend>
		<form:form method="post" modelAttribute="user">

			<label>First Name <span class="small">Add your first name</span></label>
		
			<form:input path="firstName" id="first_name" />
		
			<label>Last Name: <span class="small">Add your last name</span></label>
		
			<form:input path="lastName" id="last_name" />
		
			<label>Age: <span class="small">Add your age</span></label>
		
			<form:input path="age" id="age" />
		
			<label>Home page: <span class="small">Add your home page</span></label>
		
			<form:input path="profile.homePage" id="home_page" />
		
			<label>Hobbies: <span class="small">Add your hobbies</span></label>
		
			<form:input path="profile.hobbies" id="hobbies" />
		
			<label>Bio: <span class="small">Add your bio</span></label>
		
			<form:textarea path="profile.bio" id="bio" />
		
			<button type="submit">Sign-up</button>
		</form:form>
	</fieldset>

</div>
	<div class="clear"></div>