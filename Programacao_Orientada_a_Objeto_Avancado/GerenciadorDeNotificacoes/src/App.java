public class App implements INotificacao{

    @Override
    public void notificar(String mensagem) {
        System.out.println("Notificação enviada pelo app. Conteúdo: " + mensagem);
    }
}
