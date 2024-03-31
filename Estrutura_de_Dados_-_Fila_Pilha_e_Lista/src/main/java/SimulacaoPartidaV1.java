public class SimulacaoPartidaV1 {

    static Lista maoJogador1 = new Lista();
    static Lista maoJogador2 = new Lista();
    static Lista monte = new Lista();
    static Lista mesa = new Lista();

    public static void main(String[] args) {

        Peca _00 = new Peca(0, 0);
        Peca _01 = new Peca(0, 1);
        Peca _02 = new Peca(0, 2);
        Peca _03 = new Peca(0, 3);
        Peca _04 = new Peca(0, 4);
        Peca _05 = new Peca(0, 5);
        Peca _06 = new Peca(0, 6);

        Peca _11 = new Peca(1, 1);
        Peca _12 = new Peca(1, 2);
        Peca _13 = new Peca(1, 3);
        Peca _14 = new Peca(1, 4);
        Peca _15 = new Peca(1, 5);
        Peca _16 = new Peca(1, 6);

        Peca _22 = new Peca(2, 2);
        Peca _23 = new Peca(2, 3);
        Peca _24 = new Peca(2, 4);
        Peca _25 = new Peca(2, 5);
        Peca _26 = new Peca(2, 6);

        Peca _33 = new Peca(3, 3);
        Peca _34 = new Peca(3, 4);
        Peca _35 = new Peca(3, 5);
        Peca _36 = new Peca(3, 6);

        Peca _44 = new Peca(4, 4);
        Peca _45 = new Peca(4, 5);
        Peca _46 = new Peca(4, 6);

        Peca _55 = new Peca(5, 5);
        Peca _56 = new Peca(5, 6);

        Peca _66 = new Peca(6, 6);

        maoJogador1.inserir(_00);
        maoJogador1.inserir(_45);
        maoJogador1.inserir(_22);
        maoJogador1.inserir(_34);
        maoJogador1.inserir(_26);
        maoJogador1.inserir(_23);
        maoJogador1.inserir(_06);

        maoJogador2.inserir(_03);
        maoJogador2.inserir(_46);
        maoJogador2.inserir(_25);
        maoJogador2.inserir(_36);
        maoJogador2.inserir(_12);
        maoJogador2.inserir(_13);
        maoJogador2.inserir(_02);

        monte.inserir(_01);
        monte.inserir(_04);
        monte.inserir(_05);
        monte.inserir(_11);
        monte.inserir(_14);
        monte.inserir(_15);
        monte.inserir(_16);
        monte.inserir(_24);
        monte.inserir(_33);
        monte.inserir(_35);
        monte.inserir(_44);
        monte.inserir(_55);
        monte.inserir(_56);
        monte.inserir(_66);

        System.out.println("- Inicio -");
        imprimirJogo();

        System.out.println("- Rodada 1 -");
        mesa.inserir(maoJogador1.remover(_22));
        imprimirJogo();

        System.out.println("- Rodada 2 -");
        mesa.inserir(maoJogador2.remover(_25));
        imprimirJogo();

        System.out.println("- Rodada 3 -");
        mesa.inserir(maoJogador1.remover("[2|6]"), 1);
        imprimirJogo();

        System.out.println("- Rodada 4 -");
        mesa.inserir(maoJogador2.remover(2), 1);
        imprimirJogo();

        System.out.println("- Rodada 5 -");
        mesa.inserir(maoJogador1.remover(2), 1);
        imprimirJogo();

        System.out.println("- Rodada 6 -");
        maoJogador2.inserir(monte.remover(1));
        maoJogador2.inserir(monte.remover(1));
        maoJogador2.inserir(monte.remover(1));
        mesa.inserir(maoJogador2.remover(8));
        imprimirJogo();

        System.out.println("- Rodada 7 -");
        mesa.inserir(maoJogador1.remover(1));
        imprimirJogo();

        System.out.println("- Rodada 8 -");
        mesa.inserir(maoJogador2.remover(1));
        imprimirJogo();

        System.out.println("- Rodada 9 -");
        mesa.inserir(maoJogador1.remover(1));
        imprimirJogo();

        System.out.println("- Rodada 10 -");
        mesa.inserir(maoJogador2.remover(6));
        imprimirJogo();

        System.out.println("- Rodada 11 -");
        mesa.inserir(maoJogador1.remover(2));
        imprimirJogo();

        System.out.println("- Rodada 12 -");
        mesa.inserir(maoJogador2.remover(1));
        imprimirJogo();

        System.out.println("- Rodada 13 -");
        mesa.inserir(maoJogador1.remover(1));
        imprimirJogo();

        System.out.println("- Fim -");
        System.out.println("Jogador 1 é o vencedor!");

    }

    public static void imprimirJogo(){
        System.out.printf("J1(%d): ", maoJogador1.getTamanho());
        maoJogador1.imprimir();
        System.out.printf("Mesa(%d): ", mesa.getTamanho());
        mesa.imprimir();
        System.out.printf("J2(%d): ", maoJogador2.getTamanho());
        maoJogador2.imprimir();
        System.out.printf("Monte(%d): ", monte.getTamanho());
        monte.imprimir();
        System.out.println();
    }

}
