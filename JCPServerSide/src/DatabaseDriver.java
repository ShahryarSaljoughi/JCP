/**
 * Created by panizava on 23/07/2016.
 */
import java.sql.*;

public class DatabaseDriver {
    private static final Connection conn;
    static{
        try {
            conn = connect();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("could not make connectivity . sorry  for taht");
        }
    }
    public DatabaseDriver(){}
    public void addUser(USER user) throws SQLException{
        //Connection conn = connect();
        Statement stat = conn.createStatement();
        String SqlCommand;
        SqlCommand = "insert or  ignore into users (name ,lastname ,password ,phonenumber) values "+
                "("+
                "\'" + user.getName()+"\'" +","+
                "\'" +user.getLastName() +"\'"  +","+
                "\'" +user.getPassword()+"\'"  +","+
                "\'" +user.getPhoneNumber()  +"\'"
                +")";
        System.out.println(SqlCommand); //this will be erased
        stat.execute(SqlCommand);
        stat.close();
       // conn.close();
    }
    public void addFriendship(USER user1,USER user2)
            throws SQLException{
        //Connection conn = connect();
        PreparedStatement pstate;
        String SqlCommand;
        SqlCommand = "INSERT OR IGNORE INTO friends VALUES (?,?)";
        pstate = conn.prepareStatement(SqlCommand);
        pstate.setString(1,user1.getPhoneNumber());
        pstate.setString(2,user2.getPhoneNumber());
        pstate.execute();
        pstate.close();
        //conn.close();
    }

    private static Connection connect() throws SQLException {
        // db parameters
        String url;
        url = "jdbc:sqlite:E:/javaChatProject/database/DB";
        // create a connection to the database and returns it!
        Connection conn;
        conn = DriverManager.getConnection(url);
        return conn;
    }
}