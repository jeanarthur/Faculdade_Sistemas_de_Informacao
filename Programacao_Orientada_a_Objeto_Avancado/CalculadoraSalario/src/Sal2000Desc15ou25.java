public class Sal2000Desc15ou25 implements RegraCalculo{

    public double calcular(Funcionario funcionario){
        if(funcionario.getSalario() > 2000){
            return funcionario.getSalario() * 0.75;
        }
        return funcionario.getSalario() * 0.85;
    }

}
