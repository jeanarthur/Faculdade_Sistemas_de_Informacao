package views;

import java.util.Scanner;

public class MenuView {

    private static Scanner scanner;

    public MenuView(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
    }

    public void exibir(){
        while (true){
            System.out.println("   - Gestão do Comércio -");
            System.out.println(" 1. Gerenciar Vendas ");
            System.out.println(" 2. Gerenciar Clientes");
            System.out.println(" 0. Encerrar");
            System.out.println("--------------------------");
            System.out.println("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1 -> {
                    VendaView vendaView = new VendaView();
                    vendaView.exibir();
                }
                case 2 -> {
                    ClienteView clienteView = new ClienteView();
                    clienteView.exibir();
                }
                case 0 -> {
                    System.out.println("Programa encerrado!");
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente!");
            }
        }

    }

}
