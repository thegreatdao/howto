<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
	<title><tiles:getAsString name="title"/></title>
	<link rel="stylesheet" href="<c:url value="/css/reset.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/text.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/960.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/main.css" />" />
	<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js" />"></script>
	</head>
	<body>
		<div style="margin: 0 auto; width: 960px; text-align: center; background-color: green;">
			<div id="header">
				<div class="container_12">
					<div class="grid_12">
						<h2><a href="/howto/">How To</a></h2>
					</div>
				</div>
			</div>
			
			<div class="container_12">
				
				<div class="grid_3" style="margin-top:20px;" id="nav">
					<tiles:insertAttribute name="nav" />
				</div>
				<div class="grid_9" style="min-height: 520px;">
					<div id="main_content">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
				<div class="clear"></div>
				
			</div>
			
			<div id="footer">
				<div class="container_12">
					<div class="grid_12">
						copyright&copy; 2010
					</div>
				</div>
			</div>
		</div>	
		<script type="text/javascript">
			$(
					function()
					{
						
					}
			)
		</script>
		
	</body>

</html>