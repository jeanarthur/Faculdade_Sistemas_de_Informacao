package game.rpg.objetivo;

import game.core.abstraction.Objetivo;
import game.core.model.Inimigo;
import game.core.model.MundoVirtual;
import game.rpg.RPG;

import java.util.ArrayList;
import java.util.List;

public class MatarOgro extends Objetivo {

    private int quantidade;
    private int abates;
    private List<Inimigo> ogros;

    public MatarOgro(int quantidade) {
        super(String.format("Ogro(s) abatido(s). (0 / %d)\n", quantidade));
        this.quantidade = quantidade;
        this.abates = 0;
        this.ogros = new ArrayList<>();

        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        for(Inimigo inimigo : mundoVirtual.getListaDeInimigos()){
            if (inimigo.getNome().equals("Ogro")){
                this.ogros.add(inimigo);
            }
        }
    }
    @Override
    public void verificarProgresso() {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();

        for (Inimigo bruxa : this.ogros){
            if (!mundoVirtual.getListaDeInimigos().contains(bruxa)){
                this.abates++;
                this.ogros.remove(bruxa);
                this.descricao = String.format("Ogro(s) abatido(s). (%d / %d)\n", this.abates, this.quantidade);
            }
            if (this.abates >= this.quantidade){
                this.concluido = true;
                return;
            }
        }

        for(Inimigo inimigo : mundoVirtual.getListaDeInimigos()){
            if (inimigo.getNome().equals("Ogro") && !this.ogros.contains(inimigo)){
                this.ogros.add(inimigo);
            }
        }
    }
}
