package training.hl.model.manager
{
	import mx.collections.ArrayCollection;
	
	import training.hl.bean.Profile;
	import training.hl.bean.Role;
	import training.hl.bean.User;
	import training.hl.bean.enums.Gender;

	public class E4XParser
	{
		public function parseUsers(users:XML):Array
		{
			var userList:Array = new Array();
			
			for each(var user:XML in users..user)
			{
				var currentUser:User = new User();
				currentUser.id = user.id;
				currentUser.age = user.age;
				currentUser.firstName = user.firstName;
				currentUser.lastName = user.lastName;
				currentUser.userName = user.userName;
				var profile:Profile = new Profile();
				currentUser.profile = profile;
				currentUser.profile.bio = user.profile.bio;
				currentUser.profile.hobbies = user.profile.hobbies;
				currentUser.profile.homePage = user.profile.homePage;
				if(user.gender == "FEMALE")
				{
					currentUser.gender = Gender.FEMALE;
				}
				else
				{
					currentUser.gender = Gender.MALE;
				}
				var roles:ArrayCollection = new ArrayCollection();
				currentUser.roles= roles;
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
		
		public function parseRoles(roles:XML):Array
		{
			var roleList:Array = new Array();
			
			for each(var role:XML in roles..role)
			{
				var currentRole:Role = new Role();
				currentRole.name = role.name;
				currentRole.id = role.id;
				roleList.push(currentRole);
			}
			
			return roleList;
		}
	}
}