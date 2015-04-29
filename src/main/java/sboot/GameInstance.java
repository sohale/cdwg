package sboot;

/**
 * Created by sohail on 28/04/15.
 */
public class GameInstance {

    private final long id;
    private final String content;

    public GameInstance(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
