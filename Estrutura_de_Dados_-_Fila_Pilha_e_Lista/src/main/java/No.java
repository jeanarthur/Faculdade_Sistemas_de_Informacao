public class No<T> {

    private final T item;
    private No<T> anterior;
    private No<T> proximo;

    public No(T item) {
        this.item = item;
    }

    public No(T item, No proximo) {
        this.item = item;
        this.proximo = proximo;
    }

    public No(T item, No anterior, No proximo) {
        this.item = item;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public T getItem() {
        return item;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public No<T> getProximo() {
        return proximo;
    }
}
