<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="basic" class="myform">
	<form id="form1" name="form1" method="post" action="">
	    <h1>Sign-up form</h1>
	
	    <p>This is the basic look of my form without table</p>
	    <label>Name
	        <span class="small">Add your name</span>
	    </label>
	    <input type="text" name="textfield" id="textfield" />
	    
	    <label>Email
	    <span class="small">Add a valid address</span>
	    </label>
	
	    <input type="text" name="textfield" id="textfield" />
	    
	    <label>Password
	        <span class="small">Min. size 6 chars</span>
	    </label>
	    <input type="text" name="textfield" id="textfield" />
	    <button  type="submit">Sign-up</button>
	    <div class="spacer"></div>
	
	
	  </form>

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