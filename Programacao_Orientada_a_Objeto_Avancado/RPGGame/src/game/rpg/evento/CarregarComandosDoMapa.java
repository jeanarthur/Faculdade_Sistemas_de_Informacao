package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.rpg.comando.*;
import game.rpg.comando.MoverParaBaixo;
import game.rpg.comando.MoverParaCima;
import game.rpg.comando.MoverParaDireita;
import game.rpg.comando.MoverParaEsquerda;

public class CarregarComandosDoMapa implements Evento {
    @Override
    public boolean executar() throws JogoException {
        gerenciadorDeComandos.limparComandos();
        gerenciadorDeComandos.registrarComando("w", "Mover para cima", new MoverParaCima(), true);
        gerenciadorDeComandos.registrarComando("a","Mover para esquerda", new MoverParaEsquerda(), true);
        gerenciadorDeComandos.registrarComando("s", "Mover para baixo", new MoverParaBaixo(), true);
        gerenciadorDeComandos.registrarComando("d","Mover para direita", new MoverParaDireita(), true);
        gerenciadorDeComandos.registrarComando("m", "Missões ativas", new ListarMissoesAtivas(), true);
        gerenciadorDeComandos.registrarComando("0", "Desligar", new Desligar(), true);

        return false;
    }
}
