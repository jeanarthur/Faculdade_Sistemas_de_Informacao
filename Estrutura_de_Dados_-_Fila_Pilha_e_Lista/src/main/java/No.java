public class No {

    private final Listavel itemDaFila;
    private No anterior;
    private No proximo;

    public No(Listavel itemDaFila) {
        this.itemDaFila = itemDaFila;
    }

    public No(Listavel itemDaFila, No proximo) {
        this.itemDaFila = itemDaFila;
        this.proximo = proximo;
    }

    public No(Listavel itemDaFila, No anterior, No proximo) {
        this.itemDaFila = itemDaFila;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public Listavel getItemDaFila() {
        return itemDaFila;
    }

    public No getAnterior() {
        return anterior;
    }

    public No getProximo() {
        return proximo;
    }
}
