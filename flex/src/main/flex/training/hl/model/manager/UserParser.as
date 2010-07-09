package training.hl.model.manager
{
	import mx.controls.Alert;
	
	import training.hl.model.vo.User;

	public class UserParser
	{
		public function parseUsers(users:XML):Array
		{
			var userList:Array = new Array();
			
			for each( var user:XML in users..users)
			{
				var currentUser:User = new User();
				currentUser.age = user.age;
				currentUser.firstName = user.firstName;
				currentUser.lastName = user.lastName;
				currentUser.userName = user.userName;
				userList.push(currentUser);
			}
			
			return userList;
		}		
	}
}