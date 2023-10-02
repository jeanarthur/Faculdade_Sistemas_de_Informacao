package envio;

public class Produto {

    private String nome;
    private double peso;
    private double tamanho;

    public Produto(String nome, double peso, double tamanho){
        this.nome = nome;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public double getTamanho() {
        return tamanho;
    }
}
