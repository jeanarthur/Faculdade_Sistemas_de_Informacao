package polygon.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // carrega o mapa de opções de polígonos, cada um com nome e cálculo
        Polygon.loadOptions();

        // loop principal, roda o programa até o usuário sair (digitar 9)
        do{
            ConsoleManager.printMenu();
            int choice = ConsoleManager.getChoice();

            if (choice == 9){
                ConsoleManager.printErrorMessage("\n Programa encerrado!");
                break;
            }
            else if (Polygon.polygonOptions.get(choice) != null){
                Polygon polygon = Polygon.polygonOptions.get(choice);
                ConsoleManager.printPolygonCalculation(polygon);
            }
            else {
                ConsoleManager.printErrorMessage("Opção inválida! Por favor, digite uma opção correta!");
            }

        } while (true);

    }
}
