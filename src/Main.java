import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream filePC = new FileInputStream("D:/Java/sqlData/filePC.csv");
        int fileLength = filePC.available();

        byte[] data = new byte[fileLength];
        filePC.read(data);
        ArrayList<String[]> lineWords = new ArrayList<>();
        String filePCData = new String(data);
        String[] strings = filePCData.split("\n");
        for (String line : strings) {
            String[] words = line.split(";");
            lineWords.add(words);
        }
        for (String[] currWord : lineWords) {
            for (String thisWord : currWord) {
                System.out.println(thisWord);
            }
        }
//        System.out.println(filePCData);
    }
}
