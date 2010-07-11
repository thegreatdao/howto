package training.hl.model.manager
{
	import mx.controls.Alert;
	
	import training.hl.model.vo.User;

	public class UserParser
	{
		public function parseUsers(users:XML):Array
		{
			var userList:Array = new Array();
			
			for each( var user:XML in users..user)
			{
				var currentUser:User = new User();
				currentUser.age = user.age;
				currentUser.firstName = user.firstName;
				currentUser.lastName = user.lastName;
				currentUser.userName = user.userName;
				currentUser.bio = user.profile.bio;
				currentUser.hobbies = user.profile.hobbies;
				currentUser.homePage = user.profile.homePage;
				userList.push(currentUser);
			}
			
			return userList;
		}		
	}
}