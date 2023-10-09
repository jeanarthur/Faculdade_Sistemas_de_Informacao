package game.core.model;

import game.core.abstraction.Ator;
import game.core.abstraction.Posicionavel;

public class Inimigo extends Ator implements Posicionavel {

    public Inimigo(String nome, Double nivel, Double saude, Double energia) {
        super(nome, nivel, saude, energia);
    }

    public void atacar(Personagem personagem){
        double dano = (this.getNivel() + this.getEnergia() + this.getSaude())/3 * (0.5 * Math.random());
        personagem.reduzirVida(dano);
    }

}
