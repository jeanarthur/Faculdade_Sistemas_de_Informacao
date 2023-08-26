import java.util.Arrays;

public class Exercicio_10 {

    public static int[] unionInArrays(int[] arrayA, int[] arrayB){
        int[] union = new int[arrayA.length + arrayB.length];
        for (int i = 0, j = 0; i < union.length;){
            if (j < arrayA.length) { union[i++] = arrayA[j]; }
            if (j < arrayB.length) { union[i++] = arrayB[j]; }
            j++;
        }
        union = Arrays.stream(union).distinct().toArray();
        Arrays.sort(union);

        return union;
    }
}
