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
		private static const USER_CHANGED : String = "userChanged";
		
		[Bindable(event="saveUserList")]
		public function get users():ArrayCollection
		{
			return _users;
		}

		[Bindable(event="userChanged")]
		public function get user():User
		{
			return _user;
		}
		
		public function saveUserList(users:Array):void
		{
			_users = new ArrayCollection(users);
			dispatchEvent(new Event(SAVE_USER_LIST));
		}
		
		public function selectUser(user:User):void
		{
			_user = user;
			dispatchEvent(new Event(USER_CHANGED));
		}
	}
}