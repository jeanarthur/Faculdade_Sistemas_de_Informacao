public class Sal3000Desc10ou20 implements RegraCalculo{

    public double calcular(Funcionario funcionario){
        if(funcionario.getSalario() > 3000){
            return funcionario.getSalario() * 0.8;
        }
        return funcionario.getSalario() * 0.9;
    }

}
