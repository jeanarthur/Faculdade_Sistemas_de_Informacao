package game.rpg;

import game.core.abstraction.Evento;
import game.core.abstraction.Jogo;
import game.core.model.MundoVirtual;
import game.core.model.Personagem;
import game.rpg.evento.InicializarJogo;

public class RPG extends Jogo {
    static Personagem personagemAtivo;

    @Override
    public MundoVirtual definirMundoVirtual() {
        return new MundoVirtual(5,5);
    }

    @Override
    protected Evento definirEventoInicial() {
        return new InicializarJogo();
    }

    public static Personagem getPersonagemAtivo() {
        return personagemAtivo;
    }

    public static void setPersonagemAtivo(Personagem personagemAtivo) {
        RPG.personagemAtivo = personagemAtivo;
    }
}
