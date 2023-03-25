import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Csv {

    public static void write(List<String[]> data, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String[] row : data) {
                String line = String.join(",", row);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> read(String path) {
        List<String[]> data = new ArrayList<>();


        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i++ == 0) { continue; }
                String[] row = line.split(",");
                data.add(row);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException){
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
