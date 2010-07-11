package training.hl.model.vo
{
	public class User
	{
		private var _userName : String;
		private var _firstName : String;
		private var _lastName : String;		
		private var _age : int;
		private var _bio : String;
		private var _homePage : String;
		private var _hobbies : String;
		
		public function User()
		{
		}
		
		public function get userName() : String
		{
			return _userName;
		}
		
		public function set userName(userName:String) : void
		{
			_userName = userName;
		}
		
		public function get firstName() : String
		{
			return _firstName;
		}
		
		public function set firstName(firstName : String):void
		{
			_firstName = firstName;
		}
		
		public function get lastName() : String
		{
			return _lastName;
		}
		
		public function set lastName(lastName : String):void
		{
			_lastName = lastName;
		}
		
		public function get age() : int
		{
			return _age;
		}
		
		public function set age(age:int) : void
		{
			_age = age;
		}			

		public function get hobbies():String
		{
			return _hobbies;
		}

		public function set hobbies(value:String):void
		{
			_hobbies = value;
		}

		public function get homePage():String
		{
			return _homePage;
		}

		public function set homePage(value:String):void
		{
			_homePage = value;
		}

		public function get bio():String
		{
			return _bio;
		}

		public function set bio(value:String):void
		{
			_bio = value;
		}


	}
}