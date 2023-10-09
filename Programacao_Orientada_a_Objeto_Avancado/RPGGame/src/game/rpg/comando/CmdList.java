package game.rpg.comando;

import game.core.abstraction.Comando;
import game.rpg.evento.ListarComandosDisponiveis;


public class CmdList implements Comando {
    public void executar() {
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis(), 0);
    }
}
