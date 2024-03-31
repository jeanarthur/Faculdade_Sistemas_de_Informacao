public class Lista<T> {

    static final boolean DEBUG = false;

    private No<T> primeiro;
    private No<T> ultimo;
    private long tamanho;

    public Lista(){
        this.tamanho = 0;
    }

    public long getTamanho() {
        return tamanho;
    }

    public boolean estaVazia(){
        return this.primeiro == null;
    }

    public void inserir(T listavel){
        No<T> itemDaFila = new No<>(listavel);

        if (this.estaVazia()){
            this.primeiro = itemDaFila;
        } else {
            this.ultimo.setProximo(itemDaFila);
            itemDaFila.setAnterior(this.ultimo);
        }
        this.ultimo = itemDaFila;
        this.tamanho++;

        DEBUG("Inserido", itemDaFila.getItem().toString());
        if (itemDaFila.getAnterior() != null) {DEBUG("Anterior", itemDaFila.getAnterior().getItem().toString());}
        if (itemDaFila.getProximo() != null) {DEBUG("Proximo", itemDaFila.getProximo().getItem().toString());}

    }

    public void inserir(T listavel, int posicao){
        if (posicao < 1 || posicao > this.tamanho + 1){
            return;
        }

        No<T> itemAtual = this.primeiro;
        int posicaoAtual = 1;

        while(posicaoAtual < posicao){
            posicaoAtual++;
            itemAtual = itemAtual.getProximo();
        }

        No<T> anterior = itemAtual.getAnterior();
        No<T> proximo = itemAtual.getProximo();

        No<T> itemDaFila = new No<>(listavel, anterior, itemAtual);

        if (anterior != null){
            anterior.setProximo(itemDaFila);
        } else {
            this.primeiro = itemDaFila;
        }

        if (proximo != null){
            proximo.setAnterior(itemDaFila);
        }

        this.tamanho++;
    }

    private void DEBUG(String info, String valor){
        if (DEBUG) {
            System.out.printf("[DEBUG] %s: %s\n", info, valor);
        }
    }

    private void remover(No<T> no){
        No<T> anterior = no.getAnterior();
        No<T> proximo = no.getProximo();

        DEBUG("Removendo", no.getItem().toString());
        if (proximo != null) DEBUG("Proximo", proximo.getItem().toString());
        if (anterior != null) DEBUG("Anterior", anterior.getItem().toString());

        if (anterior != null){
            if (proximo != null) DEBUG("Definindo como proximo do anterior", proximo.getItem().toString());
            anterior.setProximo(proximo);
        } else {
            this.primeiro = proximo;
        }

        if (proximo != null){
            if (anterior != null) DEBUG("Definindo como anterior do proximo", anterior.getItem().toString());
            proximo.setAnterior(anterior);
        } else {
            this.ultimo = anterior;
        }

        this.tamanho--;
    }

    public T remover(T listavel){
        No<T> itemAtual = this.primeiro;

        while(itemAtual != null){
            if (itemAtual.getItem().equals(listavel)){
                this.remover(itemAtual);
                return listavel;
            }

            itemAtual = itemAtual.getProximo();
        }

        return null;
    }

    public T remover(int posicao){
        if (posicao < 1 || posicao > this.tamanho){
            return null;
        }

        No<T> itemAtual = this.primeiro;
        int posicaoAtual = 1;

        while(itemAtual != null){
            if (posicaoAtual == posicao){
                this.remover(itemAtual);
                return itemAtual.getItem();
            }

            posicaoAtual++;
            itemAtual = itemAtual.getProximo();
        }

        return null;
    }

    public void imprimir(){
        No<T> itemAtual = this.primeiro;

        while(itemAtual != null){
            System.out.print(itemAtual.getItem().toString() + " ");

            itemAtual = itemAtual.getProximo();
        }
        System.out.print("\n");
    }

}
