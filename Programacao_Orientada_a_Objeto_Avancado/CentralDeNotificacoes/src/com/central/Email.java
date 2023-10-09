public class Email implements INotificacao{

    @Override
    public void notificar(String mensagem) {
        System.out.println("Notificação enviada por email. Conteúdo: " + mensagem);
    }
}
