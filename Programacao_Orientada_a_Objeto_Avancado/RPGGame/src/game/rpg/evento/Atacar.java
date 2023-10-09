package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.core.model.Inimigo;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class Atacar implements Evento {

    private Ator oponente;

    public Atacar(Ator oponente){
        this.oponente = oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        Personagem personagem = RPG.getPersonagemAtivo();
        double saudeInicialDoOponente = this.oponente.getSaude();
        personagem.atacar((Inimigo) this.oponente);

        System.out.printf(Cor.GREEN + "Você causou %.2f de dano ao oponente!\n" + Cor.RESET, saudeInicialDoOponente - this.oponente.getSaude());
        gerenciadorDeEventos.adicionarEvento(new AvaliarBatalha(this.oponente), 0);
        return false;
    }
}
