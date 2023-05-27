package services;

import models.Produto;

import java.util.ArrayList;

public class GerencidorProdutos {

    ArrayList<Produto> produtos;

    public GerencidorProdutos(){
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        if (!produtos.contains(produto)){
            produtos.add(produto);
        }
    }

    public void removerProduto(int id){
        for (Produto produto : new ArrayList<>(produtos)){
            if (produto.getId() == id){
                produtos.remove(produto);
                break;
            }
        }
    }

    public ArrayList<Produto> listarProdutos(){
        return new ArrayList<>(produtos);
    }

}
