import java.sql.SQLException;

/**
 * Created by panizava on 19/07/2016.
 */
public class signUp {
    //USER User ;
    DatabaseDriver DB = new DatabaseDriver();
    public static signUp(USER user) throws SQLException {
        DatabaseDriver LocalDB = new DatabaseDriver();
        LocalDB.addUser(user);
    }
    public static Validate(USER user){

    }
}
