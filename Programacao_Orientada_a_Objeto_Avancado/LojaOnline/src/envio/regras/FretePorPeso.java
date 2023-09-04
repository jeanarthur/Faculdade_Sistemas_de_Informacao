package envio.regras;

import envio.Produto;

public class FretePorPeso implements IRegraDeCalculo{
    @Override
    public double calcular(Produto produto) {
        return produto.getPeso() / 1000 * 90.77 / 54;
    }
}
