import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Exercício 1
        try {
            System.out.print("Digite uma palavra: ");
            System.out.println(Methods.fillStringUntilLimit(scanner.nextLine(), "_", 40));
        } catch (Exception exception){ System.out.println("\u001B[31m" + exception.getMessage() + "\u001B[0m"); }

        // Exercício 2
        try {
            System.out.print("Digite uma data no formato (dd/mm/aaaa): ");
            System.out.println(Methods.convertDateToTextFormat(scanner.nextLine()));
        } catch (Exception exception){ System.out.println("\u001B[31m" + exception.getMessage() + "\u001B[0m"); }

        // Exercício 3
        try {
            System.out.print("Digite uma palavra: ");
            System.out.println(Methods.upperAllVowels(scanner.nextLine()));
        } catch (Exception exception){ System.out.println("\u001B[31m" + exception.getMessage() + "\u001B[0m"); }

        // Exercício 4
        try {
            System.out.print("Digite um cpf: ");
            System.out.println((Methods.isValidCPF(scanner.nextLine()))?"CPF valido!":"CPF invalido!");
        } catch (Exception exception){ System.out.println("\u001B[31m" + exception.getMessage() + "\u001B[0m"); }

        // Exercício 5
        try {
            System.out.print("Digite uma palavra:");
            System.out.printf("A palavra possui %d vogais!\n", Methods.countVowels(scanner.nextLine()));
        } catch (Exception exception){ System.out.println("\u001B[31m" + exception.getMessage() + "\u001B[0m"); }

    }

}
