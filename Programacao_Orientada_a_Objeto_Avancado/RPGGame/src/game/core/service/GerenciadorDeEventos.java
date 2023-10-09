package game.core.service;

import game.core.abstraction.Evento;
import game.core.abstraction.Jogo;
import game.core.exception.JogoException;
import game.core.exception.NenhumEventoRegistradoException;
import game.rpg.util.Cor;
import jdk.jfr.Event;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeEventos {

    private static List<Evento> eventos;

    public GerenciadorDeEventos(){
        if (eventos == null)
            eventos = new ArrayList<>();
    }

    public void executarEventos() throws JogoException {
        while(eventos.size() > 0) {
            if (!executarProximoEvento()) break;

        }
    }

    private boolean executarProximoEvento() throws JogoException {
        Evento evento = eventos.get(0);
        removerEvento(evento);
        //System.out.println(Cor.YELLOW + "Executando: " + evento.getClass().getSimpleName() + Cor.RESET);
        return !evento.executar();
    }

    public void adicionarEvento(Evento evento){
        eventos.add(evento);
    }

    public void adicionarEvento(Evento evento, int posicao){
        eventos.add(posicao, evento);
    }

    public void removerEvento(Evento evento){
        eventos.remove(evento);
    }

    public void removerEvento(String nomeDoEvento){
        for (Evento evento : new ArrayList<>(eventos)){
            if (evento.getClass().getSimpleName().equals(nomeDoEvento)){
                eventos.remove(evento);
                return;
            }
        }
    }

    public void limparEventos(){
        eventos.clear();
    }
}
