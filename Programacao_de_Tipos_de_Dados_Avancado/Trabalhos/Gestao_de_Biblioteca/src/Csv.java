import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    public static void write(List<String[]> data, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("Programacao_de_Tipos_de_Dados_Avancado/Trabalhos/Gestao_de_Biblioteca/reports/" + fileName + ".csv");
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

    public static List<String[]> read(String fileName) {
        List<String[]> data = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("Programacao_de_Tipos_de_Dados_Avancado/Trabalhos/Gestao_de_Biblioteca/reports/" + fileName + ".csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
