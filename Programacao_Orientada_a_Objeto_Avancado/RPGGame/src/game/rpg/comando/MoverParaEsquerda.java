package game.rpg.comando;

import game.core.abstraction.Comando;
import game.core.abstraction.Posicao;
import game.core.model.Personagem;
import game.core.service.GerenciadorDePosicionaveis;
import game.rpg.RPG;
import game.rpg.evento.AvaliarMovimento;
import game.rpg.evento.ExibirPosicao;

public class MoverParaEsquerda implements Comando {
    @Override
    public void executar() {
        GerenciadorDePosicionaveis gerenciadorDePosicao = new GerenciadorDePosicionaveis();
        Personagem personagem = RPG.getPersonagemAtivo();
        Posicao posicao = gerenciadorDePosicao.obterPosicao(personagem);

        gerenciadorDeEventos.adicionarEvento(new AvaliarMovimento(new Posicao(posicao.getX() - 1, posicao.getY())));
        gerenciadorDeEventos.adicionarEvento(new game.rpg.evento.MoverParaEsquerda());
        gerenciadorDeEventos.adicionarEvento(new ExibirPosicao(personagem));
    }
}
