public class Exercicio_4 {

    public static int[] powArrayValues(int[] array) {
        int[] powArray = new int[array.length];
        for (int i = 0; i < array.length; i++){ powArray[i] = array[i] * array[i]; }
        return powArray;
    }

}
