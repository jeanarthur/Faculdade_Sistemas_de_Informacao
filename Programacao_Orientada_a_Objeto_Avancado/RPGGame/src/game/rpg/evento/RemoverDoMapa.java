package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Posicao;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.model.MundoVirtual;
import game.rpg.RPG;
import game.core.exception.PosicionavelNaoLocalizadoException;
import game.core.service.GerenciadorDePosicionaveis;

public class RemoverDoMapa implements Evento {

    private Posicionavel posicionavel;

    public RemoverDoMapa(Posicionavel posicionavel){
        this.posicionavel = posicionavel;
    }

    @Override
    public boolean executar() throws JogoException {
        GerenciadorDePosicionaveis gerenciadorDePosicao = new GerenciadorDePosicionaveis();
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();

        Posicao posicao = gerenciadorDePosicao.obterPosicao(this.posicionavel);
        if (posicao == null)
            throw new PosicionavelNaoLocalizadoException("Não foi localizado no mapa!");

        mundoVirtual.getMapaDoMundo()[posicao.getY()][posicao.getX()] = null;
        return false;
    }

}
