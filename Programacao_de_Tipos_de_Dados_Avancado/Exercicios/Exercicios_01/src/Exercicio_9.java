import java.util.Arrays;

public class Exercicio_9 {

    public static int[] differenceInArrays(int[] arrayA, int[] arrayB){
        int[] arrayA_UniqueValues = Arrays.stream(arrayA).distinct().toArray();
        int[] arrayB_UniqueValues = Arrays.stream(arrayB).distinct().toArray();
        int[] difference = new int[0];

        for (int numA: arrayA_UniqueValues){
            boolean isUnique = true;
            for (int numB: arrayB_UniqueValues){
                if (numA == numB) { isUnique = false; break; }
            }
            if (isUnique) {
                difference = Arrays.copyOf(difference, difference.length + 1);
                difference[difference.length - 1] = numA;
            }
        }

        return difference;
    }

}
