public class Exercicio_5 {

    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < 100;){ numbers[i] = ++i; }
        System.out.println(getStringWithPrimeNumbersInArray(numbers));
    }

    public static String getStringWithPrimeNumbersInArray(int[] array){
        StringBuilder output = new StringBuilder("Primos no array: ");
        for (int n: array){
            boolean isPrime = true;

            for (int i = 1; i < array.length;){
                if (n != ++i && n % i == 0 || n == 1){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                output.append(n).append(", ");
            }
        }
        return output.substring(0, output.length() - 2);
    }

}
