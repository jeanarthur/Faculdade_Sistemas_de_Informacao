package game.core.model;

import game.core.abstraction.Jogo;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.exception.NenhumComandoRegistradoException;
import game.core.exception.NenhumEventoRegistradoException;
import game.core.service.GerenciadorDeComandos;
import game.core.service.GerenciadorDeEventos;
import game.core.service.GerenciadorDeMissoes;

import java.util.ArrayList;
import java.util.List;

public class MundoVirtual {

    private Posicionavel[][] mapaDoMundo;
    private List<Personagem> listaDePersonagens;
    private List<Inimigo> listaDeInimigos;
    private List<Missao> listaDeMissoesAtivas;

    public MundoVirtual(int largura, int comprimento) {
        this.mapaDoMundo = new Posicionavel[comprimento][largura];
        listaDePersonagens = new ArrayList<>();
        listaDeInimigos = new ArrayList<>();
        listaDeMissoesAtivas = new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem){
        this.listaDePersonagens.add(personagem);
    }

    public void adicionarInimigo(Inimigo inimigo){
        this.listaDeInimigos.add(inimigo);
    }

    public void adicionarMissaoAtiva(Missao missao){
        this.listaDeMissoesAtivas.add(missao);
    }

    public void removerPersonagem(Personagem personagem){
        this.listaDePersonagens.remove(personagem);
    }

    public void removerInimigo(Inimigo inimigo){
        this.listaDeInimigos.remove(inimigo);
    }

    public void removerMissaoAtiva(Missao missao){
        this.listaDeMissoesAtivas.remove(missao);
    }

    public void executarEventos() throws JogoException {
        GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos();
        GerenciadorDeComandos gerenciadorDeComandos = new GerenciadorDeComandos();

        while (Jogo.isEmExecucao()){
            gerenciadorDeEventos.executarEventos();
            if (!Jogo.isEmExecucao()) return;
            gerenciadorDeComandos.aguardarComando();
        }

    }

    public void verificarMissoes(){
        GerenciadorDeMissoes gerenciadorDeMissoes = new GerenciadorDeMissoes();
        for (Missao missao : new ArrayList<>(this.getListaDeMissoesAtivas())){
            missao.atualizar();
            if (gerenciadorDeMissoes.getResponsavel(missao) == null)
                this.listaDeMissoesAtivas.remove(missao);
        }
    }

    public Posicionavel[][] getMapaDoMundo() {
        return mapaDoMundo;
    }

    public List<Personagem> getListaDePersonagens() {
        return listaDePersonagens;
    }

    public List<Inimigo> getListaDeInimigos() {
        return listaDeInimigos;
    }

    public List<Missao> getListaDeMissoesAtivas() {
        return listaDeMissoesAtivas;
    }
}
