package services;

import models.Venda;

import java.util.ArrayList;
import java.util.UUID;

public class VendaService {

    private static ArrayList<Venda> dados;

    public VendaService(){
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    public void create(Venda venda){
        dados.add(venda.clone());
    }

    public ArrayList<Venda> read(){
        return new ArrayList<>(dados);
    }

    public Venda read(String id){
        for (Venda venda : dados){
            if (venda.getId().equals(id)){
                return venda;
            }
        }
        return null;
    }

    public boolean delete(String id){
        for (Venda venda : new ArrayList<>(dados)){
            if (venda.getId().equals(id)){
                dados.remove(venda);
                return true;
            }
        }
        return false;
    }

    public boolean update(Venda venda){
        for (Venda pJ : new ArrayList<>(dados)){
            if (pJ.equals(venda)){
                delete(venda.getId());
                create(venda);
                return true;
            }
        }
        return false;
    }

    public String gerarRelatorio(){
        double valorTotalVendido = 0;
        for (Venda venda : dados){
            valorTotalVendido += venda.getValorTotal();
        }
        double valorMedioPorVenda = valorTotalVendido / dados.size();
        return String.format("Valor total vendido: R$%.2f\nValor médio por venda: R$%.2f", valorTotalVendido, valorMedioPorVenda);
    }
    
}
