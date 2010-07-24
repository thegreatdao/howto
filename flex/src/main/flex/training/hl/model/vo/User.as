package training.hl.model.vo
{
	[Bindable]
//	[RemoteClass(alias="training.hl.bean.User")]
	public class User
	{
		public var id : Number;
		public var userName : String;
		public var firstName : String;
		public var lastName : String;		
		public var age : int;
		public var bio : String;
		public var homePage : String;
		public var hobbies : String;
		
		public function User()
		{
		}
		
		public function toString():String
		{
			var s:String = "user : [";
			s += "id : " + id + ",";
			s += "userName : " + userName + ",";
			s += "firstName : " + firstName + ",";
			s += "lastName : " + lastName + ",";
			s += "age : " + age + ",";
			s += "bio : " + bio + ",";
			s += "bio : " + bio + ",";
			s += "homePage : " + homePage + ",";
			s += "hobbies : " + hobbies + "]";
			return s;
		}
	}
}