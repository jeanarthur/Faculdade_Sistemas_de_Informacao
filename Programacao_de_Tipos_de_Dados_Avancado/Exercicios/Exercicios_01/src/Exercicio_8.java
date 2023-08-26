import java.util.Arrays;

public class Exercicio_8 {

    public static int[] intersectionInArrays(int[] arrayA, int[] arrayB){
        int[] arrayA_UniqueValues = Arrays.stream(arrayA).distinct().toArray();
        int[] arrayB_UniqueValues = Arrays.stream(arrayB).distinct().toArray();
        int[] intersection = new int[0];

        for (int numA: arrayA_UniqueValues){
            for (int numB: arrayB_UniqueValues){
                if (numA == numB) {
                    intersection = Arrays.copyOf(intersection, intersection.length + 1);
                    intersection[intersection.length - 1] = numA;
                }
            }
        }

        return intersection;
    }

}
