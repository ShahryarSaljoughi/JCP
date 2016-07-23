/**
 * Created by panizava on 23/07/2016.
 */
import java.sql.*;

public class DatabaseDriver {
    private Statement stat;
    private Connection conn;

    public DatabaseDriver() throws SQLException{
        conn = connect();
        stat=conn.createStatement();
    }

    public void addUser(USER user) throws SQLException{
        String SqlCommand;
        SqlCommand = "insert into users (name ,lastname ,password ,phonenumber) values "+
                "("+
                "\'" + user.getName()+"\'" +","+
                "\'" +user.getLastName() +"\'"  +","+
                "\'" +user.getPassword()+"\'"  +","+
                "\'" +user.getPhoneNumber()  +"\'"
                +")";
        System.out.println(SqlCommand); //this will be erased
        stat.execute(SqlCommand);

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


