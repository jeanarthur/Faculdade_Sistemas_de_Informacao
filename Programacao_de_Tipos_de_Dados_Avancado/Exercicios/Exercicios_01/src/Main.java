public class Main {
    public static void main(String[] args) {
        int[] arrayA = {1, 1, 2, 4, 6, 6, 7, 7, 13, 15};
        int[] arrayB = {1, 1, 1, 3, 5, 7, 9, 11, 15};
        Exercicio_1.main(args); // Valor esperado: Declaração de array de inteiro: int[] numbers = new int[10];
        System.out.println("Média: " + Exercicio_2.calcArrayAverage(arrayA)); // Valor esperado: Média: 6
        System.out.println("Soma: " + Exercicio_3.sumArray(arrayA)); // Valor esperado: Soma: 62
        printArray(Exercicio_4.powArrayValues(arrayB), "Ao quadrado: "); // Valor esperado: Ao quadrado: 1, 4, 16, 36, 49, 169, 225
        Exercicio_5.main(args); // Valor esperado: Primos no array: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        Exercicio_6.main(args); // Valor esperado: Foram digitados X número(s) par(es) e Y número(s) ímpar(es)
        System.out.println(Exercicio_7.getStringWithLargerAndSmallerNumberInArray(arrayA)); // Valor esperado: Menor número do array: 1 | Maior número do array: 15

        int[] intersection = Exercicio_8.intersectionInArrays(arrayA, arrayB);
        System.out.println("Quantidade (Interseção): " + intersection.length); // Valor esperado: Quantidade (Interseção): 3
        printArray(intersection, "Interseção: "); // Valor esperado: Interseção: 1, 7, 15

        int[] difference = Exercicio_9.differenceInArrays(arrayA, arrayB);
        System.out.println("Quantidade (Diferença): " + difference.length); // Valor esperado: Quantidade (Diferença): 4
        printArray(difference, "Diferença: "); // Valor esperado: Diferença: 2, 4, 6, 13

        int[] union = Exercicio_10.unionInArrays(arrayA, arrayB);
        System.out.println("Quantidade (União): " + union.length); // Valor esperado: Quantidade (União): 11
        printArray(union, "União: "); // Valor esperado: União: 1, 2, 3, 4, 5, 6, 7, 9, 11, 13, 15
    }

    public static void printArray(int[] array, String message){
        int i = 0;
        System.out.print(message);
        for (int num: array){
            if (i++ == array.length - 1) { System.out.print(num + "\n"); }
            else { System.out.print(num + ", "); }
        }
    }
}