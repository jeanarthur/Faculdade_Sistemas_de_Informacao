package game.rpg.comando;

import game.core.abstraction.Comando;
import game.core.abstraction.Jogo;
import game.rpg.RPG;

public class Desligar implements Comando {
    @Override
    public void executar() {
        Jogo jogo = new RPG();
        jogo.finalizar();
        gerenciadorDeEventos.limparEventos();
    }
}
