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
			<div class="grid_12" style="text-align:center;border: 1px yellow solid;" id="header">
				<tiles:insertAttribute name="header" />
			</div>
			<div class="clear"></div>
			
			<div class="grid_3" style="text-align:center;border: 1px yellow solid;" id="nav">
				<tiles:insertAttribute name="nav" />
			</div>
			<div class="grid_9" style="text-align:center;border: 1px yellow solid;" id="body">
				<tiles:insertAttribute name="body" />
			</div>
			<div class="clear"></div>
			
			<div class="grid_12" style="text-align:center;border: 1px yellow solid;" id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
			<div class="clear"></div>
		</div>
	</body>

</html>