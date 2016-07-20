/**
 * Created by shahryar_slg on 19/07/2016.
 */
public class USER {
    private String name;
    private String lastName;
    private String password;
    private String phoneNumber;
    public USER(String name,String lastName,String password,String phoneNumber){
        this.name=name;
        this.lastName=lastName;
        this.password=password;
        this.phoneNumber=phoneNumber;
    }
    public USER(USER user){
        name=getName();
        lastName=getLastName();
        password=getPassword();
        phoneNumber=getPhoneNumber();
    }
    // getters and setters :
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
