/**
 * Created by panizava on 23/07/2016.
 */
import java.sql.*;

public class DatabaseDriver {
    private static final Connection conn;
    static{
        try {
            conn = connect();
            System.out.println("connection is made");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("could not make connectivity . sorry  for that");
        }
    }
    public DatabaseDriver(){}

    public static boolean userExists(USER user) throws SQLException {
        System.out.println("userExists is running");

        String SqlCommand;
        SqlCommand = "SELECT phonenumber FROM users WHERE phonenumber = ?";
        PreparedStatement stat;
        stat = conn.prepareStatement(SqlCommand);
        stat.setString(1, user.getPhoneNumber());
        boolean hasResult =stat.execute();
        ResultSet result;
        result = stat.getResultSet();
        boolean a = result.next();
        result.close();
        return a;

        /*if (hasResult){
            result = stat.getResultSet();
            boolean a = result.next();
            result.close();
            System.out.println(a);
            return a;
        }
        else{
            System.out.println("there is no result - text just for test");
        }*/
    }

    public static void addUser(USER user) throws SQLException{
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
    public static void addFriendship(USER user1,USER user2)
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