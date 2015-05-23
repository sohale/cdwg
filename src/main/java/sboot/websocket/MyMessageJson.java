package sboot.websocket;

/**
 * Created by sohail on 23/05/15.
 */
public class MyMessageJson { //was: Greeting .content
    private String txt;

    public MyMessageJson(String text) {
        this.txt=text;
    }

    public String getMytext(){
        return this.txt;
    }
}
