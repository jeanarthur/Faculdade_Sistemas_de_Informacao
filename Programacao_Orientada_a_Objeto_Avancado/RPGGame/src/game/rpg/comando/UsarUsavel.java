package game.rpg.comando;

import game.core.abstraction.Comando;
import game.core.abstraction.Usavel;
import game.core.exception.JogoException;

public class UsarUsavel implements Comando {

    private final Usavel usavel;

    public UsarUsavel(Usavel usavel){
        this.usavel = usavel;
    }

    @Override
    public void executar(){
        gerenciadorDeEventos.adicionarEvento(new game.rpg.evento.UsarUsavel(this.usavel), 0);
    }
}
