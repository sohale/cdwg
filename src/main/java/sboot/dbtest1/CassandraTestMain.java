package sboot.dbtest1;

import com.datastax.driver.core.*;
import sboot.dbtest1.CassandraConnector;

import static java.lang.System.out;

public class CassandraTestMain {

    /**
     * sboot.dbtest1.CassandraTestMain function for demonstrating connecting to Cassandra with host and port.
     *
     * @param args Command-line arguments; first argument, if provided, is the
     *             host and second argument, if provided, is the port.
     */
    public static void main(final String[] args) {
        final CassandraConnector client = new CassandraConnector();
        final String ipAddress = args.length > 0 ? args[0] : "localhost";
        final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
        out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        client.connect(ipAddress, port);
        client.close();

        // chose,games,tims,users
        client.connect(ipAddress, port);
        Session sess = client.getSession();
        out.println(sess);
       /*
       Connected to cluster: Test Cluster
       Datacenter: datacenter1; Host: localhost/127.0.0.1; Rack: rack1
       Connected to cluster: Test Cluster
       Datacenter: datacenter1; Host: localhost/127.0.0.1; Rack: rack1
       com.datastax.driver.core.SessionManager@3ecd23d9
       */

        out.println("keyspace: " + sess.getLoggedKeyspace());
        ResultSet rs0 = sess.execute("USE mykeyspace;");
        out.println(rs0);
        out.println("keyspace: " + sess.getLoggedKeyspace());
        ResultSet rs = sess.execute("SELECT * FROM users;");
        out.println(rs);

        //ResultSet[ exhausted: true, Columns[]]
        //ResultSet[ exhausted: false, Columns[user_id(int), name(varchar)]]


        for (Row rec : rs) {
            out.print(rec);
        }
       /*yay 8:42am 28 April 2015: Cassandra connection done. (Feeling of empowerment?)
       ResultSet[ exhausted: false, Columns[user_id(int), name(varchar)]]
       Row[1745, sohail siadat]
       Process finished with exit code 0
       */

        client.close();

    }
}