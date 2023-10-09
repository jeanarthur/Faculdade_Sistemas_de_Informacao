package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.rpg.comando.*;
import game.rpg.comando.Atacar;

public class CarregarComandosDeBatalha implements Evento {

    private Ator oponente;

    public CarregarComandosDeBatalha(Ator oponente){
        this.oponente = oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        gerenciadorDeComandos.limparComandos();
        gerenciadorDeComandos.registrarComando("Atacar", new Atacar(this.oponente), true);
        gerenciadorDeComandos.registrarComando("Usar Habilidade", new UsarHabilidade(this.oponente), true);
        gerenciadorDeComandos.registrarComando("Usar Item", new UsarItem(this.oponente), true);
        gerenciadorDeComandos.registrarComando("Correr", new Correr(this.oponente), true);

        return false;
    }
}
