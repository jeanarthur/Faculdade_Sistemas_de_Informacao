package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.abstraction.Jogo;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.model.Inimigo;
import game.core.model.MundoVirtual;
import game.core.model.Personagem;
import game.core.service.GerenciadorDePosicionaveis;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class AvaliarBatalha implements Evento {

    private final Ator oponente;

    public AvaliarBatalha(Ator oponente){
        this.oponente = oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        Personagem personagem = RPG.getPersonagemAtivo();

        if (personagem.getSaude() <= 0){
            System.out.println("Infelizmente você foi derrotado!");
            Jogo jogo = new RPG();
            jogo.finalizar();
            gerenciadorDeEventos.limparEventos();
            return false;
        }

        if (this.oponente.getSaude() > 0){
            gerenciadorDeEventos.adicionarEvento(new ReceberAtaque(this.oponente), 0);
        } else {
            System.out.println(Cor.GREEN + "Parabéns, você derrotou o oponente!" + Cor.RESET);
            double experiencia = (this.oponente.getNivel() + this.oponente.getSaude() + this.oponente.getEnergia()) / 3 * 0.2;
            personagem.aumentarNivel(experiencia);
            personagem.aumentarEnergia(personagem.getEnergiaBase() - personagem.getEnergia());
            System.out.printf(Cor.GREEN + "Você recebeu %.2f pontos de experiência!\n"  + Cor.RESET, experiencia);

            this.oponente.aumentarNivel(experiencia * (0.5 + Math.random()));
            Inimigo inimigo = new Inimigo(
                    this.oponente.getNome(),
                    this.oponente.getNivel(),
                    this.oponente.getSaudeBase(),
                    this.oponente.getEnergiaBase()
            );

            MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
            mundoVirtual.getListaDeInimigos().remove((Inimigo)this.oponente);
            mundoVirtual.getListaDeInimigos().add(inimigo);

            GerenciadorDePosicionaveis gerenciadorDePosicionaveis = new GerenciadorDePosicionaveis();
            gerenciadorDePosicionaveis.removerRegistro((Posicionavel)this.oponente);

            gerenciadorDeEventos.adicionarEvento(new PosicionarNoMapa(inimigo));
        }

        return false;
    }
}
