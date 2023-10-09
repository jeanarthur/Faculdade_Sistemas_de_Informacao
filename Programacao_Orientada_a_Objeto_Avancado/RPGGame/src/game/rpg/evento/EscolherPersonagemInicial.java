package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.rpg.comando.EscolherGuerreiro;
import game.rpg.comando.EscolherMago;

public class EscolherPersonagemInicial implements Evento {
    @Override
    public boolean executar() throws JogoException {
        System.out.println("Escolha seu personagem:");
        gerenciadorDeComandos.limparComandos();
        gerenciadorDeComandos.registrarComando("Guerreiro", new EscolherGuerreiro(), true);
        gerenciadorDeComandos.registrarComando("Mago", new EscolherMago(), true);
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis());
        return false;
    }
}
