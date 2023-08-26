package br.edu.univas;

import java.util.Scanner;

public class Questao_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int golsFeitos = 0;
        int golsSofridos = 0;
        int pontuacao = 0;

        String[] jogos = {"Brasil x Sérvia", "Brasil x Suiça", "Camarões x Brasil"};

        for (String jogo: jogos){
            System.out.printf("Considerando o jogo %s, digite o número de gols:\n", jogo);

            System.out.print(" Brasil: ");
            int golsFeitosNaPartida = scanner.nextInt();

            String timeAdversário = (jogo.split("x")[0].contains("Brasil")) ? jogo.split("x")[1].trim() : jogo.split("x")[0];

            System.out.printf(" %s: ", timeAdversário);
            int golsSofridosNaPartida = scanner.nextInt();

            if (golsFeitosNaPartida > golsSofridosNaPartida){ pontuacao += 3; }
            else if (golsFeitosNaPartida == golsSofridosNaPartida){ pontuacao += 1; }

            golsFeitos += golsFeitosNaPartida;
            golsSofridos += golsSofridosNaPartida;

        }

        System.out.println("\n -- Resultado final do Brasil --");
        System.out.println(" Pontuação: " + pontuacao);
        System.out.println(" Saldo de gols: " + (golsFeitos - golsSofridos));

        scanner.close();
    }

}
