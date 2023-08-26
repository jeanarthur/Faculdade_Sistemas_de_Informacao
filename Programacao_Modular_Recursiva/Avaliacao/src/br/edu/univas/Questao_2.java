package br.edu.univas;

import java.util.Scanner;

public class Questao_2 {

    public static void main(String[] args) {
        int input = getInput("Digite um número: ");
        System.out.println(sumOneTo(input));
    }

    public static int getInput(String consoleMessage){
        Scanner scanner = new Scanner(System.in);
        System.out.println(consoleMessage);
        return scanner.nextInt();
    }

    public static long sumOneTo(int n){
        if (n <= 1){ return 1; }
        return n + sumOneTo(n-1);
    }

}
