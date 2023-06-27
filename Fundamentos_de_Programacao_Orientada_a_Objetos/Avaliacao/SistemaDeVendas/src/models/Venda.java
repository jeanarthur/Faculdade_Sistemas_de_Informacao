package models;

import java.util.UUID;

public class Venda {

    private String id;
    private Cliente cliente;
    private String nomeDoProduto;
    private double valorUnitario;
    private int quantidade;

    public Venda(Cliente cliente, String nomeDoProduto, double valorUnitario, int quantidade){
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.nomeDoProduto = nomeDoProduto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getId(){
        return this.id;
    }

    public double getValorTotal(){
        return this.valorUnitario * this.quantidade;
    }

    public Venda clone(){
        return new Venda(this.cliente, this.nomeDoProduto, this.valorUnitario, this.quantidade);
    }

}
