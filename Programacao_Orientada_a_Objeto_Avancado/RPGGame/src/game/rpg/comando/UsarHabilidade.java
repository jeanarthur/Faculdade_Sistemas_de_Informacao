package game.rpg.comando;

import game.core.abstraction.Ator;
import game.core.abstraction.Comando;
import game.rpg.evento.AvaliarBatalha;
import game.rpg.evento.ListarHabilidades;

public class UsarHabilidade implements Comando {
    private Ator oponente;

    public UsarHabilidade(Ator oponente) {
        this.oponente = oponente;
    }

    @Override
    public void executar() {
        gerenciadorDeEventos.adicionarEvento(new ListarHabilidades(), 0);
        gerenciadorDeEventos.adicionarEvento(new AvaliarBatalha(this.oponente), 1);
    }
}
