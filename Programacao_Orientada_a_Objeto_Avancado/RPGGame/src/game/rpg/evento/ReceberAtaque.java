package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.core.model.Inimigo;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class ReceberAtaque implements Evento {

    private Ator oponente;

    public ReceberAtaque(Ator oponente){
        this.oponente = oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        Personagem personagem = RPG.getPersonagemAtivo();
        double saudeInicialDoPersonagem = personagem.getSaude();
        ((Inimigo)this.oponente).atacar(personagem);

        System.out.printf(Cor.RED + "Você sofreu %.2f de dano do oponente!\n" + Cor.RESET, saudeInicialDoPersonagem - personagem.getSaude());
        gerenciadorDeEventos.adicionarEvento(new AvaliarBatalhaPersonagem(this.oponente), 0);
        return false;
    }
}
