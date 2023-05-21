public class Circulo {

    private final double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calculaArea(){
        return Math.PI * raio * raio;
    }

    public double calculaPerimetro(){
        return 2 * Math.PI * raio;
    }

    @Override
    public String toString(){
        return String.format("Area: %.2f | Perimetro: %.2f | Raio: %.2f", this.calculaArea(), this.calculaPerimetro(), this.raio);
    }

}
