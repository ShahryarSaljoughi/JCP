/**
 * Created by panizava on 23/07/2016.
 */
import java.sql.*;

public class DatabaseDriver {
    private Statement stat;
    private PreparedStatement pstate;
    private Connection conn;
    //constructor :
    public DatabaseDriver() throws SQLException{
        conn = connect();
        stat=conn.createStatement();
    }

    public void addUser(USER user) throws SQLException{
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
    //    stat.close();
    }
    public void addFriendship(USER user1,USER user2)
            throws SQLException{
        String SqlCommand;
        SqlCommand = "INSERT OR IGNORE INTO friends VALUES (?,?)";
        pstate = conn.prepareStatement(SqlCommand);
        pstate.setString(1,user1.getPhoneNumber());
        pstate.setString(2,user2.getPhoneNumber());
        pstate.execute();
    //    pstate.close();
    }

    private Connection connect() throws SQLException {
            // db parameters
            String url;
            url = "jdbc:sqlite:E:/javaChatProject/database/DB";
            // create a connection to the database and returns it!
            conn = DriverManager.getConnection(url);
            return conn;
    }
}


