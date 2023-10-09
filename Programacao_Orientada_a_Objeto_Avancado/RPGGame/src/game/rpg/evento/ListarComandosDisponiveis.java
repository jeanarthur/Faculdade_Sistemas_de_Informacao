package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.NenhumComandoRegistradoException;
import game.core.service.GerenciadorDeComandos;

public class ListarComandosDisponiveis implements Evento {
    @Override
    public boolean executar() throws NenhumComandoRegistradoException {
        GerenciadorDeComandos gerenciadorDeComandos = new GerenciadorDeComandos();
        for (String comando : gerenciadorDeComandos.getComandosDisponiveis()){
            System.out.printf("\t%s. %s\n", comando, gerenciadorDeComandos.getDescricao(comando));
        }
        System.out.println("Pressione <Enter> para confirmar a ação.");

        gerenciadorDeEventos.adicionarEvento(new ExibirSeparadorDeTela(), 0);
        return true;
    }
}
