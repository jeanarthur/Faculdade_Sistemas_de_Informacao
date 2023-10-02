package envio;

import envio.regras.IRegraDeCalculo;

public class CalculadoraDeFrete {
    private IRegraDeCalculo regraDeCalculo;

    public CalculadoraDeFrete(IRegraDeCalculo regraDeCalculo){
        this.regraDeCalculo  = regraDeCalculo;
    }

    public double calcular(Produto produto){
        return regraDeCalculo.calcular(produto);
    }

    public IRegraDeCalculo getRegraDeCalculo() {
        return regraDeCalculo;
    }

    public void setRegraDeCalculo(IRegraDeCalculo regraDeCalculo) {
        this.regraDeCalculo = regraDeCalculo;
    }
}
