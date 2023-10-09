package game.core.service;

import game.core.abstraction.Jogo;
import game.core.abstraction.Posicao;
import game.core.abstraction.Posicionavel;
import game.core.exception.PosicaoForaDoMapaException;
import game.core.model.MundoVirtual;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDePosicionaveis {

    private static Map<Posicionavel, Posicao> posicoes;

    public GerenciadorDePosicionaveis(){
        if (posicoes == null)
            posicoes = new HashMap<>();
    }

    public void registrarPosicao(Posicionavel posicionavel, Posicao posicao) throws PosicaoForaDoMapaException {
        adicionarPosicionavelNoMapa(posicionavel, posicao);
        removerPosicionavelDoMapa(posicionavel);
        posicoes.put(posicionavel, posicao);
    }

    public void removerRegistro(Posicionavel posicionavel){
        removerPosicionavelDoMapa(posicionavel);
        posicoes.remove(posicionavel);
    }

    public Posicao obterPosicao(Posicionavel posicionavel){
        return posicoes.get(posicionavel);
    }

    private void removerPosicionavelDoMapa(Posicionavel posicionavel){
        MundoVirtual mundoVirtual = Jogo.getMundoVirtualAtivo();
        Posicao posicao = obterPosicao(posicionavel);
        if (posicao == null) return;
        mundoVirtual.getMapaDoMundo()[posicao.getY()][posicao.getX()] = null;
    }

    private void adicionarPosicionavelNoMapa(Posicionavel posicionavel, Posicao posicao) throws PosicaoForaDoMapaException {
        MundoVirtual mundoVirtual = Jogo.getMundoVirtualAtivo();
        try{
            mundoVirtual.getMapaDoMundo()[posicao.getY()][posicao.getX()] = posicionavel;
        } catch (ArrayIndexOutOfBoundsException e){
            throw new PosicaoForaDoMapaException("Não foi possível posicionar, coordenadas ultrapassam o limite do mapa!");
        }
    }
}
