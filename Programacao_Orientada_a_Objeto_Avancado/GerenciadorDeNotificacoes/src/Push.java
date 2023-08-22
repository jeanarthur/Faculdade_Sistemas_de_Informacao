public class Push implements INotificacao{

    @Override
    public void notificar(String mensagem) {
        System.out.println("Notificação enviada por push. Conteúdo: " + mensagem);
    }
}
