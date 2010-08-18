<ul class="tabs">
	<li id="role_tab"><a href="javascript:void(0);"><fmt:message key="role.roleList"/></a></li>
	<li id="user_tab"><a href="javascript:void(0);"><fmt:message key="user.userList"/></a><img src="<c:url value="/images/ajax_orange.gif"/>" id="ajax_icon"/></li>
</ul>
<div class="panes">	
	<div id="role_list">
		<div class="tabular_data"><fmt:message key="role.roleList"/></div>
		<table>
			<thead>
				<tr>
					<th><fmt:message key="role.name"/></th>
					<th><fmt:message key="role.description"/></th>
				</tr>
			</thead>
			
			<c:forEach items="${pagination.records}" var="role">
				<tr>
					<td>
						<span class="user_action">${role.name}</span>
						<div class="tooltip">
							<div>
								<a href="<c:url value="/role/form.html?id=${role.id}" />"><fmt:message key="edit"/></a>
								<a href="javascript:void(0);" class="delete"><fmt:message key="delete"/></a>
							</div>
							<div class="confirm_dialog">
								<a href="<c:url value="/role/delete.html?id=${role.id}" />" class="confirm"><fmt:message key="confirm"/></a>
								<a href="javascript:void(0);" class="cancel"><fmt:message key="cancel"/></a>
							</div>
						</div>
					</td>
					<td>
						<span class="user_action"><a href="javascript:void(0);" id="role_${role.id}">${role.description}</a></span>
						<div class="tooltip">
							<div>
								<a href="javascript:void(0);"><fmt:message key="role.users"/></a>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="action">
			<a href="<c:url value="/role/form.html" />"><img src="<c:url value="/images/group_add.png" />" id="action_img"/><fmt:message key="role.add.role"/></a>
		</div>
		<div id="pagination_panel">
		</div>
	</div>
	<div id="user_list"></div>
	<div id="post_list"></div>
</div>
<script type="text/javascript">
	$(
		function()
		{
			$('#pagination_panel').pagination(
					${pagination.totalNumOfRecords},
					{
						num_display_entries: 2,
						items_per_page: ${pagination.numOfRecordsPerPage},
						num_edge_entries: 2,
						num_display_entries: 2,
						current_page: ${pagination.currentIndex},
						callback: handlePagainationClick
					}
			);
			$('#role_tab a').addClass('current');
			$('#role_tab').click(
				function()
				{
					$('#role_list').fadeIn('slow');
					$('#user_list').hide();
					$('#post_list').hide();
					$('#role_tab a').removeClass('current');
					$('#role_tab a').addClass('current');
					$('#user_tab a').removeClass('current');
					$('#post_tab a').removeClass('current');
				}
			);
			$('#user_tab').click(
				function()
				{
					$('#role_list').hide();
					$('#user_list').fadeIn('slow');
					$('#post_list').hide();
					$('#user_tab a').removeClass('current');
					$('#user_tab a').addClass('current');
					$('#role_tab a').removeClass('current');
					$('#post_tab a').removeClass('current');
				}
			);
			$('#post_tab').click(
				function()
				{
					$('#post_list').fadeIn('slow');
					$('#user_list').hide();
					$('#role_list').hide();
					$('#post_tab a').removeClass('current');
					$('#post_tab a').addClass('current');
					$('#role_tab a').removeClass('current');
					$('#user_tab a').removeClass('current');
				}
			);
			$("a[id^='role_']").click(
				function()
				{
					var roleId = $(this).attr('id').substring(5);
					$.getJSON('<c:url  value="/role/getAllUsersByRole.html?roleId="/>' + roleId, 
							function(data)
							{
								$('#ajax_icon').fadeIn();
								var userTable = '<div class="tabular_data"><fmt:message key="user.userList"/></div><table><thead><tr><th><fmt:message key="user.userName"/></th><th><fmt:message key="user.firstName"/></th><th><fmt:message key="user.lastName"/></th><th><fmt:message key="user.age"/></th><th><fmt:message key="user.gender"/></tr></thead>';
								for(var index in data)
								{
									userTable += '<tr><td><span class="user_action">' + data[index].userName + '</span></td>';
									userTable += '<td>' + data[index].firstName + '</td>';
									userTable += '<td>' + data[index].lastName + '</td>';
									userTable += '<td>' + data[index].age + '</td>';
									userTable += '<td>' + data[index].gender + '</td></tr>';
								}
								userTable += "</table>";
								$('#user_list').hide();
								$('#user_list').html(userTable);
								$('#ajax_icon').fadeOut("slow");
								$('#user_tab a').addClass("current");
								$('#role_tab a').removeClass("current");
								$('#role_list').fadeOut("slow", function(){$('#user_list').fadeIn("slow");});
							}
					);
				}
			);
		}
	)
	
	function handlePagainationClick(new_page_index, pagination_container)
	{
		var currrentIndex = getParameterByName("currentIndex");
		if(new_page_index!=currrentIndex)
		{
			var url = "<c:url value="/role/show.html"/>" + "?currentIndex=" + new_page_index;
			window.location = url;
		}		
	}

	function getParameterByName( name )
	{
	  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	  var regexS = "[\\?&]"+name+"=([^&#]*)";
	  var regex = new RegExp( regexS );
	  var results = regex.exec( window.location.href );
	  if( results == null )
	  {
	    return "";
	  }
	  else
	  {
	    return decodeURIComponent(results[1].replace(/\+/g, " "));
	  }
	}
		
</script>