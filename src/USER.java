/**
 * Created by shahryar_slg on 19/07/2016.
 */
public class USER {
    private String name;
    private String lastName;
    private String password;
    private String phoneNumber;
    public enum State{
        online,
        offline,
        away
    }
    State state=State.online;
    //constructors :
    public USER(String name,String lastName,String password,String phoneNumber){
        this.name=name;
        this.lastName=lastName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.state=State.online;
    }
    public USER(USER user){
        name=user.getName();
        lastName=user.getLastName();
        password=user.getPassword();
        phoneNumber=user.getPhoneNumber();
        state=user.getState();
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
    public State getState() { return state; }
    public void setState(State state) {this.state = state;}
}