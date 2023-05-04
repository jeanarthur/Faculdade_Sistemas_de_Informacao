package Questao_10;

public class Cliente {

    public String nome;
    public String endereco;
    public int telefone;

    public void imprimir(){
        System.out.printf("Nome: %s | Endereço: %s | Telefone: %d\n", this.nome, this.endereco, this.telefone);
    }

}
