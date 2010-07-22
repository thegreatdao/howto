/**
 * Generated by Gas3 v2.1.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Category.as).
 */

package training.hl.bean {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import mx.collections.ListCollectionView;
    import org.granite.collections.IPersistentCollection;
    import org.granite.meta;

    use namespace meta;

    [Bindable]
    public class CategoryBase extends RootEntity {

        private var __initialized:Boolean = true;
        private var __detachedState:String = null;

        private var _createdDate:Date;
        private var _id:Number;
        private var _name:String;
        private var _posts:ListCollectionView;
        private var _user:User;

        override meta function isInitialized(name:String = null):Boolean {
            if (!name)
                return __initialized;

            var property:* = this[name];
            return (
                (!(property is Category) || (property as Category).meta::isInitialized()) &&
                (!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
            );
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

        public function set name(value:String):void {
            _name = value;
        }
        public function get name():String {
            return _name;
        }

        public function set posts(value:ListCollectionView):void {
            _posts = value;
        }
        public function get posts():ListCollectionView {
            return _posts;
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
                _createdDate = input.readObject() as Date;
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
                _name = input.readObject() as String;
                _posts = input.readObject() as ListCollectionView;
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
                output.writeObject(_createdDate);
                output.writeObject(_id);
                output.writeObject(_name);
                output.writeObject(_posts);
                output.writeObject(_user);
            }
            else {
                output.writeObject(_id);
            }
        }
    }
}