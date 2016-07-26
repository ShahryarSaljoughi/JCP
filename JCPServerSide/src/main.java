import java.sql.SQLException;

/**
 * Created by shahryar_slg on 22/07/2016.
 */



public class main {
    public static void main(String args[]) {
        //DatabaseDriver myDB = null;
        //myDB = new DatabaseDriver();


        USER user2 = new USER("pegah","fateh","1995","6546546516");
        USER user = new USER("SADEQ","MOSHIRI","4271163872","09193652478");

        try {
            signUp.signup(user);
        } catch (SQLException e) {
            System.out.println("catch 2 : ");
            String eMessage = e.getMessage();
            System.out.println(eMessage);
        } catch (SignUpException e) {
            System.out.println("error catched -");
        }

        try {
            signUp.signup(user2);
        }catch (SQLException e) {
            System.out.println("catch 2 : ");
            String eMessage = e.getMessage();
            System.out.println(eMessage);
        } catch (SignUpException e) {
            System.out.println("error catched -");
        }



        /*
        try {
            myDB.addUser(user);
        }catch(SignUpException e){
            System.out.println(e.getMessage());

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("we are having trouble adding user");
        }

        try {
            myDB.addUser(user);
        }catch(SignUpException e){
            System.out.println(e.getMessage());
        }

        try {
            myDB.addUser(user2);
        }catch(SignUpException e){
            System.out.println(e.getMessage());

        }





        try {
            myDB.addFriendship(user, user2);
        }catch (SQLException e){
            e.printStackTrace();
        }  */
    }
}
