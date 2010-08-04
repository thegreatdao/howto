/**
 * Generated by Gas3 v2.1.0 (Granite Data Services).
 * HL
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Post.as).
 */

package training.hl.bean {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import org.granite.collections.IPersistentCollection;
    import org.granite.meta;

    use namespace meta;

    [Bindable]
    public class PostBase extends RootEntity {

        private var __initialized:Boolean = true;
        private var __detachedState:String = null;

        private var _body:String;
        private var _category:Category;
        private var _categoryId:Number;
        private var _createdDate:Date;
        private var _id:Number;
        private var _title:String;
        private var _user:User;

        override meta function isInitialized(name:String = null):Boolean {
            if (!name)
                return __initialized;

            var property:* = this[name];
            return (
                (!(property is Post) || (property as Post).meta::isInitialized()) &&
                (!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
            );
        }

        public function set body(value:String):void {
            _body = value;
        }
        public function get body():String {
            return _body;
        }

        public function set category(value:Category):void {
            _category = value;
        }
        public function get category():Category {
            return _category;
        }

        public function set categoryId(value:Number):void {
            _categoryId = value;
        }
        public function get categoryId():Number {
            return _categoryId;
        }

        public function set createdDate(value:Date):void {
            _createdDate = value;
        }
        public function get createdDate():Date {
            return _createdDate;
        }

        public function set id(value:Number):void {
            _id = value;
        }
        public function get id():Number {
            return _id;
        }

        public function set title(value:String):void {
            _title = value;
        }
        public function get title():String {
            return _title;
        }

        public function set user(value:User):void {
            _user = value;
        }
        public function get user():User {
            return _user;
        }

        override public function readExternal(input:IDataInput):void {
            __initialized = input.readObject() as Boolean;
            __detachedState = input.readObject() as String;
            if (meta::isInitialized()) {
                super.readExternal(input);
                _body = input.readObject() as String;
                _category = input.readObject() as Category;
                _categoryId = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
                _createdDate = input.readObject() as Date;
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
                _title = input.readObject() as String;
                _user = input.readObject() as User;
            }
            else {
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            }
        }

        override public function writeExternal(output:IDataOutput):void {
            output.writeObject(__initialized);
            output.writeObject(__detachedState);
            if (meta::isInitialized()) {
                super.writeExternal(output);
                output.writeObject(_body);
                output.writeObject(_category);
                output.writeObject(_categoryId);
                output.writeObject(_createdDate);
                output.writeObject(_id);
                output.writeObject(_title);
                output.writeObject(_user);
            }
            else {
                output.writeObject(_id);
            }
        }
    }
}