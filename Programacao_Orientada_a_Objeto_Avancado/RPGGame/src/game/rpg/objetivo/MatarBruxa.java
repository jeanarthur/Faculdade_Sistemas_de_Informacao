package game.rpg.objetivo;

import game.core.abstraction.Objetivo;
import game.core.model.Inimigo;
import game.core.model.MundoVirtual;
import game.rpg.RPG;

import java.util.ArrayList;
import java.util.List;

public class MatarBruxa extends Objetivo {

    private int quantidade;
    private int abates;
    private List<Inimigo> bruxas;

    public MatarBruxa(int quantidade) {
        super(String.format("Bruxa(s) abatida(s). (0 / %d)\n", quantidade));
        this.quantidade = quantidade;
        this.abates = 0;
        this.bruxas = new ArrayList<>();

        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        for(Inimigo inimigo : mundoVirtual.getListaDeInimigos()){
            if (inimigo.getNome().equals("Bruxa")){
                this.bruxas.add(inimigo);
            }
        }
    }
    @Override
    public void verificarProgresso() {
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();

        for (Inimigo bruxa : this.bruxas){
            if (!mundoVirtual.getListaDeInimigos().contains(bruxa)){
                this.abates++;
                this.bruxas.remove(bruxa);
                this.descricao = String.format("Bruxa(s) abatida(s). (%d / %d)\n", this.abates, this.quantidade);
            }
            if (this.abates >= this.quantidade){
                this.concluido = true;
                return;
            }
        }

        for(Inimigo inimigo : mundoVirtual.getListaDeInimigos()){
            if (inimigo.getNome().equals("Bruxa") && !this.bruxas.contains(inimigo)){
                this.bruxas.add(inimigo);
            }
        }
    }
}
