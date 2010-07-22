package training.hl.model.manager
{
	import mx.controls.Alert;
	
	import training.hl.bean.Role;
	import training.hl.bean.User;

	public class UserParser
	{
		public function parseUsers(users:XML):Array
		{
			var userList:Array = new Array();
			
			for each(var user:XML in users..user)
			{
				var currentUser:User = new User();
				currentUser.age = user.age;
				currentUser.firstName = user.firstName;
				currentUser.lastName = user.lastName;
				currentUser.userName = user.userName;
				currentUser.profile.bio = user.profile.bio;
				currentUser.profile.hobbies = user.profile.hobbies;
				currentUser.profile.homePage = user.profile.homePage;
				for each(var role:XML in user.role)
				{
					var currentRole:Role = new Role();
					currentRole.name = role.name;
					currentRole.id = role.id;
					currentUser.roles.addItem(currentRole);
				}
				userList.push(currentUser);
			}
			
			return userList;
		}		
	}
}