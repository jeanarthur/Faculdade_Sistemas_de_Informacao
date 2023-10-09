package game.core.abstraction;

import game.core.exception.JogoException;
import game.core.model.MundoVirtual;

public abstract class Jogo {

    protected static boolean emExecucao = false;
    protected static MundoVirtual mundoVirtualAtivo;

    public Jogo(){
    }

    public static boolean isEmExecucao() {
        return emExecucao;
    }

    protected abstract MundoVirtual definirMundoVirtual();

    protected abstract Evento definirEventoInicial();

    public void iniciar() throws JogoException {
        emExecucao = true;
        mundoVirtualAtivo = this.definirMundoVirtual();
        this.definirEventoInicial().executar();
        mundoVirtualAtivo.executarEventos();
    };

    public void finalizar(){
        emExecucao = false;
    }

    public static MundoVirtual getMundoVirtualAtivo() {
        return mundoVirtualAtivo;
    }
}
