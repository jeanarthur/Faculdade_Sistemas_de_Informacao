package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.JogoException;

public class IniciarAventura implements Evento {
    @Override
    public boolean executar() throws JogoException {
        gerenciadorDeEventos.adicionarEvento(new CarregarMundo());
        gerenciadorDeEventos.adicionarEvento(new ExibirMapa());
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis());
        return false;
    }
}
