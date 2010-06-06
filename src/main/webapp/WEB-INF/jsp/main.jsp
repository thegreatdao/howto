<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
	<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/text.css" />
	<link rel="stylesheet" href="css/960.css" />
	</head>
	<body>
		<div class="container_12">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="nav" />
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
		</div>
	</body>

</html>