package Questao_02;

public class ContaBancaria {

    public Double saldo;
    public String titular;

    public void sacar(Double valorDoSaque){
        this.saldo -= valorDoSaque;
    }

    public void deposito(Double valorDoDeposito){
        this.saldo += valorDoDeposito;
    }
}
