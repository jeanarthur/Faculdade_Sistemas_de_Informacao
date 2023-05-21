public class Quadrilatero {

    private final double altura;
    private final double largura;

    public Quadrilatero(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public double calculaArea(){
        return this.altura * this.largura;
    }

    public double calculaPerimetro(){
        return (2 * this.altura) + (2 * this.largura);
    }

    @Override
    public String toString(){
        return String.format("Area: %.2f | Perimetro: %.2f | Tipo: %s", this.calculaArea(), this.calculaPerimetro(), this.altura == this.largura ? "Quadrado" : "Retangulo");
    }

}
