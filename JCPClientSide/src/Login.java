/**
 * Created by shahryar_slg on 06/08/2016.
 */
public class Login {

    private static String name;
    private static String lastname;
    private static String password;
    private static String phoneNumber;
    private static boolean loggedIn = false;

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Login.loggedIn = loggedIn;
    }

    // this function checks if the password and phoneNumeber are matched .
    // runs signUp if there is no such user in the database.
    public static void validate(){
        RequestSender.loginValidator(Login.phoneNumber,Login.password);
    }


    // initializes the static variables . these variables initialized once in this programme.
    public static void init(String name,String lastname,String password,String phoneNumber){
        Login.name=name;
        Login.lastname = lastname;
        Login.phoneNumber = phoneNumber;
        Login.password = password;
    }

    //this function will initialize the porfile;
    public static void login(){
        profile.me.setName(name);
        profile.me.setLastName(lastname);
        profile.me.setPassword(password);
        profile.me.setPhoneNumber(phoneNumber);
    }
}
