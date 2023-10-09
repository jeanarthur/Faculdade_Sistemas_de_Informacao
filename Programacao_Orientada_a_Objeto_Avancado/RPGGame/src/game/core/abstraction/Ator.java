package game.core.abstraction;

import game.core.model.Habilidade;

import java.util.ArrayList;
import java.util.List;

public abstract class Ator {
    protected String nome;
    protected Double nivel;
    protected Double saude;
    protected Double energia;
    protected List<Habilidade> habilidades;

    private Double saudeBase;
    private Double energiaBase;

    public Ator(String nome, Double nivel, Double saude, Double energia){
        this.nome = nome;
        this.nivel = nivel;
        this.saude = saude;
        this.energia = energia;
        this.habilidades = new ArrayList<>();
        this.saudeBase = saude;
        this.energiaBase = energia;
    }

    public String getNome() {
        return nome;
    }

    public Double getNivel() {
        return nivel;
    }

    public Double getSaude() {
        return saude;
    }

    public Double getEnergia() {
        return energia;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void reduzirVida(double dano){
        this.saude -= Math.abs(dano);
    }

    public void aumentarVida(double vida){
        if (this.saude + vida > this.saudeBase)
            this.saude = saudeBase;
        else
            this.saude += Math.abs(vida);
    }

    public void reduzirEnergia(double quantidade){
        this.energia -= Math.abs(quantidade);
    }

    public void aumentarEnergia(double quantidade){
        this.energia += Math.abs(quantidade);
    }

    public void aumentarNivel(Double quantidade){
        this.nivel += Math.abs(quantidade);
        this.energiaBase += Math.abs(quantidade * (2 + Math.random()));
        this.saudeBase += Math.abs(quantidade * (2 + Math.random()));
    }

    public void reduzirNivel(Double quantidade){
        this.nivel -= Math.abs(quantidade);
    }

    public Double getSaudeBase() {
        return saudeBase;
    }

    public Double getEnergiaBase() {
        return energiaBase;
    }
}
