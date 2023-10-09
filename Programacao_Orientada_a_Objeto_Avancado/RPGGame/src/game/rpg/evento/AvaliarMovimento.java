package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Posicao;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.model.Inimigo;
import game.core.model.Item;
import game.core.model.MundoVirtual;
import game.core.model.Personagem;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class AvaliarMovimento implements Evento {

    private Posicao posicao;

    public AvaliarMovimento(Posicao posicao){
        this.posicao = posicao;
    }

    @Override
    public boolean executar() throws JogoException {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        Posicionavel[][] mapaDoMundo = mundoVirtual.getMapaDoMundo();

        try{
            Posicionavel posicionavel = mapaDoMundo[this.posicao.getY()][this.posicao.getX()];
            if(posicionavel == null) return false;

            switch (posicionavel.getClass().getSimpleName()){
                case "Inimigo" -> {
                    System.out.printf("Você encontrou um(a) %s%s%s nível %.0f!\n", Cor.RED, ((Inimigo)posicionavel).getNome(), Cor.RESET, ((Inimigo)posicionavel).getNivel());
                    gerenciadorDeEventos.adicionarEvento(new Batalhar(posicionavel), 0);
                }
                case "Item" -> {
                    System.out.println("Você pegou o item " + Cor.YELLOW + ((Item)posicionavel).getNome() + Cor.RESET + "!");
                    RPG.getPersonagemAtivo().pegarItem((Item)posicionavel);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored){}

        return false;
    }
}
