package envio;

import envio.regras.FretePorPeso;
import envio.regras.FretePorTamanho;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Geladeira", 54000, 159));
        produtos.add(new Produto("Smartphone", 195, 17));
        produtos.add(new Produto("Furadeira", 900, 18.5));

        for (Produto produto : produtos) {
            CalculadoraDeFrete calculadoraDeFrete = new CalculadoraDeFrete(new FretePorPeso());
            System.out.printf("Frete (por peso) para %s: R$%.2f\n", produto.getNome(), calculadoraDeFrete.calcular(produto));

            calculadoraDeFrete.setRegraDeCalculo(new FretePorTamanho());
            System.out.printf("Frete (por tamanho) para %s: R$%.2f\n", produto.getNome(), calculadoraDeFrete.calcular(produto));
        }
    }

}
