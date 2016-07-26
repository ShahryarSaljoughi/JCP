import java.sql.SQLException;

/**
 * Created by panizava on 26/07/2016.
 */
public class databaseDriverTester {
    public static void main(String args[]){
        USER user = new USER("hassan","mortazavi","rt86","6446541657");
        try {
            DatabaseDriver.addUser(user);
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }

    }
}
