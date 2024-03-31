public class Lista {

    static final boolean DEBUG = false;

    private No primeiro;
    private No ultimo;
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

    public void inserir(Enfileiravel enfileiravel){
        No itemDaFila = new No(enfileiravel);

        if (this.primeiro == null){
            this.primeiro = itemDaFila;
        } else {
            this.ultimo.setProximo(itemDaFila);
            itemDaFila.setAnterior(this.ultimo);
        }
        this.ultimo = itemDaFila;
        this.tamanho++;

        DEBUG("Inserido", itemDaFila.getItemDaFila().toString());
        if (itemDaFila.getAnterior() != null) {DEBUG("Anterior", itemDaFila.getAnterior().getItemDaFila().toString());}
        if (itemDaFila.getProximo() != null) {DEBUG("Proximo", itemDaFila.getProximo().getItemDaFila().toString());}

    }

    public void inserir(Enfileiravel enfileiravel, int posicao){
        if (posicao < 1 || posicao > this.tamanho + 1){
            return;
        }

        No itemAtual = this.primeiro;
        int posicaoAtual = 1;

        while(posicaoAtual < posicao){
            posicaoAtual++;
            itemAtual = itemAtual.getProximo();
        }

        No anterior = itemAtual.getAnterior();
        No proximo = itemAtual.getProximo();

        No itemDaFila = new No(enfileiravel, anterior, itemAtual);

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

    private void remover(No no){
        No anterior = no.getAnterior();
        No proximo = no.getProximo();

        DEBUG("Removendo", no.getItemDaFila().toString());
        if (proximo != null) DEBUG("Proximo", proximo.getItemDaFila().toString());
        if (anterior != null) DEBUG("Anterior", anterior.getItemDaFila().toString());

        if (anterior != null){
            if (proximo != null) DEBUG("Definindo como proximo do anterior", proximo.getItemDaFila().toString());
            anterior.setProximo(proximo);
        } else {
            this.primeiro = proximo;
        }

        if (proximo != null){
            if (anterior != null) DEBUG("Definindo como anterior do proximo", anterior.getItemDaFila().toString());
            proximo.setAnterior(anterior);
        } else {
            this.ultimo = anterior;
        }

        this.tamanho--;
    }

    public Enfileiravel remover(Enfileiravel enfileiravel){
        No itemAtual = this.primeiro;

        while(itemAtual != null){
            if (itemAtual.getItemDaFila().equals(enfileiravel)){
                this.remover(itemAtual);
                return enfileiravel;
            }

            itemAtual = itemAtual.getProximo();
        }

        return null;
    }

    public Enfileiravel remover(String id){
        No itemAtual = this.primeiro;

        while(itemAtual != null){
            Enfileiravel itemDaFila = itemAtual.getItemDaFila();
            if (itemDaFila.getId().equals(id)){
                this.remover(itemAtual);
                return itemDaFila;
            }

            itemAtual = itemAtual.getProximo();
        }

        return null;
    }

    public Enfileiravel remover(int posicao){
        if (posicao < 1 || posicao > this.tamanho){
            return null;
        }

        No itemAtual = this.primeiro;
        int posicaoAtual = 1;

        while(itemAtual != null){
            if (posicaoAtual == posicao){
                this.remover(itemAtual);
                return itemAtual.getItemDaFila();
            }

            posicaoAtual++;
            itemAtual = itemAtual.getProximo();
        }

        return null;
    }

    public void imprimir(){
        No itemAtual = this.primeiro;

        while(itemAtual != null){
            System.out.print(itemAtual.getItemDaFila().toString() + " ");

            itemAtual = itemAtual.getProximo();
        }
        System.out.print("\n");
    }

}
