import model.Department;
import model.PC;
import reposity.DepartmentRepository;
import reposity.PCRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        String filePC = "D:/Java/sqlData/filePC.csv";
        String fileDepartment = "D:/Java/sqlData/fileDepartment.csv";
        String fileCabinet = "D:/Java/sqlData/fileCabinet.csv";
        String fileMonitor = "D:/Java/sqlData/fileMonitor.csv";

        ArrayList<String[]> dataPC = dataFromFile(filePC);
        ArrayList<String[]> dataDepartment = dataFromFile(fileDepartment);


        PC pc = new PC();
        PCRepository pcRepository = new PCRepository();
        for (String[] currWord : dataDepartment) {
            for (String thisWord : currWord) {
                administration.setName(thisWord);
                pcRepository.create(administration);
            }
        }

        Department department = new Department();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        for (String[] currWord : dataDepartment) {
            for (String thisWord : currWord) {
                department.setName(thisWord);
                departmentRepository.create(department);
            }
        }
    }

    public static ArrayList<String[]> dataFromFile(String wayOfFile) throws IOException {
        FileInputStream filePC = new FileInputStream(wayOfFile);
        int fileLength = filePC.available();

        byte[] data = new byte[fileLength];
        filePC.read(data);
        String filePCData = new String(data);

        ArrayList<String[]> lineWords = new ArrayList<>();
        String[] strings = filePCData.split("\n");
        for (String line : strings) {
            String[] words = line.split(";");
            lineWords.add(words);
        }
        return lineWords;
    }
}
