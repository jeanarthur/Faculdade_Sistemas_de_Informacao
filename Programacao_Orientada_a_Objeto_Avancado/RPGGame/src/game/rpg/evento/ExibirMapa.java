package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.model.MundoVirtual;
import game.rpg.RPG;
import game.rpg.util.Cor;

public class ExibirMapa implements Evento {
    @Override
    public boolean executar() throws JogoException {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        Posicionavel[][] mapa = mundoVirtual.getMapaDoMundo();

        System.out.printf("%3s", " ");
        for (int i = 0; i < mapa.length; i++){
            System.out.printf("|%-3s", " ".repeat(String.valueOf(i).length()) + i);
        }
        System.out.print("|\n");

        for (int i = 0; i < mapa[0].length; i++){
            System.out.printf("%-3d", i);
            for (int j = 0; j < mapa.length; j++){
                if (mapa[i][j] != null){
                    String representacao = String.valueOf(mapa[i][j].getClass().getSimpleName().charAt(0));
                    switch (mapa[i][j].getClass().getSimpleName()){
                        case "Inimigo" -> representacao = Cor.RED + representacao + Cor.RESET;
                        case "Personagem" -> representacao = Cor.CYAN + representacao + Cor.RESET;
                        case "Item" -> representacao = Cor.YELLOW + representacao + Cor.RESET;
                    }
                    System.out.printf("|%3s", " " +representacao + " ");

                }
                else
                    System.out.printf("|%3s", "");
            }
            System.out.print("|\n");
        }

        gerenciadorDeEventos.adicionarEvento(new CarregarComandosDoMapa(), 0);
        return false;
    }
}
