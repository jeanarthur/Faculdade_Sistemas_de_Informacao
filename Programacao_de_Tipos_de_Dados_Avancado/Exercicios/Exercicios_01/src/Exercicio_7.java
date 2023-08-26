public class Exercicio_7 {

    public static String getStringWithLargerAndSmallerNumberInArray(int[] array){
        int smaller = 0;
        int larger = 0;

        int i = 0;
        for (int n: array){
            if (i++ == 0) { larger = n; smaller = n; }
            if ( n < smaller ) { smaller = n; }
            else if ( n > larger ) { larger = n; }
        }

        return String.format("Menor número do array: %d | Maior número do array: %d", smaller, larger);
    }

}
