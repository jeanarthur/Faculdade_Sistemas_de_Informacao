package br.edu.univas;

import java.util.Scanner;

public class Questao_3 {

    public static void main(String[] args) {
        int input = getInput("Digite um número: ");
        printSequence(input);
    }

    public static int getInput(String consoleMessage){
        Scanner scanner = new Scanner(System.in);
        System.out.println(consoleMessage);
        return scanner.nextInt();
    }

    public static void printSequence(int endNumber){
        if (endNumber <= 0){ return; }
        printSequence(endNumber - 2);
        System.out.println(endNumber);
    }

}
