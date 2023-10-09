package game.core.exception;

import game.core.exception.JogoException;

public class PosicionavelNaoLocalizadoException extends JogoException {
    public PosicionavelNaoLocalizadoException(String mensagem) {
        super(mensagem);
    }
}
