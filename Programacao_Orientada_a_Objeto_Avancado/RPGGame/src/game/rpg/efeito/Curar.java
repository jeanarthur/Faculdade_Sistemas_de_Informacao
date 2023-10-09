package game.rpg.efeito;

import game.core.abstraction.Ator;
import game.core.abstraction.Efeito;
import game.core.abstraction.Usavel;

public class Curar implements Efeito {

    private double quantidade;

    public Curar(double quantidade){
        this.quantidade = quantidade;
    }

    @Override
    public void aplicar() {
        Usavel usavel = gerenciadorDeEfeitos.getProprietario(this);
        Ator proprietario = gerenciadorDeUsaveis.getProprietario(usavel);
        proprietario.aumentarVida(this.quantidade);
        System.out.printf("%s recebeu %.2f pontos de saúde!\n", proprietario.getNome(), this.quantidade);
    }
}
