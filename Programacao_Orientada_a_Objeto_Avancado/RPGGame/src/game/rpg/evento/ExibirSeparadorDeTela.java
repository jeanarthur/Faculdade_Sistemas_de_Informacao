package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.JogoException;


public class ExibirSeparadorDeTela implements Evento {
    @Override
    public boolean executar() throws JogoException {
        System.out.println("+" + "=".repeat(50) + "+");
        return false;
    }
}
