package game.rpg.comando;

import game.core.abstraction.Comando;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.evento.IniciarAventura;

public class EscolherGuerreiro implements Comando {
    @Override
    public void executar() {
        RPG.setPersonagemAtivo(new Personagem("Guerreiro", 1.0, 10.0, 5.0));
        gerenciadorDeEventos.adicionarEvento(new IniciarAventura());
    }
}
