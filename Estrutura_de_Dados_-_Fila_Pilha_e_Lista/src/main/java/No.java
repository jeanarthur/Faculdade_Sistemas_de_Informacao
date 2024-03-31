public class No {

    private final Enfileiravel itemDaFila;
    private No anterior;
    private No proximo;

    public No(Enfileiravel itemDaFila) {
        this.itemDaFila = itemDaFila;
    }

    public No(Enfileiravel itemDaFila, No proximo) {
        this.itemDaFila = itemDaFila;
        this.proximo = proximo;
    }

    public No(Enfileiravel itemDaFila, No anterior, No proximo) {
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

    public Enfileiravel getItemDaFila() {
        return itemDaFila;
    }

    public No getAnterior() {
        return anterior;
    }

    public No getProximo() {
        return proximo;
    }
}
