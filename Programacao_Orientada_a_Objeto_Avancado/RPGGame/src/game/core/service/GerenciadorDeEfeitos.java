package game.core.service;

import game.core.abstraction.Usavel;
import game.core.abstraction.Efeito;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeEfeitos {

    private static Map<Efeito, Usavel> proprietarios;

    public GerenciadorDeEfeitos(){
        if (proprietarios == null)
            proprietarios = new HashMap<>();
    }

    public Usavel getProprietario(Efeito efeito){
        return proprietarios.get(efeito);
    }

    public void registrarPropriedade(Usavel proprietario, Efeito propriedade){
        proprietarios.put(propriedade, proprietario);
    }

    public void removerPropriedade(Efeito propriedade){
        proprietarios.remove(propriedade);
    }
}
