package sboot.dbtest1;
import com.datastax.driver.core.*;
import org.springframework.beans.factory.DisposableBean;

/**
 * Created by sohail on 26/05/15.
 * This is not the proper way of doing DB in Spring. This is just the initial test.
 * This is a bean, mainly a wrapper for a CassandraConnector.
 * I dpon't like mere wrappers. It simply gives a quality of Bean to a "CassandraConnector".
 * Benefit: It will be easy to change Database. But a-priori features (features before really needed) are not a good idea.
 */
public class DBMan1
        implements DisposableBean //I seriously doubt this is the right way
{
    CassandraConnector client=null; //final
    //final Session sess;

    /**
     * Uses default parameters. todo: get from properties.
     */
    public DBMan1() {
        final String ipAddress = "localhost"; //args.length > 0 ? args[0] : "localhost";
        final int port = 9042; //args.length > 1 ? Integer.parseInt(args[1]) : 9042;
        this.connect(ipAddress, port);
    }

    /**
     * Keeps a connector alive. (not a session).
     *
     * @param ipAddress
     * @param port
     */
    protected void connect(String ipAddress, int port) {
        this.client = new CassandraConnector();

        //out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        //client.connect(ipAddress, port);
        //client.close();

        // chose,games,tims,users
        client.connect(ipAddress, port);
        //this.sess = client.getSession();
    }

    public Session makeSessions(){
        final Session sess = this.client.getSession();
        return sess;
    }

    private void testQuery() {
        final Session sess = this.client.getSession();
        //import static java.lang.System.out;
        java.lang.System.out.println(sess);

        java.lang.System.out.println("keyspace: " + sess.getLoggedKeyspace());
        ResultSet rs0 = sess.execute("USE mykeyspace;");
        java.lang.System.out.println(rs0);
        java.lang.System.out.println("keyspace: " + sess.getLoggedKeyspace());
        ResultSet rs = sess.execute("SELECT * FROM users;");
        java.lang.System.out.println(rs);

        //ResultSet[ exhausted: true, Columns[]]
        //ResultSet[ exhausted: false, Columns[user_id(int), name(varchar)]]


        for (Row rec : rs) {
            java.lang.System.out.print(rec);
        }
       /*yay 8:42am 28 April 2015: Cassandra connection done. (Feeling of empowerment?)
       ResultSet[ exhausted: false, Columns[user_id(int), name(varchar)]]
       Row[1745, sohail siadat]
       Process finished with exit code 0
       */
    }
    //protected void disconnect() {
    //    client.close();
    //}

    @Override
    public void destroy() throws Exception {
        System.out.println(this+" .destroy() was called.");
        client.close();
    }
}