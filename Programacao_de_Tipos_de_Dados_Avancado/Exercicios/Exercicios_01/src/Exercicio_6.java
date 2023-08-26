import java.util.Scanner;

public class Exercicio_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite N números separados por espaço: ");
        String[] numbers = scanner.nextLine().split("\\s");

        System.out.println(getStringWithOddAndEvenNumbersAmount(numbers));
    }

    public static String getStringWithOddAndEvenNumbersAmount(String[] numbers){
        int oddNumbersAmount = 0;
        int evenNumbersAmount = 0;
        for (int i = 0; i < numbers.length;){
            int value = Integer.parseInt(numbers[i++]);
            if (value > 0 && value <= 1000){
                if (value % 2 == 0){ evenNumbersAmount++; }
                else { oddNumbersAmount++; }
            }
        }

        return String.format("Foram digitados %d número(s) par(es) e %d número(s) ímpar(es)", evenNumbersAmount, oddNumbersAmount);
    }
}
