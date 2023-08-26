public class Questao_07 {

    public static void main(String[] args) {
        int[][] matriz = {{1, 2}, {3, 4}};
        determinante(matriz); // 0
    }

    public static void determinante(int[][] matriz){
        if (matriz.length == 2 && matriz[0].length == 2) {
            int determinante = (matriz[0][0] + matriz[1][1]) - (matriz[0][1] + matriz[1][0]);
            System.out.println(determinante);
        } else {
            System.out.println("Matriz não é de ordem 2!");
        }
    }

}
