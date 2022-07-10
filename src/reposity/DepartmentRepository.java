package reposity;

import model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentRepository {
    public void create(Department department) throws SQLException {
        BaseConnection connectionToBase = new BaseConnection();
        Connection connection = connectionToBase.getConnection();

        String sql = "INSERT INTO department (name_department) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, department.getName());
        statement.execute();
        connection.close();
    }
}
