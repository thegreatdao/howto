package training.hl.event
{
	import flash.events.Event;
	
	import training.hl.model.vo.User;
	
	public class UserEvent extends Event
	{
		public static const GET_ALL_USERS : String = "getAllUsers";
		public static const GET_USER_BY_ID : String = "getUserById";
		private var _user:User;
		
		public function UserEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public function set user(user:User):void
		{
			_user = user;
		}
		
		public function get user():User
		{
			return user;
		}
	}
}