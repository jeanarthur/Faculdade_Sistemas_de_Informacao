package game.core.abstraction;

public class Posicao{

    private int x;
    private int y;

    public Posicao(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosicao(int x, int y){
        this.x = x;
        this.y = y;
    }
}
