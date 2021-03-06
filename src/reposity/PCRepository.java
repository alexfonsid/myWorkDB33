package reposity;

import model.Department;
import model.PC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PCRepository {
    public void create(PC pc) throws SQLException {
        BaseConnection connectionToBase = new BaseConnection();
        Connection connection = connectionToBase.getConnection();

        String sql = "INSERT INTO pc (name_department) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pc.getSerialNumber());
        statement.execute();
        connection.close();
    }
}
