// Código base obtido em <https://github.com/univas/2023-OO/tree/main/Encapsulamento/src> [14/05/2023]

import models.ContaCorrente;

public class Principal {

    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente("Joelha", "403.576.040-40", "12345");
        ContaCorrente conta2 = new ContaCorrente("Abizagui", "868.376.120-77", "54321");

        System.out.println(conta1.getTitular());
        conta1.depositar(1000);
        conta1.sacar(300);
        conta1.setChequeEspecial(200);
        conta1.transferir(conta2.getAgencia(), conta2.getNumero(), 700);
        conta1.sacar(100);
        conta1.sacar(200);
        conta1.depositar(300); //Nao pode sacar

        System.out.println("\n-----CONTAS e EXTRATOS-----");
        System.out.println(conta1.toString());
        conta1.getExtrato();
        System.out.println("--------\n");

        System.out.println(conta2.getTitular());
        conta2.sacar(300);
        conta2.depositar(100);
        System.out.println(conta2.toString());
        conta2.getExtrato();

    }

}
