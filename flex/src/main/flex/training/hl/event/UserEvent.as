package training.hl.event
{
	import flash.events.Event;
	
	import training.hl.model.vo.User;
	
	public class UserEvent extends Event
	{
		public static const SELECT:String = "selectUserEvent";
		public static const EDIT:String = "editUserEvent";
		public static const DELETE:String = "deleteUserEvent";
		public static const ADD:String = "addUserEvent";
		
		private var _user:User;
		
		public function UserEvent(type:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public function set user(user:User):void
		{
			_user = user;
		}
		
		public function get user():User
		{
			return _user;
		}
	}
}