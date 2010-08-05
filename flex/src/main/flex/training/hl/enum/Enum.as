package training.hl.enum
{
		import flash.utils.IDataInput;
		import flash.utils.getQualifiedClassName;
		
		public class Enum {
			private var _name:String;
			
			function Enum(name:String, restrictor:*) {
				_name = (restrictor is Restrictor ? name : constantOf(name).name);
			}
			
			public function set name(value:String):void
			{
				_name = constantOf(value).name
			}
			
			public function get name():String
			{
				return _name;
			}
			
			protected function getConstants():Array {
				throw new Error("Should be overriden");
			}
			
			protected function constantOf(name:String):Enum {
				for each (var o:* in getConstants()) {
					var enum:Enum = Enum(o);
					if (enum.name == name)
						return enum;
				}
				throw new ArgumentError("Invalid " + getQualifiedClassName(this) + "name: " + name);
			}
			
			public static function readEnum(input:IDataInput):Enum {
				var tmp:Enum = input.readObject() as Enum;
				return (tmp == null ? null : tmp.constantOf(tmp.name));
			}
			
			public function toString():String {
				return name;
			}
			
			public function equals(other:Enum):Boolean {
				return other === this || (
					other != null &&
					getQualifiedClassName(this) == getQualifiedClassName(other) &&
					other.name == this.name
				);
			}
			
			
			protected static function get _():Restrictor {
				return new Restrictor();
			}
		}	
}
class Restrictor {}