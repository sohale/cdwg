package sboot.endpoints;

/**
 * Use to pass as a json in REST.
 * Todo: remove this class. No need for this when using REST/json. Maybe a public getSummary() method in UserState. We probably don't need "view"s here.
 * Created by sohail on 28/04/15.
 */
@Deprecated
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
    public long getVLong(){
        return 5L;
    }
}
