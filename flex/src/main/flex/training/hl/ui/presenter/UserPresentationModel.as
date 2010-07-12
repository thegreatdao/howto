package training.hl.ui.presenter
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import training.hl.model.constant.NavigationConstant;
	
	public class UserPresentationModel extends EventDispatcher
	{
		private var dispatcher:IEventDispatcher;
		private var _viewState:String;
		public static const VIEW_STATE_CHANGED:String = "viewStateChanged";
		
		public function UserPresentationModel(dispatcher:IEventDispatcher)
		{
			this.dispatcher = dispatcher;
			_viewState = NavigationConstant.USER_LIST;
		}

		[Bindable(event="viewStateChanged")]
		public function get viewState():String
		{
			return _viewState;
		}

		public function set viewState(value:String):void
		{
			_viewState = value;
			dispatchEvent(new Event(VIEW_STATE_CHANGED));
		}

	}
}