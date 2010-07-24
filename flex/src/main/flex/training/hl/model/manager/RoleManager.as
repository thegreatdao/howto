package training.hl.model.manager
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;

	public class RoleManager extends EventDispatcher
	{
		private var _roles : ArrayCollection;
		private static const SAVE_ROLE_LIST : String = "saveRoleList";
		
		public function RoleManager(dispatcher:IEventDispatcher=null):void
		{
			super(dispatcher);
		}

		[Bindable(event="saveRoleList")]
		public function get roles():ArrayCollection
		{
			return _roles;
		}

		public function saveRoleList(roles:Array):void
		{
			_roles = new ArrayCollection(roles);
			dispatchEvent(new Event(SAVE_ROLE_LIST));
		}

	}
}