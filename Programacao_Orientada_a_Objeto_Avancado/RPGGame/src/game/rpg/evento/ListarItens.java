package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.exception.JogoException;
import game.core.model.Item;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.comando.UsarUsavel;
import game.rpg.comando.Voltar;

import java.util.List;

public class ListarItens implements Evento {
    @Override
    public boolean executar() throws JogoException {
        Personagem personagem = RPG.getPersonagemAtivo();
        List<Item> itens = personagem.getItens();

        if (itens.size() < 1){
            System.out.println("Você não possui nenhum item!");
            return false;
        }

        gerenciadorDeComandos.limparComandos();
        for(Item item : itens){
            gerenciadorDeComandos.registrarComando(item.getNome(), new UsarUsavel(item), true);
        }
        gerenciadorDeComandos.registrarComando("Voltar", new Voltar(), true);

        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis(), 0);
        return false;
    }
}
