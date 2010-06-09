<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
	<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title><tiles:getAsString name="title"/></title>
	<link rel="stylesheet" href="<c:url value="/css/reset.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/text.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/960.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/main.css" />" />
	</head>
	<body>
		<div id="header">
			<div class="container_12">
				<div>
					<h2><a href="<c:url value="/" />">Self Knowledge</a></h2>
				</div>
			</div>
		</div>
		
		<div class="container_12">
			
			<div class="grid_3" style="margin-top:20px;" id="nav">
				<tiles:insertAttribute name="nav" />
			</div>
			<div class="grid_9">
				<div id="main_content">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
			<div class="clear"></div>
			
		</div>
		
		<div id="footer">
			<div class="container_12">
				copyright&copy; 2010
			</div>
		</div>
		
	</body>

</html>