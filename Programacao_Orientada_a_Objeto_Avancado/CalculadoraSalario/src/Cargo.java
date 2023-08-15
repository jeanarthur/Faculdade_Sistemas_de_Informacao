public enum Cargo {

    DESENVOLVEDOR(new Sal3000Desc10ou20()),
    DBA(new Sal2000Desc15ou25()),
    TESTER(new Sal2000Desc15ou25());

    Cargo(RegraCalculo regraCalculo){
        this.regraCalculo = regraCalculo;
    }

    private RegraCalculo regraCalculo;

    double calcular(Funcionario funcionario){
        return this.regraCalculo.calcular(funcionario);
    }

}
