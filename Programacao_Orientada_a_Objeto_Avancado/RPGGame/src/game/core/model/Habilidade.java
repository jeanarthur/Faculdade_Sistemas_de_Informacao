package game.core.model;

import game.core.abstraction.Ator;
import game.core.abstraction.Efeito;
import game.core.abstraction.Usavel;
import game.core.exception.JogoException;
import game.core.exception.QuantidadeDeEnergiaInsuficienteException;
import game.core.service.GerenciadorDeEfeitos;
import game.core.service.GerenciadorDeUsaveis;

public class Habilidade extends Usavel {
    protected Double custoDeEnergia;
    private final Efeito efeito;
    public Habilidade(String nome, String descricao, Double custoDeEnergia, Efeito efeito) {
        super(nome, descricao);
        this.custoDeEnergia = custoDeEnergia;
        this.efeito = efeito;
        registarEfeito();
    }

    @Override
    public void usar() throws QuantidadeDeEnergiaInsuficienteException {
        GerenciadorDeUsaveis gerenciadorDeUsaveis = new GerenciadorDeUsaveis();
        Ator proprietario = gerenciadorDeUsaveis.getProprietario(this);
        double energia = proprietario.getEnergia();
        if (energia < this.custoDeEnergia)
            throw new QuantidadeDeEnergiaInsuficienteException("O Ator não pode usar a habilidade por falta de energia!");
        this.efeito.aplicar();
        proprietario.reduzirEnergia(this.custoDeEnergia);
    }

    private void registarEfeito(){
        GerenciadorDeEfeitos gerenciadorDeEfeitos = new GerenciadorDeEfeitos();
        gerenciadorDeEfeitos.registrarPropriedade(this, this.efeito);
    }
}
