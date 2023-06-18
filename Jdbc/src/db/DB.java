package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    
    private static Connection conn = null;

   

  public static Connection getConnection() throws ClassNotFoundException, SQLException {

         Class.forName("com.mysql.cj.jdbc.Driver");

             if (conn == null) {

                 Properties props = loadProperties();

                 String url = props.getProperty("url");

                 String user = props.getProperty("user");

                 String pass = props.getProperty("pass");

                 conn = DriverManager.getConnection(url, user, pass);

             }
            return conn;

         }

    public static void closeConnection() {
        if(conn != null) {
            try {
                    conn.close();
            }
            catch(SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }




    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e) {
            throw new DbException(e.getMessage());
        }
    }

}

