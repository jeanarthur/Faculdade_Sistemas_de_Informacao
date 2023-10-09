package game.core.abstraction;

public abstract class Objetivo {

    protected String descricao;
    protected boolean concluido;

    public Objetivo(String descricao){
        this.descricao = descricao;
        this.concluido = false;
    }

    public abstract void verificarProgresso();

    public boolean isConcluido() {
        return concluido;
    }

    public String getDescricao() {
        return descricao;
    }
}
