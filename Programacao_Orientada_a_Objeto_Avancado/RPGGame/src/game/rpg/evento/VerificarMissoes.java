package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Objetivo;
import game.core.exception.JogoException;
import game.core.model.Item;
import game.core.model.Missao;
import game.core.model.MundoVirtual;
import game.rpg.RPG;
import game.rpg.util.Cor;

import java.util.ArrayList;
import java.util.List;

public class VerificarMissoes implements Evento {

    private static List<Missao> missoes;

    public VerificarMissoes(List<Missao> missoes){
        VerificarMissoes.missoes = new ArrayList<>(missoes);
    }

    public VerificarMissoes(){
        if (missoes == null)
            missoes = new ArrayList<>();
    }

    @Override
    public boolean executar() throws JogoException {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        mundoVirtual.verificarMissoes();
        for (Missao missao : new ArrayList<>(missoes)){
            if (!mundoVirtual.getListaDeMissoesAtivas().contains(missao)){
                System.out.println(Cor.GREEN + "Parabéns, você concluiu a missão:" + Cor.RESET);
                System.out.println("\tTitulo: " + missao.getTitulo());
                System.out.println("\tDescrição: " + missao.getDescricao());
                System.out.println("\tObjetivos:");
                for (Objetivo objetivo : missao.getObjetivos()){
                    System.out.print("\t\t -> " + objetivo.getDescricao());
                }
                System.out.println(Cor.GREEN + "As recompensas abaixo foram adicionadas ao seu inventário!" + Cor.RESET);
                System.out.println("\tRecompensas:");
                for (Item item : missao.getRecompensas()){
                    System.out.println("\t\t" + Cor.YELLOW + item.getNome() + Cor.RESET + " -> " + item.getDescricao());
                }
                System.out.println();
                missoes.remove(missao);
            }
        }

        for(Missao missao : mundoVirtual.getListaDeMissoesAtivas()){
            if (!missoes.contains(missao)){
                missoes.add(missao);
            }
        }
        return false;
    }
}
