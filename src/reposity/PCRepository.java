package reposity;

import model.Department;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PCRepository {
    private Connection getConnection() {
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

    public void create(Department department) throws SQLException {
        Connection connection = getConnection();

        String sql = "INSERT INTO department (name_department) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, department.getName());

        statement.execute();
        connection.close();
    }

}
