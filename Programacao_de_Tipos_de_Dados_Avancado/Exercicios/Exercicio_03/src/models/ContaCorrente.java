// Codigo base obtido em <https://github.com/univas/2023-OO/tree/main/Encapsulamento/src/models> [14/05/2023]
package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;

public class ContaCorrente {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static ArrayList<ContaCorrente> contas = new ArrayList<>();
    private String titular;
    private double saldo;
    private String cpf;
    private String cartao;
    private String senha;
    private double cheque_especial;
    private double limite_cartao;
    private int numero;
    private String agencia;
    private String[] chave_pix;
    private double juros_cheque = .2;
    private ArrayList<String> extrato;
    private double valorEmJuizo;

    public ContaCorrente(String titular, String cpf, String senha) {
        this.titular = titular;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = 0;
        this.cheque_especial = 0;
        this.limite_cartao = 0;
        this.extrato = new ArrayList<>();

        this.agencia = "0001";
        this.numero = (int)(1000000 * Math.random()) + 1000;
        contas.add(this);
    }

    public double getSaldo() {
        return this.saldo;
    }
    public double getChequeEspecialTotal() {
        return (this.saldo < 0) ? this.cheque_especial + Math.abs(this.saldo) : this.cheque_especial;
    }

    public double getChequeEspecialAtual() {
        return this.cheque_especial;
    }

    public void setChequeEspecial(double cheque_especial) {
        this.cheque_especial = cheque_especial;
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    @Override
    public String toString(){
        String format = """
                Titular: %s
                CPF: %s
                Numero: %d
                Agencia: %s
                Saldo: %.2f
                Chaves pix: %s
                Cartao: %s
                Limite do Cartao: %.2f
                Cheque Especial: %.2f
                Juros Cheque: %.2f
                Valor em Juizo: %.2f
                """;

        return String.format(format,
                this.titular,
                this.cpf,
                this.numero,
                this.agencia,
                this.saldo,
                Arrays.toString(this.chave_pix),
                this.cartao,
                this.limite_cartao,
                this.cheque_especial,
                this.juros_cheque,
                this.valorEmJuizo);
    }

    public String getTitular(){
        return String.format("%s[%s]", this.titular, this.cpf);
    }

    public void getExtrato(){
        for (String operacao : this.extrato){
            System.out.println(operacao);
        }
    }

    public void depositar(double valor) {
        if(this.saldo < 0) {
            valor += this.saldo * (this.juros_cheque);
            this.cheque_especial += (valor - (this.saldo*-1));
        }

        // Se tiver valorEmJuizo, desconta esse valor do deposito
        if (this.valorEmJuizo > 0){
            if (this.valorEmJuizo >= valor){
                this.valorEmJuizo -= valor;
                valor = 0;
            } else {
                valor -= this.valorEmJuizo;
                this.valorEmJuizo = 0;
            }
        }

        this.saldo += valor;

        this.extrato.add(String.format("[%s] Deposito R$%.2f", LocalDateTime.now().format(formatter), valor));
    }

    public void sacar(double valor) {
        // verificar se o saldo + cheque permite o saque
        if(this.saldo + this.cheque_especial >= valor) {
            if(this.saldo < valor) {
                this.cheque_especial -= (valor - this.saldo);
            }

            this.saldo -= valor;
            
            this.extrato.add(String.format("[%s] Saque R$%.2f", LocalDateTime.now().format(formatter), valor));
        }else {
            System.out.println("Nao pode sacar");
        }
    }

    public void transferir(String agencia, int numero, double valor) {
        if (valor > 0 && this.saldo >= valor){
            ContaCorrente contaDestino;
            boolean contaLocalizada = false;
            for (ContaCorrente conta : ContaCorrente.contas){
                if (conta.agencia.equals(agencia) && conta.numero == numero){
                    contaLocalizada = true;
                    this.saldo -= valor;
                    conta.depositar(valor);
                    
                    this.extrato.add(String.format("[%s] Transferencia R$%.2f", LocalDateTime.now().format(formatter), valor));
                    break;
                }
            }
            if (!contaLocalizada){
                System.out.println("A conta destino nao foi localizada.");
            }
        } else {
            System.out.println("Erro ao transferir!");
        }
    }

    public void transferirPix(String pix, double valor) {
        if (valor > 0 && this.saldo >= valor){
            ContaCorrente contaDestino;
            boolean contaLocalizada = false;
            for (ContaCorrente conta : ContaCorrente.contas){
                for(String chave : conta.chave_pix){
                    if (chave.equals(pix)){
                        contaLocalizada = true;
                        this.saldo -= valor;
                        conta.depositar(valor);
                        
                        this.extrato.add(String.format("[%s] Transferencia R$%.2f", LocalDateTime.now().format(formatter), valor));
                        break;
                    }
                }
            }
            if (!contaLocalizada){
                System.out.println("A conta destino nao foi localizada.");
            }
        } else {
            System.out.println("Erro ao transferir!");
        }
    }
}