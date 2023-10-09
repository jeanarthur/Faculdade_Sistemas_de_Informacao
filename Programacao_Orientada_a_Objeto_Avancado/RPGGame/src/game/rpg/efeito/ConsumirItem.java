package game.rpg.efeito;

import game.core.abstraction.Ator;
import game.core.abstraction.Efeito;
import game.core.abstraction.Usavel;
import game.core.model.Item;
import game.core.model.Personagem;

public class ConsumirItem implements Efeito {
    @Override
    public void aplicar() {
        Usavel usavel = gerenciadorDeEfeitos.getProprietario(this);
        Ator proprietario = gerenciadorDeUsaveis.getProprietario(usavel);
        for (Efeito efeito : ((Item)usavel).getEfeitos()){
            gerenciadorDeEfeitos.removerPropriedade(efeito);
        }
        gerenciadorDeUsaveis.removerPropriedade(usavel);
        ((Personagem)proprietario).getItens().remove(usavel);
    }
}
