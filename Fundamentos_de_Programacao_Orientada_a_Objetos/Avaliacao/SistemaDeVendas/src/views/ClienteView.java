package views;

import models.PessoaFisica;
import models.PessoaJuridica;
import services.PessoaFisicaService;
import services.PessoaJuridicaService;

import java.util.Scanner;

public class ClienteView {

    private static Scanner scanner;

    public ClienteView(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
    }

    public void exibir(){
        while (true){
            System.out.println("   - Gestão de Clientes -");
            System.out.println(" 1. Cadastrar ");
            System.out.println(" 0. Sair");
            System.out.println("--------------------------");
            System.out.println("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1 -> cadastrar();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente!");
            }

        }
    }

    public void cadastrar(){
        while (true) {
            System.out.println("Selecione o tipo do cliente:");
            System.out.println(" 1. Pessoa Fisica");
            System.out.println(" 2. Pessoa Juridica");
            System.out.println("--------------------------");
            System.out.println("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cpf:");
                    String cpf = scanner.nextLine();

                    PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
                    pessoaFisicaService.create(new PessoaFisica(nome, cpf));
                    return;
                }
                case 2 -> {
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cnpj:");
                    String cnpj = scanner.nextLine();

                    PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
                    pessoaJuridicaService.create(new PessoaJuridica(nome, cnpj));
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente!");
            }

        }
    }

}
