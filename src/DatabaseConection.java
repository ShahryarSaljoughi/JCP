import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by panizava on 23/07/2016.
 */
    public class DatabaseConection {
        /**
         * Connect to a sample database
         */
        public static void connect() {
            Connection conn = null;
            try {
                // db parameters
                String url;
                url = "jdbc:sqlite:E:/javaChatProject/database/DB";
                // create a connection to the database
                conn = DriverManager.getConnection(url);

                System.out.println("Connection to SQLite has been established.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }


