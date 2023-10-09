package game.core.model;

import game.core.abstraction.Efeito;
import game.core.abstraction.Posicionavel;
import game.core.abstraction.Usavel;
import game.core.service.GerenciadorDeEfeitos;

import java.util.ArrayList;
import java.util.List;

public class Item extends Usavel implements Posicionavel {
    protected String tipo;
    protected List<Efeito> efeitos;

    public Item(String nome, String descricao, String tipo, List<Efeito> efeitos) {
        super(nome, descricao);
        this.tipo = tipo;
        this.efeitos = efeitos;
        registrarEfeitos();
    }

    public Item(String nome, String descricao, String tipo) {
        super(nome, descricao);
        this.tipo = tipo;
        this.efeitos = new ArrayList<>();
    }

    @Override
    public void usar() {
        for (Efeito efeito : efeitos){
            efeito.aplicar();
        }
    }

    private void registrarEfeitos(){
        GerenciadorDeEfeitos gerenciadorDeEfeitos = new GerenciadorDeEfeitos();
        for (Efeito efeito : efeitos){
            gerenciadorDeEfeitos.registrarPropriedade(this, efeito);
        }
    }

    public List<Efeito> getEfeitos() {
        return efeitos;
    }

    public String getTipo() {
        return tipo;
    }
}
