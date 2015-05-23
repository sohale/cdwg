package sboot.websocket;

/**
 * Created by sohail on 23/05/15.
 */
public class MyMessageJson { //was: Greeting .content
    private String txt; //private field name is not cared for in this class only.

    public MyMessageJson(String text) {
        this.txt=text;
    }

    public String getMytext(){
        return this.txt;
    }
}
