package game.core.model;

import game.core.abstraction.*;
import game.core.exception.PosicaoForaDoMapaException;
import game.core.exception.QuantidadeDeEnergiaInsuficienteException;
import game.core.service.GerenciadorDePosicionaveis;
import game.core.service.GerenciadorDeUsaveis;

import java.util.ArrayList;
import java.util.List;

public class Personagem extends Ator implements Posicionavel {

    private List<Item> itens;
    private static GerenciadorDeUsaveis gerenciadorDeUsaveis;

    public Personagem(String nome, Double nivel, Double saude, Double energia) {
        super(nome, nivel, saude, energia);
        this.itens = new ArrayList<>();

        if (gerenciadorDeUsaveis == null)
            gerenciadorDeUsaveis = new GerenciadorDeUsaveis();
    }

    public void atacar(Inimigo inimigo){
        double dano = (this.getNivel() + this.getEnergia() + this.getSaude())/3 * (0.5 * Math.random());
        inimigo.reduzirVida(dano);
    }

    public void pegarItem(Item item){
        gerenciadorDeUsaveis.registrarPropriedade(this, item);
        this.itens.add(item);
    }

    public void aprenderHabilidade(Habilidade habilidade){
        gerenciadorDeUsaveis.registrarPropriedade(this, habilidade);
        this.habilidades.add(habilidade);
    }

    public void usarHabilidade(Habilidade habilidade) throws QuantidadeDeEnergiaInsuficienteException {
        habilidade.usar();
    }

    public void usarItem(Item item){
        item.usar();
    }

    public void caminhar(int x, int y) throws PosicaoForaDoMapaException {
        GerenciadorDePosicionaveis gerenciadorDePosicionaveis = new GerenciadorDePosicionaveis();
        gerenciadorDePosicionaveis.registrarPosicao(this, new Posicao(x, y));
    }

    public List<Item> getItens() {
        return itens;
    }
}
