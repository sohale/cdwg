package sboot.endpoints;

/**
 * Use to pass as a json in REST.
 * Created by sohail on 28/04/15.
 */
public class UserStateSummaryView {
    private final String summary;
    private final long uid;
    public UserStateSummaryView(long uid, String summary){
        this.summary = summary;
        this.uid=uid;
    }
    //A 'json' is the set of public get*() methods of a POJO.
    public String getSummary(){
        return this.summary;
    }
}
