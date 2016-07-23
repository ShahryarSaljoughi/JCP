import java.sql.SQLException;

/**
 * Created by shahryar_slg on 22/07/2016.
 */



public class main {
    public static void main(String args[]) {
        DatabaseDriver myDB = null;
        try {
            myDB = new DatabaseDriver();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Oooooops ! we are having trouble :'( ");
        }
        USER user = new USER("SADEQ","MOSHIRI","4271163872","09193652478");
        try {
            myDB.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("we are having trouble adding user");
        }


    }
}
