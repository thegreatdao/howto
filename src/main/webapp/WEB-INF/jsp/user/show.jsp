<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="grid_9" style="text-align:center;">
	<p>
		<c:forEach items="${users}" var="user">
			${user.firstName}
			${user.gender}
		</c:forEach>
	</p>
</div>
<div class="clear"></div>