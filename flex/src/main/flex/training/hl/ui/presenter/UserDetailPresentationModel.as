package training.hl.ui.presenter
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import training.hl.bean.User;
	import training.hl.bean.enums.Gender;
	import training.hl.event.UserEvent;
	
	
	public class UserDetailPresentationModel extends EventDispatcher
	{
		private var dispatcher:IEventDispatcher;
		private var _selectedUser:User;
		private var _roles:ArrayCollection;
		private var _male:Boolean;
		private var _female:Boolean;
		private var _emptyPassword:String;
		
		public static const USER_CHANGED:String = "userChanged";
		public static const GENDER_CHANGED_TO_MALE:String = "genderChangedToMale";
		public static const GENDER_CHANGED_TO_FEMALE:String = "genderChangedToFemale";
		public static const ROLES_CHANGED:String = "rolesChanged";
		public static const RESET_PASSWORD_TO_EMPTY:String = "resetPasswordToEmpty";
		
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
			if(value.gender == Gender.MALE)
			{
				male = true;
			}
			else
			{
				female = true;
			}
			dispatchEvent(new Event(USER_CHANGED));
		}

		[Bindable(event="genderChangedToMale")]
		public function get male():Boolean
		{
			return _male;
		}

		public function set male(value:Boolean):void
		{
			_male = value;
			dispatchEvent(new Event(GENDER_CHANGED_TO_MALE));
		}

		[Bindable(event="genderChangedToFemale")]
		public function get female():Boolean
		{
			return _female;
		}

		public function set female(value:Boolean):void
		{
			_female = value;
			dispatchEvent(new Event(GENDER_CHANGED_TO_FEMALE));
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

		[Bindable(event="resetPasswordToEmpty")]
		public function get emptyPassword():String
		{
			return _emptyPassword;
		}

		public function set emptyPassword(value:String):void
		{
			dispatchEvent(new Event(RESET_PASSWORD_TO_EMPTY));
		}


	}
}