package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Posicao;
import game.core.exception.JogoException;
import game.core.exception.PosicaoForaDoMapaException;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.exception.NenhumPersonagemAtivoException;
import game.core.service.GerenciadorDePosicionaveis;

public class MoverParaDireita implements Evento {
    @Override
    public boolean executar() throws JogoException {
        GerenciadorDePosicionaveis gerenciadorDePosicao = new GerenciadorDePosicionaveis();
        Personagem personagem = RPG.getPersonagemAtivo();

        Posicao posicao = gerenciadorDePosicao.obterPosicao(personagem);
        if (posicao == null)
            throw new NenhumPersonagemAtivoException("Não foi localizado um personagem ativo no mapa!");

        try{
            personagem.caminhar(posicao.getX() + 1, posicao.getY());
        } catch (PosicaoForaDoMapaException e){
            System.out.println("Há uma barreira aqui, você não consegue caminhar nessa direção.");
        }
        gerenciadorDeEventos.adicionarEvento(new VerificarMissoes());
        gerenciadorDeEventos.adicionarEvento(new ExibirMapa());
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis());

        return false;
    }
}
