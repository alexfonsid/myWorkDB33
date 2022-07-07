import model.Department;
import reposity.PCRepository;

import java.sql.SQLException;

public class ReposityUsage {
    public static void main(String[] args) throws SQLException {
        PCRepository pcRepository = new PCRepository();
        Department administration = new Department();
        administration.setName("AD");
        pcRepository.create(administration);


    }
}
