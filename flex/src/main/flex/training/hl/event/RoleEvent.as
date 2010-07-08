package training.hl.event
{
	import flash.events.Event;
	
	public class RoleEvent extends Event
	{
		public static const GET_ALL : String = "getAllRoles";
		public static const GET_ROLE_BY_ID : String = "getRoleById";
		
		public function RoleEvent(type:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
	}
}