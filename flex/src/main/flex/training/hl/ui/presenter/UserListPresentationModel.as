package training.hl.ui.presenter
{
	import com.asfusion.mate.events.DispatcherEvent;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import training.hl.bean.User;
	import training.hl.event.UserEvent;
	
	public class UserListPresentationModel extends EventDispatcher
	{
		public static const USERS_CHANGED:String = "usersChanged";
		public static const ROLES_CHANGED:String = "rolesChanged";
		public static const SELECTED_USER_CHANGED:String = "selectedUserChanged";
		public static const SELECTED_USER_INDEX_CHANGED:String = "selectedUserIndexChanged";
		private var dispatcher:IEventDispatcher;
		private var _users:ArrayCollection;
		private var _roles:ArrayCollection;
		private var _selectedUser:User;
		private var _selecteIndex:int = -1;
		
		public function UserListPresentationModel(dispatcher:IEventDispatcher):void
		{
			this.dispatcher = dispatcher;
		}
		
		public function set users(list:ArrayCollection):void
		{
			_users = list;
			dispatchEvent(new Event(USERS_CHANGED));
		}
		
		[Bindable(event="usersChanged")]
		public function get users():ArrayCollection
		{
			return _users;
		}
		
		[Bindable(event="rolesChanged")]
		public function get roles():ArrayCollection
		{
			return _roles;
		}

		public function set roles(value:ArrayCollection):void
		{
			_roles = value;
			dispatchEvent(new Event(ROLES_CHANGED));
		}

		[Bindable(event = "selectedUserIndexChanged")]
		public function get selecteIndex():int
		{
			return _selecteIndex;
		}
		
		public function set selecteIndex(value:int):void
		{
			_selecteIndex = value;
			dispatchEvent(new Event(SELECTED_USER_INDEX_CHANGED));
		}
		
		[Bindable(event="selectedUserChanged")]
		public function get selectedUser():User
		{
			return _selectedUser;
		}

		public function set selectedUser(selectedUser:User):void
		{
			if(_selectedUser != selectedUser)
			{
				_selectedUser = selectedUser;
				dispatchEvent(new Event(SELECTED_USER_CHANGED));
			}
		}
		
		public function selectUser(user:User):void
		{
			var event:UserEvent = new UserEvent(UserEvent.SELECT);
			event.user = user;
			dispatcher.dispatchEvent(event);
		}

		public function addUser(user:User):void
		{
			var index:int = 0;
			var newUser:Boolean = true;
			for each(var existingUser:User in _users)
			{
				if(existingUser.id == user.id)
				{
					_users.removeItemAt(index);
					_users.addItem(user);
					newUser = false;
				}
				index++;				
			}
			if(newUser)
			{
				_users.addItem(user);
			}
		}
		
		public function deleteUser(user:User):void
		{
			var index:int = 0;
			for each(var currentUser:User in _users)
			{
				if(currentUser.id == user.id)
				{
					_users.removeItemAt(index);
				}
				index++;
			}
		}

	}
}