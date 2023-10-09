package com.central;

public class GerenciadorDeNotificacoes {

    private INotificacao notificacao;

    public GerenciadorDeNotificacoes(INotificacao notificacao){
        this.notificacao = notificacao;
    }

    public void setNotificacao(INotificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void notificar(String mensagem){
        this.notificacao.notificar(mensagem);
    }

}
