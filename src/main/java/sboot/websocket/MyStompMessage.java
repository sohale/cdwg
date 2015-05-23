package sboot.websocket;

/**
 * Created by sohail on 22/05/15.
 */
public class MyStompMessage { //was: HelloMessage  .name
    //private String txt;
    private String myStompText;
    //The private member variable of the field name must be of the same name with the getter, otherwise the automatic conversion (constructor) from a "stringified JSON" will not work!
    public String getMyStompText(){
        return this.myStompText;
    }
    //Seems to need a default constructor MyStompMessage()
    //public MyStompMessage(String text){
    //    this.txt=text;
    //}
    //public MyStompMessage(){
    //    this.txt="[not initialised]";
    //}
}
