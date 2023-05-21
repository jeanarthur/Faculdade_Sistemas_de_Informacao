public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(3);
        Quadrilatero quadrado = new Quadrilatero(10, 10);
        Quadrilatero retangulo = new Quadrilatero(2, 6);
        Triangulo trianguloEquilatero = new Triangulo(3, 3, 3);
        Triangulo trianguloIsosceles = new Triangulo(3, 4, 3);
        Triangulo trianguloEscaleno = new Triangulo(3, 4, 5);

        ManipuladorDeElementos manipuladorDeElementos = new ManipuladorDeElementos();
        manipuladorDeElementos.obterInformacoes(circulo);
        manipuladorDeElementos.obterInformacoes(quadrado);
        manipuladorDeElementos.obterInformacoes(retangulo);
        manipuladorDeElementos.obterInformacoes(trianguloEquilatero);
        manipuladorDeElementos.obterInformacoes(trianguloIsosceles);
        manipuladorDeElementos.obterInformacoes(trianguloEscaleno);
    }
}