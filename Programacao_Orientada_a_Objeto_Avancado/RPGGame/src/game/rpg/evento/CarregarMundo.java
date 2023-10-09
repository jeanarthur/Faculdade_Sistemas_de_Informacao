package game.rpg.evento;

import game.core.abstraction.Efeito;
import game.core.abstraction.Evento;
import game.core.abstraction.Objetivo;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.model.*;
import game.rpg.RPG;
import game.rpg.efeito.ConsumirItem;
import game.rpg.efeito.Curar;
import game.rpg.objetivo.MatarBruxa;
import game.rpg.objetivo.MatarOgro;

import java.util.ArrayList;
import java.util.List;


public class CarregarMundo implements Evento {
    @Override
    public boolean executar() throws JogoException {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        Personagem personagem = RPG.getPersonagemAtivo();

        List<Posicionavel> posicionaveis = new ArrayList<>();

        Inimigo ogro = new Inimigo("Ogro", 1.0, 4.0, 1.0);
        Inimigo bruxa = new Inimigo("Bruxa", 1.0, 2.0, 3.0);


        mundoVirtual.adicionarInimigo(ogro);
        mundoVirtual.adicionarInimigo(bruxa);
        mundoVirtual.adicionarPersonagem(RPG.getPersonagemAtivo());

        List<Efeito> efeitos = new ArrayList<>();
        efeitos.add(new Curar(5.0));
        efeitos.add(new ConsumirItem());
        Item pocaoP = new Item("Poção P.", "Cura 5 de saúde", "Cura", efeitos);

        posicionaveis.add(ogro);
        posicionaveis.add(bruxa);
        posicionaveis.add(RPG.getPersonagemAtivo());
        posicionaveis.add(pocaoP);

        for (Posicionavel posicionavel : posicionaveis){
            gerenciadorDeEventos.adicionarEvento(new PosicionarNoMapa(posicionavel), 0);
        }

        Habilidade curar = new Habilidade(
                "Curar Lv1",
                "Cura 3 pontos de vida.",
                3.0,
                new Curar(3.0)
        );
        personagem.aprenderHabilidade(curar);

        efeitos = new ArrayList<>();
        efeitos.add(new Curar(10.0));
        efeitos.add(new ConsumirItem());
        Item pocaoM = new Item("Poção M.", "Cura 10 de saúde", "Cura", efeitos);
        List<Item> recompensas = new ArrayList<>();
        recompensas.add(pocaoM);

        List<Objetivo> objetivos = new ArrayList<>();
        objetivos.add(new MatarBruxa(1));
        objetivos.add(new MatarOgro(1));

        Missao treinamento = new Missao("Treinamento", "Mate 1 Ogro e 1 Bruxa.", recompensas, objetivos);
        treinamento.iniciar(personagem);
        mundoVirtual.adicionarMissaoAtiva(treinamento);

        gerenciadorDeEventos.adicionarEvento(new VerificarMissoes(mundoVirtual.getListaDeMissoesAtivas()));

        return false;
    }
}
