import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Csv {

    public static String[] getContent(String path) throws IOException {
        String[] fileContent;

        // abre o arquivo e cria caso não exista.
        File file = new File(path);
        if(file.createNewFile()) {
            // Se criar um arquivo novo já retorna com um vetor vazio.
            return new String[0];
        }

        // obtém tamanho do arquivo e cria o vetor de linhas
        long fileSize = Files.lines(Paths.get(path)).count();

        fileContent = new String[(int)fileSize];
        int count = 0;
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            fileContent[count++] = scan.nextLine();
        }

        scan.close();

        return fileContent;
    }

    public static String[] addRow(String path, String linha) throws IOException {
        String[] newContent;

        // abre o arquivo e/ou cria se não existir
        File file = new File(path);
        file.createNewFile();

        // abre o arquivo de modo a poder adicionar conteúdo
        FileWriter writer = new FileWriter(file, true);

        // escreva a linha desejada e adiciona um salto de linha no arquivo
        writer.write(linha.concat("\n"));
        writer.close();

        newContent = getContent(path);

        return newContent;
    }

    public static String[] removeRow(String path, String linha) throws IOException {
        String[] fileContent = getContent(path);
        if (fileContent.length == 0){ return fileContent; }

        File file = new File(path);
        file.delete();

        for (String line : fileContent){
            if (!line.equals(linha)){
                addRow(path, line);
            }
        }

        return getContent(path);
    }

}
