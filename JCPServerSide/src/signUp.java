import java.sql.SQLException;

public class signUp  {
    //USER User ;
    public static void signup(USER user) throws SQLException,SignUpException {
       if (DatabaseDriver.userExists(user)){
           System.out.println("the user already exists . just sign in");
           throw new SignUpException("the user already is in database - error in signup");
       }else{
           System.out.println("singup is going to add user to DB");
           DatabaseDriver.addUser(user);
       }
    }
}
