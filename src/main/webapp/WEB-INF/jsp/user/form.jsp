<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="user_form">
	<fieldset>
		<legend>User form</legend>
		<form:form method="post" modelAttribute="user" action="save.html">

			<div>
				<label>First Name <span class="small">Add your first name</span></label>
				<form:input path="firstName" id="first_name" />
				<form:hidden path="id"/>
			</div>
			
			<div class="form_error">
				<form:errors path="firstName"/>
			</div>
			
			<div>	
				<label>Last Name: <span class="small">Add your last name</span></label>
				<form:input path="lastName" id="last_name" />
			</div>
			
			<div class="form_error">
				<form:errors path="lastName"/>
			</div>
			
			<div>
				<label>Age: <span class="small">Add your age</span></label>
				<form:input path="age" id="age" />
			</div>
			
			<div class="form_error">
				<form:errors path="age"/>
			</div>
			
			<div>
				<label>Gender: <span class="small">Select your gender</span></label>
				<div>
					<form:radiobuttons path="gender" id="gender" />
				</div>
			</div>
			
			<div class="clear"></div>
			<div class="radio_error">
				<form:errors path="gender"/>
			</div>
			
			<!--<label>Gender: <span class="small">Select your gender</span></label>
		
			<input type="radio" name="gender" value="FEMALE"/>
			<input type="radio" name="gender" value="MALE"/>
			<form:errors path="gender" />
			
		
			-->
			<div>
				<label>Home page: <span class="small">Add your home page</span></label>
				<form:input path="profile.homePage" id="home_page" />
			</div>
			
			<div>
				<label>Hobbies: <span class="small">Add your hobbies</span></label>
				<form:input path="profile.hobbies" id="hobbies" />
			</div>
			
			<div>
				<label>Bio: <span class="small">Add your bio</span></label>
				<form:textarea path="profile.bio" id="bio" />
			</div>
			
			<div>									
				<button type="submit">Sign-up</button>
			</div>
			
		</form:form>
	</fieldset>

</div>
	<div class="clear"></div>