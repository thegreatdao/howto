<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<title><tiles:getAsString name="title"/></title>
		<link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>" >
		<link rel="stylesheet" href="<c:url value="/css/reset.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/text.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/960.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/main.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/pagination.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/zoomer.css" />" />
		<script type="text/javascript" src="<c:url value="/js/jquery-1.3.2.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.tools.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.pagination.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.tablesorter.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/zoomer.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.easing.1.3.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.qtip-1.0.0-rc3.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/swfobject.js" />"></script>
		<!--
		<script type="text/javascript" src="<c:url value="/js/jquery-css-transform.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery-animate-css-rotate-scale.js" />"></script>
		-->
		<script type="text/javascript" src="<c:url value="/js/jquery.quicksand.min.js" />"></script>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div class="container_12">
					<div class="grid_12">
						<div id="logo">
							<a href="/" title="How To" class="qTip"><img src="<c:url value="/images/howto.png" />"/></a>
						</div>
						<div id="language">
							<a href="?locale=en_us"  class="qTip" title="<fmt:message key="lang.en"/>" ><img src="<c:url value="/images/us.png" />"/></a>
							<a href="?locale=zh_CN"  class="qTip" title="<fmt:message key="lang.cn"/>" ><img src="<c:url value="/images/cn.png" />"/></a>
						</div>
					</div>
				</div>
				<div id="search_form">
					<form action="/post/search.html" method="get" id="searchForm">
						<input type='text' name="title" value="${param.title}"/>
						<a href="javascript:void(0);" id="searchButton"><fmt:message key="search"/></a>						
					</form>
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
						<sec:authorize	ifAnyGranted="ROLE_ADMIN">
						$(".user_action").tooltip({  position: "center left", opacity: 0.6, effect: 'slide'});
						</sec:authorize>
						$('table tr:odd').addClass('odd'); 
						$('.confirm_dialog').hide();
						$('.delete').click(
							function()
							{
								$(this).parent().hide();
								$(this).parent().next().show();
							}
						);
						$('.cancel').click(
							function()
							{
								$(this).parent().hide();
								$(this).parent().prev().show();
							}
						);
						$('#searchButton').click(
							function()
							{
								$('#searchForm').submit();
							}
						);
						$("table").tablesorter();
						zoom();
						$('div#filter a').each(
							function()
							{
								$(this).click(
									function()
									{
										var id = $(this).attr('id');
										var indexOfUnderScore = id.indexOf('_');
										var destination = id.substring(0, indexOfUnderScore);										
										destination = '#' + destination + ' li';
										filter('.thumb', destination);
									}
								);
							}
						);
						$('a.qTip').qtip({ style: { name: 'light', tip: true} });
						selectNav();
						displayTagCloud();
						 $('#login_error').fadeOut('slow').fadeIn('slow').fadeOut('slow').fadeIn('slow').fadeOut('slow').fadeIn('slow');
					}
			)						
			
			function filter(source, destination)
			{
				//$(source).quicksand($(destination), { duration: 1000, easing: 'swing', adjustHeight: false, useScaling: true}, function(){ zoom();});
				$(source).quicksand($(destination), { duration: 1000, easing: 'easeInOutQuint', adjustHeight: false}, function(){zoom();});
			}
			
			function zoom()
			{
				$('ul.thumb li').Zoomer({speedView:200,speedRemove:400,altAnim:true,speedTitle:400,debug:false});
			}
			
			function selectNav()
			{
				var path = $(location).attr('pathname');
				var tab = 'home';
				if(path.indexOf("user") != -1)
				{
					tab = "user";
				}
				else if(path.indexOf("role") != -1)
				{
					tab = "role";
				}
				else if(path.indexOf("post") != -1)
				{
					tab = "post";
				}
				else if(path.indexOf("category") != -1)
				{
					tab = "category";
				}
				else if(path.indexOf("ria") != -1)
				{
					tab = "flex";
				}
				else if(path.indexOf("report") != -1)
				{
					tab = "report";
				}
				$('#'+tab).css('color','#663300');
			}
			
			function displayTagCloud()
			{
				var jLocation = $(location);
				var protocolPlusHost = jLocation.attr('protocol') + '//' + jLocation.attr('host');				
				var home = protocolPlusHost;
				var usersList = protocolPlusHost + '/user/show.html';
				var rolesList = protocolPlusHost + '/role/show.html';
				var postsList = protocolPlusHost + '/post/show.html';
				var categoriesList = protocolPlusHost + '/category/show.html';
				var ria = protocolPlusHost + '/ria/index.html';
				var reportsList = protocolPlusHost + '/report/index.html';				
				var so = new SWFObject("<c:url value="/swf/tagcloud.swf"/>", "tc", "220", "200", "7", "#FFFFFF");
				so.addParam("wmode", "transparent");
				so.addVariable("mode", "tags");
				so.addVariable("distr", "true");
				so.addVariable("tcolor", "0xff0000");
				so.addVariable("hicolor", "0x000000");
				so.addVariable("tagcloud",
					"<tags>" + 
					"<a href='" + home + "' style='9'><fmt:message key='home'/></a>" +
					"<a href='" + usersList + "'  style='10'><fmt:message key='user'/></a>" +
					"<a href='" + rolesList + "'  style='20'><fmt:message key='role'/></a>" +
					"<a href='" + postsList + "'  style='12'><fmt:message key='post'/></a>" +
					"<a href='" + categoriesList + "'  style='15'><fmt:message key='category'/></a>" +
					"<a href='" + ria + "'  style='9'><fmt:message key='ria'/></a>" +
					"<a href='" + reportsList + "'  style='10'><fmt:message key='report'/></a>" +
					"</tags>"
				);
				so.write("tagcloud");				
			}
		</script>
		
	</body>

</html>