/**
 * Created by shahryar_slg on 31/07/2016.
 */

/* instead of having a class named profile , I could provide the USER class with a static
member of type USER named profile .
but i want to design my program in a way that helps me develop and edit it later easier !
later I will add more methods and variables to this class , in order let the user modify themselves or set preferences!
 */

public class profile extends USER {
    public static profile me = null;
    static{
        me = new profile("shahryar","saljougi","123465789","09127401672");
    }
    public profile(String name, String lastName, String password, String phoneNumber) {
        super(name, lastName, password, phoneNumber);

    }
}
