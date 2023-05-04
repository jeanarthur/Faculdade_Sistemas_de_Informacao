package Questao_08;

public class Funcionario {

    public String nome;
    public String cargo;
    public Double salario;

    public void imprimir(){
        System.out.printf("Nome: %s | Cargo: %s | Salário: %.2f\n", this.nome, this.cargo, this.salario);
    }

}
