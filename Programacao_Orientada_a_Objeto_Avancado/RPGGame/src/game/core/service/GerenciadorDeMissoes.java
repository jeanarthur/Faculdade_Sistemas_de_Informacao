package game.core.service;

import game.core.abstraction.Ator;
import game.core.model.Missao;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeMissoes {

    private static Map<Missao, Ator> responsaveis;

    public GerenciadorDeMissoes(){
        if (responsaveis == null)
            responsaveis = new HashMap<>();
    }

    public Ator getResponsavel(Missao missao){
        return responsaveis.get(missao);
    }

    public void registrarCompromisso(Ator responsavel, Missao missao){
        responsaveis.put(missao, responsavel);
    }

    public void encerrarCompromisso(Missao missao){
        responsaveis.remove(missao);
    }

}
