package sboot.websocket;

/**
 * Identical to the BcwChangeMessageJson class
 */
public class BcwChangeMessageStomp {

    //careful with the private names. (Used by an automatic constructor by Spring?)
    //Must be Long and not long (no primitive).
    private Long uid;
    private Integer new_choice;
    private Integer old_choice;

    public Long getUid() {
        return uid;
    }

    public Integer getNew_choice() {
        return new_choice;
    }

    public Integer getOld_choice() {
        return old_choice;
    }
}
