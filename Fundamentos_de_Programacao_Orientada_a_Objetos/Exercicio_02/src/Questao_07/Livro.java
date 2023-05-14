package Questao_07;

public class Livro {

    public String titulo;
    public String autor;
    public int ano;

    public void imprimir(){
        System.out.printf("Título: %s | Autor: %s | Ano: %s\n", this.titulo, this.autor, this.ano);
    }

}
