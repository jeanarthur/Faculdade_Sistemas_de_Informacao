package game.core.service;

import game.core.abstraction.Ator;
import game.core.abstraction.Usavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeUsaveis {

    private static Map<Usavel, Ator> proprietarios;

    public GerenciadorDeUsaveis(){
        if (proprietarios == null)
            proprietarios = new HashMap<>();
    }

    public Ator getProprietario(Usavel usavel){
        return proprietarios.get(usavel);
    }

    public void registrarPropriedade(Ator proprietario, Usavel propriedade){
        proprietarios.put(propriedade, proprietario);
    }

    public void removerPropriedade(Usavel propriedade){
        proprietarios.remove(propriedade);
    }

}
