/**
 * Generated by Gas3 v2.1.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Profile.as).
 */

package training.hl.bean {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;

    [Bindable]
    public class ProfileBase implements IExternalizable {

        private var _bio:String;
        private var _hobbies:String;
        private var _homePage:String;

        public function set bio(value:String):void {
            _bio = value;
        }
        public function get bio():String {
            return _bio;
        }

        public function set hobbies(value:String):void {
            _hobbies = value;
        }
        public function get hobbies():String {
            return _hobbies;
        }

        public function set homePage(value:String):void {
            _homePage = value;
        }
        public function get homePage():String {
            return _homePage;
        }

        public function readExternal(input:IDataInput):void {
            _bio = input.readObject() as String;
            _hobbies = input.readObject() as String;
            _homePage = input.readObject() as String;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_bio);
            output.writeObject(_hobbies);
            output.writeObject(_homePage);
        }
    }
}