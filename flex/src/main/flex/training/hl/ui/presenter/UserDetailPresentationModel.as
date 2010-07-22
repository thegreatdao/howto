package training.hl.ui.presenter
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import training.hl.event.UserEvent;
	import training.hl.bean.User;
	
	public class UserDetailPresentationModel extends EventDispatcher
	{
		private var dispatcher:IEventDispatcher;
		private var _selectedUser:User;
		
		public static const USER_CHANGED:String = "userChanged";
		
		public function UserDetailPresentationModel(dispatcher:IEventDispatcher)
		{
			this.dispatcher = dispatcher;
		}

		[Bindable(event="userChanged")]
		public function get selectedUser():User
		{
			return _selectedUser;
		}

		
		public function set selectedUser(value:User):void
		{
			_selectedUser = value;
			dispatchEvent(new Event(USER_CHANGED));
		}

	}
}