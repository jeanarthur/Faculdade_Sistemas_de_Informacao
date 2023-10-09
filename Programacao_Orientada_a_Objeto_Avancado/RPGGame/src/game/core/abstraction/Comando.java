package game.core.abstraction;

import game.core.service.GerenciadorDeComandos;
import game.core.service.GerenciadorDeEventos;

public interface Comando {
    GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos();
    GerenciadorDeComandos gerenciadorDeComandos = new GerenciadorDeComandos();
    void executar();

}
