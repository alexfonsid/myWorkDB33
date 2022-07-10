import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePC = "D:/Java/sqlData/filePC.csv";
        String fileDepartment = "D:/Java/sqlData/fileDepartment.csv";
        String fileCabinet = "D:/Java/sqlData/fileCabinet.csv";
        String fileMonitor = "D:/Java/sqlData/fileMonitor.csv";

        ArrayList<String[]> dataPC = DataFromFile(filePC);

        for (String[] currWord : dataPC) {
            for (String thisWord : currWord) {
                System.out.println(thisWord);
            }
        }
    }

    public static ArrayList<String[]> DataFromFile(String wayOfFile) throws IOException {

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
