public class Questao_08 {

    public static void main(String[] args) {
        String[] lista = {"Hel", "lo ", "W", "ord", "!"};
        System.out.println(concatenarLista(lista)); // Hello Word!
    }

    public static String concatenarLista(String[] lista){
        String listaConcatenada = "";
        for (String string : lista){
            listaConcatenada += string;
        }
        return listaConcatenada;
    }

}
