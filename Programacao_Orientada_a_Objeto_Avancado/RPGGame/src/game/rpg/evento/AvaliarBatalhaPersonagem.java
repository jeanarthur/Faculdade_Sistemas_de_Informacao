package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.abstraction.Jogo;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.model.Inimigo;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class AvaliarBatalhaPersonagem implements Evento {

    private final Ator oponente;

    public AvaliarBatalhaPersonagem(Ator oponente){
        this.oponente = oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        Personagem personagem = RPG.getPersonagemAtivo();

        if (personagem.getSaude() <= 0){
            System.out.println(Cor.RED + "Infelizmente você foi derrotado!" + Cor.RESET);
            Jogo jogo = new RPG();
            jogo.finalizar();
            gerenciadorDeEventos.limparEventos();
            return false;
        }
        gerenciadorDeEventos.adicionarEvento(new Batalhar((Posicionavel)this.oponente), 1);
        return false;
    }
}
