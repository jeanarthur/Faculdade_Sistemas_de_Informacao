package game.core.abstraction;

import game.core.exception.JogoException;
import game.core.exception.QuantidadeDeEnergiaInsuficienteException;

public abstract class Usavel {

    protected String nome;
    protected String descricao;

    public Usavel(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public abstract void usar() throws JogoException;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
