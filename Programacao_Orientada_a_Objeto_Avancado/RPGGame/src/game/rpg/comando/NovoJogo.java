package game.rpg.comando;

import game.core.abstraction.Comando;
import game.rpg.evento.EscolherPersonagemInicial;

public class NovoJogo implements Comando {
    @Override
    public void executar() {
        gerenciadorDeEventos.adicionarEvento(new EscolherPersonagemInicial());
    }
}
