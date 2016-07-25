import java.sql.SQLException;

/**
 * Created by panizava on 19/07/2016.
 */
public class signUp  {
    //USER User ;
    DatabaseDriver DB = new DatabaseDriver();
    public signUp(USER user) throws SQLException {
        DB.addUser(user);
    }
    public static boolean isValid(USER user){
        boolean valid = true;

        return valid;
    }
}
