public class Peca implements Listavel {

    int valorA;
    int valorB;

    public Peca(int valorA, int valorB) {
        this.valorA = valorA;
        this.valorB = valorB;
    }

    public int getValorA() {
        return valorA;
    }

    public int getValorB() {
        return valorB;
    }

    @Override
    public String getId() {
        return String.format("[%d|%d]", this.valorA, this.valorB);
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
