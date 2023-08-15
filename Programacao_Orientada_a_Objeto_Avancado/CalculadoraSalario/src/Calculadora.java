public class Calculadora {

    public double calcularSalario(Funcionario funcionario){
        return funcionario.getCargo().calcular(funcionario);
    }

}
