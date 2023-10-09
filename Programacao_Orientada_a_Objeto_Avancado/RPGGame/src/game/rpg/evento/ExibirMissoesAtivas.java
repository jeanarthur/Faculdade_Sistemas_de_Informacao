package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Objetivo;
import game.core.exception.JogoException;
import game.core.model.Item;
import game.core.model.Missao;
import game.core.model.MundoVirtual;
import game.rpg.RPG;
import game.rpg.comando.Voltar;

import java.util.List;

public class ExibirMissoesAtivas implements Evento {
    @Override
    public boolean executar() throws JogoException {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        List<Missao> missoes =  mundoVirtual.getListaDeMissoesAtivas();

        System.out.println("Missões ativas:");
        for (Missao missao : missoes){
            System.out.println("\tTitulo: " + missao.getTitulo());
            System.out.println("\tDescrição: " + missao.getDescricao());
            System.out.println("\tObjetivos:");
            for (Objetivo objetivo : missao.getObjetivos()){
                System.out.print("\t\t -> " + objetivo.getDescricao());
            }
            System.out.println("\tRecompensas:");
            for (Item item : missao.getRecompensas()){
                System.out.println("\t\t" + item.getNome() + " -> " + item.getDescricao());
            }
            System.out.println();
        }
        System.out.println("-----");

        gerenciadorDeComandos.limparComandos();
        gerenciadorDeComandos.registrarComando("Voltar", new Voltar(), true);

        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis(), 0);
        gerenciadorDeEventos.adicionarEvento(new ExibirMapa());
        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis());
        return false;
    }
}
