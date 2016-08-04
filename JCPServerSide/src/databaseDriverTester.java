import java.sql.SQLException;

/**
 * Created by panizava on 26/07/2016.
 */
public class databaseDriverTester {
    public static void main(String args[]){
        Message m = new Message("pegah","shahryar","pish miad !! bara man pish miad javab nadam!");
        try {
            DatabaseDriver.addMessage(m);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
