package training.hl.ui.presenter
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import training.hl.event.UserEvent;
	import training.hl.bean.User;
	
	public class UserListPresentationModel extends EventDispatcher
	{
		public static const USERS_CHANGED:String = "usersChanged";
		public static const SELECTED_USER_CHANGED:String = "selectedUserChanged";
		private var dispatcher:IEventDispatcher;
		private var _users:ArrayCollection;
		private var _selectedUser:User;
		
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

	}
}