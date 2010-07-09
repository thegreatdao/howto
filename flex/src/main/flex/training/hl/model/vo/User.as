package training.hl.model.vo
{
	public class User
	{
		private var _userName : String;
		private var _firstName : String;
		private var _lastName : String;		
		private var _age : int;
		
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
		
		public function toString():String
		{
			var s : String = "User[firstName=";
			s +=firstName;
			s += ", lastName=";
			s += lastName;
			s += ", userName=";
			s += userName + "]";
			return s;
		}
	}
}