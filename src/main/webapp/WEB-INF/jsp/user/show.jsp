<table>
	<thead>
		<tr>
			<th>id</th>
			<th>first name</th>
			<th>last name</th>
			<th>age</th>
			<th>gender</th>
			<th>bio</th>
			<th>hobbies</th>
			<th>home page</th>
		</tr>
	</thead>
	
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>	
			<td>${user.firstName}</td>	
			<td>${user.lastName}</td>	
			<td>${user.age}</td>	
			<td>${user.gender}</td>
			<td>${user.profile.bio}</td>
			<td>${user.profile.hobbies}</td>
			<td>${user.profile.homePage}</td>
		</tr>
	</c:forEach>
</table>

<div id="action">
	<a href="#">add user</a>
</div>