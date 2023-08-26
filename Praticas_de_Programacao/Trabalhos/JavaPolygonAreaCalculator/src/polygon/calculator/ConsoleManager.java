package polygon.calculator;

import java.util.Scanner;

// classe com métodos estáticos para gerenciar as interações com o console
public class ConsoleManager {

    static Scanner scanner = new Scanner(System.in);

    // Declara constantes para cor de texto no console
    public static final String TEXT_RED = "\u001B[31m";
    //public static final String TEXT_BLACK = "\u001B[30m";
    //public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    //public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    //public static final String TEXT_YELLOW = "\u001B[33m";
    //public static final String TEXT_WHITE = "\u001B[37m";

    // Exibe o menu principal, com as opções disponíveis para o usuário
    public static void printMenu(){
        System.out.println(TEXT_BLUE + "=============== Calculadora de Polígonos ==================" + TEXT_RESET);
        Polygon.printOptions();
        System.out.printf("%4d. Sair\n", 9);
        System.out.println(TEXT_BLUE + "===========================================================" + TEXT_RESET);
    }

    // Solicita ao usuário a entrada de número, referente a uma das opções apresentadas
    public static int getChoice(){
        try {
            System.out.print("Digite o número da opção desejada: ");
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    // Exibe a tela de cálculo, chama o método que solicita a entrada de cada medida necessária
    // e, por fim, imprime o resultado do cálculo
    public static void printPolygonCalculation(Polygon polygon){
        System.out.print(TEXT_CYAN);
        System.out.printf("\n --- Digite a(s) seguinte(s) medida(s) do %s ---\n", polygon.name);
        System.out.print(TEXT_RESET);
        System.out.printf("\tA área do %s é igual a: %.2f\n", polygon.name, polygon.calcArea.get());
        System.out.print(TEXT_CYAN);
        System.out.println(" " + ":".repeat(45 + polygon.name.length()) + "\n");
        System.out.print(TEXT_RESET);
    }

    // Exibe uma mensagem com o texto em vermelho
    public static void printErrorMessage(String errorMessage){
        System.out.println(TEXT_RED + errorMessage + TEXT_RESET);
    }

}
