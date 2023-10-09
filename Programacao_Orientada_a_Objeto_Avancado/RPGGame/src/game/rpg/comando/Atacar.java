package game.rpg.comando;

import game.core.abstraction.Ator;
import game.core.abstraction.Comando;

public class Atacar implements Comando {
    private Ator oponente;

    public Atacar(Ator oponente) {
        this.oponente = oponente;
    }

    @Override
    public void executar() {
        gerenciadorDeEventos.adicionarEvento(new game.rpg.evento.Atacar(this.oponente), 0);
    }
}
