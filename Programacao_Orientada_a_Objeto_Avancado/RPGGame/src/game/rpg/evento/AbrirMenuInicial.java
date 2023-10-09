package game.rpg.evento;

import game.core.abstraction.Evento;

public class AbrirMenuInicial implements Evento {
    @Override
    public boolean executar() {
        System.out.println("Bem-vindo ao RPG!");
        System.out.println("Boa sorte em sua aventura!");

        gerenciadorDeEventos.adicionarEvento(new ListarComandosDisponiveis());
        return false;
    }
}
