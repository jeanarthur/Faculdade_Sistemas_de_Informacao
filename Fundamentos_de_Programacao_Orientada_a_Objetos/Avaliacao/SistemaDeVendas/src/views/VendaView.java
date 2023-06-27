package views;

import models.Venda;
import services.PessoaFisicaService;
import services.PessoaJuridicaService;
import services.VendaService;

import java.util.Scanner;

public class VendaView {

    private static Scanner scanner;

    public VendaView(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
    }

    public void exibir(){
        while (true){
            System.out.println("   - Gestão de Clientes -");
            System.out.println(" 1. Vender ");
            System.out.println(" 2. Gerar Relatorio");
            System.out.println(" 0. Sair");
            System.out.println("--------------------------");
            System.out.println("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1 -> vender();
                case 2 -> gerarRelatorio();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente!");
            }

        }
    }

    public void vender(){
        while (true){
            System.out.println("Selecione o tipo do cliente:");
            System.out.println(" 1. Pessoa Fisica");
            System.out.println(" 2. Pessoa Juridica");
            System.out.println("--------------------------");
            System.out.println("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o cpf:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o nome do produto:");
                    String nomeDoProduto = scanner.nextLine();
                    System.out.println("Digite o valor unitário: ");
                    double valorUnitario = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a quantidade: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());

                    VendaService vendaService = new VendaService();
                    PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
                    vendaService.create(new Venda(pessoaFisicaService.read(cpf), nomeDoProduto, valorUnitario, quantidade));
                    return;
                }
                case 2 -> {
                    System.out.println("Digite o cnpj:");
                    String cnpj = scanner.nextLine();
                    System.out.println("Digite o nome do produto:");
                    String nomeDoProduto = scanner.nextLine();
                    System.out.println("Digite o valor unitário: ");
                    double valorUnitario = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a quantidade: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());

                    VendaService vendaService = new VendaService();
                    PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
                    vendaService.create(new Venda(pessoaJuridicaService.read(cnpj), nomeDoProduto, valorUnitario, quantidade));
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente!");
            }

        }
    }

    public void gerarRelatorio(){
        VendaService vendaService = new VendaService();
        System.out.println(vendaService.gerarRelatorio());
    }

}
