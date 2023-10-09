package game.rpg.comando;

import game.core.abstraction.Ator;
import game.core.abstraction.Comando;
import game.rpg.evento.AvaliarBatalha;
import game.rpg.evento.ListarItens;

public class UsarItem implements Comando {

    private Ator oponente;

    public UsarItem(Ator oponente) {
        this.oponente = oponente;
    }

    @Override
    public void executar() {
        gerenciadorDeEventos.adicionarEvento(new ListarItens(), 0);
        gerenciadorDeEventos.adicionarEvento(new AvaliarBatalha(this.oponente), 1);
    }
}
