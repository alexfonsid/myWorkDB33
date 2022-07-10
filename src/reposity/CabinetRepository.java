package reposity;

import model.Cabinet;
import model.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CabinetRepository {
    public void create(Cabinet cabinet) throws SQLException {
        BaseConnection connectionToBase = new BaseConnection();
        Connection connection = connectionToBase.getConnection();

        String sql = "INSERT INTO " +
                "cabinet(name_cabinet, number_cabinet, floor_cabinet, id_department_cabinet) " +
                "VALUES (?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cabinet.getName());
        statement.setInt(2, cabinet.getNumber());
        statement.setInt(3, cabinet.getFloor());
        statement.setString(4, cabinet.getDepartment(""));
        statement.execute();
        connection.close();
    }

}
