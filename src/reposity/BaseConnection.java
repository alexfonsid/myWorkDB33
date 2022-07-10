package reposity;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseConnection {
    protected Connection getConnection() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(properties.getProperty("driver-class-name"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");

        try {
            return DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
