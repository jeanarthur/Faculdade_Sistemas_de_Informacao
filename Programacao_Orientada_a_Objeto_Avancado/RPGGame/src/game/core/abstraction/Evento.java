package game.core.abstraction;

import game.core.exception.JogoException;
import game.core.service.GerenciadorDeComandos;
import game.core.service.GerenciadorDeEventos;

public interface Evento {
    GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos();
    GerenciadorDeComandos gerenciadorDeComandos = new GerenciadorDeComandos();
    boolean executar() throws JogoException;
}
