package views;

import models.Produto;
import services.GerencidorProdutos;

public class InterfacePrincipal {

    public static void main(String[] args) {
        GerencidorProdutos gerencidorProdutos = new GerencidorProdutos();

        Produto geladeira = new Produto("Geladeira", 3369.50);
        Produto fogao = new Produto("Fogao", 1139.99);

        gerencidorProdutos.adicionarProduto(geladeira);
        gerencidorProdutos.adicionarProduto(fogao);

        System.out.println(gerencidorProdutos.listarProdutos());

        gerencidorProdutos.removerProduto(0);
        System.out.println(gerencidorProdutos.listarProdutos());
    }

}
