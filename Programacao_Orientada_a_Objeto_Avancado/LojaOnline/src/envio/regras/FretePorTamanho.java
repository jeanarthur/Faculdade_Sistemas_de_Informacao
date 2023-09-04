package envio.regras;

import envio.Produto;

public class FretePorTamanho implements IRegraDeCalculo{
    @Override
    public double calcular(Produto produto) {
        return produto.getTamanho() * 90.77 / 172;
    }
}
