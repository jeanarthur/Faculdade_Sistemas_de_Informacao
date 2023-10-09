package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Usavel;
import game.core.exception.JogoException;
import game.core.exception.QuantidadeDeEnergiaInsuficienteException;
import game.core.model.Habilidade;
import game.core.model.Item;
import game.core.model.Personagem;
import game.rpg.RPG;

public class UsarUsavel implements Evento {

    private Usavel usavel;

    public UsarUsavel(Usavel usavel){
        this.usavel = usavel;
    }

    @Override
    public boolean executar() throws JogoException {
        try {
            Personagem personagem = RPG.getPersonagemAtivo();
            if (this.usavel.getClass().getSimpleName().equals("Item"))
                personagem.usarItem((Item) this.usavel);
            else if (this.usavel.getClass().getSimpleName().equals("Habilidade"))
                personagem.usarHabilidade((Habilidade) this.usavel);
            else
                this.usavel.usar();
        } catch (QuantidadeDeEnergiaInsuficienteException e){
            System.out.println("Você não possui energia suficiente!");
        }

        return false;
    }
}
