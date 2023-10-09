package game.core.abstraction;

import game.core.service.GerenciadorDeEfeitos;
import game.core.service.GerenciadorDeUsaveis;

public interface Efeito {
    GerenciadorDeEfeitos gerenciadorDeEfeitos = new GerenciadorDeEfeitos();
    GerenciadorDeUsaveis gerenciadorDeUsaveis = new GerenciadorDeUsaveis();
    void aplicar();
}
