package game.rpg.comando;

import game.core.abstraction.Comando;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.evento.IniciarAventura;

public class EscolherMago implements Comando {
    @Override
    public void executar() {
        RPG.setPersonagemAtivo(new Personagem("Mago", 1.0, 5.0, 10.0));
        gerenciadorDeEventos.adicionarEvento(new IniciarAventura());
    }
}
