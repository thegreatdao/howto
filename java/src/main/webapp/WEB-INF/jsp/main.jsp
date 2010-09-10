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
	<link rel="stylesheet" href="<c:url value="/css/pagination.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/zoomer.css" />" />
	<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.tools.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.pagination.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.tablesorter.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/zoomer.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.quicksand.min.js" />"></script>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div class="container_12">
					<div class="grid_12">
						<div id="logo">
							<a href="/"><img src="<c:url value="/images/howto.png" />" title="How To"/></a>
						</div>
						<div id="language">
							<a href="?locale=en_us"><img src="<c:url value="/images/us.png" />" title="<fmt:message key="lang.en"/>" /></a>
							<a href="?locale=zh_CN"><img src="<c:url value="/images/cn.png" />" title="<fmt:message key="lang.cn"/>" /></a>
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
						/*
						$('#swap').click(
							function(e)
							{
								$('.thumb').quicksand( $('.all li'), {
								  duration: 3000,
								  attribute: 'id',
								  easing: 'easeInOutQuad'
								});
								e.preventDefault();
							}
						);
						*/
						$('div.title a').each(
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
						)
					}
			)						
			
			function filter(source, destination)
			{
				$(source).quicksand($(destination), function(){ zoom();});
			}
			
			function zoom()
			{
				$('ul.thumb li').Zoomer({speedView:200,speedRemove:400,altAnim:true,speedTitle:400,debug:false});
			}
		</script>
		
	</body>

</html>