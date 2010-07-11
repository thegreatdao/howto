package training.hl.model.manager
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	
	import training.hl.model.vo.User;
	
	public class UserManager extends EventDispatcher
	{
		private var _users : ArrayCollection;
		private var _user : User;
		private static const SAVE_USER_LIST : String = "saveUserList";
		
		[Bindable(event="saveUserList")]
		public function get users():ArrayCollection
		{
			return _users;
		}

		public function get user():User
		{
			return _user;
		}

		public function set user(value:User):void
		{
			_user = value;
		}
		
		public function saveUserList(users:Array):void
		{
			_users = new ArrayCollection(users);
			dispatchEvent(new Event(SAVE_USER_LIST));
		}
	}
}