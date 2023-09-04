package envio;

import envio.regras.IRegraDeCalculo;

public class CalculadoraDeFrete {

    public double calcular(IRegraDeCalculo regraDeCalculo, Produto produto){
        return regraDeCalculo.calcular(produto);
    }

}
