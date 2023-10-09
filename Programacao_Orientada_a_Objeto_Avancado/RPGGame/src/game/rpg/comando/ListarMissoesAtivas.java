package game.rpg.comando;

import game.core.abstraction.Comando;
import game.rpg.evento.ExibirMissoesAtivas;

public class ListarMissoesAtivas implements Comando {
    @Override
    public void executar() {
        gerenciadorDeEventos.adicionarEvento(new ExibirMissoesAtivas(), 1);
    }
}
