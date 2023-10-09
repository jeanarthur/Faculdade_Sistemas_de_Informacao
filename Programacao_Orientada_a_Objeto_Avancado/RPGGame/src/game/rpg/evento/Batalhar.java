package game.rpg.evento;

import game.core.abstraction.Ator;
import game.core.abstraction.Evento;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;

public class Batalhar implements Evento {

    private Ator oponente;

    public Batalhar(Posicionavel oponente){
        this.oponente = (Ator) oponente;
    }

    @Override
    public boolean executar() throws JogoException {
        gerenciadorDeEventos.adicionarEvento(new ExibirStatusDaBatalha(this.oponente), 0);
        gerenciadorDeEventos.adicionarEvento(new CarregarComandosDeBatalha(this.oponente), 1);
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis(), 2);
        return false;
    }
}
