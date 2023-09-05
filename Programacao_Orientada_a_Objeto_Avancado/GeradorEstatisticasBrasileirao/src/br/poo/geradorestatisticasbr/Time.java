package br.poo.geradorestatisticasbr;

public class Time {

    private int gols;
    private int chutesAGol;
    private int posseBolaAtaqueEmMin;
    private int posseBolaDefesaEmMin;
    private int faltas;
    private int cartoesAmarelos;
    private int cartoesVermelhos;

    public Time(int gols, int chutesAGol, int posseBolaAtaqueEmMin, int posseBolaDefesaEmMin, int faltas, int cartoesAmarelos, int cartoesVermelhos) {
        this.gols = gols;
        this.chutesAGol = chutesAGol;
        this.posseBolaAtaqueEmMin = posseBolaAtaqueEmMin;
        this.posseBolaDefesaEmMin = posseBolaDefesaEmMin;
        this.faltas = faltas;
        this.cartoesAmarelos = cartoesAmarelos;
        this.cartoesVermelhos = cartoesVermelhos;
    }

    public int getGols() {
        return gols;
    }

    public int getChutesAGol() {
        return chutesAGol;
    }

    public int getPosseBolaAtaqueEmMin() {
        return posseBolaAtaqueEmMin;
    }

    public int getPosseBolaDefesaEmMin() {
        return posseBolaDefesaEmMin;
    }

    public int getFaltas() {
        return faltas;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }
}
