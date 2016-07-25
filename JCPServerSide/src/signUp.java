import java.sql.SQLException;

public class signUp  {
    //USER User ;
    DatabaseDriver DB = new DatabaseDriver();
    public signUp(USER user) throws SQLException {
        if isValid(user){ DB.addUser(user); }
        else {
            throw new SignUpException("the user already exists!")
        }
    }
    public static boolean isValid(USER user){
        boolean valid = !DatabaseDriver.userExists(user);
        return valid;
    }
}
