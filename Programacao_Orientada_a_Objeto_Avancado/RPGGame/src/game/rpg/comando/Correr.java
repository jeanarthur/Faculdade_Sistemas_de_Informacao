package game.rpg.comando;

import game.core.abstraction.Ator;
import game.core.abstraction.Comando;
import game.rpg.evento.*;
import game.rpg.evento.MoverParaBaixo;
import game.rpg.evento.MoverParaCima;
import game.rpg.evento.MoverParaDireita;
import game.rpg.evento.MoverParaEsquerda;

public class Correr implements Comando {
    public Correr(Ator oponente) {
    }

    @Override
    public void executar() {
        gerenciadorDeEventos.removerEvento(MoverParaBaixo.class.getSimpleName());
        gerenciadorDeEventos.removerEvento(MoverParaCima.class.getSimpleName());
        gerenciadorDeEventos.removerEvento(MoverParaEsquerda.class.getSimpleName());
        gerenciadorDeEventos.removerEvento(MoverParaDireita.class.getSimpleName());

        gerenciadorDeEventos.adicionarEvento(new VerificarMissoes());
        gerenciadorDeEventos.adicionarEvento(new ExibirMapa());
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis());
    }
}
