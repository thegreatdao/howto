<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
	<title><tiles:getAsString name="title"/></title>
	<link rel="stylesheet" href="<c:url value="/css/reset.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/text.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/960.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/main.css" />" />
	<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.tools.min.js" />"></script>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div class="container_12">
					<div class="grid_12">
						<div id="logo">
							<a href="/"><img src="<c:url value="/images/howto.png" />" alt="How To"/></a>
						</div>
						<div id="language">
							<a href="?locale=en_us"><img src="<c:url value="/images/us.png" />" title="<fmt:message key="lang.en"/>" /></a>
							<a href="?locale=zh_CN"><img src="<c:url value="/images/cn.png" />" title="<fmt:message key="lang.cn"/>" /></a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="container_12" id="main_body">
				
				<div class="grid_3" id="nav">
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
					<div class="grid_12" id="footer_texts">
						<div>copyright&copy; 2010</div>
					</div>
					<div class="grid_12" id="footer_bottom">
					</div>
				</div>
			</div>
		</div>	
		<script type="text/javascript">
			$(
					function()
					{
						$(".user_action").tooltip({  position: "center left", opacity: 0.6, effect: 'slide'});
					}
			)
		</script>
		
	</body>

</html>