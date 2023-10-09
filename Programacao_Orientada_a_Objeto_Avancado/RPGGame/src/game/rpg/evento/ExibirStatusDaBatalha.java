package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class ExibirStatusDaBatalha implements Evento {

    private Ator oponente;

    public ExibirStatusDaBatalha(Ator oponente){
        this.oponente = oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        Personagem personagem = RPG.getPersonagemAtivo();
        System.out.printf("%s nível %.2f!\n", Cor.GREEN + personagem.getNome() + Cor.RESET, personagem.getNivel());
        System.out.printf("Saúde: (%.2f / %.2f)\n", personagem.getSaude(), personagem.getSaudeBase());
        System.out.printf("Energia: (%.2f / %.2f)\n", personagem.getEnergia(), personagem.getEnergiaBase());
        System.out.println(" -----  VS  ----- ");
        System.out.printf("%s nível %.2f!\n", Cor.RED + this.oponente.getNome() + Cor.RESET, this.oponente.getNivel());
        System.out.printf("Saúde: (%.2f / %.2f)\n", this.oponente.getSaude(), this.oponente.getSaudeBase());
        System.out.printf("Energia: (%.2f / %.2f)\n", this.oponente.getEnergia(), this.oponente.getEnergiaBase());
        return false;
    }
}
