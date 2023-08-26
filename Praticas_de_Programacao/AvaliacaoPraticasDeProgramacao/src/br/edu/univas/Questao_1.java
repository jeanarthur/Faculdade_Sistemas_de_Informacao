package br.edu.univas;

import java.util.Scanner;

public class Questao_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int candidatoX = 0;
        int candidatoY = 0;
        int candidatoZ = 0;
        int branco = 0;
        int nulo = 0;

        for (int i = 0; i < 1500; i++){
            System.out.print("Digite seu voto: ");

            switch (scanner.nextInt()){
                case 0 -> { branco++; }
                case 111 -> { candidatoX++; }
                case 222 -> { candidatoY++; }
                case 333 -> { candidatoZ++; }
                default -> { nulo++; }
            }

        }

        System.out.println(" --- Resultado da Votação ---");
        System.out.printf(" CandidatoX: %d votos\n", candidatoX);
        System.out.printf(" CandidatoY: %d votos\n", candidatoY);
        System.out.printf(" CandidatoZ: %d votos\n", candidatoZ);
        System.out.printf(" Branco: %d votos\n", branco);
        System.out.printf(" Nulo: %d votos\n", nulo);

        scanner.close();
    }

}
