package sboot.websocket;

/**
 * Change (of choice) as received by backend.
 */
public class BcwChangeMessageJson {
    private long uid;
    private int new_choice;
    private int old_choice;

    /*
    public BcwChangeMessageJson(long uid, int choice, int old_choice)
    {
        this.uid = uid;
        this.new_choice=choice;
        this.old_choice=old_choice;
    }
    */
    public BcwChangeMessageJson(BcwChangeMessageStomp jsobj)
    {
        this.uid = jsobj.getUid();
        this.new_choice=jsobj.getNew_choice();
        this.old_choice=jsobj.getOld_choice();
    }

    public long getUid() {
        return uid;
    }

    public int getNew_choice() {
        return new_choice;
    }

    public int getOld_choice() {
        return old_choice;
    }
}
