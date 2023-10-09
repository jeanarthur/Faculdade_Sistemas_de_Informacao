package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Posicao;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.service.GerenciadorDePosicionaveis;

public class ExibirPosicao implements Evento {

    private Posicionavel posicionavel;

    public ExibirPosicao(Posicionavel posicionavel){
        this.posicionavel = posicionavel;
    }

    @Override
    public boolean executar() throws JogoException {
        GerenciadorDePosicionaveis gerenciadorDePosicionaveis = new GerenciadorDePosicionaveis();
        Posicao posicao = gerenciadorDePosicionaveis.obterPosicao(posicionavel);
        System.out.printf("Moveu para X: %s, Y: %d\n", posicao.getX(), posicao.getY());
        return false;
    }
}
