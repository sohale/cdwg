package sboot.endpoints;

/**
 * Use to pass as a json in REST.
 * Created by sohail on 28/04/15.
 */
public class UserStateSummaryView {
    final String summary;
    final long uid;
    public UserStateSummaryView(long uid, String summary){
        this.summary = summary;
        this.uid=uid;
    }
}
