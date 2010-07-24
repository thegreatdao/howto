package training.hl.model.manager
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import training.hl.bean.Role;
	import training.hl.bean.User;
	
	public class UserManager extends EventDispatcher
	{
		private var dispatcher:IEventDispatcher;
		private var _users : ArrayCollection;
		private var _user : User;
		private var _roles:ArrayCollection;
		private static const SAVE_USER_LIST : String = "saveUserList";
		private static const USER_CHANGED : String = "userChanged";
		private static const SAVE_ROLE_LIST : String = "saveRoleList";
			
		public function UserManager(dispatcher:IEventDispatcher=null):void
		{
			super(dispatcher);
		}
		
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
			for each(var resetRole:Role in _roles)
			{
				resetRole.checked = false;
			}
			for each(var role:Role in _user.roles)
			{
				for each(var innerRole:Role in _roles)
				{
					if(role.name == innerRole.name)
					{
						innerRole.checked = true;
					}
				}
			}
			dispatchEvent(new Event(USER_CHANGED));
		}

		[Bindable(event="saveRoleList")]
		public function get roles():ArrayCollection
		{
			return _roles;
		}

		public function set roles(value:ArrayCollection):void
		{
			_roles = value;
			dispatchEvent(new Event(SAVE_ROLE_LIST));
		}

	}
}