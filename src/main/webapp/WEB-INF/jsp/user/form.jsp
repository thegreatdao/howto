<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="basic" class="myform">
	<form:form  method="post" modelAttribute="user">
	    <h1>User form</h1>
		<p>User basic information form</p>
	    <label>First Name
	        <span class="small">Add your first name</span>
	    </label>
	    <form:input path="firstName"/>
	    

	    <label>Last Name:
   	        <span class="small">Add your last name</span>
	    </label>
	
	    <form:input path="lastName"/>
	    
	    <label>Password</label>
	    <input type="text" name="textfield" id="textfield" />
	    <button  type="submit">Sign-up</button>
	    <div class="clear"></div>
	  </form:form>

</div><!--
	<form:form modelAttribute="user">
		<form:input path="firstName"/>
		<form:input path="lastName"/>
		<form:input path="age"/>
		<form:input path="gender"/>
		<form:textarea path="profile.bio"/>
		<form:textarea path="profile.hobbies"/>
		<form:input path="profile.homePage"/>
	</form:form>-->