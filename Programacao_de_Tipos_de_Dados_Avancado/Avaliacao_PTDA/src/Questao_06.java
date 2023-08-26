public class Questao_06 {

    public static void main(String[] args) {
        String palavra = "oditrevni";
        System.out.println(inverter(palavra)); // invertido
    }

    public static String inverter(String string){
        String stringInvertida = "";
        for (int i = string.length() - 1; i >= 0; i--){
            stringInvertida += String.valueOf(string.charAt(i));
        }
        return stringInvertida;
    }

}
