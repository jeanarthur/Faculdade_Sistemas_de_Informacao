package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.rpg.comando.Desligar;
import game.rpg.comando.NovoJogo;

public class InicializarJogo implements Evento {
    @Override
    public boolean executar() throws JogoException {
        // Define os comandos ativos para o menu inicial
        gerenciadorDeComandos.registrarComando("Novo Jogo", new NovoJogo(), true);
        gerenciadorDeComandos.registrarComando("Sair", new Desligar(), true);

        // Adiciona o evento para abrir menu inicial
        gerenciadorDeEventos.adicionarEvento(new AbrirMenuInicial());
        return false;
    }
}
