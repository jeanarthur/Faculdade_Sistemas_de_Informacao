package models;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private static int quantidadeTotal = 0;

    public Produto(String nome, double preco){
        this.id = quantidadeTotal++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return String.format("ID: %d\nNome: %s\nPreco: %.2f", this.id, this.nome, this.preco);
    }

    @Override
    public boolean equals(Object o){
        Produto produto = (Produto) o;
        return this.id == produto.getId();
    }

}
