public class Questao_10 {

    public static void main(String[] args) {
        String string = "Hello Word!";
        String palavra1 = "Word";
        String palavra2 = "World";

        System.out.println((contem(string, palavra1)) ? "verdadeiro" : "falso"); // verdadeiro
        System.out.println((contem(string, palavra2)) ? "verdadeiro" : "falso"); // falso

    }

    public static boolean contem(String string, String palavra){
        return string.contains(palavra);
    }

}
