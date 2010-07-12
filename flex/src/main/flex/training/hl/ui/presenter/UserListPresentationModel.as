package training.hl.ui.presenter
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	public class UserListPresentationModel extends EventDispatcher
	{
		private var dispatcher:IEventDispatcher;
		private var _users:ArrayCollection = null;
		public static const USERS_CHANGED:String = "usersChanged";
		
		public function UserListPresentationModel(dispatcher:IEventDispatcher)
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
	}
}