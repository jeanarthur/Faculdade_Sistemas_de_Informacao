package game.core.model;

import game.core.abstraction.Objetivo;
import game.core.service.GerenciadorDeMissoes;

import java.util.List;

public class Missao {

    private String titulo;
    private String descricao;
    private List<Item> recompensas;
    private List<Objetivo> objetivos;
    private static GerenciadorDeMissoes gerenciadorDeMissoes;

    public Missao(String titulo, String descricao, List<Item> recompensas, List<Objetivo> objetivos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.recompensas = recompensas;
        this.objetivos = objetivos;

        if (gerenciadorDeMissoes == null)
            gerenciadorDeMissoes = new GerenciadorDeMissoes();
    }

    public void iniciar(Personagem personagem){
        gerenciadorDeMissoes.registrarCompromisso(personagem, this);
    }

    public void atualizar(){
        int objetivosConcluidos = 0;
        for (Objetivo objetivo : this.objetivos){
            if(objetivo.isConcluido()){
                objetivosConcluidos++;
                continue;
            }

            objetivo.verificarProgresso();
            if(objetivo.isConcluido()) objetivosConcluidos++;
        }

        if (objetivosConcluidos == this.objetivos.size()) this.completar();
    }

    private void completar(){
        Personagem personagem = (Personagem)gerenciadorDeMissoes.getResponsavel(this);
        for (Item item : this.recompensas){
            personagem.pegarItem(item);
        }
        gerenciadorDeMissoes.encerrarCompromisso(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Item> getRecompensas() {
        return recompensas;
    }

    public List<Objetivo> getObjetivos() {
        return objetivos;
    }
}
