/**
 * Generated by Gas3 v2.1.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR.
 */

package training.hl.bean.enums {
	import training.hl.enum.Enum;


    [Bindable]
    [RemoteClass(alias="training.hl.bean.enums.Gender")]
    public class Gender extends Enum {

        public static const FEMALE:Gender = new Gender("FEMALE", _);
        public static const MALE:Gender = new Gender("MALE", _);

        function Gender(value:String = null, restrictor:* = null) {
            super((value || FEMALE.name), restrictor);
        }

        override protected function getConstants():Array {
            return constants;
        }

        public static function get constants():Array {
            return [FEMALE, MALE];
        }

        public static function valueOf(name:String):Gender {
            return Gender(FEMALE.constantOf(name));
        }
    }
}